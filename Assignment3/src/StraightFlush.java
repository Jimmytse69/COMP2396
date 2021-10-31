import java.util.*;

/**
 * This Straight Flush is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class StraightFlush extends Hand{
    //private static variable to indicate the rank difference from normal poker game. This is a look up table (where index indicate) from rank lower to high.
    //RANK[2] = rank 3 which is smallest, RANK[1] = rank 2 which is biggest (Big2)
    private static ArrayList<Integer> bigTwoRank = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1));


    /**
     * public Construtor for StraightFlush class
     * @param player
     * @param card
     */
    public StraightFlush(CardGamePlayer player, CardList card){
        super(player, card);
    }

    /**if 5 consecutive rank and same suit card presented, it is valid.
     * @return boolean true = valid
    */
    public boolean isValid(){
        if (this.size() == 5){
            for (int i = 1; i < this.size(); ++i){
                if (this.getCard(i).getSuit() != this.getCard(i-1).getSuit()){
                    return false;   //if "one pair" out of 4 between 5 are not same suit, it is not striaghtflush
                }
            }
            //reference: https://stackoverflow.com/questions/6171663/how-to-find-the-index-of-an-element-in-an-int-array
            for (int i = 1; i < this.size(); ++i){
                //if the top card (i) in terms of big2rank is 1 more then (i-1). it should be consecutive for 5 times (Assume sorted form small to big)
                if (bigTwoRank.indexOf(this.getCard(i).getRank()) - bigTwoRank.indexOf(this.getCard(i-1).getRank()) != 1){
                    return false;
                }
            }
            return true;
        }
        return false;   //it is not even 5 cards.
    }
        
    /**Type of this name 
     * @return string of hand type name
    */
    public String getType(){
        return "StraightFlush";
    }
}
