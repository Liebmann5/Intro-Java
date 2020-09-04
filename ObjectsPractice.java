/*
 * Chapter 9.3
 * 
 * Chapter 9 is also connected to the CommandLine folder!
 */
import java.math.BigInteger;

public class ObjectsPractice
{
	public static void main(String[] args)
	{
		/*
		 * When you invoke a method on a String,
		 * you get a new String object as a result.
		 * (1)After the 1st two statements run,
		 * upperName 'refers' to the string "ALAN TURING".
		 * -toUpperCase() DOES NOT AFFECT THE O.G. STRING
		 *  Ex)The 1st Paragraphs result.The value of name,
		 *  which refers to the O.G. String object, never
		 *  changes.(2)To save the result you need to assign
		 *  the return value.
		 */
		String name = "Alan Turing";
		//(1)String upperName  = name.toUpperCase();
		name.toUpperCase();
		//(2)name = name.toUpperCase();
		System.out.println(name);
		
		String text = "Computer Science is fun?";
		//text.replace("Computer Science", "CS");
		text = text.replace("Computer Science", "CS");
		System.out.println(text);
		
		//parse => "read and translate"
		String str = "12345";
		double num = Double.parseDouble(str);
		System.out.println(num);
		int num2 = 12345;
		String stri = Integer.toString(num2);
		System.out.println(stri);
		
		/*
		 * Objects from wrapper classes are also immutable.
		 * x and y refer to different objects.
		 * 
		 * ?Should only display the 2nd if not the 1st????
		 */
		Integer x = Integer.valueOf(123);
		Integer y = Integer.valueOf(123);
		System.out.println(y);
		if(x == y)                    //false
			System.out.println("x and y are the same object!");
		if(x.equals(y))               //true
			System.out.println("x and y are the same value!");
		
		//BigInteger's have no upper bound they only depend on
		//your memory size and processing speed.
		long z = 17;
		BigInteger big = BigInteger.valueOf(z);
		System.out.println(big);
		String s = "12345678901234567890";
		BigInteger bigger = new BigInteger(s);
		System.out.println(bigger);
	}
}