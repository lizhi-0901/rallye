package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courses.*;


public class InscriptionDao extends AbstractDao<Inscription>{

	public InscriptionDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	
	
	public boolean save(int id_c,int id_com, int id_t) {
		
		try {
			PreparedStatement stm = connection.prepareStatement("insert into inscription (etat,id_coureur,id_comp,id_veh) values(?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1, "Enattend");
			stm.setInt(2, id_c);
			stm.setInt(3, id_com);
			stm.setInt(4, id_t);
			stm.execute();
			
			
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		}

	@Override
	public boolean create(Inscription obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Inscription obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Inscription obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Inscription find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Integer> findidcoureurByidcomp(int id_comp) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM inscription where id_comp=?");
			stm.setInt(1, id_comp);
			
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			List<Integer> listcoureur = new ArrayList<>();
	
			
			
			while (rs.next()) {
				listcoureur.add(rs.getInt(3)) ;
				
			}
			return listcoureur;
		} catch (SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
	
	

}
