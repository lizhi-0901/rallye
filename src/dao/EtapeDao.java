package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courses.*;

public class EtapeDao extends AbstractDao<Etape>{

	public EtapeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Etape obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Etape obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Etape obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Etape find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Etape save(Etape obj,int id) {
	try {
		PreparedStatement stm = connection.prepareStatement("insert into etape(comp_id,ordreEtape, distanceE, niveauE) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		stm.setInt(1,id);
		stm.setInt(2, obj.getOrdreEtape());
		stm.setDouble(3, obj.getDistanceE());
		stm.setString(4, obj.getNiveauE());
		stm.execute();
		ResultSet rs = stm.getGeneratedKeys();
		if(rs.next())
			obj.setCodeEtape(rs.getInt(1)); 
		
		return obj;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}	
	}
	
	public int FindId(int id_comp,int idordre) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM etape WHERE comp_id=? and ordreEtape =?", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1,id_comp);
			stm.setInt(2, idordre);
			stm.execute();
			System.out.println(stm.toString());
			ResultSet rs = stm.getResultSet();
			int idEtape= 0;
			while(rs.next()) {
			idEtape=rs.getInt(1);
			}
				 
			
			return idEtape;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
		}
	
	public List<Etape> FindEtapeById(int id_comp) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM etape WHERE comp_id=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1,id_comp);
			
			stm.execute();
			System.out.println(stm.toString());
			ResultSet rs = stm.getResultSet();
			
			int ordre =0;
			List<Etape> list = new ArrayList<>();	 
			while(rs.next()) {
				ordre =rs.getInt(3);
				list.add(new Etape(ordre));
			}
			return list;
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		}
}
