/**
 * This Single is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class Single extends Hand{
    /**
     * public Construtor for Single class
     * @param player
     * @param card
     */
    public Single(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if Single card presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){   //not sure how to implement in detail in Ver1.0 now
        if (this.size() == 1){
            return true;
        }
        return false;
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Single";
    }
}
