

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * @author Professor Kartchner
 */
public class CourseDBStructureSTUDENT {
	CourseDBStructure cds, testStructure;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(30);
		testStructure = new CourseDBStructure("Testing", 30);
	}

	@After
	public void tearDown() throws Exception {
		cds = testStructure = null;
	}
	
	/**
	 * Test the tableSize for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(30, cds.getTableSize());
		assertEquals(30, testStructure.getTableSize());		
	}
	
	/**
	 * Test the hashTable for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testHashTable()
	{
		//CourseDBStructure cds = new CourseDBStructure(500);
		assertEquals(30, cds.hashTable.length);
		CourseDBElement cde = new CourseDBElement("CMSC510", 39998, 3, "SC101", "Nobody Specifically"); 
		cds.add(cde);
		String stringCRN = Integer.toString(cde.crn);
		int key = stringCRN.hashCode();
		LinkedList<CourseDBElement> list = cds.hashTable[key%cds.getTableSize()];
		assertEquals(39999, list.get(0).getCRN());
		
		cds = new CourseDBStructure("Testing",20);
		assertEquals(20, cds.hashTable.length);	
		cds.add(cde);
		String stringCRN2 = Integer.toString(cde.crn);
		int key2 = stringCRN2.hashCode();
		list = cds.hashTable[key%20];
		assertEquals(39999, list.get(0).getCRN());
	}
}
