package calculator;
/*
 * This class holds all the functions for performing mathematical operations as needed.
 */
import java.math.*;
public class Calculations {
	
	public static String[] ratio(double firNum, double secNum) {
		// results holds the values of every calculation
		String[] results = new String[2];
		
		// Ensures the first number is smaller than the second to simplify math
		// TODO Possibly replace with a check before the numbers are passed to ratio?
		if (firNum > secNum) {
			double tempNum = secNum;
			secNum = firNum;
			firNum = tempNum;
		}
		
		// Common divisor calculation, looks for greatest common divisor using modulo
		double tempFir = firNum;
		double tempSec = secNum;
		while (tempSec != 0) {
			double tempNum = tempSec;
			tempSec = tempFir % tempSec;
			tempFir = tempNum;
		}
		results[0] = ((int)(firNum/tempFir))+":"+((int)(secNum/tempFir));
		
		// Simple ratio calculation, 1:x
		results[1] = "1:"+String.format("%.3f", secNum/firNum);
		
		//System.out.println("Answer 1 = " + results[0]);
		//System.out.println("Answer 2 = " + results[1]);
		return results;
	}
	
	// TODO Helper method that saves results where they can be displayed in "History" tab
	private static void saveHistory(String[] results) {
		
	}
}
