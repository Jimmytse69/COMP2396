/**
 * This Hand class is a subclass of the CardList class used to model a hand of cards. detail shown below
 * @author Tse Chung Wan, 3035689324
 * @version 1.1
 * v1.0: Tester wrong, caused by the beat method is directly compare card rank not in terms of rule of Big2Rank.
 * Should use .compareTo method to compare instead
 * (updated): not sure getTop is really the top, add .sort method to sort and get Top
 * (updated2): Only Quad need extra "top" treatment
 * @date 19/10/2021 (start ver1.0); 29/10/2021 (start ver1.1)
 */

public abstract class Hand extends CardList{
    /**
     * public Constructor for building a hand with specified player and list of cards.
     * @param player, type CardGamePlayer
     * @param cards, type CardList
     */
    public Hand(CardGamePlayer player, CardList cards){
        this.player = player;
        for (int i = 0; i < cards.size(); ++i){
            this.addCard(cards.getCard(i));     //copy the cards list in param to Hand.cards with addCard and getCard method
        }
    }

    private CardGamePlayer player;


    /**public getter for player of this hand 
     * @return player, type CardGamePlayer
    */
    public CardGamePlayer getPlayer(){return this.player;}

    /**public getter for top card of this hand
     * Quad, FullHouse need to Overwrite it!!, because it's top card is quad, tri
     * @return topCard, type Card
     */
    public Card getTopCard(){
        this.sort();
        return this.getCard(this.size() - 1);   //top card is the "lastest" card if sorted
    }

    /**public method for checking if this hand beats a specified hand
     * @param hand, type Hand
     * @return true = beaten
     */
    public boolean beats(Hand hand){
        int bigger = this.getTopCard().compareTo(hand.getTopCard());    //if same hand type, it is used to convert bool\
        boolean big = false;
        boolean equal = false;
        if (bigger > 0){
            big = true;
        }
        else if (bigger == 0){
            equal = true;
        }

        if (this.getType() == "StraightFlush"){ //case of this.hand = StraightFlush
            if (hand.getType() != "StraightFlush"){
                return true; //beaten if this hand is StraightFlush but param's is not (StraightFlush is highest hand)
            }
            else{            
                if (big){
                    return true;
                }
                else if (equal){
                    if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()){
                        return true;
                    }
                    return false;   //same type same rank, but this hand have lower/equal suit so it is not beaten param's hand
                }
                else{
                    return false;   //same type lower rank always lose
                }
            }
        }
        else if (this.getType() == "Quad"){
            if (hand.getType() == "StraightFlush"){
                return false;   //always lose to StraightFlush
            }
            else if (hand.getType() == "Quad"){
                if (big){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;    //type is lower, so we win
            }
        }
        else if (this.getType() == "FullHouse"){
            if (hand.getType() == "StraightFlush" || hand.getType() == "Quad"){
                return false;
            }
            else if (hand.getType() == "FullHouse"){
                if (big){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else if (this.getType() == "Flush"){
            if (hand.getType() == "StraightFlush" || hand.getType() == "Quad" || hand.getType() == "FullHouse"){
                return false;
            }
            else if (hand.getType() == "Flush"){
                if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()){
                    return true;
                }
                else if (this.getTopCard().getSuit() == hand.getTopCard().getSuit()){
                    if (big){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return true;    //beaten lower type
            }
        }
        else if (this.getType() == "Straight"){
            if (hand.getType() == "StraightFlush" || hand.getType() == "Quad" || hand.getType() == "FullHouse" || hand.getType() == "Flush"){
                return false;
            }
            else if (hand.getType() == "Straight"){
                if (big){
                    return true;
                }
                else if (equal){
                    if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return true;    //beaten lower type
            }
        }
        else if (this.getType() == "Triple"){
            if (hand.getType() == "StraightFlush" || hand.getType() == "Quad" || hand.getType() == "FullHouse" || 
                hand.getType() == "Flush"         || hand.getType() == "Straight" ){
                return false;
            }
            else if (hand.getType() == "Triple"){
                if (big){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else if (this.getType() == "Pair"){
            if (hand.getType() == "StraightFlush" || hand.getType() == "Quad"       || hand.getType() == "FullHouse" || 
                hand.getType() == "Flush"         || hand.getType() == "Straight"   || hand.getType() == "Triple"){
                return false;
            }
            else if (hand.getType() == "Pair"){
                if (big){
                    return true;
                }
                else if (equal){
                    if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return true;    //beaten Single type
            }
        }
        else{   //only left Single class
            if (hand.getType() == "Single"){
                if (big){
                    return true;
                }
                else if (equal){
                    if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;   //it lose to any other hand types
            }
        }
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
