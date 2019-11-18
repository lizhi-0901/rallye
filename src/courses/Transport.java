package courses;


public abstract class Transport {
	int idTransport;
	Coureur c;
	String imm;
	public Transport(int id, Coureur c, String imm) {
		this.idTransport = id;
		this.c = c;
		this.imm=imm;
	}
	public Transport() {
		
	}
	public Transport(String imm) {
		
		this.imm=imm;
	}
	
	public int getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}
	public Coureur getC() {
		return c;
	}
	public void setC(Coureur c) {
		this.c = c;
	}
	public String getImm() {
		return imm;
	}
	public void setImm(String imm) {
		this.imm = imm;
	}

}
