/*
 * Chapter 15.6
 */
//import java.awt.Frame;
import javax.swing.JFrame;

public class Conway extends Automaton
{
	//ALSO had to remove this for Automaton to work!!!!
	//??Can superclass's have access to a subclasses instance variable???
	//Since Automatan had an error at frame.add(this.grid); I'd say they can!????
	//private GridCanvas grid;
	
	public Conway()
	{
		grid = new GridCanvas(5, 10, 30);
		//??So if we initialize a variable(grid) with an object
		//type(GridCanvas) then once we declare it are we
		//allowed to access that classes methods?? I ask because I
		//feel like we had to access that objects variables(array)
		//in order to use that classes methods???? grid.array.turnOn
		grid.turnOn(2, 1);
		grid.turnOn(2, 2);
		grid.turnOn(2, 3);
		grid.turnOn(1, 7);
		grid.turnOn(2, 7);
		grid.turnOn(3, 7);
	}
	
	/*public static void main(String[] args)
	{
		String title = "Game of Life";
		Conway game = new Conway();
		JFrame frame = new JFrame(title);  //JFrame makes a window on your screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit's program if window gets closed 
		frame.setResizable(false);  //resizing the window is disabled
		frame.add(game.grid);  //adds GridCanvas inside the frame
		frame.pack();  //resizes the frame to fit the canvas(resize means "packs"{?it in?})
		frame.setVisible(true);  //makes the frame visible
		game.mainloop();
	}*/
	public static void main(String[] args)
	{
		//BOOK:Conway extends Automaton, so it inherits the protected instance 
		//variable grid and the methods run and mainloop. But because Automaton is 
		//abstract, Conway has to provide update and a constructor (which it has 
		//already).
		//?????Why does Conway need to provide a constructor???? Because abstract
		//classes can't be instantiated does that mean, because they can never create
		//an object for their class, that a constructor must always be provided???
		//Basically do I always have to give a constructor to an abstract class?????
		String title = "Game of Life";
		Conway game = new Conway();
		game.run(title, 2);
	}
	
	/*public void mainloop()
	{
		while(true)
		{
			this.update();
			//BOOK:repaint comes from the Canvas class(10)
			//???So because repaint is in Canvas which is the superclass
			//of GridCanvas DOES that mean whenever I make a new object in
			//a class outside of the created object(like GridCanvas here,
			//in Conway) I can call a method from the superclass????(below)
			//(11)BOOK:By default, it calls the paint method we provided,
			//which calls draw. We do this so we don't have to provide a
			//Graphics object as a parameter.	QUESTION still stands!
			grid.repaint();
			//Causes the program to "sleep" for 500 milliseconds(=.5 sec)
			//Thread.sleep(500);
			//^Gave us "Unhandled exception type InterruptedException" error
			//BOOK:First, Java runs the code in the try block, which calls
			//Thread.sleep. If an InterruptedException occurs during the try
			//block, Java executes the catch block. In this example, the catch
			//block contains a comment, so it doesn't do anything.
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				//BOOK:do nothing
			}
		}
	}*/
	
	/*public int test(int r, int c)
	{
		try
		{
			if(array[r][c].isOn())
				return 1;
		} catch(ArrayIndexOutOfBoundsException e) {
			//cell doesn't exist
		}
		return 0;
	}*/ 
	
	//???????????????????????????????????????????????????????????????
	//Thinking about how to logically organize the code and divide up
	//its classes and methods; why are all the below methods in the
	//actual games class? Shouldn't they be in the GridCanvas class
	//since they deal with the grid or is there something I'm not
	//considering as why they need to be here? OR maybe why it's a
	//better option to keep them here?
	//IDEA:Is it because these are the rules of the game essentially?
	//If so, then what about updateGrid and UpdateCell, those I feel
	//don't belong in this class?
	//????????????????????????????????????????????????????????????????
	
	
	//(21)Deals with any values of r and c
	public int countAlive(int r, int c)
	{
		int count = 0;
		count += grid.test(r - 1, c - 1);
		count += grid.test(r - 1, c);
		count += grid.test(r - 1, c + 1);
		count += grid.test(r, c + 1);
		count += grid.test(r + 1, c + 1);
		count += grid.test(r + 1, c);
		count += grid.test(r + 1, c - 1);
		count += grid.test(r, c - 1);
		return count;
	}
	
	public void update()
	{
		//NOTICE kinda the idea here!!!! We run a method that
		//returns a value(int[][]) that we need; so we save it,
		//so that we can later invoke another method and pass
		//that value to it as an argument. Yet within that
		//method we will invoke another method that doesn't 
		//have any need or use for the argument that we passed
		//to the prior method!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//I felt like this was maybe an important idea or concept?
		//[countNeighbors() > updateGrid() > updateCell()] was
		//the idea I think?????
		int[][] counts = countNeighbors();
		updateGrid(counts);
	}
	
	private int[][] countNeighbors()
	{
		int rows = grid.numRows();
		int cols = grid.numCols();
		
		int[][] counts = new int[rows][cols];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				counts[r][c] = countAlive(r, c);
			}
		}
		return counts;
	}
	
	//updateGrid() and updateCell() are private because they are
	//helper methods; not intended to be invoked from outside of
	//the class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void updateGrid(int[][] counts)
	{
		int rows = grid.numRows();
		int cols = grid.numCols();
				
		for(int r = 0; r < rows; r++) {		
			for(int c = 0; c < cols; c++)
			{
				Cell cell = grid.getCell(r, c);
				updateCell(cell, counts[r][c]);
			}
		}
	}
	
	//ALSO, this is static because it does not depend on the grid!!
	private static void updateCell(Cell cell, int count)
	{
		if(cell.isOn()) {
			if(count < 2 || count > 3) {
				cell.turnOff();
			}
		}
		else {
			if(count == 3) {
				cell.turnOn();
			}
		}
	}
}