/*
 * Chapter 17.1
 */
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Graphics;

//BOOK:SPECIALIZATION is useful for adding new features to an existing
//class, especially when you can't (or don't want to) change its design.
//For example, we can extend the Polygon class by adding a draw method and
//a Color attribute:

//??(11)Shouldn't this class extend RegularPolygon(RP) because technically
//that is the class that actually makes the objects and this class just
//gives those objects the option to be drawn and have color. I can kinda
//see why this class needs to be the superclass in this situation but
//logically I think RP needs to be the superclass??? I feel if someone
//reads my code they might get confused off my organization of these 2
//classes???
//IDEA:I think they are this way exactly to have that happen, which shows
//"polymorphism".?? So the add method takes a DP object but any type of DP
//can be used which includes RP and any other subclasses(if it has any).??
public class DrawablePolygon extends Polygon implements Actor
{
	//^So DP inherits methods from Polygon, and it is required to provide
	//the methods in Actor, step and draw.
	//??Can I inherit step and draw from Polygon and just pass them to Actor??
	//BOOK:(60)In terms of inheritance, DrawablePolygon is both a Polygon and
	//an Actor. (62)And the same is true for subclasses of DrawablePolygon.
	
	public Color color;
	
	//*********************************************************************
	//BOOK:As a reminder, constructors are not inherited when you extend a 
	//class. If you don't define a constructor, the compiler will generate
	//one that does nothing.
	//??Does this only occur for subclasses???? Isn't every program I make
	//a subclass??? so this should always be true no matter what right??????
	public DrawablePolygon()
	{
		//invokes the constructor of Polygon, which initializes the attributes
		//npoints, xpoints, and ypoints
		super();
		//initializes the color attribute to GRAY
		color = Color.GRAY;
	}
	
	//??(29)WHEN THE HECK DO WE USE THIS & HOW DOES IT WORK?? What is it's purpose??
	public void draw(Graphics g)
	{
		g.setColor(color);
		//What is this?????; What is the current object???
		g.fillPolygon(this);
	}
	
	public static void main(String[] args)
	{
		//BOOK:The following code creates a DrawablePolygon and sets its
		//color to GREEN:
		DrawablePolygon p = new DrawablePolygon();
		p.addPoint(57, 110);
		p.addPoint(100, 35);
		p.addPoint(143, 110);
		p.color = Color.GREEN;
		
		//EXAMPLES: (61)
		//??I tried declaring this in Drawing but they didn't work?? Can
		//these declarations only be made here and if yes why???????????
		Polygon p1 = new DrawablePolygon();
		Actor a1 = new DrawablePolygon();
		//EXAMPLES: (63)
		//??Also what is the benefit of having this and doing this??
		//??Again I tried to declare these in RP and it didn't work??
		//????HE HAD THE ACTOR NAME a2 DOWN HERE AS WELL & ERROR?????
		Polygon p2 = new RegularPolygon(5, 50, Color.YELLOW);
		Actor a2 = new RegularPolygon(5, 50, Color.YELLOW);
		//^BOOK:Interfaces are another example of polymorphism. a1 and
		//a2 are the same type of variable, but they refer to objects
		//with different types.
	}
	
	//??(41)If this does absolutely nothing what is the point of even
	//making this exist???
	public void step()
	{
		//do nothing
	}
}