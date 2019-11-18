package courses;


public abstract  class Utilisateur {
	int id;
	String nom;
	String prenom;
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utilisateur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Utilisateur() {
		super();
	}
	 private static boolean connected = false;
		
	    private static Coureur  utilisateur;
		
	    public static boolean connecte() {
			
			return connected;
		}
	
	    public static void connecter(Utilisateur user) {
			
			utilisateur = (Coureur) user;
			connected = true;
		}
	
	
	
	
}
