/*
 * Chapter 6.4
 */
import java.util.*;

public class Loops
{
	public static void main(String[] args)
	{
		for (int x = 1; x <= 10; x++)
		{
			/*
			 * This for loop adds +1 to y every
			 * iteration (basically it does a  
			 * full row for every x increment)
			 * 
			 * Once it completes a row (ie. y > 10)
			 * it starts a new row
			 * 
			 * IMPORTANT: initializer is never
			 * never remembered once a loop completes
			 * so int y = 1 is newly discovered when
			 * the nested for loop is run again 
			 */
			for (int y = 1; y <= 10; y++)
			{
				System.out.printf("%4d", (x*y));
			}
			System.out.println();
		}
		//System.out.println();
		

		System.out.print("Greek Alphabet: ");
		for (int i = 913; i <= 937; i++)
			System.out.print((char) i);
		System.out.println('\n');
		
		
		for (int hour = 0; hour <= 23; hour++)
			for (int minute = 0; minute <= 59; minute++)
				System.out.println(timeString(hour, minute));
	}
	
	public static String timeString(int hour, int minute)
	{
		String ampm;
		if (hour < 12)
		{
			ampm = "AM";
			if (hour == 0)
			{
				hour = 12;
			}
		}
		else
		{
			ampm = "PM";
			hour = hour - 12;
			if (hour == 0)
				hour = 12;
		}
		return String.format("%02d:%02d %s%n", hour, minute, ampm);
	}
}