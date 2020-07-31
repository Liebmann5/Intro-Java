/**
 * 3.2
 * Use the Scanner class to read input then print
 * out the given inputs.
 */
import java.util.Scanner;

public class Welcome
{
	public static void main (String[] args)
	{
		System.out.print("Hello, there!");
		System.out.print(" What's your name? ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		//int age  = in.nextInt();
		/*This new Scanner run through will read
		  the inputed name and save it to variable name*/
		// [Ignore^] Only need to set up Scanner 1 time
		//then every input you want to save after needs to
		//saved as a new variable
		//in.nextLine();
		System.out.println("Also how old are you?");
		int age = in.nextInt();
		//String name = in.nextLine();
		
		System.out.println("So " + name + " who is "
				+ age + " years old! Welcome!!!!");
	}
}