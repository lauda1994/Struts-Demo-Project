package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class insertDb extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	  String serverName = "localhost";
          String portNumber = "3306";
          String sid = "progettostruts";
          String userName = "root";
          String password = "root";
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
        Connection con = null;

        PreparedStatement preparedStmtInsert = null;
        PreparedStatement preparedStmtInsert1 = null;

        String inputNome = request.getParameter("nomeInp");
        String inputCognome = request.getParameter("cognomeInp");
        String inputTelefono1 = request.getParameter("telefono1");
        String inputTelefono2 = request.getParameter("telefono2");
        String inputIndirizzo = request.getParameter("indirizzo");
        String inputCodCom = request.getParameter("citta");
        String inputRagSoc = request.getParameter("ragSocInps");
        String inputGender = request.getParameter("options");
        String inputDataNascita = request.getParameter("dataNasc");
        String inputLuogoNascita = request.getParameter("citta");
        String inputCodiceFiscale = request.getParameter("codFisc");
        String inputPartitaIva = request.getParameter("pIvaInp");
        String inputEmail = request.getParameter("email");
        String inputContoC = request.getParameter("numConto");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, userName, password);
          


            String queryInsert = "INSERT INTO anagraficacorrentisti (cognome, nome, ragSoc, indirizzo, idComune, sesso, data_nascita, luogo_nascita, cod_fiscale, p_iva, telefono1, telefono2, email) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStmtInsert = (PreparedStatement) con.prepareStatement(queryInsert);
            preparedStmtInsert.setString(1, inputCognome);
            preparedStmtInsert.setString(2, inputNome);
            preparedStmtInsert.setString(3, inputRagSoc);
            preparedStmtInsert.setString(4, inputIndirizzo);
            preparedStmtInsert.setString(5, inputCodCom);
            preparedStmtInsert.setString(6, inputGender);
            java.util.Date dataScadenza = new SimpleDateFormat("yyyy-MM-dd").parse(inputDataNascita);
            java.sql.Date dataScadenzaSql = new java.sql.Date(dataScadenza.getTime());
            preparedStmtInsert.setDate(7, dataScadenzaSql);
            preparedStmtInsert.setString(8, inputLuogoNascita);
            preparedStmtInsert.setString(9, inputCodiceFiscale);
            preparedStmtInsert.setString(10, inputPartitaIva);
            preparedStmtInsert.setString(11, inputTelefono1);
            preparedStmtInsert.setString(12, inputTelefono2);
            preparedStmtInsert.setString(13, inputEmail);
            preparedStmtInsert.execute();

            String querySelectLastCodAnag = "SELECT cod_anag FROM anagraficacorrentisti ORDER BY cod_anag DESC LIMIT 1";
            PreparedStatement stmtSelectLastCodAnag = (PreparedStatement) con.prepareStatement(querySelectLastCodAnag);
            ResultSet rs = stmtSelectLastCodAnag.executeQuery();

            int cod_anag = 0;
            if (rs.next()) {
            	cod_anag = rs.getInt("cod_anag");
            }
            System.out.println(cod_anag);
            int cod_anag_cc = cod_anag ;

            
            String queryInsertContoCorrente = "INSERT INTO conticorrenti (cod_cc,cod_anag_cc) "
                    + "VALUES (?, ?)";
            
            preparedStmtInsert1 = (PreparedStatement) con.prepareStatement(queryInsertContoCorrente);
            preparedStmtInsert1.setString(1, inputContoC);
            preparedStmtInsert1.setInt(2, cod_anag_cc);
            preparedStmtInsert1.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return mapping.findForward("insert");
    }
}
