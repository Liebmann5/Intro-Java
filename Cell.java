/*
 * Chapter 15.1
 */
import java.awt.Graphics;
import java.awt.Color;
//import java.awt.Canvas;

public class Cell
{
	//Stable means the total number of live cells doesn't
	//grow over time
	private final int x;
	private final int y;
	private final int size;
	private int state;
	public static final Color[] COLORS = {Color.WHITE, Color.BLACK};
	
	public Cell(int x, int y, int size)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.state = 0;
	}
	
	//takes a graphics context as a parameter
	//??What does "context" mean here????????
	public void draw(Graphics g)
	{
		g.setColor(COLORS[state]);
		g.fillRect(x + 1, y + 1, size - 1, size - 1);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, size, size);
	}
	
	public boolean isOff()
	{
		//??WHY is this allowed? What is and isn't allowed?????
		return state == 0;
	}
	
	public boolean isOn()
	{
		return state == 1;
	}
	
	public void turnOff()
	{
		state = 0;
	}
	public void turnOn()
	{
		state = 1;
	}
}