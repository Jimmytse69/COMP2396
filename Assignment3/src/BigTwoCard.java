/**
 * This BigTwoCard class is a subclass of the Card class and is used to model a card used in a Big Two card game.
 * The contructor and overwritten methods are showed below
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (v1.0 start)
 */

public class BigTwoCard extends Card{

    /**
     * Constructor for building a card with specified suit and rank, suit is int (0-3) and rank is int (0-12)
     * @param suit, int type
     * @param rank, int type
     */
    public BigTwoCard(int suit, int rank){
        //ref: https://stackoverflow.com/questions/23395513/implicit-super-constructor-person-is-undefined-must-explicitly-invoke-another
        super(suit, rank);
    }

    /**
     * a overwritten method for comparing the order of this card with the specified card.
     * Return -ve, 0, +ve when less than, equal, greater than specified card.
     * @param card, Card type
     * @return int, indicate less,equal or greater
     */
    public int compareTo(Card card){
    }
}
