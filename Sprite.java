import java.io.IOException;
//What allows us to read the file!!
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.File;

//????????????????????????????????????????????????????????????????????????????
//?????THE ARROW KEYS DIDN'T WORK IN DRAWING?????
//??Is a Sprite object at all related to any of the Polygon objects?????
//??If not is there any way I can make a Sprite object a DP and what would
//be the benefit of that?????
//??Also is a Sprite object an Actor object or is an Actor object a Sprite
//object??? because; pertaining to the 1st 2 questions here, can I make a
//Sprite object an Actor object and then make a DP object that takes that
//Sprite object from the Actor class, because DP implements Actor, essentially
//making a DP object that is an Actor object which is actually a Sprite object?? 
public class Sprite implements Actor, KeyListener
{
	//BOOK:KeyListener is an interface for receiving keyboard events, which
	//means we can detect and respond to key presses. A class that implements
	//KeyListener has to provide the following methods:
	// 1. void keyPressed(KeyEvent e);
	//	  Invoked when a key has been "pressed". This method is invoked repeatedly
	//	  while a key is being held down.
	// 2. void keyReleased(KeyEvent e);
	//	  Invoked when a key has been "released", meaning it is no longer down.
	// 3. void keyTyped(KeyEvent e);
	//	  Invoked when a key has been \typed", which generally means it has been
	//	  both pressed and released.
	//These methods get invoked when the user presses and releases any key. They
	//take a KeyEvent object as a parameter, which specifies which key was pressed,
	//released, or typed.
	
	//BOOK:The instance variables xpos and ypos represent the location
	//of the sprite.
	private int xpos;
	private int ypos;
	//BOOK:dx and dy represent the velocity of the sprite in the x and
	//y directions.
	private int dx;
	private int dy;
	private Image image;
	
	//BOOK:The constructor takes as parameters the name of a File and
	//the initial position.
	public Sprite(String path, int xpos, int ypos)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		try {
			this.image = ImageIO.read(new File(path));
		} catch(IOException exc) {
			exc.printStackTrace();
		} //IOException is for errors that occur during the reading of the file
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(image, xpos, ypos, null);
	}
	
	public void step()
	{
		xpos +=	dx;
		ypos += dy;
	}
	
	//^^^BOOK:The values of dx and dy determine how much the sprite
	//moves each time "(^)step" is invoked.
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				dy = -5;
				break;
			case KeyEvent.VK_DOWN:
				//???WHY IS BELOW LEGAL????? Can I do away with the +????
				dy = +5;
				break;
			case KeyEvent.VK_LEFT:
				dx = -5;
				break;
			case KeyEvent.VK_RIGHT:
				dx = +5;
				break;
		}
	}
	
	//BOOK:When the user releases the key, keyReleased sets dx or dy
	//to 0, so the sprite stops moving in that direction.
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				dy = 0;
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				dx = 0;
				break;
		}
	}
	
	//BOOK:We don't need the keyTyped method for this example, but it's required
	//by the interface; if we don't provide one, the compiler will complain.
	public void keyTyped(KeyEvent e)
	{
		//does nothing
	}
}