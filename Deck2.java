/*
 * a Deck is just like a CardCollection, but it provides a
 * different constructor.
 */
public class Deck2 extends CardCollection
{
	//Deck "extends" the class CardCollection
	//A Deck object has the same instance variables and methods as
	//a CardCollection.        ???a CardCollection object?????
	//Deck "inherits from" CardCollection
	//Deck extends CardCollection and CardCollection extends Object
	//?????Constructors are "not" inherited, and all other PUBLIC 
	//attributes and methods are!????? label is private in CardColl?
	public Deck2(String label)
	{
		//"super" invokes the constructor of the superclass
		//which initializes the attributes label and cards
		super(label);
		//Once the constructor returns, this Deck constructor resumes
		//and populates the (empty)ArrayList with Card Objects.
		for(int suit = 0; suit <= 3; suit++)
		{
			for(int rank = 1; rank <= 13; rank++)
			{
				//?why create a new Card???
				//??WHY is [new Card] call allowed this way it wasn't
				//even ever initialized??????? why not just (Card) no new??
				addCard(new Card(rank, suit));
			}
		}
	}
}