import java.util.*;

/**
 * This Straight is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.1
 * @date 19/10/2021 (start v1.0); 6/11/2021 (start v1.1)
 * v1.0: BigTwoRank Look up Table is useless, remove and redo isValid()
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
        this.sort();
        int counter = 0;
        if (this.size() == 5){
            for (int i = 0; i < 4; ++i){
                if (this.getCard(i).getRank() + 1 == this.getCard(i+1).getRank()){  //it is consecutive when i -> i+1
                    counter += 1;
                }
            }
        }
        else{
            return false;
        }
        
        if (counter == 4){
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
        return "Straight";
    }
}

