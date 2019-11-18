package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FrauConnection {
	/**
	  * URL de connection
	  */
	  private static String url = "jdbc:mysql://localhost:3306/projetcomp?characterEncoding=latin1&useConfigs=maxPerformance";

	  /**
	  * Nom du user
	  */
	  private static String user = "root";

	  /**
	  * Mot de passe du user
	  */
	  private static String passwd = "lisa";

	  /**
	  * Objet Connection
	  */
	  private static Connection connect;


	/**
	  * M�thode qui va retourner notre instance
	  * et la cr�er si elle n'existe pas...
	  * @return
	  */
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        connect = DriverManager.getConnection(url, user, passwd);
	      } catch (SQLException e) {
	    	  System.out.println(e);
	      } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }		
	    return connect;	
	  }

}
