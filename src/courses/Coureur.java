package courses;

import java.sql.Date;
import courses.*;

public class Coureur extends Utilisateur{
	
	public Coureur(int id,String nom, String prenom) {
		super(id, nom, prenom);
		// TODO Auto-generated constructor stub
	}
	public Coureur(String nom, String prenom, String dateN, String groupSang2) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		this.prenom=prenom;
		this.dateNais=dateN;
		this.groupSang=groupSang2;
		
	}
	public Coureur(String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
	}
	String dateNais;
	String groupSang;
	public String getDateNais() {
		return dateNais;
	}
	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}
	public String getGroupSang() {
		return groupSang;
	}
	public void setGroupSang(String groupSang) {
		this.groupSang = groupSang;
	}
	
	
}