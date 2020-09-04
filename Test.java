/*
 * Chapter 7.3 OR maybe 6
 * 
 * THIS IS AN IDEA CONNECTED TO THE REVERSE ARRAY IN ArrayPractice
 * ^^OG:I believe it could be that which is in the Arrays folder
 * but if not, then try the Doubloon folder and if still no try
 * the Chapter 6 folder.
 */

public class Test 
{
	public static void main(String[] args) {
		String[] s = {"Marlon", "Lamont", "Wayans"};
        // Loop backwards through the array of arguments
        for(int i = s.length-1; i >= 0; i--) {
            // Loop backwards through the characters in each argument
            for(int j = 0; j>=0; j--) {
                // Print out character j of argument i.
                System.out.print(s[i]);
            }
            System.out.print(" ");  // Add a space at the end of each argument.
        }
        System.out.println( );       // And terminate the line when we're done.
    }
	
	
	/*
	 * public static void main(String[  ] args) {
        // Loop backwards through the array of arguments
        for(int i = args.length-1; i >= 0; i--) {
            // Loop backwards through the characters in each argument
            for(int j=args[i].length( )-1; j>=0; j--) {
                // Print out character j of argument i.
                System.out.print(args[i].charAt(j));
            }
            System.out.print(" ");  // Add a space at the end of each argument.
        }
        System.out.println( );       // And terminate the line when we're done.
    }
	 */

}
