public class BigTwoDeckTester {
    public static void main(String[] args){
        //Prepare a Big Two Deck
        BigTwoDeck deck = new BigTwoDeck();

        System.out.println(
            "=== Are you going to cheat with an illegal deck? ==="
        );
        System.out.println("-----");

        System.out.println(
            "How many cards are there (Expected: 52)? " +
            deck.size()
        );
        System.out.println("-----");

        System.out.println(
            "What cards are you using (Expected: BigTwoCard)? " +
            deck.getCard(0).getClass()            
        );
        System.out.println("-----");

        System.out.println(
            "Just to make sure, Ace of spades is not top card in your deck. "
        );
        System.out.println(String.format(
            "Is %s stronger than %s (Expected: -1)? %d",
            deck.getCard(39), deck.getCard(40), deck.getCard(39).compareTo(deck.getCard(40))));
        System.out.println("-----");

        System.out.println("-----");
        
        System.out.println("I don't believe you! Let me check all your cards!");
        deck.print();

    }
}
