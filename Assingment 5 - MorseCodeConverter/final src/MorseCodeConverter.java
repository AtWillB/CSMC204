/**
 * This class generates the string statements in English from morseCode
 * @author willbyrne
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree tree = new MorseCodeTree();;
	
	//Constructor - Useless because methods are static
	public MorseCodeConverter() {
		
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		ArrayList<String> str = tree.toArrayList();
		String printTree = "";
		
		for(String element: str) {
			printTree += element + " ";
		}
		
		return printTree;
	}
	
	/**
	 * Converts morse code into English.
	 * Each letter is delimited by a space (" "). 
	 * Each word is delimited by a "/"
	 * @param code - the morse code
	 * @return - the English translation
	 */
	public static String convertToEnglish(String code) {
		String[] codeBits = code.split(" ");
		String english = "";
		
		for (int i = 0; i < codeBits.length; i++) {
			if (!codeBits[i].equals("/")) {
				english += tree.fetch(codeBits[i]);
			}
			else {
				english += " ";
			}
		}
		
		return english;
	}
	
	/**
	 * Converts a file of Morse code into English 
	 * Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’. 
	 * @param codeFile - name of file that contains morse code
	 * @return - the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		if (!codeFile.exists()) {
			throw new FileNotFoundException();
		}
		
		Scanner sc = new Scanner(codeFile);
		String morseCode = sc.nextLine().trim();
		
		return convertToEnglish(morseCode);
	}
	
	

}
