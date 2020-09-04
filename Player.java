public class Player
{
	private String name;
	private Hand hand;
	
	public Player(String name)
	{
		//Here we have to use this to distinguish between the
		//instance variable and the parameter with the same name
		this.name = name;
		this.hand = new Hand(name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public Card play(Eights eights, Card prev)
	{
		//"prev" is the top card of the discard pile
		//BOOK:play invokes two helper methods: searchForMatch and
		//drawForMatch. Since we have not written them yet, this is
		//an example of "top-down development".
		Card card = searchForMatch(prev);//='s null if you check all the cards in your hand and nothing matches which then executes the inside
		if(card == null)
			card = drawForMatch(eights, prev);
		return card;
	}
	
	public Card searchForMatch(Card prev)
	{
		for(int i = 0; i < hand.size(); i++)
		{
			Card card = hand.getCard(i);
			//(50)If the card is found then we remove it BUT the current object(this)
			//in use is player BUT once we remove it from player the card is removed
			//from the Eights one/two attribute as well HOW?????
			if(cardMatches(card, prev))
				return hand.removeCard(i);
		}
		return null;
	}
	
	public Card drawForMatch(Eights eights, Card prev)
	{
		while(true)
		{ //?????HOW IS THIS ALLOWED??? eights.two
			Card card = eights.drawCard();
			System.out.println(name + " draws " + card);
			if(cardMatches(card, prev))
				return card;
			hand.addCard(card);
		}
	}
	
	public static boolean cardMatches(Card card1, Card card2)
	{
		return card1.getSuit() == card2.getSuit()
				|| card1.getRank() == card2.getRank()
				|| card1.getRank() == 8;
	}
	
	public int score()
	{
		int sum = 0;
		for(int i = 0; i < hand.size(); i++)
		{
			int rankPoints = hand.getCard(i).getRank() % 14;
			if(rankPoints <=13 && rankPoints >= 11)
			{
				sum += 10;
			}
			//rankPoints = hand.getCard(i).getRank() % 10;
			if(rankPoints < 11)
				sum += rankPoints;
		}
		return sum;
	}
	
	//??Isn't this just a wrapper method??? So in Eights can't we just
	//call the display method in Hand from there and make it easier!???
	public void display()
	{
		hand.display();
	}
	
	public void displayScore()
	{
		System.out.println(name + " had " + score() + " points!");
	}
}