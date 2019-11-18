package courses;


public class Moto extends Transport{
	Double CylindreM;
	public Moto(int id, String nom, Double cyl, Coureur c) {
		super(id, c, nom);
		this.CylindreM = cyl;
	}
	public Double getCylindreM() {
		return CylindreM;
	}
	public void setCylindreM(Double cylindreM) {
		CylindreM = cylindreM;
	}
	
}
