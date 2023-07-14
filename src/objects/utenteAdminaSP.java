package objects;

import java.util.Date;

public class utenteAdminaSP {
	 private int codUser;
	    private String cognome;
	    private String nome;
	    private String nMatricola;
	    private String username;
	    private String password;
	    private Date dataScad;
	    private String sessionId;
	    private int codCab;
	    
		public int getCodUser() {
			return codUser;
		}
		public void setCodUser(int codUser) {
			this.codUser = codUser;
		}
		public String getCognome() {
			return cognome;
		}
		
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getnMatricola() {
			return nMatricola;
		}
		public void setnMatricola(String nMatricola) {
			this.nMatricola = nMatricola;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getDataScad() {
			return dataScad;
		}
		public void setDataScad(Date dataScad) {
			this.dataScad = dataScad;
		}
		public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
		public int getCodCab() {
			return codCab;
		}
		public void setCodCab(int codCab) {
			this.codCab = codCab;
		}
		@Override
		public String toString() {
			return "anagraficaSP [codUser=" + codUser + ", cognome=" + cognome + ", nome=" + nome + ", nMatricola="
					+ nMatricola + ", username=" + username + ", password=" + password + ", dataScad=" + dataScad
					+ ", sessionId=" + sessionId + ", codCab=" + codCab + "]";
		}
}
