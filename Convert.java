/*
 * THIS IS HIS CODE FOR CHAPTER 3!
 * I copied it for the practice of the command-line in Appendix A!!!
 * (NOTE:He writes test.out but in Windows it comes out TEST.OUT)
 * 
 * ??Also he said it's ok to compile your code in your environment
 * and then run it from your command-line, is this true??? From
 * experience I thought once you bring up your code on the
 * command-line, then any new updates to your code(including compile)
 * won't be seen from your current command-line session????? So
 * basically you would have to close and restart your current
 * command-line to fix anything of that sort???????????????????????
 */
import java.util.Scanner;

/**
 * Converts centimeters to feet and inches.
 */
public class Convert 
{
	public static void main(String[] args) 
	{
		double cm;
		int feet, inches, remainder;
		final double CM_PER_INCH = 2.54;
		final int IN_PER_FOOT = 12;
		Scanner in = new Scanner(System.in);
		// prompt the user and get the value
		System.out.print("Exactly how many cm? ");
		cm = in.nextDouble();
		// convert and output the result
		inches = (int) (cm / CM_PER_INCH);
		feet = inches / IN_PER_FOOT;
		remainder = inches % IN_PER_FOOT;
		System.out.printf("%.2f cm = %d ft, %d in\n", cm, feet, remainder);
	}
}

//!!!!!!!!!!!!!COMMAND-LINE TESTING!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!BELOW^ IS CHECKSTYLE!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!BELOW^ IS JAVADOC!!!!!!!!!!!!!!!!!!!!!!!
//D:\>cd Users
//
//D:\Users>cd Liebm
//
//D:\Users\Liebm>cd Conversions
//
//D:\Users\Liebm\Conversions>cd src
//
//D:\Users\Liebm\Conversions\src>dir
// Volume in drive D has no label.
// Volume Serial Number is 5CF7-7649
//
// Directory of D:\Users\Liebm\Conversions\src
//
//09/01/2020  10:26 AM    <DIR>          .
//09/01/2020  10:26 AM    <DIR>          ..
//09/01/2020  10:17 AM               754 Convert.java
//08/30/2020  06:46 PM               983 FeetAndInches.class
//09/01/2020  10:17 AM             2,932 FeetAndInches.java
//09/01/2020  10:26 AM                22 test.exp
//09/01/2020  10:25 AM                 6 test.in
//               5 File(s)          4,697 bytes
//               2 Dir(s)  1,618,384,068,608 bytes free
//
//D:\Users\Liebm\Conversions\src>javac Convert.java
//
//D:\Users\Liebm\Conversions\src>java Convert < test.in > test.out
//
//D:\Users\Liebm\Conversions\src>FC test.exp test.out
//Comparing files test.exp and TEST.OUT
//**** test.exp
//193.04 cm = 6 ft, 4 in
//**** TEST.OUT
//Exactly how many cm? 193.04 cm = 6 ft, 4 in
//****
//
//
//D:\Users\Liebm\Conversions\src>




//!!!!!!!!!!!!!!!!!!!CHECKSTYLE!!!!!!!!!!!!!!!!!!!!!!!!!!
//C:\Users\ user>D:
//
//D:\>cd USers
//
//D:\Users>cd Liebm
//
//D:\Users\Liebm>cs Conversions
//'cs' is not recognized as an internal or external command,
//operable program or batch file.
//
//D:\Users\Liebm>cd Conversions
//
//D:\Users\Liebm\Conversions>cd src
//
//D:\Users\Liebm\Conversions\src>java -jar checkstyle-*-all.jar -c google_checks.xml *.java
//Error: Unable to access jarfile checkstyle-*-all.jar
//
//D:\Users\Liebm\Conversions\src>java -jar checkstyle-*-all.jar -d google_checks.xml *.java
//Error: Unable to access jarfile checkstyle-*-all.jar
//
//D:\Users\Liebm\Conversions\src>java -jar checkstyle-8.36-all.jar -c /google_checks.xml *.java
//Starting audit...
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:20:1: '{' at column 1 should be on the previous line. [LeftCurly]
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:21:1: Line contains a tab character. [FileTabCharacter]
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:21:9: 'method def modifier' has incorrect indentation level 8, expected level should be 2. [Indentation]
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:21:9: Missing a Javadoc comment. [MissingJavadocMethod]
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:22:1: Line contains a tab character. [FileTabCharacter]
//[WARN] D:\Users\Liebm\Conversions\src\Convert.java:22:9: 'method def lcurly' has incorrect indentation level 8, expected level should be 2. [Indentation]




//!!!!!!!!!!!!!!!!!!!!!!JAVADOC!!!!!!!!!!!!!!!!!!!!!!!!!!
//C:\Users\ user>D:
//
//D:\>cd Users
//
//D:\Users>cd Liebm
//
//D:\Users\Liebm>cd Conversions
//
//D:\Users\Liebm\Conversions>cd src
//
//D:\Users\Liebm\Conversions\src>javadoc -d doc Convert.java
//Loading source file Convert.java...
//Constructing Javadoc information...
//Creating destination directory: "doc\"
//Standard Doclet version 12.0.1
//Building tree for all the packages and classes...
//Generating doc\Convert.html...
//Generating doc\package-summary.html...
//Generating doc\package-tree.html...
//Generating doc\constant-values.html...
//Building index for all the packages and classes...
//Generating doc\overview-tree.html...
//Generating doc\deprecated-list.html...
//Building index for all classes...
//Generating doc\index-all.html...
//Building index for all classes...
//Generating doc\allclasses-index.html...
//Generating doc\allpackages-index.html...
//Generating doc\index.html...
//Generating doc\help-doc.html...
//
//D:\Users\Liebm\Conversions\src>