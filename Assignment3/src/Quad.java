import java.util.*;

/**
 * This Quad is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.1
 * @date 19/10/2021 (start v1.0); 6/11/2021 (start v1.1)
 * v1.0 redo the isValid(), may have bug
 * (update) bug casued by i!=j logic when i=4, it is not possible to be j=4 (max = 3)
 * (update2) the getTopCard method need to overwirte
 */

public class Quad extends Hand{
    /**
     * public Construtor for Quad class
     * @param player
     * @param card
     */
    public Quad(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if 5 card, with 4 having same rank presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
        this.sort();
        int first4Count = 0;    //sort will make it only left this 2 cases
        int last4Count = 0;
        if (this.size() == 5){
            for (int i = 0; i < 3; ++i){
                if (this.getCard(i).getRank() == this.getCard(i+1).getRank()){
                    first4Count += 1;
                }
            }
            for (int j = 1; j < 4; ++j){
                if (this.getCard(j).getRank() == this.getCard(j+1).getRank()){
                    last4Count += 1;
                }
            }
        }
        else{
            return false;
        }
        if (first4Count == 3 || last4Count == 3){
            return true;
        }
        else{
            return false;
        }
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Quad";
    }

    /**public getter for top card of this hand
     * Overwrite it for Quad
     * @return topCard, type Card
     */
    public Card getTopCard(){
        this.sort();
        if (this.getCard(0).getRank() == this.getCard(1).getRank()){    //it means it is in the pattern x,x,x,x,odd when sorted
            return this.getCard(3);
        }
        else{
            return this.getCard(4);
        }
    }
}
