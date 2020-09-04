/*
 * a Hand is just like a CardCollection, but
 * it provides an additional method.
 */
public class Hand extends CardCollection
{
	public Hand(String label)
	{
		super(label);
	}
	//??So only Hand objects have access to the display method????
	public void display()
	{
		System.out.println(getLabel() + ":");
		for(int i = 0; i < size(); i++)
		{
			System.out.println(getCard(i));
		}
		System.out.println();
	}
}