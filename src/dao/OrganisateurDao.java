package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import courses.*;
public class OrganisateurDao extends AbstractDao<Organisateur> {

	public OrganisateurDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Organisateur obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Organisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Organisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organisateur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

    public Organisateur findByLoginAndPwd(String login, String psw) {
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM organisateur where nom = ? and pass = ?");
			stm.setString(1, login);
			stm.setString(2, psw);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			int id = 0;
			String nom = "";
			String prenom = "";
			
			while (rs.next()) {
				
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
				
			}
			
			if (id != 0) {
				return new Organisateur(id,nom, prenom);

			} else {
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
    
    
public int findIdByLogin(String login) {
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM coureur where nom = ? ");
			stm.setString(1, login);
			
			stm.execute();
			ResultSet rs = stm.getResultSet();
			System.out.println("rs"+rs.toString());
			int id = 0;
			while (rs.next()) {
				
				id = rs.getInt(1);
			
				
			}
			return id;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	
}
