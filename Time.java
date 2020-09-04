/**
 * Chapter 11.1
 */

/*
 * EXAMPLE/EXPLANATION of why to use this. in the constructor
 * 
 * public class Point
 * {
 * 		//Here we declare and assign x to be = to 0 in the Point class
 * 		public int x = 0;
 * 		public int y = 0;
 * 
 * 		//Here we are making a constructor that takes in arguments for the object
 * 		//We wanted to keep the attribute names the same to not cause confusion
 * 		//Inside the constructor x is a local copy of the constructor's 1st arg
 * 		public Point(int x, int y)
 * 		{
 * 			//???Here this.x refers to the Point attribute(one of the named data
 * 			//items that make-up and object) x.[this.x => public int x = 0;]
 * 			//Then the value x is the parameter for the argument that the
 * 			//constructor will receive
 * 			//Finally this is assigning the instance variable x to the argument
 * 			//value that we will receive
 * 			this.x = x;
 * 			this.y = y;
 * 		{
 * }
 * 
 * [https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html]
 */

public class Time
{
	private int hour;
	private int minute;
	private double second;
	
	//(1)Overloading with constructors
	//(1)This constructor makes the object 1st so you can fill in attributes later
	public Time()
	{
		//?If this is a keyword that refers to the object we are creating AND when
		//we create a new class, we also create a new object type then why isn't
		//Time.hour = 0; allowed?
		//What specifically does this mean and what NEW object is this representing
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
		
		//Doing this is wrong because it causes infinite recursion
		//The NEW keyword invokes the constructor and the construction runs again
		//new Time();
	}
	
	//(1)This constructor collects all info before creating the object itself
	public Time(int hour, int minute, double second)
	{
		//Here hour on the right side is the parameter hour, since it was declared
		//most recently, which "shadows" (hides) the instance variable that has the
		//same name
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public static void main(String[] args)
	{
		Time time = new Time();
		//Time time = new Time(11, 59, 59.9);
	}
	
	//"getter" method which allows for the instance variables to be "read only", in
	//other classes, and not "write"
	public int getHour()
	{
		return this.hour;
	}
	
	//"setter" method which allows other classes to modify their instance variables
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	//not a good method for object oriented programming but toString sure is!
	public static void printTime(Time t)
	{
		System.out.print(t.hour);
		System.out.print(":");
		System.out.print(t.minute);
		System.out.print(":");
		System.out.print(t.second);
		System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
	}
	
	//"overrides" java.lang.Object.toString ALSO an instance method not static method
	public String toString()
	{
		//%d with ints, %f with floating-points, & 02 means "total width 2, with
		//leading zeros if necessary", & 04.1 means "total width 4, one digit after
		//the decimal point, leading with zeros if necessary".
		return String.format("%02d:%02d:%04.1f\n", this.hour, this.minute, 
				this.second);
		//String.format returns a formatted String rather than displaying it
	}
	
	public boolean equals(Time that)
	{
		//ERROR: cannot convert double to float => EXPLAIN everything? how?
		//final DELTA = 0.001;
		final float DELTA = (float)0.001;
		//this refers to object time1, that refers to the object time3
		return this.hour == that.hour
				&& this.minute == that.minute
				&& Math.abs(this.second - that.second) < DELTA;
		//we subtract seconds out of fear of possible rounding errors
		//SIDE NOTE:An example is .1 in binary is a repeating fraction when converte
	}
	
	//Shouldn't this object be immutable?
	//Static method of add
	//"invoked the static method with the Time class"?
	/*public static Time add(Time start, Time length)
	{
		start.hour += length.hour;
		start.minute += length.minute;
		start.second += length.second;
		return start;
	}*/
	//instance method of add
	//start is our explicit parameter(?the current object?), movieLength/that is the
	//implicit parameter(?the object we want to compare the current to?)
	//"invoked the instance method with the start object"?
	public Time add(Time that)
	{
		this.hour += that.hour;
		this.minute += that.minute;
		this.second += that.second;
		
		if(this.second >= 60.0)
		{
			this.second -= 60.0;
			this.minute += 1;
		}
		if(this.minute >= 60)
		{
			this.minute -= 60;
			this.hour += 1;
		}
		if(this.hour >= 24)
			this.hour -= 24;
		return this;
	}
}