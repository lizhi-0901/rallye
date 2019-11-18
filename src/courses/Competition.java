package courses;

import java.util.ArrayList;

public   class  Competition {
	private static int count=0;
	private int codecomp;
	private String nomcomp,ville,pays,typecourse;
	private String dateDeb;
	private String dateFin;
	private ArrayList<Inscription> listInscrip;
	
	
	
	public String getTypecourse() {
		return typecourse;
	}
	public void setTypecourse(String typecourse) {
		this.typecourse = typecourse;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Competition.count = count;
	}
	public int getCodecomp() {
		return codecomp;
	}
	public void setCodecomp(int codecomp) {
		this.codecomp = codecomp;
	}
	public String getNomcomp() {
		return nomcomp;
	}
	public void setNomcomp(String nomcomp) {
		this.nomcomp = nomcomp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	public String getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public Competition( String nomcomp, String ville, String pays,String type, String dateDeb, String dateFin) {
		super();
		this.codecomp = ++count;
		this.nomcomp = nomcomp;
		this.ville = ville;
		this.pays = pays;
		this.typecourse=type;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.listInscrip= new ArrayList<Inscription>();
	}
	public Competition(String nomcomp) {
		this.nomcomp=nomcomp;
	}
	
	public Competition() {
		super();
	}
	
	
	
	public void afficher() {
		System.out.println("Competition \""+this.nomcomp+"\" à "+ this.ville +", du " +this.dateDeb +" au " +this.dateFin);
	};
	
	public  void classement() {
		
	}; 
	
	public  void creat() {
		
	};
	
	public void update() {
		
	};
	
	public  void calculertemps() {
		
	};
	
	
	
	
	
}
