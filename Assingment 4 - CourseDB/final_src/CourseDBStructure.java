import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	@SuppressWarnings("rawtypes")
	LinkedList[] hashTable;
	private int size;
	
	/**
	 * Constructor 1 - Takes in only the size of the hashTable
	 * @param size - size of the hashTable
	 */
	CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[this.size];
	}
	
	/**
	 * Constructor 2 - Used only for testing
	 * @param Testing - Paramater used only for testing
	 * @param size - size of hashTable
	 */
	CourseDBStructure(String Testing, int size) {
		this.size = size;
		hashTable = new LinkedList[this.size];
	}
	
	
	/**
	 * this method adds an element to the hashTable
	 */
	@Override
	public void add(CourseDBElement element) {
		int ip = element.hashCode() % this.size;
		LinkedList<CourseDBElement> list = new LinkedList<CourseDBElement>();
		
		if (hashTable[ip] == null) {
			list.add(element);
			hashTable[ip] = list;
		}
		else {
			hashTable[ip].add(element);
		}
	}
	/**
	 * This method allows you to find a course with a given crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String stringCRN = Integer.toString(crn);
		int key = stringCRN.hashCode();
		int ip = key % this.size;
		LinkedList<CourseDBElement> test = new LinkedList<CourseDBElement>();
		CourseDBElement element = null;
		
		
		for (int i = 0; i < hashTable[ip].size()-1; i++) {
			test = hashTable[ip];
			if(test.get(i).crn == crn) {
				element = test.get(i);
			}
		}
		
		if (element == null) {
			throw new IOException();
		}
		return element;
		
	}
	/**
	 * this method returns the size of the hashTable
	 * @return the size of the hashTable
	 */
	@Override
	public int getTableSize() {
		return size;
	}

}
