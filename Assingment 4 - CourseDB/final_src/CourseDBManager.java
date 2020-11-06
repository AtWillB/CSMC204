import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * This is the manager class that uses both the CDE and the CDS
 * @author willbyrne
 *
 */
public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure structure = new CourseDBStructure(20);
	
	/**
	 * This method allows a user to add the course details to the list of courses directly
	 */
	@Override
	public void add(String courseID, int crn, int numOfCredits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement( courseID,  crn,  numOfCredits, roomNum,  instructor);
		structure.add(element);
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement element = new CourseDBElement();
		element = structure.get(crn);
		if (element == null) {
			throw new IOException();
		}
		return element;
		
	}

	/**
	 * This method takes in a txt file of courses and adds them to the course list
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		if (input == null) {
			throw new FileNotFoundException();
		}
		
			Scanner sc = new Scanner(input);
			String courseID = null;
			int crn = 0;
			int numOfCredits = 0;
			String roomNum = null;
			String instructor = null;
			
			while (sc.hasNext()) {
						courseID = sc.next();
						crn = Integer.parseInt(sc.next());
						numOfCredits = Integer.parseInt(sc.next());
						roomNum = sc.next();
						instructor = sc.nextLine();
						
						add(courseID, crn, numOfCredits, roomNum, instructor);
						courseID = null;
						crn = 0;
						numOfCredits = 0;
						roomNum = null;
						instructor = null;
			}
			sc.close();
	}

	/**
	 * This method returns an ArrayList containing all classes in the course list
	 * @returns an ArrayList containing all classes in the course list
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<CourseDBElement> linkedList = new LinkedList<CourseDBElement>();
		
		for (int i =0; i < structure.getTableSize()-1; i++) {
			if (structure.hashTable[i]!= null) {
				linkedList = structure.hashTable[i];
				for (int j = 0; j < linkedList.size(); j++) {
					if (linkedList.get(j) != null) {
						arrayList.add("\nCourse:"+ linkedList.get(j).courseID+ " CRN:"+linkedList.get(j).crn + " Credits:"+linkedList.get(j).numOfCredits+" Instructor:"+linkedList.get(j).instructor+" Room:"+linkedList.get(j).roomNum);
					}
					
				}
			}
		}
		
		return arrayList;
	}

}
