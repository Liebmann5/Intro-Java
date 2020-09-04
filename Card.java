import java.util.Arrays;

public class Card
{
	//ranks & suits as "class variables"
	//class variables are allocated when the program begins & persist until it ends
	//For advantages look at 1st comment in toString but also in my own words I think
	//that they are a necessity here because these need to be accessed everywhere and
	//they are an ?object attribute? that should never be deleted or tampered with???
	//Since the array variables are final, and the strings they reference are
	//immutable, there is no danger in making them public.
	//^?Since the strings are already immutable isn't it overkill to make them final
	//too? IDEA's for no 1You can change RANKS to reference something else 2You could
	//add to the array or make it smaller? ALSO by adding final doesn't that make any
	//value untouchable and so here the immutable part is just a coincidence of extra
	//security?????????????????????????????????????????????
	public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
	public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	//?I don't understand why we would use instance variables here because I don't
	//see why we would need any incoming values from anywhere else? Also throughout
	//chapter 12 I never saw us use these things or the constructor?? Am I wrong????
	//instance variables(rank and suit) are allocated when the program creates "new"
	//objects, and they are deleted when the object is garbage collected
	/*private int rank;
	private int suit;*/
	//By making the instance variables final we are ensuring that nobody can modify
	//their values. Above's can be altered by someone adding a modifier!
	private final int rank;
	private final int suit;
	
	//Card[] cards = new Card[52];
	
	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString()
	{
		/* //Having suits and ranks here vs as class variables is worse because here
		 * //they need to be created (and garbage-collected) every time toString is
		 * //called!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * //?pg205-206 it says instance variables are allocated when...aren't these
		 * //local variables? so how does that change the thinking? Agreed that I
		 * //don't believe other methods can access local variables so I'm confused
		 * //on why he would even show us this way??????????????????????????????????
		 * //suits & ranks are "local variables"
		String[] suits = new String[4];
		//Each element([1]) of the array is a reference to a String
		suits[0] = "Clubs";
		suits[1] = "Diamonds";
		suits[2] = "Hearts";
		suits[3] = "Spades";
		
		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "Jack", "Queen", "King"};
		
		//ranks[this.rank] = "use the instance variable rank from this object as an
		//index into the array ranks" ????????????????????
		String card = ranks[this.rank] + " of " + suits[this.suit];
		return card;*/
		
		//??If toString is an instance method which means it has access to this and
		//the instance variables why can we use the class variables below without
		//putting them in the parameter?????????????????????????????????????????????
		//When we use the class variables this is our return 
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}
	
	//Test if two objects are equivalent
	public boolean equals(Card that)
	{
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	public int compareTo(Card that)
	{
		//-1 = lower card & +1 = higher card
		if(this.suit < that.suit)
			return -1;
		/*else			//?????????????????????
			return 1;*/
		if(this.suit > that.suit)
			return 1;
		if(this.rank < that.rank)
			return -1;
		if(this.rank > that.rank)
			return 1;
		//?0 if they are the same card?(equivalent)
		return 0;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public static void main(String[] args)
	{
		Card[] cards = new Card[52];
		if(cards[0] == null)
			System.out.println("No card here yet!");
		//If you try to access the instance variables of non-existent Card objects,
		//you get a NullPointerException
		//1 Why would we do this if, I assume, our instance variables aren't even
		//being used? We never assigned any values to them therefore they're nothing?
		//2 Why would we use the instance variable .rank instead of .getRank(), is
		//there a benefit? What is the difference between these 2 options and what
		//are the values both of them hold? or can hold??? The purpose of the 
		//question is because I don't see why we would even write a getRank method
		//then?
		//3 Didn't we just make a Card object(an array of Card objects) above? So
		//it isn't non-existent; it exists, the values are just null???? Which means
		//that elements in our array have the reference values and the 52 Card
		//objects have been made it's just that their null?????????????????????????
		//2 ANS:The getRank() method allows other classes to read this classes rank
		//and suit values while our instance variables are private which means they
		//can only be accessed in this class?
		//System.out.println(cards[0].rank);
		
		int index = 0;
		//is suit related to our instance variable suit NOT SUITS
		for(int suit = 0; suit < SUITS.length; suit++)
		{
			for(int rank = 1; rank < RANKS.length; rank++)
			{
				cards[index] = new Card(rank,suit);
				index++;
			}
		}
		
		printDeck(cards);
		//OR--this way eliminates our printDeck() and prints them all on 1 line
		//System.out.println(Arrays.toString(cards));
		
		Card threeOfClubs = new Card(3, 0); 
		int cardPosition = search(cards, threeOfClubs);
		System.out.println(threeOfClubs);
		
		System.out.println(cards.length);
		Card jackOfClubs = new Card(11, 0);
		System.out.println(binarySearch(cards, jackOfClubs));
	}
	
	public static void printDeck(Card[] cards)
	{
		for(Card card: cards)
			System.out.println(card);
		//println invokes the toString method in the Card class
	}
	
	public static int search(Card[] cards, Card card)
	{
		//Whenever or wherever you hit a return in a method does that
		//method just end right there no matter what????
		for(int i = 0; i < cards.length; i++)
		{
			/*if(card.equals(cards[i]))
				return 1;*/
			if(cards[i].equals(card))
				return i;
		}
		return -1;
	}
	
	public static int binarySearch(Card[] cards, Card card)
	{
		int low = 0;
		int high = cards.length-1;
		while(low <= high)
		{
			System.out.println("Range is " + low + "-" + high);
			int mid = (low + high)/2;
			//System.out.println("Range is " + low + "-" + high);
			//If the card at mid is lower(else if) than our target
			//card, search from (mid+1) to high
			//What if we do card.compareTo(cards[mid])?
			//ANS:
			int comp = cards[mid].compareTo(card);
			System.out.println(comp);	//prints either -1 or 1
			
			if(comp == 0)
				return mid;
			else if(comp < 0)
				low = mid + 1;	//sets a new low value
			else
				high = mid - 1;
		}
		return -1;
	}
}