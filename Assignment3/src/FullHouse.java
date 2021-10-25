import java.util.*;

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
        ArrayList<Integer> freqOfRank = new ArrayList<Integer>(); 
        if (this.size() == 5){
            for (int i = 0; i < this.size(); ++i){
                freqOfRank.add(this.getCard(i).getRank());
            }
            //sorted order of freqOfRank. the (first 3 elem should have same rank and last 2 elem should have same rank) or
            //                                (first 2 elem should have same rank and last 3 elem should have same rank)
            Collections.sort(freqOfRank);
            if ( ( (freqOfRank.get(0) == freqOfRank.get(1) && freqOfRank.get(1) == freqOfRank.get(2)) && (freqOfRank.get(3) == freqOfRank.get(4)) ) ||
                 ( (freqOfRank.get(1) == freqOfRank.get(1)) && (freqOfRank.get(2) == freqOfRank.get(3) && freqOfRank.get(3) == freqOfRank.get(4)) ) ){
                    return true;
            }
        }
        return false;
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "FullHouse";
    }
}
