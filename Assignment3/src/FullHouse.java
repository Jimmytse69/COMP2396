/**
 * This FullHouse is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class FullHouse extends Hand{
    /**
     * public Construtor for FullHouse class
     * @param player
     * @param card
     */
    public FullHouse(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if 5 card, 2 have same rank and 3 another have same rank presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
    }
}
