package calculator;
/*
 * This class holds all the functions for performing mathematical operations as needed.
 */
import java.math.*;
public class Calculations {
	
	public static String[] ratio(double firNum, double secNum) {
		// results holds the values of every calculation
		String[] results = new String[4];
		
		// Ensures the first number is smaller than the second to simplify math
		// TODO Possibly replace with a check before the numbers are passed to ratio?
		if (firNum > secNum) {
			double tempNum = secNum;
			secNum = firNum;
			firNum = tempNum;
		}
		
		// Simple ratio calculation, looks for greatest common divisor using modulo
		double tempFir = firNum;
		double tempSec = secNum;
		while (tempSec != 0) {
			double tempNum = tempSec;
			tempSec = tempFir % tempSec;
			tempFir = tempNum;
		}
		results[0] = (firNum/tempFir)+":"+(secNum/tempFir);
		
		// Basic ratio calculation, 1:x
		results[1] = "1:"+secNum/firNum;
		
		System.out.println("Answer 1 = " + results[0]);
		System.out.println("Answer 2 = " + results[1]);
		return results;
	}
}
