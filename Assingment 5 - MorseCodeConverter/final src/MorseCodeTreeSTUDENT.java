import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeSTUDENT {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFetchAndAdd() { 
		MorseCodeTree tree = new MorseCodeTree();
		tree.addNode(tree.getRoot(), ".", "a");
		tree.insert("-", "b");
		assertEquals(tree.fetchNode(tree.getRoot(), "."), "a");
		assertEquals(tree.fetch("-"), "b");
		
		tree.insert("-.", "c");
		assertEquals(tree.fetch("-."), "c");
	}
	
	@Test
	public void testBuildTree() {
		MorseCodeTree tree = new MorseCodeTree();
		
		//assertEquals("", tree.fetch(""));
		assertEquals("e", tree.fetch("."));
		assertEquals("t",tree.fetch("-") );
		assertEquals("i", tree.fetch(".."));
		assertEquals("a",tree.fetch(".-"));
		assertEquals("n", tree.fetch("-."));
		assertEquals("m", tree.fetch("--"));
		assertEquals("s", tree.fetch("..."));
		assertEquals("u", tree.fetch("..-"));
		assertEquals("r", tree.fetch(".-."));
		assertEquals("w", tree.fetch(".--"));
		assertEquals("d", tree.fetch("-.."));
		assertEquals("k", tree.fetch("-.-"));
		assertEquals("g", tree.fetch("--."));
		assertEquals("o", tree.fetch("---"));
		assertEquals("h", tree.fetch("...."));
		assertEquals("v", tree.fetch("...-"));
		assertEquals("f", tree.fetch("..-."));
		assertEquals("l", tree.fetch(".-.."));
		assertEquals("p", tree.fetch(".--."));
		assertEquals("j", tree.fetch(".---"));
		assertEquals("b", tree.fetch("-..."));
		assertEquals("x", tree.fetch("-..-"));
		assertEquals("c", tree.fetch("-.-."));
		assertEquals("y", tree.fetch("-.--"));
		assertEquals("z", tree.fetch("--.."));
		assertEquals("q", tree.fetch("--.-"));
	}
	
	@Test
	public void testToArrayList() {
		MorseCodeTree tree = new MorseCodeTree();
		tree.toArrayList();
		
		assertEquals("h", tree.toArrayList().get(0));
		assertEquals("s", tree.toArrayList().get(1));
		assertEquals("v", tree.toArrayList().get(2));
		assertEquals("i", tree.toArrayList().get(3));
		assertEquals("f", tree.toArrayList().get(4));
		assertEquals("u", tree.toArrayList().get(5));
		assertEquals("e", tree.toArrayList().get(6));
		assertEquals("l", tree.toArrayList().get(7));
		assertEquals("r", tree.toArrayList().get(8));
		assertEquals("a", tree.toArrayList().get(9));
		assertEquals("p", tree.toArrayList().get(10));
		assertEquals("w", tree.toArrayList().get(11));
		assertEquals("j", tree.toArrayList().get(12));
		assertEquals("",  tree.toArrayList().get(13));
		assertEquals("b", tree.toArrayList().get(14));
		assertEquals("d", tree.toArrayList().get(15));
		assertEquals("x", tree.toArrayList().get(16));
		assertEquals("n", tree.toArrayList().get(17));
		assertEquals("c", tree.toArrayList().get(18));
		assertEquals("k", tree.toArrayList().get(19));
		assertEquals("y", tree.toArrayList().get(20));
		assertEquals("t", tree.toArrayList().get(21));
		assertEquals("z", tree.toArrayList().get(22));
		assertEquals("g", tree.toArrayList().get(23));
		assertEquals("q", tree.toArrayList().get(24));
		assertEquals("m", tree.toArrayList().get(25));
		assertEquals("o", tree.toArrayList().get(26));
		
	}
}
