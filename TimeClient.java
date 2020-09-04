/*
 * Chapter 11.4
 * 
 * To add a new class file in an already existing Java Project
 * 1st make sure that that Window > Perspective > Open
 * Perspective is set to Java and not Debug and once that is
 * good I RIGHT CLICKED on the (default package) > New >
 * Class to get this.
 * BUT I'm not 100% this is correct! or right!
 */
public class TimeClient
{
	public static void main(String[] args)
	{
		Time time = new Time(11, 59, 59.9);
		//System.out.println(time.hour);
		System.out.println(time.getHour());
		
		//This doesn't work an error pop's up
		//System.out.println(Time.printTime(time);
		//********************************************************
		//YOU CALL THE CLASS AND THEN USE "DOT-NOTATION" TO INVOKE
		//THE DESIRED METHOD AND PROVIDE THE ARGUMENTS BY PUTTING
		//THEM INTO THE PARANTHESIS
		//********************************************************
		Time.printTime(time);
		
		//BEFORE I ADDED MY OVERRIDE TO THE TOSTRING METHOD
		//Displays objects type and its address in hexadecimal(indirectly invoking)
		//By using print or ln Java invokes the objects toString method
		System.out.println(time);
		//calling toString directly
		String s = time.toString();
		System.out.print(s);
		
		//
		Time time1 = new Time(3, 30, 0.0);
		Time time2 = time1;
		Time time3 = new Time(3, 30, 0.0);
		//they have the same instance variables
		//time1 is the current object, ?time3 is the argument we want to compare itto
		//time1.equals(time3);
		System.out.println(time1.equals(time3));
		System.out.println(time1.equals(time2));
		System.out.println(time2.equals(time3));
		//Here time1 and time2 reference the same object but time3 refers a new object
		if(time1 == time3)
			System.out.println("true");
		else
			System.out.println("false");
		
		Time start = new Time(18, 50, 0.0);
		Time movieLength = new Time(2, 16, 0.0);
		/*//For the static add method
		Time end = Time.add(start, movieLength);
		System.out.println(end);*/
		Time end = start.add(movieLength);
		System.out.println(end);
	}
}