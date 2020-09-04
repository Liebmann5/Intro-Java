/**
*	Chapter 5.9
*
*	Using Operators and if-else statements.
**/
import java.util.Scanner;

public class Logarithm
{
	public static void main(String[] args)
	{
		System.out.println("Give a number to take the log of!");
		Scanner in = new Scanner(System.in);
		/*
		 * hasNextDouble just checks if the user's input is a
		 * double and if not returns ONLY the next token
		 * because of .next() method
		 */
		if(!in.hasNextDouble())
		{
			String word = in.next();
			System.err.println(word + " NaN");
			return;
		}
		
		double num = in.nextDouble();
		if(num > 0)
		{
			double log = Math.log(num);
			System.out.println(log + " is the natural log of " + num);
		}
		else
			System.err.println(num + " is not a positive number.");
	}
}