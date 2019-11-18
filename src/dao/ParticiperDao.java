package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import courses.*;

public class ParticiperDao extends AbstractDao<Participer> {

	public ParticiperDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	
	public boolean enreigistrer(Participer obj, int id_comp,int id_c,int id_course) throws Exception {
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO participer(id_comp,id_coureur,id_course,temps) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1, id_comp);		
			stm.setInt(2, id_c);
			stm.setInt(3, id_course);
			stm.setInt(4, obj.getTemps());
			stm.execute();
			System.out.println(stm.toString());
			System.out.println("lalalalla");
			return true;
		}catch(SQLException e) {
			System.out.println("lalala");
			
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Participer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Participer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Participer find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean create(Participer obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
