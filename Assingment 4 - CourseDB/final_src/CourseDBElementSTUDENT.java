import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test I wrote for the Element class
 * @author willbyrne
 */
public class CourseDBElementSTUDENT {
	private CourseDBElement dataElem;

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataElem = new CourseDBElement("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataElem = null;
	}

	/**
	 * Test for the createConcordanceArray method
	 * Use the String text created in setUp()
	 */
	@Test
	public void testCompareTo() {
		boolean equals = false;
		CourseDBElement dataElem2 = new CourseDBElement("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		
		if (dataElem.compareTo(dataElem2) == 0) {
			equals = true;
		}
		assertEquals(equals, true);
	}

}
