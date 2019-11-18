package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import courses.*;



public class CoureurDao extends AbstractDao<Coureur>{

	public CoureurDao(Connection connection) {
		super(connection);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Coureur obj) throws SQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Coureur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Coureur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coureur find(int id) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM coureur where id=?");
			stm.setInt(1, id);
			
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			String nom = "";
			String prenom = "";
			while(rs.next()) {
			nom = rs.getString(3);
			prenom = rs.getString(4);
			
			
			}
			if(nom!=null) {
				return new Coureur(nom,prenom);
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public Coureur save(Coureur obj) {
		
		try {
			PreparedStatement stm = connection.prepareStatement("insert into coureur (pass,nom,prenom,dateNais,groupeSang) values(?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, obj.getPrenom() );
			stm.setString(2, obj.getNom() );
			stm.setString(3, obj.getPrenom() );
			stm.setString(4, obj.getDateNais());
			stm.setString(5, obj.getGroupSang() );
			
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next())
				obj.setId(rs.getInt(1));
			if (obj.getId() != 0) {
				
				return obj;
			} else {
				return null;
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		
	}
    public Coureur findByLoginAndPwd(String login, String psw) {
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM coureur where nom = ? and pass = ?");
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
				return new Coureur(id,nom, prenom);

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
