/*
 * Chapter 7.9
 */
import java.util.Arrays;
import java.util.Scanner;

public class IsDoubloon
{
	public static void main(String[] args)
	{
		System.out.println("Hi, please type in a string.");
		Scanner in = new Scanner(System.in);
		String userWord = in.nextLine();
		System.out.println(userWord);
		String userLower = userWord.toLowerCase();
		System.out.println(userLower);
		String[] userConverted = convertToArray(userLower);
		boolean isDoubloon = isDoubloon(userConverted);
		//System.out.println(Arrays.deepToString(isDoubloon));
		System.out.println(isDoubloon);
		if (isDoubloon == true)
			System.out.println("Ya, your word is a doubloon!");
		else
			System.out.println("Boo, you suck. Your words suck!");
	}
	
	public static String[] convertToArray(String word)
	{
		String[] doubloon = new String[word.length()];
		for(int i = 0; i < word.length(); i++)
			doubloon[i] = Character.toString(word.charAt(i));
		System.out.println(Arrays.toString(doubloon));
		return doubloon;
	}
	
	public static boolean isDoubloon(String[] doubloon)
	{
		int[] counts = new int[26];
		for(int i = 0; i < doubloon.length; i++)
		{
			//counts[((doubloon[i].chartAt(i))-'a')]++;
			for (int j = 0; j < doubloon[i].length(); j++)
				counts[(doubloon[i].charAt(j)-'a')]++;
			System.out.println(Arrays.toString(counts));
		}
		/*for(char letter : doubloon.toCharArray())
			counts[letter-'a']++;*/
		for(int count : counts)
		{
			if(count != 0 && count != 2)
				return false;
			//return false;
		}
		return true;
	}
}





/*
https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings

An efficient way of turning a String into an array of one-character Strings would be to do this:

String[] res = new String[str.length()];
for (int i = 0; i < str.length(); i++) {
    res[i] = Character.toString(str.charAt(i));
}

However, this does not take account of the fact that a char in a String could actually represent half of a Unicode code-point. (If the code-point is not in the BMP.) To deal with that you need to iterate through the code points ... which is more complicated.

This approach will be faster than using String.split("clever regex"), and it will probably be faster than using Java 8+ streams. It is probable faster than this:

String[] res = new String[str.length()];
int 0 = 0;
for (char ch: str.toCharArray[]) {
    res[i++] = Character.toString(ch);
}  

because toCharArray has to copy the characters to a new array.*/
