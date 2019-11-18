package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courses.*;


public class CompetitionDao extends AbstractDao<Competition>{
	public CompetitionDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public Competition save(Competition obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into competition(nomcomp,ville,pays,typecourse,dateDeb,dateFin) values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, obj.getNomcomp());
			stm.setString(2, obj.getVille());
			stm.setString(3, obj.getPays());
			stm.setString(4, obj.getTypecourse());
			stm.setString(5, obj.getDateDeb());
			stm.setString(6, obj.getDateFin());
			
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next())
				obj.setCodecomp(rs.getInt(1));
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean create(Competition obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stm = connection.prepareStatement("insert into competition(id,nomcomp,ville,pays,typecourse,dateDeb,dateFin) values(?,?,?,?,?,?)");
			stm.setString(1, obj.getNomcomp());
			stm.setString(2, obj.getVille());
			stm.setString(3, obj.getPays());
			stm.setString(4, obj.getTypecourse());
			stm.setString(5, obj.getDateDeb());
			stm.setString(6, obj.getDateFin());
			
			
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Competition obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Competition obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Competition find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Competition> findAll() {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM competition ");
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Competition> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Competition(rs.getString(2)));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Competition> findByType(String type) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM competition WHERE typecourse=?");
			
			stm.setString(1, type);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Competition> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Competition(rs.getString(2)));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public int findByNom(String nom) {
		PreparedStatement stm;
		try {
			
			stm = connection.prepareStatement("SELECT * FROM competition WHERE nomcomp=?");
			stm.setString(1, nom);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			int num=0;
	        while(rs.next()) {
	        	num = rs.getInt(1);
	        }
			return num;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	
	public String returnType(String nom) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM competition WHERE nomcomp=?");
			
			stm.setString(1, nom);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			String type=null;
			while (rs.next()) {
				
				type=rs.getString(5);		
			}
			
			return type;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
