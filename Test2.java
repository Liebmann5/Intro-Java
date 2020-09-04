/*
 *  Chapter 8.3
 *  
 *  This is connected to the Recursion
 *  class's noX method
 *  AND, this explains how .substring() works
 */

public class Test2
{
	public static void main(String[] args)
	{
		String myName = "domanokz";
		String newName = myName.substring(0,4)+'x'+myName.substring(5);
		String newName2 = myName.substring(0,4)+' '+myName.substring(5);
		String newName3 = myName.substring(0,4)+myName.substring(5);
		System.out.println(myName);
		System.out.println(newName + "\n" + newName2 + "\n" + newName3);
		
		//String one = "S xomebody x took mxy Horxse";
		String one = "xaXb";
		System.out.println("\n\n\n\n\n\n\n" + noX(one));
	}
	//saves everything before the recursion and nothing after
	/*
	 * BEFORE Recursion(working forward through the String)
	 * sent - stays the same ALWAYS we just use it to shuffle through every char
	 * first - used to save every char into a new frame
	 * rest - used to find the end of the String
	 * recurse - saved as the recursion because we want to create an empty String by using/(starting with) the empty char at the end of the given string
	 * 
	 * AFTER Recursion(working backwards through the String)
	 * sent - serves no purpose
	 * first - used as a saved point for each char and decides whether to keep it or remove it
	 * rest - serves no purpose and as an argument it also means nothing->The String recurse just saves the last returned value 
	 * recurse - where we save the previous frame's char's (from a return statement) that don't have the unwanted char
	 */
	public static String noX(String sent)
	{ //sent STAYS THE SAME up and down the recursion
		if(sent.length() == 0)
			return "Ya";
		char first = sent.charAt(0);
		System.out.println(first); //used to pinpoint every char in the string and decide whether to keep to delete
		
		String rest = sent.substring(1);
	    //At the end of the string returns the empty char
		System.out.println(sent.substring(1));
		System.out.println(rest);
		
		//when this stops the last frame deletes itself and returns "Ya" and return to the previous frame and because of this recursive will == "Ya"
		String recurse = noX(rest);
		System.out.println(rest);
		System.out.println(first);
		
		if(first == 'x')
		{
			System.out.println(recurse); //uses the recurse variable as a last saved point and returns the value to eliminate the first unwanted value
			return recurse;    //why not return rest? Cause then all the x's stay and only the 1st char matters
		}
		else
		{
			System.out.println(first + recurse);
			return first + recurse;
		}
	}

}
