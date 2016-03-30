import java.io.*;
import java.util.*;

/**
 * Converts Decimal numbers to Roman numbers and vice-versa.
 */

public class RomanNumberConverter{

	public static final int MAX_REPITITION = 3;
	static char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	static int[] values = {1000, 500, 100, 50, 10, 5, 1};
	
	public static String ToRoman(int n) {
		int repitition = 0; // Counts the number of times the symbol must be replicated.
		String romanNum = "";
		int i = 0, flag = 0;
		
		if(n > 3999) {
			System.out.println("\nError! Enter numbers in range [0 - 3999]");
			return null;
		}
		else if(n==0)	{
			System.out.println("\tDoes not exist!");
			return null;
		}
			
		while(n > 0) {
			flag = i % 2;
			if(n >= values[i] && flag == 0)	{
				repitition = n / values[i];
				n -= repitition * values[i];
				if(repitition > MAX_REPITITION)	{	//append symbols[i] + symbols[i-1]
					// Processes numbers like 400(CD), 40(XL), 4(IV)
					romanNum = romanNum + symbols[i] + symbols[i-1];
				}
				else {
					//append symbols[i] "repitition" times	
					for(int j = 0; j < repitition; j++)
						romanNum = romanNum + symbols[i];
				}
			}
			else if(n >= values[i] && flag == 1) {
				repitition = (n - values[i]) / values[i+1];
				n = n - values[i] - repitition * values[i+1];
				if(repitition > MAX_REPITITION)	//append symbols[i+1] + symbols[i-1]
					// Processes numbers like 900(CM), 90(XC), 9(IX)
					romanNum = romanNum + symbols[i+1] + symbols[i-1];
				else {
					//append symbols[i] once and symbols[i+1] "repitition" times
					romanNum = romanNum + symbols[i];
					for(int j = 0; j < repitition; j++)
						romanNum += symbols[i+1];
				}
			}
			i++;
		}
		return romanNum;
	}
	
	public static int ToNumeral(String s) {
		int num = 0;
		int temp = 0, curCharValue, nextCharValue;
		
		if(s.length() == 0)	{
			System.out.println("\nEmpty!\nEnter valid Roman number (Contains only M,D,C,L,X,V,I)");
			return -1;
		}
		
		for(int i = 0; i < s.length(); i++)	{
			try {
				curCharValue = values[new String(symbols).indexOf(s.charAt(i))];
				try {
					nextCharValue = values[new String(symbols).indexOf(s.charAt(i+1))];
					if(curCharValue >= nextCharValue)
						num += curCharValue;
					else
						num -= curCharValue;
				}
				catch(StringIndexOutOfBoundsException e)	{
					num += curCharValue;
				}
			}
			catch(ArrayIndexOutOfBoundsException e)	{
				System.out.println("\nError! Enter valid Roman number (Contains only M,D,C,L,X,V,I)");
				return -1;
			}
		}
		return num;
	}
	
	public static void main(String args[])	{
		
		int decimal_num, converted_num;
		String roman_num, converted_roman;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t\t\t Roman Number Converter \t\t\t");
		System.out.println("\t1. Decimal Number to Roman Number Conversion");
		System.out.println("\t2. Roman Number to Decimal Number Conversion");
		System.out.println("\t3. Exit");
		
		System.out.print("\nEnter your choice: ");
		switch(scan.nextInt()) {
			case 1:
				System.out.print("\nEnter the decimal number: ");
				decimal_num = scan.nextInt();
				converted_roman = ToRoman(decimal_num);
				if(converted_roman != null)
					System.out.println("\nThe Roman Numeral representation of " + decimal_num + " is: " + converted_roman);
				break;
			case 2:
				System.out.print("\nEnter the Roman numeral: ");
				roman_num = scan.next().toString().toUpperCase();
				converted_num = ToNumeral(roman_num);
				if(converted_num != -1)
					System.out.println("\nThe Numerical representation of " + roman_num + " is: " + converted_num);
				break;
			case 3:
				System.out.println("Bye!");
				break;
			default:
				System.out.print("\nEnter valid choice: ");
		}
	}
}
