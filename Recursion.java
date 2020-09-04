/*
 * Chapter 8.3
 * 
 * Connected to this class is a Test2 Class in the
 * HowSubstringsWork folder!
 */
import java.util.Scanner;
//import java.util.*;

public class Recursion
{
	public static void main(String[] args)
	{
		System.out.println("Pick a number to factorial!");
		Scanner in = new Scanner(System.in);
		int userNum = in.nextInt();
		System.out.println(factorial(userNum) + "\n");
		
		System.out.println("Type in any number to see it in Binary!");
		int userBin = in.nextInt();
		binary(userBin);
		System.out.println();
		in.nextLine();
		
		System.out.println("Please provide a String!");
		String userStr = in.nextLine();
		String userLow = userStr.toLowerCase();
		System.out.println(noX(userLow));
	}
	
	//"stub"
	/*public static int factorial(int n)
	{
		return 0;
	}*/
	public static int factorial(int n)
	{
		if(n == 0)
			return 1;
		int sum = n*factorial(n-1);
		return sum;
		//return n*factorial(n-1);
	}
	
	public static void binary(int num)
	{
		//(1)WRONG includes the base case BUT prints normal
		//Because the f(n) is done before everything but printed after!
		//(1)int numToBinary = num % 2;
		if(num != 0)
		{
			//(2)WRONG prints correctly just backwards because
			//it prints before the recursion
			//(2)System.out.print(num%2);
			binary(num/2);
			System.out.print(num%2);
		}
		//(1)System.out.print(numToBinary);
		//return numToBinary;
		
		/*
		int numToBinary = 0;
		int mod = 0;
		//bad thinking because dividing will bring any
		//number to 1 or 2 NOT 0 or 1 and that last 1 or 0
		//division is important for the one's place!!!
		if(num == 0)
			return 0;
		else if(num == 1)
			return 1;
		else
		{
			mod = num % 2;
			System.out.println(mod);
			numToBinary = binary(num/2);
			System.out.println(mod + "\n\n");
			System.out.println(mod);
		}
		return numToBinary;*/
	}
	
	public static String noX(String sent)
	{
		if(sent.length() == 0)
			return "";
		//Why can't I use this in the return and why can it be used
		//for loop without being initialized 1st??????
		String noX;
		String abNoX = "";
		for(int i = 0; i < sent.length(); i++)
		{
			if(sent.charAt(i) == 0 && sent.charAt(i) == 'x')
				sent.substring(i+1);
			if(sent.charAt(i) == 'x')
			{
				//System.out.println(sent);
				String notX = sent.substring(i+1);
				//System.out.println(notX);
				noX = sent.substring(0, i) + notX;
				//Why does this print out the answer and not our return?
				System.out.println(noX);
				abNoX = noX(noX);
			}
		}
		//System.out.println(noX);  ?
		return abNoX;
	}
	
	//How many times the No. 11 appears in an array
	public static int array11(int[] nums, int index)
	{
		if(index >= nums.length)
			return 0;
		int recurse = array11(nums, index+1);
		if(nums[index] == 11)
			return (recurse + 1);
		else
			return recurse;
	}
}