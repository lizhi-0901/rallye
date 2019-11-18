package courses;


public class Participer2 {
	Coureur coureur;
	Etape etape;
	int temps;
	public Participer2(Coureur coureur, Etape e, int temps) {
		this.etape = e;
		this.coureur= coureur;
		this.temps = temps;
	}
	public Participer2(int temps) {
		
		this.temps = temps;
	}
	public Coureur getCoureur() {
		return coureur;
	}
	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}
	public Etape getEtape() {
		return etape;
	}
	public void setEtape(Etape etape) {
		this.etape = etape;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	
}
