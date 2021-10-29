

public class BigTwoHandTester {

    public static void composeAndCompare(CardList cards1, CardList cards2){
        Hand h1 = BigTwo.composeHand(p1, cards1);
        if (h1 != null){
            System.out.println("1P plays " + h1.getType() + " :");
        }   else{
            System.out.println("1P is not playing a legit hand:");
        }
        cards1.print();

        Hand h2 = BigTwo.composeHand(p2, cards2);
        if (h2 != null){
            System.out.println("2P plays " + h2.getType() + " :");
        }   else{
            System.out.println("2P is not playing a legit hand:");
        }
        cards2.print();

        if ((h1 != null) && (h2 != null)){
            if (h1.beats(h2)){
                System.out.println("1P wins!");
            }
            else{
                System.out.println("1P does not beat 2P.");
            }
        }
        else{
            System.out.println("The two hand cannot be compared.");
        }


    }

    //Create two dummy players and prepare them different hands for
    //testing later
    private static CardGamePlayer p1 = new CardGamePlayer("1P");
    private static CardGamePlayer p2 = new CardGamePlayer("2P");

    public static void main(String[] args){
        CardList cards1, cards2;

        /**
         * Attempt to campare two legit hands
         */
        // Player 1: a pair of 3s
        cards1 = new CardList();
        cards1.addCard(new BigTwoCard(0,2));    //3d
        cards1.addCard(new BigTwoCard(1,2));    //3c
        Hand h1 = new Pair(p1, cards1);
        System.out.println("1P players" + h1.getType() + " :");
        cards1.print();

        //Player 2: a paire of 2s
        cards2 = new CardList();
        cards2.addCard(new BigTwoCard(3,1));    //2s
        cards2.addCard(new BigTwoCard(2,1));    //2h
        Hand h2 = new Pair(p2, cards2);
        System.out.println("2P players " + h2.getType() + " :");
        cards2.print();
        //Compare the two hands
        if (h1.beats(h2)){
            System.out.println("1P wins!");
        }   else{
            System.out.println("1P does not beat 2P.");
        }

        System.out.println("========");
    }

}
