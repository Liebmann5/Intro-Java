/**
 * Chapter 3.9
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

//Did this before just copying his code!
//!!!!!!!!!!!!!COMMAND-LINE TESTING!!!!!!!!!!!!!!!!!!!!
/*
D:\Users\Liebm\Conversions\src>dir
 Volume in drive D has no label.
 Volume Serial Number is 5CF7-7649

 Directory of D:\Users\Liebm\Conversions\src

08/30/2020  06:36 PM    <DIR>          .
08/30/2020  06:36 PM    <DIR>          ..
08/30/2020  06:41 PM               725 FeetAndInches.java
08/30/2020  06:42 PM                31 test.exp
08/30/2020  06:42 PM                 9 test.in
               3 File(s)            765 bytes
               2 Dir(s)  1,618,384,183,296 bytes free

D:\Users\Liebm\Conversions\src>javac FeetAndInches.java

D:\Users\Liebm\Conversions\src>java FeetAndInches
Hello we're converting inches to feet and inches.
How many inches you got?
76
76.000000 in = 6 feet, 4 inches

D:\Users\Liebm\Conversions\src>java FeetAndIches < test.in > test.out
Error: Could not find or load main class FeetAndIches
Caused by: java.lang.ClassNotFoundException: FeetAndIches

D:\Users\Liebm\Conversions\src>java FeetAndInches < test.in > test.exp

D:\Users\Liebm\Conversions\src>

D:\Users\Liebm\Conversions\src>diff test.exp test.out
'diff' is not recognized as an internal or external command,
operable program or batch file.

D:\Users\Liebm\Conversions\src>FC test.exp test.out
Comparing files test.exp and TEST.OUT
***** test.exp
Hello we're converting inches to feet and inches.
How many inches you got?
76.000000 in = 6 feet, 4 inches
***** TEST.OUT
*****


D:\Users\Liebm\Conversions\src>

//pg.304
//BOOK:The diff utility summarizes the differences between two files. If there
are no differences, then it displays nothing, which in our case is what we want.
If the expected output differs from the actual output, then we need to continue
debugging. Usually the program is at fault, and diff provides some insight
about what is broken. But there's also a chance that we have a correct program
and the expected output is wrong.
Interpreting the results from diff can be confusing, but fortunately there are
many graphical tools that show the differences between two files. For example,
on Windows you can install WinMerge, on Mac you can use opendiff (which
comes with Xcode), and on Linux there's meld, shown in Figure A.4.
*/