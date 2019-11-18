package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import courses.*;


public class TransportDao extends AbstractDao<Transport>{

	public TransportDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	

	
	
public Transport save(Transport obj,String type) {
		
		try {
			PreparedStatement stm = connection.prepareStatement("insert into transport (immatriculation,veh_type,veh_puissance,veh_poid,veh_cylindre) values(?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			stm.setString(2, type);
			
			if("Voiture".equals(type)) {
				stm.setString(1, obj.getImm());
				stm.setDouble(3, ((Voiture) obj).getPuissance());
				stm.setInt(4, 0);
				stm.setInt(5, 0);
			}
			else if("Camion".equals(type)) {
				stm.setString(1, obj.getImm());
				stm.setInt(3, 0);
				stm.setDouble(4, ((Camion) obj).getPoid());
				stm.setInt(5, 0);
			}
			else if("Moto".equals(type)) {
				stm.setString(1, obj.getImm());
				stm.setInt(3, 0);
				stm.setInt(4, 0);
				stm.setDouble(5, ((Moto) obj).getCylindreM());
			}else if("pied".equals(type)) {
				stm.setString(1, "pied");
				stm.setInt(3, 0);
				stm.setInt(4, 0);
				stm.setInt(5, 0);
			}
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()) {
				obj.setIdTransport(rs.getInt(1));
				
				}
			return obj;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		}

@Override
public boolean create(Transport obj) throws Exception {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Transport obj) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean update(Transport obj) {
	// TODO Auto-generated method stub
	return false;
}






public String findtype(int id) {
	// TODO Auto-generated method stub
	return null;
}





@Override
public Transport find(int id) {
	// TODO Auto-generated method stub
	return null;
}

}
