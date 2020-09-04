import java.util.Scanner;

public class Eights
{
	private Player one;
	private Player two;
	private Hand drawPile;
	private Hand discardPile;
	private Scanner in;
	
	public Eights(String p1, String p2)
	{
		//Remember the current object(this) in use now is the Eights object which
		//has these attributes!^ 
		Deck2 deck = new Deck2("Deck");
		deck.shuffle();	//??What's the point of even making a deck!!???
		
		one = new Player(p1);	
		//?Why doesn't one.hand just work???? Is it because if we say one.hand then
		//the type is a Player object so it returns as a Player object and deal()
		//needs either Hand, Deck2, or a CardCollection object???? or is it that we 
		//just can't access the attributes of a Player object from here because they
		//are private???? if yes to the last one is a getMethod the only way????
		deck.deal(one.getHand(), 5);
		two = new Player(p2);
		deck.deal(two.getHand(), 5);
		
		discardPile = new Hand("Discard Pile");
		deck.deal(discardPile, 1);
		
		drawPile = new Hand("Draw Pile");
		deck.dealAll(drawPile);
		
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args)
	{
		System.out.println("Howdy, let's play 8's!");
		//Eights game;
		
		Scanner inny = new Scanner(System.in);
		System.out.println("What's your name?");
		String p1 = inny.nextLine();
		System.out.println("Whats your friends name?");
		String p2 = inny.nextLine();
		
		//game = new Eights(p1, p2);
		Eights game = new Eights(p1, p2);
		game.playGame();
	}
	
	public boolean isDone()
	{
		/*if(p1.hand.size() == 0)
		{
			System.out.println("Ya " + p1.name + " won!");
			p1.score();
		}*/
		return one.getHand().isEmpty() || two.getHand().isEmpty();
	}
	
	public void reshuffle()
	{
		Card prev = discardPile.removeCard();
		discardPile.dealAll(drawPile);
		discardPile.addCard(prev);
		drawPile.shuffle();
	}
	
	public Card drawCard()
	{
		if(drawPile.isEmpty())
			reshuffle();
		return drawPile.removeCard();
	}
	
	public Player nextPlayer(Player current)
	{
		if(current == one)
			return two;
		else
			return one;
	}
	
	public void displayState()
	{		
		//???Why not just do one.hand.display(); and if this doesn't work why not,
		//because we never technically access it we just use the attribute to invoke
		//that attributes own objects/class's method
		//or one.getHand().display();
		//??Point is I feel like adding the display method in Player, since it's 
		//just a wrapper method, is pointless either by a slowing down of computation
		//or just bad style since here we can't tell that it's just a wrapper method
		//to use another class's method!!!??? How do we just invoke the Hand's 
		//display method directly(from here)!!!!????????????????????????????????????
		one.display();
		two.display();
		discardPile.display();
		System.out.println("Draw Pile:");
		System.out.println(drawPile.size() + " cards");
		in.nextLine();
	}
	
	public void takeTurn(Player player)
	{
		Card prev = discardPile.lastCard();
		//???We passed argument this which is the eights object not the player, yet
		//in the class Player this is the player variable??????
		//ANS:Yes this is right
		//?????BUT what is the purpose in doing this???????
		Card next = player.play(this, prev); 
		//(51)??takes from player or one???? or neither????
		//(52)Which discardPile is it being added to, player or one??? AND if it's
		//added to only 1 of those options WHY because when we removed it, both
		//variables had the card removed????????????????????????????????????????
		discardPile.addCard(next);
		
		System.out.println(player.getName() + " plays " + next);
		System.out.println();
	}
	
	public void playGame()
	{
		//???WHAT IS THIS VARIABLES PURPOSE????????????? Why not just use the 2 
		//Player variables that we already had???????
		Player player = one;
		
		while(!isDone())
		{
			displayState();
			takeTurn(player);
			player = nextPlayer(player);
		}
		
		one.displayScore();
		two.displayScore();	
	}
	
	//?Why cant this be here????? Cause score method is in Player so
	//it can't be seen from here cause it's not static???????
	/*public void displayScore()
	{
		System.out.println(name + " had " + score() + " points!");
	}*/
}