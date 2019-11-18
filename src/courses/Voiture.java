package courses;


public class Voiture extends Transport {
	Double puissance;
	Coureur c;
	
	public Voiture(int id, String nom, Coureur c, Double puissance) {
		super(id, c, nom);
		this.puissance = puissance;
	}
	public Voiture( String nom,  Double puissance) {
		super(nom);
		this.puissance = puissance;
	}
	
	
	public Voiture(String imm) {
		super(imm);
	}
	
	public Double getPuissance() {
		return puissance;
	}

	public void setPuissance(Double puissance) {
		this.puissance = puissance;
	}

	public Coureur getC() {
		return c;
	}

	public void setC(Coureur c) {
		this.c = c;
	}
	
}
