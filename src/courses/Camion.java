package courses;


public class Camion extends Transport {
	Double poid;
	String nom;
	public Camion(int id, String nom, Double poid, Coureur c) {
		super(id, c, nom);
		this.poid = poid;
	}
	public Double getPoid() {
		return poid;
	}
	public void setPoid(Double poid) {
		this.poid = poid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
