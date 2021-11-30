/**
 * This Flush is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class Flush extends Hand{
    /**
     * public Construtor for Flush class
     * @param player
     * @param card
     */
    public Flush(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if 5 card of same suit presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
        if (this.size() == 5){
            // if suit of (4)=(3)=(2)=(1)=(0), 5 card have same suit
            for (int i = 1; i < this.size(); ++i){
                if (this.getCard(i).getSuit() != this.getCard(i-1).getSuit()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Flush";
    }
}
