package courses;


public class Participer {
	Coureur coureur;
	Courses course;
	
	int temps;
	
	public Participer(Coureur coureur, Courses c, int temps) {
		this.course = c;
		this.coureur = coureur;
		this.temps = temps;
	}
	public Participer(int temps) {
		
		this.temps = temps;
	}
	public Coureur getCoureur() {
		return coureur;
	}
	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	

}
