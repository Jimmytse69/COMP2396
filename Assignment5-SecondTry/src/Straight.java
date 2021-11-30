import java.util.*;

/**
 * This Straight is subclass of Hand class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (start v1.0)
 */

public class Straight extends Hand{
    //private static variable to indicate the rank difference from normal poker game. This is a look up table (where index indicate) from rank lower to high.
    //RANK[2] = rank 3 which is smallest, RANK[1] = rank 2 which is biggest (Big2)
    private static ArrayList<Integer> bigTwoRank = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1));

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
                if (bigTwoRank.indexOf(this.getCard(i).getRank()) + 1 == bigTwoRank.indexOf(this.getCard(i+1).getRank())){  //it is consecutive when i -> i+1
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

