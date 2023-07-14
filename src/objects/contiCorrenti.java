package objects;

public class contiCorrenti {

	 private String iso;
	    private int numControllo;
	    private String cin;
	    private int abi;
	    private int cab;
	    private long codCC;
	    private int codAnagCC;
	    private int importoSaldo;
	    private int importoFido;
		public String getIso() {
			return iso;
		}
		public void setIso(String iso) {
			this.iso = iso;
		}
		public int getNumControllo() {
			return numControllo;
		}
		public void setNumControllo(int numControllo) {
			this.numControllo = numControllo;
		}
		public String getCin() {
			return cin;
		}
		public void setCin(String cin) {
			this.cin = cin;
		}
		public int getAbi() {
			return abi;
		}
		public void setAbi(int abi) {
			this.abi = abi;
		}
		public int getCab() {
			return cab;
		}
		public void setCab(int cab) {
			this.cab = cab;
		}
		public long getCodCC() {
			return codCC;
		}
		public void setCodCC(long codCC) {
			this.codCC = codCC;
		}
		public int getCodAnagCC() {
			return codAnagCC;
		}
		public void setCodAnagCC(int codAnagCC) {
			this.codAnagCC = codAnagCC;
		}
		public int getImportoSaldo() {
			return importoSaldo;
		}
		public void setImportoSaldo(int importoSaldo) {
			this.importoSaldo = importoSaldo;
		}
		public int getImportoFido() {
			return importoFido;
		}
		public void setImportoFido(int importoFido) {
			this.importoFido = importoFido;
		}
		@Override
		public String toString() {
			return "contiCorrentiSP [iso=" + iso + ", numControllo=" + numControllo + ", cin=" + cin + ", abi=" + abi
					+ ", cab=" + cab + ", codCC=" + codCC + ", codAnagCC=" + codAnagCC + ", importoSaldo="
					+ importoSaldo + ", importoFido=" + importoFido + "]";
		}
	
}
