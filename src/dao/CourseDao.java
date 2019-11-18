package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courses.Courses;
import courses.Etape;

public class CourseDao extends AbstractDao<Courses> {

	
	public CourseDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	

	public Courses saveE(Courses obj,int id_etape) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into coursesE(etape_id,ordreCourse, distanceC, tempsmaxC) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1,id_etape);
			
			stm.setInt(2, obj.getOrdreCourse());
			stm.setDouble(3, obj.getDistanceC());
			stm.setDouble(4, obj.getTempsmaxC());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next())
				obj.setCodeCourse(rs.getInt(1)); 
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		}
	
	public Courses saveC(Courses obj,int id_comp) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into coursesC(comp_id,ordreCourse, distanceC, tempsmaxC) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stm.setInt(1,id_comp);
			stm.setInt(2, obj.getOrdreCourse());
			stm.setDouble(3, obj.getDistanceC());
			stm.setDouble(4, obj.getTempsmaxC());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next())
				obj.setCodeCourse(rs.getInt(1)); 
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		}
	@Override
	public boolean create(Courses obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Courses obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Courses obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Courses find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Courses> FindCoursesCById(int id_comp) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM coursesC WHERE comp_id=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1,id_comp);
			
			stm.execute();
			System.out.println(stm.toString());
			ResultSet rs = stm.getResultSet();
			
			List<Courses> list= new ArrayList<>();
			int i=0;
			while(rs.next()) {
				i=rs.getInt(3);
				list.add(new Courses(i));
				
			}
				 
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		}
	
	
	
	public List<Courses> FindCoursesEById(int id_etape) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM coursesE WHERE etape_id=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1,id_etape);
			
			stm.execute();
			System.out.println(stm.toString());
			ResultSet rs = stm.getResultSet();
			
			List<Courses> list= new ArrayList<>();
			list.add(new Courses(1));
			int i=0;
			System.out.println(rs.next());
			while(rs.next()) {
				i=rs.getInt(3);
				list.add(new Courses(i));
				System.out.println(i);
				
			}
				 
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
		}

}
