

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class GradebookTester {

	GradeBook g1 = new GradeBook(5);
	@Before
	public void setUp() throws Exception {
		g1.addScore(95);
		g1.addScore(60);
		
		
	}

	@After
	public void tearDown() throws Exception {
	g1 = null;
	}
	
	@Test
	public void testAddScore() {
		assertTrue(g1.toString().equals("95.0 60.0 "));
		assertEquals(2, g1.getScoreSize());
		}
	
	@Test
	public void testSum() {
		assertEquals(155, g1.sum(), .0001);
	}
	
	@Test
	public void testMinimum() {
		assertEquals(60, g1.minimum(), .001);
	}
	
	@Test
	public void testFinalScore() {
		assertEquals(95, g1.finalScore(), .001);
	}
	
	
	
	
	
	
	
	
}
