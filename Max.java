/*
 * Chapter 9.5
 * 
 * Chapter 9 is also connected with the Objects folder!
 */
import java.util.Arrays;

public class Max
{
	//(1)If I gave ints into the String[] why did the program still run?
	public static void main(String[] args)
	{
		//(1)I think Arrays.toString(args) does this?
		//System.out.println(Arrays.toString(args));
		//I assume this makes max = to the lowest possible int number? YES!
		int max = Integer.MIN_VALUE;
		System.out.println(max);
		if(args.length == 0)
		{
			System.err.println("Usage: java Max <numbers>");
			return;
		}
		for(String arg : args)
		{
			int value = Integer.parseInt(arg);
			if(value > max)
				max = value;
		}
		System.out.println("The max value is " + max);
	}
	
	public static boolean isCapitalized(String str)
	{
		return Character.isUpperCase(str.charAt(0));
	}
}


//C:\Users\>d:
//D:\>cd\Users
//D:\Users>dir
//Volume in drive D has no label.
//Volume Serial Number is 5CF7-7649
//
//Directory of D:\Users
//
//12/31/2018  03:24 PM    <DIR>          .
//12/31/2018  03:24 PM    <DIR>          ..
//08/02/2020  05:55 PM    <DIR>          Liebm
//12/31/2018  03:19 PM    <DIR>          Public
//              0 File(s)              0 bytes
//              4 Dir(s)  1,618,739,593,216 bytes free
//
//D:\Users>cd Liebm
//
//D:\Users\Liebm>cd CommandLine
//
//D:\Users\Liebm\CommandLine>cd src
//D:\Users\Liebm\CommandLine\src>dir /s		<--I don't think you use the s!!
// Volume in drive D has no label.
// Volume Serial Number is 5CF7-7649
//
// Directory of D:\Users\Liebm\CommandLine\src
//
//08/02/2020  06:10 PM    <DIR>          .
//08/02/2020  06:10 PM    <DIR>          ..
//08/02/2020  06:10 PM               180 Max.class
//08/02/2020  06:10 PM               145 Max.java
//               2 File(s)            325 bytes
//
//     Total Files Listed:
//               2 File(s)            325 bytes
//               2 Dir(s)  1,618,739,589,120 bytes free
//
//D:\Users\Liebm\CommandLine\src>javac Max.java
//
//D:\Users\Liebm\CommandLine\src>java Max
//[]
//D:\Users\Liebm\CommandLine\src>java Max 10 -3 55 0 14
//[10, -3, 55, 0, 14]

/*
* The elements of args are strings 
* args is the array {"10", "-3", "55", "0", "14"}
*/

//D:\Users\Liebm\CommandLine\src>javac Max
//error: Class names, 'Max', are only accepted if annotation processing is explicitly requested
//1 error

/*
* To fix this I just ran the program in eclipse
* becuase I had added new code and tried to run it through the prompt
*/

//D:\Users\Liebm\CommandLine\src>javac Max.java
//Max.java:2: error: cannot find symbol
//import java.util.String;
//                ^
//  symbol:   class String
//  location: package java.util
//1 error
//
//D:\Users\Liebm\CommandLine\src>javac Max.java
//
//D:\Users\Liebm\CommandLine\src>java Max 10 -3 55 0 14
//[10, -3, 55, 0, 14]
//The max value is 55
//
//D:\Users\Liebm\CommandLine\src>
