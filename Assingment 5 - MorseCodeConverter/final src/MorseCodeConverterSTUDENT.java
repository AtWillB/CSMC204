import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterSTUDENT {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		
		String answer = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String str = MorseCodeConverter.printTree();
		str = str.trim(); 
		assertEquals(answer, str);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String answer1 = MorseCodeConverter.convertToEnglish("--. --- --- -.. -... -.-- . / .-- --- .-. .-.. -.. ");
		assertEquals("goodbye world", answer1);
				
		String answer2 = MorseCodeConverter.convertToEnglish("-.. .- .. ... -.-- / -.. .- .. ... -.-- ");
		assertEquals("daisy daisy", answer2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="give me your answer do";		
		getFile("Daisy.txt");
		String answer1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,answer1);
		
		String test2="im half crazy all for the love of you";		
		getFile("DaisyDaisy.txt");
		String answer2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,answer2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}