package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import courses.*;

public class Participer2Dao extends AbstractDao<Participer2> {

	public Participer2Dao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}




	
	public boolean enreigistrer(Participer2 obj, int id_comp,int id_c,int id_etape) throws Exception {
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO participer(id_comp,id_coureur,id_etape,temps) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1, id_comp);		
			stm.setInt(2, id_c);
			stm.setInt(3, id_etape);
			stm.setInt(4, obj.getTemps());
			stm.execute();
			return true;
		}catch(SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Participer2 obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Participer2 obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Participer2 find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean create(Participer2 obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
