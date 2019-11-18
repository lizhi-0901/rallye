package courses;

import java.sql.Date;
import java.util.ArrayList;

public class Inscription {
	private static int count=0;
	int noInscrip;
	Date dateInscrip;
	public int getNoInscrip() {
		return noInscrip;
	}

	public void setNoInscrip(int noInscrip) {
		this.noInscrip = noInscrip;
	}

	public String getEtatValid() {
		return etatValid;
	}

	public void setEtatValid(String etatValid) {
		this.etatValid = etatValid;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Coureur getCoureur() {
		return coureur;
	}

	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}




	String etatValid;
	Transport transport;
	Coureur coureur;
	Competition competition;
	ArrayList<Participer> listTemps;
	
	public Inscription(Coureur c, Date dtInsc, Transport trans, Competition comp) {
		this.noInscrip=++count;
		this.listTemps = new ArrayList<Participer>();
		this.dateInscrip = dtInsc;
		this.etatValid = "EnAttend";
		this.transport = trans;
		this.coureur = c;
		this.competition = comp;
	}
	
	public Inscription(Coureur c, Date dtInsc, Competition comp) {
		this.noInscrip=++count;
		this.listTemps = new ArrayList<Participer>();
		this.dateInscrip = dtInsc;
		this.etatValid = "EnAttend";
		this.coureur = c;
		this.competition = comp;
	}
	
	
	
	
	public void modifEtat(String etat) {
		this.etatValid = etat;
	}
	
	

}
