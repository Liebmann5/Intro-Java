import java.util.*;

public class ArrayPractice
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4};
		printArray(array);
		
		int[] g = printArrayReverse(array);
		System.out.println(Arrays.toString(g));
		
		//Random nums = new Random(30);
		int[] scores = randomNumbers(30);
		System.out.println(Arrays.toString(scores));
		//int a = scores(scores, 90, 100);
		//System.out.println(a);
		
		int[] range = new int[10];
		for(int i = 0; i < range.length; i++)
		{
			if(i == 0)
				range[i] = inRange(scores, i, i+10);
			else if (i == 9)
				range[i] = inRange(scores, i*10, i*10+11);
			else
				range[i] = inRange(scores, i*10, i*10+10);
		}
		System.out.println(Arrays.toString(range));
		
		/*How do the above more efficiently
		int[] counts = new int[100];
		for(int i = 0; i < scores.length; i++)
		{
			int index = scores[i];
			counts[index]++;
		}
		System.out.println(Arrays.toString(counts));*/
		
		//try to efficiently go through the scores array
		//and organize it by grades
		int[] counts = new int[10];
		for(int i = 0; i < scores.length; i++)
		{
			int index = 0;
			if (scores[i] == 100)
				counts[counts.length-1]++;
			else
			{
				//Int Division(/) doesn't include decimals
				//and always rounds the decimals down
				index = ((scores[i] % 100)/10);
				counts[index]++;
			}
		}
		System.out.println(Arrays.toString(counts));
		
		//Enhanced for Loop
		int[] countsMore = new int[101];
		for (int score : scores)
			countsMore[score]++;
		System.out.println(Arrays.toString(countsMore));
		
		int[] countAgain = new int[10];
		for(int assign : scores)
		{
			//assign replaces writing scores[i]
			if (assign == 100)
				countAgain[countAgain.length-1]++;
			else
				countAgain[((assign%100)/10)]++;
		}
		System.out.println(Arrays.toString(countAgain));
	}
	
	public static String printArray(int[] a)
	{
		System.out.print("{");
		for(int i = 0; i < a.length; i++)
		{
			if(i == 0)
				System.out.print(a[0]);
			else
				System.out.print(", " + a[i]);
			//For a[4] why does an OutOfBounds err not occur?
			//Also why is there not another comma after 4?
			//YOUR DUMB! Do it!
		}
		System.out.println("}");
		return "}";
		//Why does it not return }?
		//RETURN prints nothing
	}
	
	//To copy an array from one to another you do it this way
	//int[] c = Arrays.copyOf(b, b.length); does it too
	public static int[] printArrayReverse(int[] b)
	{
		int[] c = new int[b.length];
		//int j = 0;
		for(int i = b.length-1; i >= 0; i--)
		{
			for (int j = 0; j <= b.length-c.length; j++)
			{
				c[j] = b[i];
			System.out.print(c[j]);
			//break;
			//j++;
			}
		}
		//System.out.println();
		System.out.println(Arrays.toString(c));
		return c;
	}
	
	public static int[] randomNumbers(int size)
	{
		Random numbers = new Random();
		int[] rando = new int[size];
		for(int i = 0;i < rando.length; i++)
			rando[i] = numbers.nextInt(101);
		return rando;
	}
	
	public static int inRange(int[] scores, int low, int high)
	{
		int count = 0;
		for(int i = 0; i < scores.length; i++)
		{
			if(scores[i] < high && scores[i] >= low)
				count++;
		}
		return count;
	}
}