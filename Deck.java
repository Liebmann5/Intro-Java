import java.util.Arrays;

/*
 * [https://coderanch.com/t/697769/java/Unable-invoke-method-main-class]
 * (1)Explanation on how nothing outside of the main method is read
 * Compiler ONLY READS DIRECTIONS FROM MAIN
 */

public class Deck
{
	//(2)Why not just make it a class variable and assign [52] to cards??? 
	private Card[] cards;
	//(1)Deck deck = new Deck();
	//(1)deck.print();
	
	//(2)Why have a constructor that allows someone to choose the amount of cards????
	//I see this only having problems cause maybe they make a deck of 1 card? This
	//gives the user the ability to mess with our code which leaves then leads to
	//vulnerabilities for hackers????
	public Deck(int n)
	{
		//"Initializes" the instance variable with an array of n cards
		//THIS DOES NOT CREATE ANY CARD OBJECTS!!!!!!!
		//Card[] cards = new Card[n];
		this.cards = new Card[n];
	}
	
	public Card[] getCards()
	{
		return this.cards;
	}
	
	public Deck()
	{
		this.cards = new Card[52];
		int index = 0;
		for(int suit = 0; suit < Card.SUITS.length; suit++)
		{
			for(int rank = 1; rank < Card.RANKS.length; rank++)
			{
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	/*What are the differences between the ^ method and the below method?????????????
	 * What is the purpose of returning something? And when should we vs not?????????
	 * The above is a constructor and this is a method. Is there a difference????????
	 * public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }
	 */
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.print();
		//System.out.println("\n\n\n");
		
		deck.shuffle();
		System.out.println(Arrays.toString(deck.cards));
		//Write a method to see if any cards are repeats
		
		deck.selectionSort();
		System.out.println(Arrays.toString(deck.cards));
		
		deck.shuffle();
		System.out.println(Arrays.toString(deck.cards));
		
		//ERROR had to set this equal to deck for it to run
		//??Im pretty sure I had to save the return because almostMergeSort returned
		//an object(Deck) so...????? If a method returns an object do you have to
		//save it like below?? If you change almostMergeSort() return to void can
		//you just make the statement like the above??????
		deck = deck.almostMergeSort();
		System.out.println(Arrays.toString(deck.cards));
		
		deck.shuffle();
		System.out.println(Arrays.toString(deck.cards));
		
		System.out.println("Here's mergeSort!");
		deck = deck.mergeSort();
		System.out.println(Arrays.toString(deck.cards));
		
		//NOTES:Basically I think a class can invoke static methods
		//Deck.randomInt(0, 12);
		//This doesn't work
		//BOOK:You get an compiler error like this:
		/*Non-static method print() cannot be referenced from a
		static context.*/
		//By "static context", the compiler means you are trying to invoke a method
		//in a context that requires a static method.
		//????I BELIEVE what this fool is trying to imply is that the object deck is
		//created and invoked in the main method which is "static" and Deck is not??
		//Deck.print();
		//This is just "bad style" because people assume the method is an instance
		//int i = deck.randomInt(0, 12);
	}
	
	public void print()
	{
		//this is a reference to the object deck right? and it uses it's attribute
		for(Card card: this.cards)    //cards?
		{
			System.out.println(card);
		}
	}
	
	public void shuffle()
	{
		//why does this.deck not work, instance methods have access to this so why
		//can't I access the current object's(Deck) attribute(deck)???????????????
		//IDEA-??I believe that it's because the current object in use is deck so
		//this isn't referring to anything! BUT then why doesn't Deck.deck.length
		//work?(Side note I believe that the value would be 1) or Deck.deck.cards.
		//length work?????????????
		for(int i = 0; i < this.cards.length-1; i++)
		{
			///////// choose a random number between i and length - 1
			int x = randomInt(i, this.cards.length-1);
			///////// swap the ith card and the randomly-chosen card
			swap(i, x);
		}
	}
	
	//??????????
	//When you do the exercise, notice that randomInt is a "class method" u know why
	//!!!!BOOK:static because they do not read or write and instance variables same
	//with merge apparently.
	//!!!!ALL other methods are instance methods because they access cards!!!!!!!!!!
	private static int randomInt(int low, int high)
	{
		/////////return a random number between low and high, including both
		//[https://stackoverflow.com/questions/363681/how-do-i-generate-rando
		//m-integers-within-a-specific-range-in-java]
		int num = (low + (int)(Math.random() * ((high - low) + 1)));
		return num;
	}
	
	//instance method because I need access to the instance variables so I can modify
	private void swap(int i, int j)
	{
		//if(i == j)
			//return;
		////////////// swap the ith and the jth cards in the array
		Card[] toSwap = new Card[2];
		toSwap[0] = this.cards[i];
		toSwap[1] = this.cards[j];
		this.cards[j] = toSwap[0];
		this.cards[i] = toSwap[1];
	}
	
	public void selectionSort()
	{
										// -1
		for(int i = 0; i < this.cards.length; i++)
		{
			////////// find the lowest card at or to the right of i
			int lowestCardIndex = indexLowest(i, this.cards.length-1);
			////////// swap the ith card and the lowest card found
			swap(i, lowestCardIndex);
			//in swap() the lowest card=j & current i position=i
			//swap(this.cards[i], this.cards[]);
		}
	}
	
	//{!!!!!!!!!!!!REDO THIS WITH RECURSION!!!!!!!!!!!!!!}
	private int indexLowest(int low, int high)
	{
		///////////// find the lowest card between low and high
		Card lowestCard = this.cards[low];
		int index = 0;
		int cardIndex = low + 1;
		//???Why can't I make a blank Card???????
		//Card lowestSaved = new Card(null, null);
		int lowValue = low;
		while(low < high)
		{
			//for(int i = low; i < this.cards.length-1; i++)
				
			//if the card at our index(lowestCard) is greater than the card we are
			//currently on then compareTo() returns 1
			if(lowestCard.compareTo(this.cards[cardIndex]) == 1)
			{
				lowestCard = this.cards[cardIndex];
				//Pretty sure that if this is true then we
				//index++;
				index = cardIndex;
				//cardIndex = high - low;
			}
			//else if(low - 1 == high && index == 0)
				//index = low;
			cardIndex++;
			low++;
			
		}
		//PROBLEMs occur when the card is in its exact element so index returns 0
		//and nothing is higher the card[52] so same thing happens
		//if(index == 0 && lowestCard.compareTo(this.cards[cardIndex]) == 0)
			//index = Arrays.indexOf((int)this.cards[low]);
		//?????WHEN YOU DO index=low WHY DOES THAT NOT WORK!!?? AND DOES IT ALMOST??
		if(index == 0)
			index = lowValue;
		return index;
	}
	 
	//Why not just take the deck and /2 and return!!??? What's the point of making
	//a new deck and returning it(the new deck)?? I feel like doing this seems
	//silly cause I think that there's a better and faster way!!??????????????????
	public Deck subdeck(int low, int high)
	{
		Deck sub = new Deck(high - low + 1);
		for(int i = 0; i < sub.cards.length; i++)
		{
			//?????????????????????????????????????????????????????????????????????
			//HERE I believe that this would refer to the current object which I
			//think is sub, since it is the most recent object we have made AND even
			//used(in the for loop)?
			//???IDEA Is this wrong because instance methods only allow "this" usage
			//from outside objects and not inside??? WELL actually I don't think we
			//have any way to refer to an outside object and using this seems to be
			//the only way? (If we set the outside object as a param then we could)?
			sub.cards[i] = this.cards[low + i];
			//This "aliases"(a variable{sub} that refers to the same obj{cards[i]} 
			//as another variable{this}) these two objects. Normally bad but since
			//Card objs are immutable, this aliasing isn't a problem! It also saves
			//memory since we don't create duplicate Card objects!!!!!!!!!!!!
			//?If Card wasn't immutable would the problem be that by setting a card
			//from this = to sub, now means that this is missing that card we just
			//set = to sub.cards[i]?????
		}
		return sub;
	}
	
	//"Helper method" which is why it's private
	private static Deck merge(Deck subSorted1, Deck subSorted2)
	{
		Deck subSorted3 = new Deck(subSorted1.cards.length+subSorted2.cards.length);
		//These count up until they reach the length of subSorted1 &2 then stop
		int i = 0;
		int j = 0;
		
		for(int k = 0; k < subSorted3.cards.length; k++)
		{
			//Is the array in this location memory address empty???????
			//??How would you check if the array was empty or null???????
			//if(subSorted1 == null)
			if(i == subSorted1.cards.length)
			{
				subSorted3.cards[k] = subSorted2.cards[j];
				j++;
			}
			else if(j == subSorted2.cards.length)
			{
				subSorted3.cards[k] = subSorted1.cards[i];
				i++;
			}
			else if(subSorted1.cards[i].compareTo(subSorted2.cards[j]) == -1)
			{
				subSorted3.cards[k] = subSorted1.cards[i];
				i++;
			}
			/*else if(subSorted1.cards[i].compareTo(subSorted2.cards[j]) == 1)
			{
				subSorted3.cards[k] = subSorted2.cards[j];
				j++;
			}*/
			else
			{
				subSorted3.cards[k] = subSorted2.cards[j];
				j++;
			}	
		}
		return subSorted3;
	}
	
	public Deck almostMergeSort()
	{
		//////////// divide the deck into two subdecks
		Deck firstHalf = subdeck(0, ((this.cards.length/2) - 1));
		Deck secondHalf = subdeck(((this.cards.length/2)), this.cards.length-1);//-1
		System.out.println(firstHalf.cards.length + " " + secondHalf.cards.length);
		//////////// sort the subdecks using selectionSort
		firstHalf.selectionSort();
		secondHalf.selectionSort();
		//////////// merge the subdecks, return the result
		Deck almostMerged = merge(firstHalf, secondHalf);
		//Deck almostMerged = new Deck(52);
		//almostMerged = merge(firstHalf, secondHalf);
		return almostMerged;
		//merge(firstHalf, secondHalf);
	}
	
	//BOOK DIRECTIONS-MY IDEA: THESE NOTES HAVE NOTHING TO DO WITH THE VARIABLES OR
	//ANYTHING ELSE IT'S TALKING ABOUT THE IF STATEMENT BECAUSE THAT'S WHAT DEALS
	//WITH EVERY ENDING OF EVERY FRAME(BASE CASE)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//(+0)BOOK DIRECTIONS:To make mergeSort work recursively, you have to add a base
	//case; otherwise it repeats forever!!!!! (+1 and +2 comments should be switched)
	//?????To have a base case is a necessity for a method to not run for infinity
	//but why is he implying that the base case are the variables half1 and half2??
	//Can't we just consider where we want to stop and start the thinking for the
	//method this way!!!!?????????
	//ANS:Yes he's dumb. He's describing the if statement and what we need in it!
	//The top comment here describes it!!!!! He wanted us to get every card to the
	//left and work our way up but how we know to stop is our half2 array will be
	//created empty for CONVENIECE and i see no other reason! All I've worked
	//through and see me using is half1 really!!!
	public Deck mergeSort()
	{
		//(33)The BOOK DIRECTIONS make little sense so heres my thoughts on how and
		//why we chose and made these variables!!!
		//(32)???THESE VARIABLES WERE MADE(EMPTY AND AN ARRAY OF 2) TO WORK WITH 3
		//CARDS AT A TIME
		//(+2)And it will turn out to be convenient if we handle another base case,
		//a subdeck with 0 cards. By the same logic, if there are no cards, they
		//can't be out of order. So we consider an empty deck to be sorted, and 
		//return it.
		//????Why does the debugging skip this???AND why isn't it in the variables??
		Deck half1;
		//(+1)The simplest base case is a subdeck with 1 cards. If there is only one
		//card, it can't be out of order, so we consider it sorted. And if it is
		//already sorted, we can just return it.
		//??I believe this creates a deck with 1 card???What card does this make????
		Deck half2 = new Deck(0);
		//MY NOTES:(1)=going down && (2)=going up
		//(1)This I believe is to separate the deck in half every iteration, but use
		//the same half during every iteration. So half1 is the 1st half of the deck
		//and half2 is the and half. Next frame will work with ONLY half1(so the
		//front half of the deck) and repeat this. half1 should = the 1st card!!!!!
		//(2)On the way up the frames half1 will equal either the sorted cards from
		//the left or just 1 card.(??The 1 card I believe is normally the leftmost
		//card of that set???????)
		//????? BELOW I think is how (2) works??????????????????????????????????????
		//?????I think is sorts by starting from the leftmost position(half1), and
		//then taking and sorting the next 2 cards(half2) following the leftmost
		//card, and then merging them(half1 & half2) and this is done repeatedly
		//until all of the cards for that set are complete???? I believe the number
		//of cards in a set is found with (52/2^n)!!!??????? half1 starts with 1
		//card but through each iteration I think it increases by 2;taking them from
		//half2 recursively(31)?????????????????????????????????????????????????????
		////////// if the deck has 0 or 1 cards, return it
		if(this.cards.length == 0 || this.cards.length == 1)
			return this;
		//MY NOTES:This deals with the base case. If our current this object is empty
		//or has just 1 card return it. I believe this is so we kinda just
		//continuously compare and sort only 2 cards.(think what this object is!!)
		////////// otherwise, divide the deck into two subdecks
		else 
		{
			//??I see that since half1 is empty how it can become the subdeck BUT
			//since half2 is an already created 1 element array how can we set a 26
			//element array = to that?? Does it add to it and what about the 1 card
			//that was made where is it or where did it go?????????????????????????
			half1 = subdeck(0, ((this.cards.length/2) - 1));
			half2 = subdeck((this.cards.length/2), this.cards.length - 1);
			//MY NOTES:If base case isn't empty or 1 card then make subdecks to get
			//them to 1 card!!
		
		////////// sort the subdecks using mergeSort
		//????????????WHY DO I HAVE TO SAVE THESE ONES????????????????
		//half1.mergeSort();
		//half2.mergeSort();
		half1 = half1.mergeSort();
		half2 = half2.mergeSort();
		//MY NOTES:Once this current frame is split up; we need to split up the front
		//half again(recursion). We recursively do this until we get the left most
		//card alone(1 card). Then return it and we split up the remaining right side
		//(half2) until those cards are alone so we may compare and sort them!!!!!!
		////////// merge the subdecks
		//????????????WHY DONT THESE WORK??????????????????????????
		//ANS:Because there are frames from recursion this changes often!!!!!! 
		//this.merge(half1, half2);
		//this = this.merge(half1, half2);
		////////// return the result
		//????????????^SSAAAAMMMMEEEEEE??????????????????????????????
		//return this;
		return merge(half1, half2);
		//MY NOTES:This is where the sorting will take place. We 1st sort cards 2 and
		//3 and then return them, then sort the 1st card into them!!!!
		}
	}
}