import java.util.ArrayList;
import java.util.Random;

//Deck and Pile classes don't represent a hand of cards very well
public class CardCollection
{
	//BOOK:To implement Crazy Eights, we need to represent a deck of cards, a discard
	//pile, a draw pile, and a hand for each player. And we need to be able to deal,
	//draw, and discard cards.
	//??????Why a deck of cards, a discard pile, and draw pile?? Why can't the
	//discard pile start empty and have the draw pile be the deck(ArrayList situation)
	//The label attribute represents the difference between different piles and hands
	//of cards so we can tell them apart
	private String label;
	private ArrayList<Card> cards;
	
	public CardCollection(String label)
	{
		this.label = label;
		this.cards = new ArrayList<Card>();
	}
	
	public String getLabel()
	{
		return label;
	}
	public int size()
	{
		return cards.size();
	}
	
	public void addCard(Card card)
	{
		//BOOK:Until now, we have used this explicitly to make it easy to identify 
		//attributes. Inside addCard and other instance methods, you can access
		//instance variables without using the keyword this. So from here on, we
		//will drop it:
		//this.cards.add(card);
		cards.add(card);
	}
	
	public Card removeCard(int i)
	{
		return cards.remove(i);
	}
	//popCard-taking the card from the bottom is faster because any other position 
	//would require us to move every card tp the right of it 1 to the left!
	//Ex. Would be dealing cards from a shuffled deck, doesn't matter where we deal
	//removeCard == draw from Pile BUT this is an "overloaded version"????????
	//ANS:??Maybe by adding that^ method it becomes overloaded??
	public Card removeCard()
	{
		int i = cards.size() - 1;
		return removeCard(i);
	}
	
	public boolean isEmpty()
	{
		return cards.isEmpty();
	}
	
	public Card getCard(int i)
	{
		//!!!!!!PILE: here .get returns a Card and not an int???
		//ANS:Yes, wow your smart!
		return cards.get(i);
	}
	
	//Remember just gets the last card, but doesn't remove it!
	public Card lastCard()
	{
		//??he has just, = size()-1; ????????????
		//ANS:I looked at his code he has cards too just like below!!!!!
		int i = cards.size() - 1;
		return cards.get(i);
	}
	
	public void swapCards(int i, int j)
	{
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}
	
	//I assume this starts at the bottom and switches cards based on 2 chosen
	//positions. Swap cards always saves 1 card and then switches so no cards lost.
	public void shuffle()
	{
		Random random = new Random();
		for(int i = cards.size()-1; i > 0; i--)
		{
			int j = random.nextInt(i + 1);
			swapCards(i, j);
		}
	}
	
	public static void main(String[] args)
	{
		Deck2 deck = new Deck2("Deck");
		deck.shuffle();
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//
		//Here we will have made a deck object and then this will create
		//a Hand object that is an empty ArrayList, which we will fill by
		//using the deal(that) method which removesCard from the deck this.
		//??Doing this I believe Hand & Deck2 are both their own separate
		//objects but are also both CardCollection objects and while doing
		//this walkthrough we never explicitly? made a CardCollection object
		//but I THINK that was because it allows us the opportunity to not
		//write as much code. I think that because we didn't we are able to
		//refer to both objects ?instances? as just CardCollection objects.
		//So in the deal method we ask for a CardCollection object which
		//refers to both objects rather than ?maybe? making 2 separate deal
		//methods that require Hand & Deck2 objects for the parameters!!???
		//Basically it acts as a this, in a way for the 2 different objects,
		//which means we know what the current object in use is so we can
		//condense the code to work with both objects in 1 method rather
		//than making 2 different methods that work with each object!?
		Hand hand = new Hand("Hand");
		deck.deal(hand, 5);
		hand.display();
		
		Hand drawPile = new Hand("Draw Pile");
		deck.dealAll(drawPile);
		System.out.printf("Draw Pile has %d cards.\n", drawPile.size());
	}
	
	//BOOK:The deal method removes cards from the collection it is invoked 
	//on, this, and adds them to the collection it gets as a parameter, that.
	//The second parameter, n, is the number of cards to deal.
	public void deal(CardCollection that, int n)
	{
		for(int i = 0; i < n; i++)
		{
			Card card = removeCard();
			that.addCard(card);
		}
	}
	//??This takes the rest of the cards from the deck that we just made and puts
	//them into the Draw Pile so since we are returning the Draw Pile why have
	//void??? We are literally returning a Hand type back?????????????????????????
	public void dealAll(CardCollection that)
	{
		int n = size();
		deal(that, n);		//imagine they both have this(this is the deck)
	}
}