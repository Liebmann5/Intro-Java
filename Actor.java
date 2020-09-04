import java.awt.Graphics;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????????????????????????????????????????
//IDEA:I believe the purpose of an interface is a way for multiple
//objects(DP & {?Sprite or Game}?) in a code to invoke an interface(Actor)
//for the purpose of identifying them as a new object that will allow them
//to use a common code that they both require! {for the means of having less
//code in your program} I think this package has only 2 objects that need
//to be manipulated which is ?DP and Sprite?; the other objects can be/are
//these objects already(?because they are subclasses?). Both objects have
//different draw() and step() which is why Actor requires both common
//objects to have and implement them. Identifying both of them as a common
//object(Actor) allows them to use Drawing, which uses that common object as
//a "type" in the class so the only object type to be used in parameters or
//ArrayLists is that very common object type(Actor)!!!!!! ??Drawing has it's
//own step method which then calls step() again BUT, ?I think it invokes the
//step method that each object provided in Actor... so because dp is an Actor
//type/object it doesn't use recursion it actually ?knows that the objects(dp)
//is an interface? so it invokes the step method in Actor which then invokes
//the proper objects step()? If this is true then ya BUT why is recursion not
//the immediate ?thing to do?????? {Go through the section again and see how
//dp.step() is used throughout because I think it changes!!!!} DRAWING is the
//common code and ?it is what makes a blank Canvas for every class and allows
//them to manipulate multiple objects(becasue of ArrayList) from each of the
//2 main objects!!????
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????????????????????????????????????????
//??With this idea in mind; WHY did he make us put the DP main method in
//Drawing? rather than us invoking Drawing from DP??
//IDEA:I think it was just a weird situation translate() & other methods
//required a extends Canvas(which I'm pretty sure he explains as how to deal
//with an object that needs 2 superclasses) so... ????????????????????
//public class Actor
public interface Actor
{
	//(51)BOOK:Define a new superclass, which we call Actor, that
	//provides the two methods needed by Drawing:
	//???Drawing doesn't need any methods so how the heck would I
	//know what to provide?????????????????
	/*public void draw(Graphics g)
	{
		//do nothing
	}*/
	//??Why can't I put a breakpoint here to see when this method
	//is implemented or invoked??????????????????????????????????
	void draw(Graphics g);
	
	/*public void step()
	{
		//do nothing
	}*/
	void step();
	
	//Seems as though the 2nd one works here but not the 1st!!??
	//Polygon p1 = new DrawablePolygon();
	Actor a2 = new DrawablePolygon();
}