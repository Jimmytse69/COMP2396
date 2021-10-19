/**
 * This Hand class is a subclass of the CardList class used to model a hand of cards. detail shown below
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start ver1.0)
 */

public abstract class Hand extends CardList{
    /**
     * public Constructor for building a hand with specified player and list of cards.
     * @param player, type CardGamePlayer
     * @param cards, type CardList
     */
    public Hand(CardGamePlayer player, CardList cards){

    }

    /**private instance variable to state the player who plays this hand */
    private CardGamePlayer player;


    /**public getter for player of this hand 
     * @return player, type CardGamePlayer
    */
    public CardGamePlayer getPlayer(){return this.player;}

    /**public getter for top card of this hand
     * @return topCard, type Card
     */
    public Card getTopCard(){}

    /**public method for checking if this hand beats a specified hand
     * @param hand, type Hand
     * @return true = beaten
     */
    public boolean beats(Hand hand){

    }

    /**abstract methods for checking if this is valid hand, supposed to be overwritten by "leaf node" 
     * @return true = valid
    */
    abstract boolean isValid();

    /**abstract methods for returning a string specifying the type of this hand.
     * @return type of hand, String type
     */
    abstract String getType();

    


}
