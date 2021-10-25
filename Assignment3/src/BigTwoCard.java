/**
 * This BigTwoCard class is a subclass of the Card class and is used to model a card used in a Big Two card game.
 * The contructor and overwritten methods are showed below
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (v1.0 start)
 */

public class BigTwoCard extends Card{

    /**
     * private static variable to indicate the rank difference from normal poker game.
     * this is a look up table (where index indicate) from rank lower to high.
     * RANK[2] = rank 3 which is smallest.
     * RANK[1] = rank 2 which is biggest (Big2)
     * RANK[0] = rank ACE which is only smaller than Big 2 in this game
     */
    private static int[] bigTwoRank = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1};

    /**
     * Constructor for building a card with specified suit and rank, suit is int (0-3) and rank is int (0-12)
     * @param suit, int type
     * @param rank, int type
     */
    public BigTwoCard(int suit, int rank){
        //ref: https://stackoverflow.com/questions/23395513/implicit-super-constructor-person-is-undefined-must-explicitly-invoke-another
        super(suit, rank);
    }

    /**
     * a overwritten method for comparing the order of this card with the specified card.
     * Return -ve, 0, +ve when less than, equal, greater than specified card.
     * @param card, Card type
     * @return int, indicate less,equal or greater
     */
    //need to translate to back to accending order first by look up table (static array)
    public int compareTo(Card card){
        if (bigTwoRank[this.rank] > bigTwoRank[card.rank]){
            return 1;       //this card in BigTwo rank system is greater
        }
        else if (bigTwoRank[this.rank] < bigTwoRank[card.rank]){
            return -1;
        }
        else{   //when 2 card's big2Rank is equal, compare suit
            if (this.suit > card.suit){
                return 1;
            }
            else if (this.suit < card.suit){
                return -1;
            }
            else{   //both rank and suit are equal
                return 0;
            }
        }

    }
}
