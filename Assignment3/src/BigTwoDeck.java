import java.util.*;

/** 
 * This BigTwoDeck class is a subclass of the Deck class to model a deck of cards used in a Big Two game.
 * The overwritten methods as detailed as below
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start ver1.0)
 */

public class BigTwoDeck extends Deck{
    /**create a new private ArrayList<BigTwoCard> to represent a BigTwoDeck in terms of BigTwoCard*/
    private ArrayList<BigTwoCard> bigTwoDeck = new ArrayList<BigTwoCard>();

    /**
     * private static variable to indicate the rank difference from normal poker game.
     * this is a look up table (where index indicate) from rank lower to high.
     * RANK[2] = rank 3 which is smallest.
     * RANK[1] = rank 2 which is biggest (Big2)
     * RANK[0] = rank ACE which is only smaller than Big 2 in this game
     */
    private static int[] bigTwoRank = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1};

    /**
     * a public overriding method for initializing a deck of Big Two cards.
     * it will remove all cards from the deck, create 52 Big Two cards and add them to the deck.
     */
    public void initialize(){
        removeAllCards();
        for (int i = 0; i < 4; ++i){    //i = suit number
            for (int j = 0; j < 13; j++){   //j = rank number
                bigTwoDeck.add(new BigTwoCard(i, bigTwoRank[j]));  //convert to bigTwoRank system, BigTwoDeck is sort from smallest to biggest in terms of big2
            }    
        }

    }
}
