/**
 * 3.9
 * Convert given inches to feet and inches.
 */
import java.util.Scanner;

public class FeetAndInches
{
	public static void main (String[] args)
	{
		System.out.println("Hello we're converting inches"
				+ " to feet and inches.");
		System.out.println("How many inches you got?");
		Scanner in = new Scanner(System.in);
		double measurement = in.nextDouble();
		final int INCHES_PER_FEET = 12;
		int feet = ((int)(measurement/INCHES_PER_FEET));
		int inches = (int)(measurement % INCHES_PER_FEET);
		System.out.printf("Alrighty so we are working "
				+ "%,d feet and %d inches!\n", feet, inches);
	}
}