package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AjaxCognomi extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String serverName = "localhost";
        String portNumber = "3306";
        String sid = "progettostruts";
        String userName = "root";
        String password = "root";
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
		Connection con = null;

		String cognome = request.getParameter("Cognome");

		List<String> nomi = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, userName, password);
			if (cognome != null && !cognome.isEmpty()) {
				String queryCercaPerCognome = "SELECT nome FROM anagraficacorrentisti WHERE cognome=?";
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(queryCercaPerCognome);
				stmt.setString(1, cognome);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					nomi.add(rs.getString("nome"));
				}

				rs.close();
				stmt.close();

			}
		} catch (ClassNotFoundException | SQLException e) {
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(String.join(",", nomi));
		return null;

	}
}