/*
 * Chapter 10.1
 */
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;

public class PointAndRectangle
{
	public static void main(String[] args)
	{
		Point cordinates = new Point();
		//cordinates = cordinates.Point(3,2);
		cordinates = new Point(3, 4);
		Point blank;
		blank = new Point(7, 7);

		printPoint(cordinates);
		System.out.println(cordinates);

		double pointsDist = distance(cordinates, blank);
		System.out.println(pointsDist);
		
		Rectangle box = new Rectangle(0, 0, 100, 100);
		System.out.println(box);
		System.out.println(findCenter(box));

		Rectangle boxy = new Rectangle(0, 0, 100, 200);
		moveRect(boxy, 50, 100);
		boxy.translate(50, 100);
		System.out.println(boxy);
		
		//box1 and box2 are "aliases", they refer to the same object so they're 
		//the exactly the same, the Rectangle object has 2 names basically
		//I assume this reinforces the idea that variables values are references
		Rectangle box1 = new Rectangle(1, 2, 3, 4);
		Rectangle box2 = box1;
		box1.grow(6, 8);
		System.out.println("Box1=" + box1 + " & Box2=" + box2);
		
		//blanky will be destroyed completely in memory
		Point blanky = new Point(3, 4);
		blanky = null;
		
		String s1 = "Hi, Mom!";
		String s2 = "Hi, " + "Mom!";
		if(s1 == s2)
			System.out.println("s1 and s2 are the same");
		//REMEMBER String returns a completely new String and it must be saved
		//in order for it to be remembered
		//s1.concat(" Coolio!");
		s1 += " Coolio!";
		System.out.println(s1);
		System.out.println(s2);
		
		Scanner in = new Scanner(System.in);
		String text = "";
		for(int i = 0; i < 10; i++)
		{
			String line = in.nextLine();
			text = text + line + '\n';
			//text = text + line;
			//System.out.print(text);
		}
		//It's supposed to return the last created String and delete all the prior
		//created objects but it returns nothing. BUT I think the newLine command
		//is whats returned cause ?it creates the start of a new String????^
		/*
		 * I BELIEVE this is right it 1st creates a String object for line then it
		 * creates a String object for text that saves all prior inputs BUT the
		 * newLine character also creates a new String by going to the next Line 
		 * AND this ultimately causes text to equal the new empty line and not the
		 * prior Strings? So this would cause 3 objects to be made every iteration
		 */
		System.out.println(text);
		//I assume this is just showing how the below only creates ?1 object with
		//mutable objects vs the above that does 30
		//ALSO, I think '\n' is just an annoying add on that makes new empty
		//objects? and the below shows that it doesn't for mutable objects
		StringBuilder texts = new StringBuilder();
		for(int i = 0; i < 10; i++)
		{
			String line = in.nextLine();
			texts.append(line);
			texts.append('\n');
			//System.out.println(texts);
		}
		System.out.println(texts);
	}

	public static void printPoint(Point p)
	{
		System.out.println("x=" + p.x + " & y=" + p.y);
	}

	//originally had return type int and changed to ensure all #'s work and no
	//rounding
	//I BELIEVE Math. methods return double and doubles can't => ints so cast 
	public static double distance(Point one, Point two)
	{
		Point subtraction = new Point((two.x - one.x), (two.y - one.y));
		// sum below goes from double->int BUT int squareX won't WHY? (I changed it)
		// int sum = (subtraction.x + subtraction.y);
		double squareX = Math.pow(subtraction.x, 2);
		double squareY = Math.pow(subtraction.y, 2);
		// Wrong you want to call the class Math in which the method sqrt
		// lies! BUT WHEN do you put the variable in front and in the parenthesis?
		// You invoke a method on that variable
		// result.sqrt();

		// Point is not a primitive type
		double sum = (squareX + squareY);
		// int result = Math.sqrt(sum);
		return Math.sqrt(sum);
		// System.out.println(result);
		// return result;
	}

	public static Point findCenter(Rectangle z)
	{
		/*
		 * //Why is Point an int here but in distance it's a double?
		 * Point center = new Point();
		 * center = new Point((int)Math.sqrt(z.width), (int)Math.sqrt(z.height));
		 * //int w = (int)Math.sqrt(z.width);
		 * //int h = (int)Math.sqrt(z.height);
		 * //center = new Point(w, h);
		 * center = new Point(center.x, center.y);
		 * return center;
		 */
		
		 int x = z.x + z.width/2;
		 int y = z.x + z.height/2;
		 return new Point(x, y);
	}
	
	public static void moveRect(Rectangle moved, int dx, int dy)
	{
		moved.x = moved.x + dx;
		moved.y = moved.y + dy;
		System.out.println(moved);
	}
}