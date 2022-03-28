/**
	 * @author Omar Abarca
	 */
public class CourseDBElement implements Comparable{
	String courseID;
	int CRN;
	int credits;
	String roomNum; 
	String instructor;
	
	   public CourseDBElement() {
	    }

	   public CourseDBElement(String courseID, int CRN, int credits, String roomNum, String instructor) {
	        this.courseID = courseID;
	        this.CRN = CRN;
	        this.credits = credits;
	        this.roomNum = roomNum;
	        this.instructor = instructor;
	    }
	    
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getCRN() {
		return CRN;
	}

	public void setCRN(int cRN) {
		CRN = cRN;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Override the compareTo method
	 * @return the result of compare
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		if (CRN < element.getCRN())
			return -1;
		else if (CRN > element.getCRN())
			return 1;
		else
			return 0;
	}
	
	/**
	 * define the hash code of the element
	 * @return hash code
	 */
	  @Override
	    public int hashCode() {
	        String crn = Integer.toString(CRN);
	        int hashCode = crn.hashCode();
	        return hashCode;
	    }
}
