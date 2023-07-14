package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import objects.Anagrafica;
import objects.contiCorrenti;

public class dispModule extends org.apache.struts.actions.DispatchAction {

	public ActionForward formIns(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("inserimento");

	}

	public ActionForward formMod(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	        HttpServletResponse response) throws Exception {

	    String serverName = "localhost";
	    String portNumber = "3306";
	    String sid = "progettostruts";
	    String userName = "root";
	    String password = "root";
	    String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
	    PreparedStatement preparedStmtNome = null;

	    PreparedStatement codiceConto = null;
	    ResultSet rsNome = null;
	    Connection con = null;
	    ArrayList<Anagrafica> listaAnagrafica = new ArrayList<>();
	    ArrayList<contiCorrenti> listaCc = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = (Connection) DriverManager.getConnection(url, userName, password);
	        String queryNome = "SELECT nome, cognome FROM anagraficacorrentisti";
	        preparedStmtNome = (PreparedStatement) con.prepareStatement(queryNome);
	        rsNome = preparedStmtNome.executeQuery();
	        while (rsNome.next()) {
	            Anagrafica anagrafica = new Anagrafica();
	            anagrafica.setNome(rsNome.getString("nome"));
	            anagrafica.setCognome(rsNome.getString("cognome"));
	            listaAnagrafica.add(anagrafica);
	        }
	        rsNome.close();

	        String queryCc = "SELECT cod_cc FROM conticorrenti";
	        codiceConto = (PreparedStatement) con.prepareStatement(queryCc);
	        ResultSet rsCc = codiceConto.executeQuery();
	        while (rsCc.next()) {
	            contiCorrenti codiciConti = new contiCorrenti();
	            codiciConti.setCodCC(rsCc.getLong("cod_cc"));
	            listaCc.add(codiciConti);
	        }
	        rsCc.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    request.setAttribute("listaAnagrafica", listaAnagrafica);
	    request.setAttribute("listaCc", listaCc);
	    return mapping.findForward("modifica");
	}

	public ActionForward elencoTab(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 String serverName = "localhost";
         String portNumber = "3306";
         String sid = "progettostruts";
         String userName = "root";
         String password = "root";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		ArrayList<Anagrafica> listaAnagrafica = new ArrayList<>();
		try {
			Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
			Statement statement = (Statement) connection.createStatement();
			String query = "SELECT * FROM anagraficacorrentisti";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Anagrafica anagrafica = new Anagrafica();

				anagrafica.setNome(resultSet.getString("nome"));
				anagrafica.setCognome(resultSet.getString("cognome"));
				anagrafica.setRag_soc(resultSet.getString("ragSoc"));
				anagrafica.setTelefono1(resultSet.getString("telefono1"));

				listaAnagrafica.add(anagrafica);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listaAnagrafica", listaAnagrafica);

		return mapping.findForward("tabella");
	}
}