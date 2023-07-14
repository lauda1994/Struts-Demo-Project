package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import objects.utenteAdminaSP;

public class Login extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String serverName = "localhost";
        String portNumber = "3306";
        String sid = "progettostruts";
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
        Connection con = null;
        PreparedStatement preparedStmtAna = null;
        ResultSet rsUtente = null;
        ArrayList<utenteAdminaSP> userList = new ArrayList<>();
        boolean isLoggedIn = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, userName, password);


            String query = "SELECT * FROM utente_admin";
            preparedStmtAna = (PreparedStatement) con.prepareStatement(query);
            rsUtente = preparedStmtAna.executeQuery();
            String inputUs = request.getParameter("username");
            String inputPw = request.getParameter("password");

            while (rsUtente.next()) {
            	utenteAdminaSP userLog = new utenteAdminaSP();
                userLog.setCodUser(rsUtente.getInt("id_utente"));
                userLog.setCognome(rsUtente.getString("cognome"));
                userLog.setNome(rsUtente.getString("nome"));
                userLog.setUsername(rsUtente.getString("username"));
                userLog.setPassword(rsUtente.getString("password"));
                userList.add(userLog);

            }
            if (inputUs == null || inputUs.isEmpty() || inputPw == null || inputPw.isEmpty()) {
                System.out.println("Campi username o password vuoti");
            } else {
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getUsername().equals(inputUs) && userList.get(i).getPassword().equals(inputPw)) {
                        isLoggedIn = true;
                        break;
                    } else if (userList.get(i).getUsername().equals(inputUs) && !userList.get(i).getPassword().equals(inputPw)) {
                        return mapping.findForward("error2");
                    }
                }
            }


            if (isLoggedIn) {
            	return mapping.findForward("success");
               
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rsUtente != null) {
                    rsUtente.close();
                }
                if (preparedStmtAna != null) {
                    preparedStmtAna.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		return mapping.findForward("error");

        
    }
}
