/*
 * Chapter 15.4
 */
import java.awt.Canvas;
import java.awt.Graphics;

//BOOK:By extending the Canvas class from java.awt, we inherit methods
//for drawing graphics on the screen.
//!!!!Have to import it(?I think?) in order to extend it which makes
//0 sense??? If it's imported we should have it regardless then right???
//IDEA:Has to do with setSize!! this. and array. didn't work??????
public class GridCanvas extends Canvas
{
	//GridCanvas "IS-A" Canvas that "HAS-A" two-dimensional array
	//of cells
	//?????Sooooo GridCanvas shares an instance from array or Cell???(HAS-A part)?
	private Cell[][] array;
	
	public GridCanvas(int rows, int cols, int size)
	{
		array = new Cell[rows][cols];
		for(int r = 0; r < rows; r++)
		{
			int y = r * size;
			for(int c = 0; c < cols; c++)
			{
				int x = c * size;
				array[r][c] = new Cell(x, y, size);
			}
		}
		//???WHY do I need to extend Canvas for this to WORK????????
		setSize(cols * size, rows * size);
	}
	
	public void draw(Graphics g)
	{
		//Pretty sure array works because the elements of array are only the rows
		//and not the columns? So the 1st element of array is the row 0!?
		//??BUT why is that allowed since it's a [][] how can we just ignore cols??
		//BOOK:"For each row in the array, and for each cell in the row, draw the
		//cell in the graphics context."     (How to read the nested for loop!)
		for(Cell[] row: array)
			for(Cell cell: row)
				cell.draw(g);
		//^^^^?????THIS IS RECURSION???????? What's happening??????
	}
	
	//BOOK:Classes that extend Canvas are supposed to provide a method called paint
	//that "paints" the contents of the Canvas. It gets invoked when the Canvas is
	//created and any time it needs to be redrawn, for example, when its window is
	//moved or resized.
	public void paint(Graphics g)
	{
		//The window management system calls paint, paint calls draw, and draw
		//draws the cells!!
		draw(g);
	}
	
	//BOOK:Because we are using row-major order, the 2D array is an array of rows.
	public int numRows()
	{
		return array.length;
	}
	public int numCols()
	{
		return array[0].length;
	}
	
	public Cell getCell(int r, int c)
	{
		return array[r][c];
	}
	
	public void turnOn(int r, int c)
	{
		array[r][c].turnOn();
	}
	
	//(20)Deals with "out of bounds" exceptions
	public int test(int r, int c)
	{
		//for cells on the edges; if a cell is not within our bounds
		//then we say ok and mark it as off!!!
		try
		{
			if(array[r][c].isOn())
				return 1;
		} catch(ArrayIndexOutOfBoundsException e) {
			//cell doesn't exist
		}
		return 0;
	}
	
	//!!!!!!!!!!!!!!!!FIXED THE SHORT GRAY SPURTS!!!!!!!!!!!!!!!!!!!!!!!!!
	/*
	 * FROM HIS CODE: (Pretty darn sure it wasn't in the book)
	 * 
	 * Overriding this method helps the simulation run more smoothly. Normally
	 * the Canvas is cleared before painting, but there is no need to clear it
	 * since the paint method draws the entire grid.
	 * 
	 * @param g graphics context
	 */
	public void update(Graphics g)
	{
		draw(g); 
	}
}