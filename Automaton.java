/*
 * Chapter 16.2
 */
import javax.swing.JFrame;

//??????(10)WHY A SUPERCLASS if it only does so little???????????????
//IDEA:I believe it's to show how refactoring and abstract works!!! We
//wanted to remove repeated code by refactoring it. Then in order for
//our repeated code to work it required the mainloop() to be present
//and by adding this, it needed a method(update) from each class so we
//used abstract to access the update() from each class. ?IN ORDER to
//abstract something from another class(subclass) we ?need to make the
//superclass abstract? so I think it was easier to show and implement
//it here in this way!!?????
//??If yes then why not abstract the mainloop???? I feel like adding it
//here is only for organization because I think it would be faster to
//leave them where they are as is and here it's just more computations
//and also at putting more at risk??????????????
//???Why not just inherit because this way for this problem seems dumb!??
public abstract class Automaton
{
	/*
	 * BOOK:There are a few problems with the current design
	 * 
	 * 1. The grid attribute is private, making it inaccessible in Conway 
	 * 	  and Langton. We could make it public, but then other (unrelated)
	 *    classes would have access to it as well.
	 *    
	 * 2. The Automaton class has no constructors, and even if it did, there
	 *    would be no reason to create an instance of this class.
	 *    
	 * 3. The Automaton class does not provide an implementation of update.
	 *    In order to work properly, subclasses need to provide one.
	 *    
	 * Java provides language features to solve these problems:
	 * 
	 * 1. We can make the grid attribute protected, which means it's accessible
	 *    to subclasses but not other classes.
	 *    
	 * 2. We can make the class abstract, which means it cannot be instantiated.
	 * 	  If you attempt to create an object for an abstract class, you will get
	 *    a compiler error.
	 *    
	 * 3. We can declare update as an abstract method, meaning that it must be
	 *    overridden in subclasses. If the subclass does not override an abstract
	 *    method, you will get a compiler error.
	 */
	//??#2.1 To have/be an instance do you need a constructor??????????
	//??#1.1&1.2 By making it public other classes would have access to it too
	//but our solution is to just allow only subclasses access SOOOOO..... what's
	//stopping someone from just extending this super as well and boom now it's a
	//subclass of this class? OR just make a subclass to the subclass????????????
	//??#2.1 (Question still stands) Why is there no reason to create an instance
	//for this class!? If it's not an instance then what is it????? What is the
	//purpose or benefit of creating an instance and not?????????
	//??#2.2 Abstract classes can't be instantiated(make a new instance); again
	//what is the purpose or benefit in doing this????????
	//??#3.2 Why do the methods in the subclasses need to be overridden?? To me
	//overridden means that a method is written multiple times so override is
	//used to make a particular method the priority, but here we define the
	//object, we wish to access with, this; meaning that we know which object
	//is currently in use so we will find each update() in that objects class??
	//???After adding update() I was wondering that if only 1 class had update,
	//because it was a necessity for it, that if this would still be 
	//necessary/needed? ALSO what if each class has update but different return
	//values for it then what?????????
	
	
	//BOOK:Automaton declares grid as an instance variable, so 
	//every Automaton "has a" GridCanvas
	//???define the HAS-A here??? The variable grid has a value
	//that is = to a reference(?or instance?) that is from GridCanvas
	//private GridCanvas grid;
	protected GridCanvas grid;
	
	//BOOK:The declaration specifies the name, arguments, and return type. But
	//it does not provide an implementation, because it is an abstract method.
	//Any class that extends Automaton must provide an implementation of update;
	//the declaration here allows the compiler to check.
	//??How does the compiler check??? Aside from that, does the compiler check
	//if a method like this exists; without the abstract, and if so run the code.
	//(Read the Aside part like, What does the compiler check for?)
	public abstract void update();
	
	//????(11)Why a method and not a constructor???? I know it's
	//supposed to be a super but doesn't that only further my point??
	//BOOK:rate="frame rate", the # of time steps to show per second
	public void run(String title, int rate)
	{
		JFrame frame = new JFrame(title);
		//???Why JFrame.EXIT and not frame????
		//frame is a variable here and not there???
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(this.grid);
		frame.pack();
		frame.setVisible(true);
		this.mainloop(rate);
	}
	
	private void mainloop(int rate)
	{
		while(true)
		{
			this.update();
			grid.repaint();
			
			try {
				Thread.sleep(1000 / rate);
			} catch(InterruptedException e) {
				//do nada
			}
		}
	}
}