package Factory;

import dao.*;
import utils.FrauConnection;

public class Daofactory {
	static CoureurDao coureurDao;
	static CompetitionDao competitionDao;
	static EtapeDao etapeDao;
	static CourseDao courseDao;
	static TransportDao transportDao;
	static InscriptionDao inscriptionDao;
	static OrganisateurDao organisateurDao;
	static Participer2Dao participer2Dao;
	static ParticiperDao participerDao;
	
	
public static ParticiperDao getParticiperDao() {
		
		if (participerDao == null) {
			participerDao = new ParticiperDao(FrauConnection.getInstance());
		}
		
		return participerDao;
		
	}
public static Participer2Dao getParticiper2Dao() {
	
	if (participer2Dao == null) {
		participer2Dao = new Participer2Dao(FrauConnection.getInstance());
	}
	
	return participer2Dao;
	
}
	
	
	
	
	
	
	public static OrganisateurDao getOrganisateurDao() {
		
		if (organisateurDao == null) {
			organisateurDao = new OrganisateurDao(FrauConnection.getInstance());
		}
		
		return organisateurDao;
		
	}	
	
	
	public static CoureurDao getCoureurDao() {
		
		if (coureurDao == null) {
			coureurDao = new CoureurDao(FrauConnection.getInstance());
		}
		
		return coureurDao;
		
	}	
public static CourseDao getCourseDao() {
		
		if (courseDao == null) {
			courseDao = new CourseDao(FrauConnection.getInstance());
		}
		
		return courseDao;
		
	}
	

	public static CompetitionDao getCompetitionDao() {
		
		if (competitionDao == null) {
			competitionDao = new CompetitionDao(FrauConnection.getInstance());
		}
		
		return competitionDao;
		
	}	
	
public static InscriptionDao getInscriptionDao() {
		
		if (inscriptionDao == null) {
			inscriptionDao = new InscriptionDao(FrauConnection.getInstance());
		}
		
		return inscriptionDao;
		
	}	

public static EtapeDao getEtapeDao() {
	
	if (etapeDao == null) {
		etapeDao = new EtapeDao(FrauConnection.getInstance());
	}
	
	return etapeDao;
	
}	
public static TransportDao getTransportDao() {
	
	if (transportDao == null) {
		transportDao = new TransportDao(FrauConnection.getInstance());
	}
	
	return transportDao;
	
}
}
