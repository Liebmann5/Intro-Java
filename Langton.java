/*
 * Chapter 16.1
 */
import javax.swing.JFrame;

public class Langton
{
	//BOOK:grid is a GridCanvas object, which represents the state of the cells
	private GridCanvas grid;
	private int xpos;
	private int ypos;
	private int head;
	//head is which direction the ant is facing, "its heading"....
	//0=North(top of the screen), 1=East, 2=South, 3=West
	
	public Langton(int rows, int cols)
	{
		grid = new GridCanvas(rows, cols, 10);
		xpos = rows / 2;
		ypos = cols / 2;
		head = 0;
	}
	
	public void update()
	{
		flipCell();
		moveAnt();
	}
	
	//!!!!!!!!!NOTICE HOW % ALLOWS WRAP-AROUND!!!!!!!!!!!!!!!!!!!!!!!!!
	private void flipCell()
	{
		Cell cell = grid.getCell(xpos, ypos);
		if(cell.isOff())
		{
			head = (head + 1) % 4; 	//%4 seems pointless???
			cell.turnOn();			//(3+1)%4=0 so it allows a wrap around
		} else {
			head = (head + 3) % 4;	//not (head-1) bc (-1)%4=-1
			cell.turnOff();			//!!+3 acts as 3 right turns!!
		}
	}
	
	private void moveAnt()
	{
		if(head == 0) {
			ypos -= 1;
		}
		else if(head == 1) {
			xpos += 1;
		}
		else if(head == 2) {
			ypos += 1;
		}
		else {
			xpos -= 1;
		}
	}
	
	public static void main(String[] args)
	{
		String title = "Langton's Ant";
		Langton game = new Langton(61, 61);
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game.grid);
		frame.pack();
		frame.setVisible(true);
		game.mainloop();
	}
	
	private void mainloop()
	{
		while(true)
		{
			this.update();
			grid.repaint();
			
			try {
				Thread.sleep(2);
			} catch(InterruptedException e) {
				//do nathing
			}
		}
	}
}