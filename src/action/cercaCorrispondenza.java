package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import objects.Anagrafica;
import objects.contiCorrenti;

public class cercaCorrispondenza extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String serverName = "localhost";
	    String portNumber = "3306";
	    String sid = "progettostruts";
	    String userName = "root";
	    String password = "root";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		Connection con = null;

		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String conto = request.getParameter("CodiceConto");

		Anagrafica anagrafica = null;
		contiCorrenti contoCorr = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, userName, password);

			if ((nome != null && !nome.isEmpty()) && (cognome != null && !cognome.isEmpty())) {
				String queryCercaPerNome = "SELECT a.*, cc.cod_cc FROM anagraficacorrentisti a "
						+ "JOIN conticorrenti cc ON cc.cod_anag_cc = a.cod_anag "
						+ "WHERE a.nome=? AND a.cognome=?";

				PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement(queryCercaPerNome);
				stmt1.setString(1, nome);
				stmt1.setString(2, cognome);

				ResultSet rsNomeCogn = stmt1.executeQuery();
				if (rsNomeCogn.next()) {
					anagrafica = new Anagrafica();
					anagrafica.setCod_anag(rsNomeCogn.getInt("cod_anag"));
					anagrafica.setNome(rsNomeCogn.getString("nome"));
					anagrafica.setCognome(rsNomeCogn.getString("cognome"));
					anagrafica.setRag_soc(rsNomeCogn.getString("ragSoc"));
					anagrafica.setIndirizzo(rsNomeCogn.getString("indirizzo"));
					anagrafica.setId_comune(rsNomeCogn.getInt("idComune"));
					anagrafica.setSesso(rsNomeCogn.getString("sesso"));
					Date dataNascita = rsNomeCogn.getDate("data_nascita");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dataNascitaString = sdf.format(dataNascita);
					anagrafica.setData_nascita(dataNascitaString);
					anagrafica.setLuogo_nascita(rsNomeCogn.getString("luogo_nascita"));
					anagrafica.setCod_fiscale(rsNomeCogn.getString("cod_fiscale"));
					anagrafica.setPartita_iva(rsNomeCogn.getString("p_iva"));
					anagrafica.setTelefono1(rsNomeCogn.getString("telefono1"));
					anagrafica.setTelefono2(rsNomeCogn.getString("telefono2"));
					anagrafica.setEmail(rsNomeCogn.getString("email"));
					contoCorr = new contiCorrenti();
					contoCorr.setCodCC(rsNomeCogn.getLong("cod_cc"));
					rsNomeCogn.close();
				}
				stmt1.close();

			} else if (conto != null && !conto.isEmpty()) {
				long contoLong = Long.parseLong(conto);
				String queryConto = "SELECT * FROM conticorrenti cc "
						+ "JOIN anagraficacorrentisti a ON cc.cod_anag_cc = a.cod_anag " + "WHERE cc.cod_cc = ?";

				PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement(queryConto);
				stmt2.setLong(1, contoLong);

				ResultSet rsConto = stmt2.executeQuery();
				if (rsConto.next()) {
					
					contoCorr = new contiCorrenti();
					contoCorr.setCodAnagCC(rsConto.getInt("cod_anag_cc"));
					contoCorr.setCodCC(rsConto.getLong("cod_cc"));
					anagrafica = new Anagrafica();
					anagrafica.setNome(rsConto.getString("nome"));
					anagrafica.setCognome(rsConto.getString("cognome"));
					anagrafica.setRag_soc(rsConto.getString("ragSoc"));
					anagrafica.setIndirizzo(rsConto.getString("indirizzo"));
					anagrafica.setId_comune(rsConto.getInt("idComune"));
					anagrafica.setSesso(rsConto.getString("sesso"));
					Date dataNascita = rsConto.getDate("data_nascita");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dataNascitaString = sdf.format(dataNascita);
					anagrafica.setData_nascita(dataNascitaString);
					anagrafica.setLuogo_nascita(rsConto.getString("luogo_nascita"));
					anagrafica.setCod_fiscale(rsConto.getString("cod_fiscale"));
					anagrafica.setPartita_iva(rsConto.getString("p_iva"));
					anagrafica.setTelefono1(rsConto.getString("telefono1"));
					anagrafica.setTelefono2(rsConto.getString("telefono2"));
					anagrafica.setEmail(rsConto.getString("email"));

				}
				rsConto.close();
				stmt2.close();
			} else {
			}

			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
		}

		request.setAttribute("contoCorr", contoCorr);
		request.setAttribute("anagrafica", anagrafica);

		return mapping.findForward("EffettuaModifica");

	}
}
