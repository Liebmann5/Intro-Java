import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JFrame;

//BOOK:Drawing overrides the paint method that it inherits from
//Canvas. paint loops through the list of DrawablePolygon objects
//and invokes draw on each one.
//???Did we know to do this and if so how?? or was this just a
//happy coincidence???????; random fact???
//??(27)Pertaining to the debugging I never saw this occur?? When
//would it or is supposed to????
public class Drawing extends Canvas {
	//(50)BOOK:The Drawing class does essentially three things: 
	// 1. it maintains a list of objects 
	// 2. it invokes the draw method on each object
	// 3. it invokes the step method on each object.
	
	//BOOK:The ArrayList in Drawing is a "polymorphic" data
	//structure, because the elements can be different types.
	//???????????Only DP and RP right??????????????????
	//??(30)Why is list even in this class; shouldn't it be in RP since that's
	//where all the Polygon attributes are????????????????????????????????
	//(Bc of 51)private ArrayList<DrawablePolygon> list;
	private ArrayList<Actor> list;
	
	public Drawing(int width, int height)
	{	
		//??(26)the object at hand here is Drawing(this) and setSize is from Canvas
		setSize(width, height);
		setBackground(Color.WHITE);
		//??(31)Of all the places to declare list, WHY THE HECK IS IT HERE????????
		//list = new ArrayList<DrawablePolygon>();
		//??^Error occurred because of type mismatch DP to Actor, BUT ISN'T
		//DP an Actor now?? so why does it matter?????
		list = new ArrayList<Actor>();
	}
	
	//"polymorphic method" && overrides method from ArrayList
	//public void add(DrawablePolygon cp)
	public void add(Actor cp)
	{
		list.add(cp);
	}
	
	//??(28)WHEN THE HECK DO WE USE THIS & HOW DOES IT WORK?? What is it's purpose??
	public void paint(Graphics g)
	{
		//for(DrawablePolygon dp : list)
		for(Actor dp : list)
		{
			dp.draw(g);
		}
	}
	
	//???????????????????????????????????????????????????????????????????????
	//??(20)Before I put breakpoints debug would skip this class completely??
	public static void main(String[] args)
	{
		//??(21)WHY DOES DEBUG SKIP THIS!!??? IT EVEN HAS THE BREAKPOINT!!????
		if(3 < 3)
			System.out.println("Stop!");
		//BOOK:create some regular polygons
		//DrawablePolygon p1 = new DrawablePolygon(3, 50, Color.GREEN);
		//??(10)RP p1 = RP works but is there a flaw or am I missing out on
		//something in doing this???? Why represent as below?? and because
		//a RP is technically a DP why doesn't DP p1 = DP(^) work?????
		//??I don't see the purpose of DP because we never even call it or
		//invoke anything from it?? It has a constructor yet I don't see
		//us ever use it or see any use for it here???????????????????????
		//(22)??????WHY DOES 3 WORK HERE(3 < 3) => Exception??????????????
		DrawablePolygon p1 = new RegularPolygon(3, 50, Color.GREEN);
		DrawablePolygon p2 = new RegularPolygon(6, 50, Color.ORANGE);
		DrawablePolygon p3 = new RegularPolygon(360, 50, Color.BLUE); //360 degrees!!
		
		//BOOK:move them out of the corner	
		//??(24)From the code I think it just moves EVERY (x, y) point over
		//however far we have made the new center?????
		p1.translate(100, 80);
		p2.translate(250, 120);
		p3.translate(400, 160);
		
		//BOOK:create drawing, add polygons
		Drawing drawing = new Drawing(500, 250); 
		//??(25)The Drawing object drawing adds object p1 to its "list" but its
		//value in list is only a reference??? Soooo p1 only takes up index[0]?
		//and doesn't add every (x, y) point individually to an element in the
		//List(p1's 1st point doesn't go to index[0] in List)???
		drawing.add(p1);
		drawing.add(p2);
		drawing.add(p3);
		
		//BOOK:set up the window frame
		JFrame frame = new JFrame("Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawing);
		frame.pack();	
		//!!!!!!!!!!!!!!!!!!!THIS OPENS THE NEW THREAD!!!!!!!!!!!!!!!!!!!!!
		//!!!!IN DEBUG I can't fix the problem or see what and when things happen
		//because this opens a new thread which works separately than the current
		//which I'm pretty sure continues with the while below!!??
		//??In terms of Threads does (50) maybe show a reason why this might be???
		frame.setVisible(true); 
		
		//int i = 0;
		//the blinking class????
		//????DOES THIS GO HERE?????
		//??It said it was supposed to animate the polygons but all they are
		//doing is blinking???? Is that what it was supposed to do??????????
		//??AFTER LIKE 10 SECONDS ONLY THE CIRCLE BLINKS??????? the others don't?
		//???????????????????????????????????????????????????????????????????????
		//Isn't this the same thing as the blinking class?? So why even have that
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//(80)BOOK:Previously, we implemented the animation loop using while (true)
		//and Thread.sleep. Java provides a Timer class (in javax.swing) that
		//encapsulates this behavior.
		/*while(true)
		{
			drawing.step();
			//i++;
			//System.out.println(i);
			try {
				Thread.sleep(1000/30);
			} 
			catch(InterruptedException e) {
				//System.out.println(i); //noshing
			}
		}*/
		
		//!!!!!!!!!WON'T LET ME MOVE THE SMILEY FACE!!!!!!!!!!!!!!!!!
		//??(90)Do the arrow keys not work here because we are using this classes'
		//draw and step methods????
		Sprite sprite = new Sprite("C:\\Users\\user\\Desktop\\face-smile.png",
				25, 150);
		drawing.add(sprite);
		//BOOK:The addKeyListener method is inherited from Canvas. It adds a
		//KeyListener to the list of objects that will receive key events.
		drawing.addKeyListener(sprite);
		//BOOK:In graphical applications, key events are only sent to components
		//when they have the keyboard focus. The setFocusable method ensures that
		//drawing will be have the focus initially, without the user having to
		//click on it first.
		drawing.setFocusable(true);
	}
	
	//BOOK:step invokes step on each DrawablePolygon in the list and then
	//repaints (clears and redraws) the canvas. In order for this code
	//to compile, we need DrawablePolygon to provide a step method.
	//??Q1: (40) 
	//??Q2: No idea what anything beyond here is doing?? especially painting??
	public void step()
	{
		//?list is from the object drawing??? thats why we pass our drawing object??
		//??Why use recursion here?? and not just say repaint dp.p1 then p2 & p3????
		//for(DrawablePolygon dp : list)
		for(Actor dp : list)
			dp.step();
		//??^(40)Why make yourself make a step method in the DP class????? 
		//??^(42)Why not just have it call to a specific subclass like RP
		//since it's already a DP??? Adding a blank method seems foolish???
		repaint();
		//??^Where the heck does repaint() come from???
		//??^Also is the current object(this) here, drawing or dp.p1 for repaint???
		//??^Is the purpose of this call for blinking so it paints p3 then p2>p1???
	}
}