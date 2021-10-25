/**
 * This Straight is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class Straight extends Hand{
    /**
     * public Construtor for Straight class
     * @param player
     * @param card
     */
    public Straight(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if 5 card of consecutive rank is presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
        if (this.size() == 5){
            
        }
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Straight";
    }
}

