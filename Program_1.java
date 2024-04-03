
public class Shuffle_Deck 
{

	public static void main(String[] args) 
	{
		boolean[] myDeck = new boolean[52];
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		initDeck(myDeck);
		System.out.println("\nHere is a shuffled deck ...\n");
		while (!emptyDeck(myDeck))
		{
		myCard = dealCard(myDeck);
		++cardsThisRow;
		if (cardsThisRow <= cardsPerRow)
		{
		printCard(myCard);
		System.out.print(" ");
		}
		else
		{
		System.out.println("");
		cardsThisRow = 1;
		printCard(myCard);
		System.out.print(" ");
		}
		}
		System.out.println("\n");

	}
	public static void initDeck(boolean[] deck)
	{
		for(int i = 0; i<deck.length; i++)
		{
			deck[i] = true;
		}
	}
	
		public static boolean emptyDeck(boolean[] deck)
		{
			for(int i=0; i<deck.length; i++)
			{
				if (deck[i] == true)
				{
					return false;
				}
			}
			return true;
		}
		
		
		public static int dealCard(boolean[] deck)
		{
			int i; 
			
			do
			{
				i = (int) (Math.random()*52);
			}while(deck[i] !=true);
			
			deck[i] = false;
			return i;
		}
	
		public static void printCard(int card)
		{
			String[] suits = {"H","D","C","S"};
			String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
			
			int suitIndex = card/13;
			int rankIndex = card%13;
			
			String suit = suits[suitIndex];
			String rank = ranks[rankIndex];
			
			System.out.print(rank + suit + " ");
			
		}
	
}

















