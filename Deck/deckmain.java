package Deck;

public class deckmain {

	public static void main(String[] args) {
		 Deck cardDeck = new Deck();
	        cardDeck.shuffle();
	        int i;
	       

	       // System.out.println();
	        i=0;
	        cardDeck.order();
	        while (cardDeck.hasNext()){
	            Card topCard = cardDeck.drawOne();
	            System.out.println(topCard.getRank().getName() +" of " + topCard.getSuit().getName());
	}

	}

}
