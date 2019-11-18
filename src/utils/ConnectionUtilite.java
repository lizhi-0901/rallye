package utils;

import courses.*;


import Factory.Daofactory;

public class ConnectionUtilite {
	
	
	
	
	
	public static void seConnecter(String login, String password) {
		
		Coureur coureur = Daofactory.getCoureurDao().findByLoginAndPwd(login, password);
		Organisateur orga =Daofactory.getOrganisateurDao().findByLoginAndPwd(login, password);
		if (coureur != null || orga != null) {
			Coureur.connecter(coureur);
		}
	}
}
