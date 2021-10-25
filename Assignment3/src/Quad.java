import java.util.*;

/**
 * This Quad is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
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
        int first4Count = 0;
        int last4Count = 0;
        ArrayList<Integer> freqOfRank = new ArrayList<Integer>(); 
        if (this.size() == 5){
            for (int i = 0; i < this.size(); ++i){
                freqOfRank.add(this.getCard(i).getRank());
            }
            //sorted order of freqOfRank. the (first4 should have same rank) or (last 4 should have same rank)
            Collections.sort(freqOfRank);
            for (int j = 0; j < this.size() - 2; ++j){
                if (freqOfRank.get(j) == freqOfRank.get(j+1)){
                    first4Count++;  //0-1, 1-2, 2-3
                }
            }
            for (int k = 1; k < this.size() - 1; ++k){
                if (freqOfRank.get(k) == freqOfRank.get(k+1)){
                    last4Count++;   //1-2, 2-3, 3-4
                }
            }
            if (first4Count != 3 && last4Count != 3){
                return false;
            }
            else{
                return true;    //at least 1 == 3
            }
        }
        return false;
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "Quad";
    }
}
