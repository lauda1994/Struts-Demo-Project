package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import objects.Anagrafica;

public class ElencoAnagrafica extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String serverName = "10.153.120.35";
		String portNumber = "3308";
		String sid = "corsodb004";
		String userName = "corsodb004";
		String password = "ciaociao";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		ArrayList<Anagrafica> listaAnagrafica = new ArrayList<>();
		try {
			Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
			Statement statement = (Statement) connection.createStatement();
			String query = "SELECT * FROM AnagraficaSP";
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
		return mapping.findForward("tab");
	}
}
