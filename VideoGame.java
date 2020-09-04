import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Toolkit;

//(81)BOOK:A Timer is useful for executing code at regular intervals.
//The constructor for Timer takes two parameters:
// 1. int delay // milliseconds between events
// 2. ActionListener listener // for handling timer events
//The ActionListener interface requires only one method, actionPerformed.
//This is the method the Timer invokes after the given delay. Using a
//Timer, we can reorganize the code in main by defining a class that
//implements ActionListener.
public class VideoGame implements ActionListener
{
	//BOOK:The main method constructs a VideoGame object, which creates a
	//Sprite, a Drawing, and a JFrame. Then it constructs a Timer object
	//and starts the timer. Every 33 milliseconds, the Timer invokes
	//actionPerformed, which invokes step on the Drawing. Drawing.step
	//invokes step on all of its Actor objects, which causes them to update
	//their position, color, or other aspects of their appearance. The
	//Drawing.step then repaints the Canvas, and the time step is done.
	private Drawing drawing;
	
	public VideoGame()
	{
		Sprite sprite = new Sprite("C:\\Users\\user\\Desktop\\face-smile.png",
				50, 50);
		drawing = new Drawing(800, 600);
		drawing.add(sprite);
		drawing.addKeyListener(sprite);
		drawing.setFocusable(true);
		
		JFrame frame = new JFrame("Video Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawing);
		frame.pack();
		frame.setVisible(true);
	}
	
	//??(91)Well if that is the case then aren't I calling that classes step
	//method right here??? since the object invoking step() is a drawing object??
	//IDEA:?I believe since we switched the types in Drawing from DP to Actor that
	//because Actor is an interface we implemented the draw and step methods from
	//Sprite to Actor which is why we used Sprite's methods??
	//???BUT drawing has its own draw method too so why isn't it using that??? 
	//??After the repaint() in Drawing the debugger lead me right to this method?Why?
	public void actionPerformed(ActionEvent e)
	{
		drawing.step();
	}
	
	public static void main(String[] args)
	{
		VideoGame game = new VideoGame();
		Timer timer = new Timer(33, game);
		timer.start();
	}
}