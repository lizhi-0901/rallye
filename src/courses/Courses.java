package courses;

public class Courses {
	private int CodeCourse, ordreCourse;
	private double distanceC,tempsmaxC;
	
	
	public Courses() {
		super();
	}


	public Courses(int codeCourse, int ordreCourse, double distanceC, double tempsmaxC) {
		super();
		CodeCourse = codeCourse;
		this.ordreCourse = ordreCourse;
		this.distanceC = distanceC;
		this.tempsmaxC = tempsmaxC;
	}
	public Courses( int ordreCourse, double distanceC, double tempsmaxC) {
		super();
		
		this.ordreCourse = ordreCourse;
		this.distanceC = distanceC;
		this.tempsmaxC = tempsmaxC;
	}
	public Courses( int ordreCourse) {
		this.ordreCourse = ordreCourse;
		
	}
	
	public int getCodeCourse() {
		return CodeCourse;
	}


	public void setCodeCourse(int codeCourse) {
		CodeCourse = codeCourse;
	}


	public int getOrdreCourse() {
		return ordreCourse;
	}


	public void setOrdreCourse(int ordreCourse) {
		this.ordreCourse = ordreCourse;
	}


	public double getDistanceC() {
		return distanceC;
	}


	public void setDistanceC(double distanceC) {
		this.distanceC = distanceC;
	}


	public double getTempsmaxC() {
		return tempsmaxC;
	}


	public void setTempsmaxC(double tempsmaxC) {
		this.tempsmaxC = tempsmaxC;
	}
	
	
	
}
