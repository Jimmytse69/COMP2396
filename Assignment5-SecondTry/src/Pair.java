/**
 * This Pair is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class Pair extends Hand{
    /**
     * public Construtor for Pair class
     * @param player
     * @param card
     */
    public Pair(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if pair of card of same rank presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
        if (this.size() == 2){
            if (this.getCard(0).getRank() == this.getCard(1).getRank()){    //2 same Rank to be pair
                return true;
            }
        }
        return false;
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Pair";
    }
}
