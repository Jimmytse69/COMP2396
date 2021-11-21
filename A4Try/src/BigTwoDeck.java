/** 
 * This BigTwoDeck class is a subclass of the Deck class to model a deck of cards used in a Big Two game.
 * The overwritten methods as detailed as below
 * @author Tse Chung Wan, 3035689324
 * @version 1.2: 
 * v1.0: BigTwo.java have NullPointerException when complie, it point to initialize() method in this class; redo it
 * (update): after redo, realize why i am creating new bigTwoDeck instance var. to store but not use .addCard inherit method
 * v1.1: used card of (new Card) Constructor instead of new BigTwoCard(i, j), minor fix
 * @date 19/10/2021 (start ver1.0); 28/10/2021 (start ver1.1); 29/10/2021 (start ver1.2)
 */

public class BigTwoDeck extends Deck{
    /**
     * a public overriding method for initializing a deck of Big Two cards.
     * it will remove all cards from the deck, create 52 Big Two cards and add them to the deck.
     */
    public void initialize(){
        this.removeAllCards();
        for (int i = 0; i < 4; ++i){
            for (int j = 0; j < 13; ++j){
                this.addCard(new BigTwoCard(i, j));
            }
        }
    }
}