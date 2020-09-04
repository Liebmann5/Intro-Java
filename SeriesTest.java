/*import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeriesTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}*/

/*
 * THIS IS A JUNIT TEST CASE CLASS!!!!!!!
 * 
 * To make it right click on package>New>
 * JUnit Test Case!
 * 
 * At the top (^) is what came in this pre-created
 * class!!!!!! Don't know anything about it???????
 */

//pg.308
//BOOK:JUnit is a common testing tool for Java programs.To use it, you
//have to create a test class that contains test methods. For example,
//suppose that the fibonacci method belongs to a class named Series. 
//Here is the corresponding JUnit test class and test method:

import junit.framework.TestCase;

/**
 * Example JUnit test from Appendix A.
 */
public class SeriesTest extends TestCase {
	
	//BOOK:The names in this example follow convention: if the name of your
	//class is Something, the name of the test class should be SomethingTest.
	//And if there is a method in Something named someMethod, there should be
	//a method in SomethingTest named testSomeMethod.

    public void testFibonacci() {
    	//BOOK:assertEquals is provided by the TestCase class. It takes two
    	//arguments and checks whether they are equal. If so, it does nothing;
    	//otherwise it displays a detailed error message. The first argument
    	//is the "expected value", which we consider correct, and the second
    	//argument is the "actual value" we want to check. If they are not
    	//equal, the test fails.
        assertEquals(1, Series.fibonacci(1));
        assertEquals(2, Series.fibonacci(2));
        assertEquals(2, Series.fibonacci(3));
        //BOOK:Using assertEquals is more concise than writing your own if
        //statements and System.err messages. JUnit provides additional assert
        //methods, such as assertNull, assertSame, and assertTrue, that can be
        //used to design a variety of tests.
    }
    //!!!To get the specific error message Rerun the code by clicking the Green
    //circled arrow; that has a small yellow arrowed circle on its bottom right,
    //near the top left hand corner. Towards the top tab called Package; where
    //you can see all your files, should be a new JUnit tab and once clicked
    //the new screen will show. And right below the tab are 2 yellow arrows(up &
    //down) then right below the down pointing arrow is the Rerun button! Once run
    //the very bottom on that column should show the "stack trace" with the title
    //Failure Trace! Along that same bar, the computer screen logo is "Show Stack
    //Trace in Console View" click it! IF needed scroll all the way up and the 1st
    //line is the Error followed by JUnits' specific message!!!!
}
