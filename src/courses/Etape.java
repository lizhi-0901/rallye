package courses;

import java.util.ArrayList;

public class Etape {
	private int codeEtape,ordreEtape;
	private double distanceE;
	private String niveauE;
	private ArrayList<Courses> listCourse;
	private ArrayList<Participer2> listTemps;
	
	public Etape() {
		super();
	}


	public Etape(int codeEtape, int ordreEtape, double distanceE, String niveauE) {
		super();
		this.codeEtape = codeEtape;
		this.ordreEtape = ordreEtape;
		this.distanceE = distanceE;
		this.niveauE = niveauE;
		this.listCourse = new ArrayList<Courses>();
	}
	public Etape( int ordreEtape, double distanceE, String niveauE) {
		super();
		
		this.ordreEtape = ordreEtape;
		this.distanceE = distanceE;
		this.niveauE = niveauE;
		this.listCourse = new ArrayList<Courses>();
	}
	public Etape(int ordreEtape) {
		this.ordreEtape=ordreEtape;
		
	}

	public int getCodeEtape() {
		return codeEtape;
	}


	public void setCodeEtape(int codeEtape) {
		this.codeEtape = codeEtape;
	}


	public int getOrdreEtape() {
		return ordreEtape;
	}


	public void setOrdreEtape(int ordreEtape) {
		this.ordreEtape = ordreEtape;
	}


	public double getDistanceE() {
		return distanceE;
	}


	public void setDistanceE(double distanceE) {
		this.distanceE = distanceE;
	}


	public String getNiveauE() {
		return niveauE;
	}


	public void setNiveauE(String niveauE) {
		this.niveauE = niveauE;
	}
	
	public void create() {
		
	}
	
	public void update() {
		
	}
	
	public void delet() {
		
	}
	public void calculerClassement() {
		
	}
	
	
	
	
}
