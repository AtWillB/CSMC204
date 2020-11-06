/**
 * CourseDBElement implements Comparable, and consists of five attributes: 
 * the Course ID (a String), the CRN (an int), 
 * the number of credits (an int), the room number (a String), 
 * and the instructor name (a String).
 * @author willbyrne
 *
 */
public class CourseDBElement implements Comparable{
	 String courseID;
	 int crn;
	 int numOfCredits;
	 String roomNum;
	 String instructor;
	
	
	/**
	 * First Constructor, takes all as parameters
	 * @param courseID
	 * @param crn
	 * @param numOfCredits
	 * @param roomNum
	 * @param instructor
	 */
	CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructor) {
		this.courseID = courseID;
		this.crn = crn;
		this.roomNum = roomNum;
		this.numOfCredits = numOfCredits;
		this.instructor = instructor;
	}
	
	/**
	 * default constructor
	 */
	public CourseDBElement() {
		this.courseID = null;
		this.crn = 0;
		this.numOfCredits = 0;
		this.roomNum = null;
		this.instructor = null;
	}
	
	/**
	 * Gets the CRN code for the course
	 * @return - the CRN code
	 */
	public int getCRN() {
		return this.crn;
	}

	/**
	 * Compares two different CourseDBElements for 
	 * ranking purposes.
	 * @return a positive number if the current CDE is greater than
	 * the compared CDE, 0 if they are equal, and a negative number
	 * if the compared is greater. 
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return this.crn - element.crn;
	}
	
	/**
	 * sets the CRN of a given course
	 * @param parseInt - the CRN one wishes to set
	 */
	public void setCRN(int parseInt) {
		this.crn = parseInt;
	}
	
	public int hashCode() {
		int crn = this.crn;
		String stringCRN = Integer.toString(crn);
		int key = stringCRN.hashCode();
		return key;
	}
	
	public int getNumOfCredits() {
		return this.numOfCredits;
	}
	
	public void setNumOfCredits(int parseInt) {
		this.numOfCredits = parseInt;
	}
	
	public String getCourseID() {
		return this.courseID;
	}
	
	public void setCourseID(String parseString) {
		this.courseID = parseString;
	}
	
	public String getRoomNum() {
		return this.roomNum;
	}
	
	public void setRoomNUm(String parseString) {
		this.roomNum = parseString;
	}
	
	public String getInstructor() {
		return this.instructor;
	}
	
	public void setInstructor(String parseString) {
		this.instructor = parseString;
	}
}
