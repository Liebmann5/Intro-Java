/*
 * Chapter 13 Section 9-10
 * 
 * Basically just working with ArrayList's and using the Card & Deck classes
 * for their functions to make a deck of cards that can be removed and added
 * at will.
 */

import java.util.ArrayList;

public class Pile
{
	//Our implementation of Deck uses a Card array, and array
	//length can't be changed.???
	//The Pile class represents a pile of cards, and it uses an
	//ArrayList to store Card objects
	private ArrayList<Card> cards;
	
	public Pile()
	{
		//the constructor initializes this.cards with an empty ArrayList
		this.cards = new ArrayList<Card>();
	}
	
	//These 3 methods are "wrapper methods" because they just invoke
	//methods on the instance variables
	public Card draw()
	{
		//??What is this here???????
		return this.cards.remove(0);
	}
	
	public void addCard(Card card)
	{
		//ArrayList's method add; adds cards to the bottom of the collection
		this.cards.add(card);
	}
	
	public boolean isEmpty()
	{
		return this.cards.isEmpty();
	}
	
	public void addDeck(Deck deck)
	{
		//(02)Except for this deck cause it's a param, WHAT'S this??????
		//??Also why can't just deck work here or maybe a different
		//method in the deck class????? Deck's instance variable is a
		//creation of an array of Card object's so since a deck is our
		//parameter then any argument we get is already a Card[]??????
		//???Also what was the purpose of the getCards() in deck??????
		//BOOK NOTES:Notice that it does not remove the cards from the
		//Deck, so the Deck and the Pile share cards. But that won't be
		//a problem because cards are immutable.
		//?I think that that might have answered some stuff. I think
		//getCards() in the deck class doesn't set the Deck classes
		//object = to anything and it only returns cards but again
		//what's the point???Maybe it acts as an alias situation, so it
		//allows something? to = the cards and returns it, like makes
		//its return value = the reference to those cards, so that it
		//doesn't interrupt the organization of the deck???????????????
		for(Card card: deck.getCards())
			this.cards.add(card);
		//??I assume this is the object ArrayList<Card> so why can we
		//invoke add from the variable(cards) if add is for ArrayList
		//objects??? Shouldn't that be invoked from the object???? So
		//either this.add or 
	}
	//(01)??^Till this point and up we never had anything to do with the
	//Deck class so why is he talking about us getting from the deck?
	//Card has no correlation to the Deck class so I'm confused?????
	
	//Here we use Deck and Pile to play War!
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		//?Why doesn't this.shuffle work or this.cards.shuffle???????
		deck.shuffle();
		
		Pile p1 = new Pile();
		//??What exactly does this mean and do????????? I feel like
		//doing all these calls is unnecessary so is there a reason
		//we are forced to do this or purpose???????????????????????
		//???Also isn't it bad to have literals??READ top of subdeck!
		p1.addDeck(deck.subdeck(0, 25));
		
		Pile p2 = new Pile();
		p2.addDeck(deck.subdeck(26, 51));
		
		long x = 0;
		
		//???????????????????????????????????????????????????????????
		//			Sometimes this code runs endlessly
		//???????????????????????????????????????????????????????????
		
		while(!p1.isEmpty() && !p2.isEmpty())
		{
			x++;
			System.out.println(x);
			if(p1.cards.size()+p2.cards.size() != 52)
			{
				System.out.println("Missing some cards!");
				System.out.println("x = " + x);
			}
			
			Card c1 = p1.draw();
			Card c2 = p2.draw();
			
			int diff = c1.getRank() - c2.getRank();
			if(diff > 0)
			{
				p1.addCard(c1);
				p1.addCard(c2);
			}
			else if(diff < 0)
			{
				p2.addCard(c1);
				p2.addCard(c2);
			}
			else
			{
				Pile tie = new Pile();
				tie.addCard(c1);
				tie.addCard(c2);
				Pile p1Tie = new Pile();
				Pile p2Tie = new Pile();
				//Why can't I make a Card object???? yet I can make a Deck??
				//Card p1Best = new Card(0);
				//Deck p1Best = new Deck(0); This might've worked better!!??
				Card p1Best = new Card(0, 0);
				Card p2Best = new Card(0, 0);
				int drawSize = 0;
				//while(p1Best == p2Best) WHY? compares same reference!?
				while(p1Best.getRank() == p2Best.getRank()) {
				for(int i = 0; i < 4; i++)
				{
					if(!p1.isEmpty())
					{
						//this does remove the top card after this call!!!
						c1 = p1.draw();
						p1Tie.addCard(c1);
					}
					if(!p2.isEmpty())
					{
						c2 = p2.draw();
						p2Tie.addCard(c2);
					}
				}
				
				if(p1Tie.cards.size() <= p2Tie.cards.size())
					drawSize = p2Tie.cards.size();
				else
					drawSize = p1Tie.cards.size();
				//p1Best = p1Tie.get(0); is WRONG!!!
				//p1Best = p1Tie.cards.get(0);
				//p2Best = p2Tie.cards.get(0);
				for(int i = 1; i < drawSize; i++)
				{
					//size is constant and i is counting up so this won't work
					if((p1Tie.cards.size() > i))
					{
						//if(p1Best < p1Tie.get(i)) is WRONG!!!
						if(p1Best.getRank() < p1Tie.cards.get(i).getRank())
							p1Best = p1Tie.cards.get(i);
					}
					if((p2Tie.cards.size() > i))
					{
						if(p2Best.getRank() < p2Tie.cards.get(i).getRank())
							p2Best = p2Tie.cards.get(i);
					}
				}
				
				if(p1Best.getRank() == 13 && p2Best.getRank() == 13)
					break;
				}
				//This needed to be moved here before putting our 2 tie cards in
				//their respected collections in case a players last card is tie
				//!!!!!!!!!!!JK Pretty sure this never mattered!!!!!!!!!!!!!!!!!!!
				//int tieBreaker = p1Best.getRank() - p2Best.getRank();
				//In a tie situation, Pile tie will only ever have 2 cards!
				p1Tie.addCard(tie.cards.get(0));
				p2Tie.addCard(tie.cards.get(1));
				int tieBreaker = 0;
				if(p1Best.getRank() == 13 && p2Best.getRank() == 13)
				{
					if(p1Best.compareTo(p2Best) == 1)
						tieBreaker = 1;
					else
						tieBreaker = -1;
				}
				else
					tieBreaker = p1Best.getRank() - p2Best.getRank();
				drawSize++;
				if(tieBreaker > 0)
				{
					//if anything find a way to shuffle through all these
					//piles and add them individually can addDeck won't
					for(int i = 0; i < drawSize; i++)
					{
						if((p1Tie.cards.size() > i))
							p1.addCard(p1Tie.cards.get(i));
						if((p2Tie.cards.size() > i))
							p1.addCard(p2Tie.cards.get(i));
					}
				}
				else
				{
					for(int i = 0; i < drawSize; i++)
					{	
						//************SMART ERROR********************
						//I mistakingly made both if-else add the card to p1 so
						//that when I debug I run into errors much faster!!!!!!!
						//p1.addCard(tie.cards.get(i));    What I used!
						if((p1Tie.cards.size() > i))
							p2.addCard(p1Tie.cards.get(i));
						if((p2Tie.cards.size() > i))
							p2.addCard(p2Tie.cards.get(i));
					}
				}
			}
		}
		if(p2.isEmpty())
			System.out.println("Player 1 wins!");
		else
			System.out.println("Player 2 wins!");
	}
}