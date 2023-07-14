package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import objects.Anagrafica;
public class DispAction extends org.apache.struts.actions.DispatchAction {

	public ActionForward modifDb(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  String serverName = "localhost";
		    String portNumber = "3306";
		    String sid = "progettostruts";
		    String userName = "root";
		    String password = "root";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		Connection con = null;
		String risposta = "elimina";
		Anagrafica anagrafica = new Anagrafica();
		anagrafica.setCod_anag(Integer.parseInt(request.getParameter("inputAnag")));
		anagrafica.setCognome(request.getParameter("cognomeInp"));
		anagrafica.setNome(request.getParameter("nomeInp"));
		anagrafica.setRag_soc(request.getParameter("ragSocInps"));
		anagrafica.setIndirizzo(request.getParameter("indirizzo"));
		anagrafica.setId_comune(Integer.parseInt(request.getParameter("idComune")));
		anagrafica.setSesso(request.getParameter("options"));
		anagrafica.setData_nascita(request.getParameter("dataNasc"));
		anagrafica.setLuogo_nascita(request.getParameter("citta"));
		anagrafica.setCod_fiscale(request.getParameter("codFisc"));
		anagrafica.setPartita_iva(request.getParameter("pIvaInp"));
		anagrafica.setTelefono1(request.getParameter("telefono1"));
		anagrafica.setTelefono2(request.getParameter("telefono2"));
		anagrafica.setEmail(request.getParameter("email"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, userName, password);

			String queryUpdate = "UPDATE anagraficacorrentisti "
					+ "SET cognome = ?, nome = ?, ragSoc = ?, indirizzo = ?, idComune = ?,"
					+ "data_nascita = ?, luogo_nascita = ?, cod_fiscale = ?, p_iva = ?, "
					+ "telefono1 = ?, telefono2 = ?, email = ? " + "WHERE cod_anag = ?";

			PreparedStatement preparedStmtUpdate = (PreparedStatement) con.prepareStatement(queryUpdate);
			preparedStmtUpdate.setString(1, anagrafica.getCognome());
			preparedStmtUpdate.setString(2, anagrafica.getNome());
			preparedStmtUpdate.setString(3, anagrafica.getRag_soc());
			preparedStmtUpdate.setString(4, anagrafica.getIndirizzo());
			preparedStmtUpdate.setInt(5, anagrafica.getId_comune());
			preparedStmtUpdate.setString(6, anagrafica.getData_nascita());
			preparedStmtUpdate.setString(7, anagrafica.getLuogo_nascita());
			preparedStmtUpdate.setString(8, anagrafica.getCod_fiscale());
			preparedStmtUpdate.setString(9, anagrafica.getPartita_iva());
			preparedStmtUpdate.setString(10, anagrafica.getTelefono1());
			preparedStmtUpdate.setString(11, anagrafica.getTelefono2());
			preparedStmtUpdate.setString(12, anagrafica.getEmail());
			preparedStmtUpdate.setInt(13, anagrafica.getCod_anag());

			preparedStmtUpdate.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return mapping.findForward(risposta);
	}

	public ActionForward eliminaRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  String serverName = "localhost";
		    String portNumber = "3306";
		    String sid = "progettostruts";
		    String userName = "root";
		    String password = "root";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		Connection con = null;
		String risposta = "elimina";

		String inputCodAnag = request.getParameter("inputAnag");
		int codAnag = Integer.parseInt(inputCodAnag);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, userName, password);
			PreparedStatement preparedStmtDelete = null;
			String queryDelete = "DELETE anagraficacorrentisti, conticorrenti\r\n" + "FROM anagraficacorrentisti\r\n"
					+ "LEFT JOIN conticorrenti ON anagraficacorrentisti.cod_anag = conticorrenti.cod_anag_cc\r\n"
					+ "WHERE anagraficacorrentisti.cod_anag = ? OR conticorrenti.cod_anag_cc = ?;";
			preparedStmtDelete = (PreparedStatement) con.prepareStatement(queryDelete);
			preparedStmtDelete.setInt(1, codAnag);
			preparedStmtDelete.setInt(2, codAnag);

			preparedStmtDelete.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return mapping.findForward(risposta);

	}
}
