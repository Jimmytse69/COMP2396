import java.util.*;

/** 
 * This BigTwoDeck class is a subclass of the Deck class to model a deck of cards used in a Big Two game.
 * The overwritten methods as detailed as below
 * @author Tse Chung Wan, 3035689324
 * @version 1.1: 
 * v1.0: BigTwo.java have NullPointerException when complie, it point to initialize() method in this class; redo it
 * (update): after redo, realize why i am creating new bigTwoDeck instance var. to store but not use .addCard inherit method
 * @date 19/10/2021 (start ver1.0); 28/10/2021 (start ver1.1)
 */

public class BigTwoDeck extends Deck{
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
        this.removeAllCards();
        for (int i = 0; i < 4; ++i){
            for (int j = 0; j < 13; ++j){
                this.addCard(new Card(i, bigTwoRank[j]));
            }
        }
    }
}