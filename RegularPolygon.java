//??Since this is a subclass of a class that already imported the Color
//package why don't packages get inherited too?????????????????????????
import java.awt.Color;

//BOOK:Regular polygons are a special case of polygons, so we will use
//specialization to define a class for them. We could extend the Polygon
//class, like we did in the previous section(how we made the 
//DrawablePolygon). But then we would not have the Color functionality
//we just added. So we will make RegularPolygon extend DrawablePolygon.
//When we construct a RegularPolygon, the vertices are centered at the
//point (0, 0).
public class RegularPolygon extends DrawablePolygon
{
	//RegularPolygon rp = new RegularPolygon(6, 50, Color.BLUE);
	//To make the center of the polygon be somewhere else, we can use
	//translate, which we inherit from Polygon!!
	//rp.translate(100, 100);
	//RegularPolygon rps = new RegularPolygon(6);
	
	//????(200)THIS MADE THE COLORS EITHER STAY GRAY FROM DP'S CONSTUCTOR OR
	//IF THAT WAS COMMENTED OUT THEN THEY WOULD BE BLACK????????????????
	//?????????WHY IS HAVING INSTANCE VARIABLES HERE BAD????????????????
	//????What caused the colors to not work and why??? I'm pretty darn sure
	//we never even used the RP class after their object's were made so HOW???
	//!!!As soon as they were commented out no mistakes;even with DP's gray!!!
	//public int nsides;
	//public int radius;
	//public Color color;
	
	//BOOK:This constructor initializes all four DrawablePolygon
	//attributes, so it doesn't have to invoke super().	
	//??(23)IN DEBUG when I created a new RP(in Drawing) it read the parameters
	//in the constructor and then went and did the constructor for DP?? and
	//the this in the 2nd block of code says it's type RP?? DP can't be an
	//RP right it only works vice verse???? p1 returns 2 colors in Drawing
	//grey & green??? ALSO WHEN I CLICKED STEP OVER at the assignment right
	//before this it actually SKIPPED THIS COMPLETELY and just went to DP's
	//constructor????????   WHY????? there's no call to DP's constructor????
	//(201)BOOK QUESTION:(After debugging and reading that BOOK: again) Isn't
	//that statement 100% WRONG from reading my debugging notes!!!! It obviously
	//STILL invokes the super to initialize these attributes!!!??????????????
	public RegularPolygon(int nsides, int radius, Color color)
	{
		//BOOK:When writing constructors, it's a good idea to validate the
		//values you get as arguments. Doing so prevents run-time errors
		//later in the program, which makes the code easier to debug.
		if(nsides < 3)
			throw new IllegalArgumentException("invalid nsides");
		if(radius <= 0)
			throw new IllegalArgumentException("invalid radius");
		if(color == null)
			throw new NullPointerException("invalid color");
		//BOOK:By default, these exceptions(^) terminate the program and
		//display an error message along with the stack trace.
		
		//sides = this.sides;
		//npoints only makes an array for 1 polygon!!! which works
		//because we will already know how many sides to work with!!
		//??Does this mean that because this is a subclass of a
		//subclass(Regular>Drawable>Polygon) that we have access to
		//our superclass's superclass?? Like we have all of their
		//attributes and methods???? (Based off this.npoints=nsides)
		//??^BOOK:This constructor initializes all four DrawablePolygon
		//attributes, so it doesn't have to invoke super().?? So yes???
		this.npoints = nsides;
		this.xpoints = new int[nsides];
		this.ypoints = new int[nsides];
		this.color = color;
		
		double angle = ((2*(Math.PI)) / nsides);
		//???angle = Math.toRadians(angle);
		
		for(int i = 0; i < nsides; i++)
		{
			//If I switch these is cos still done first??????????????
			//????ISN'T THIS WRONG!! (0, 0) is supposed to be the
			//center of the polygon?? when i=0 x&y=0?????????????????
			//ANS:YOUR DUMB!!!! Do the math 1st you fool!!! cos(0)=1
			double x = Math.cos(i * angle) * radius;
			double y = Math.sin(i * angle) * radius;
			xpoints[i] = (int) Math.round(x);
			ypoints[i] = (int) Math.round(y);
		}
	}
	
	public RegularPolygon(int nsides, int radius)
	{
		this(nsides, radius, Color.GRAY);
	}
	
	public RegularPolygon(int nsides)
	{
		this(nsides, 50);
	}
}