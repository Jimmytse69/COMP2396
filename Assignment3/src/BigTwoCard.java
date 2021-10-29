import javax.swing.text.Style;

/**
 * This BigTwoCard class is a subclass of the Card class and is used to model a card used in a Big Two card game.
 * The contructor and overwritten methods are showed below
 * @author Tse Chung Wan, 3035689324
 * @version 1.1
 * v1.0 CompareTo method not working (not sorted in big2 order), try to rewrite
 * (update): using -2 (shift left) mod 13 to do so, but when -ve: e.g. 1-2 mod 13 = -1 but not desire 13 - 1 = 12 (bug).
 * resolved by checking -ve and +13 if necessary, Ref: https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers
 * v1.1 update: seems ok now in Tester class
 * 
 * @date 19/10/2021 (v1.0 start); 29/10/2021 (v1.1 start)
 */

public class BigTwoCard extends Card{
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
        int big2RankOfThis = (this.rank - 2) % 13;
        int big2RankOfCard = (card.rank - 2) % 13;
        if (big2RankOfThis < 0){
            big2RankOfThis += 13;
        }
        if (big2RankOfCard < 0){
            big2RankOfCard += 13;
        }
        //Resolve bug in v1.0 mentioned in javaDoc.

        if (big2RankOfThis > big2RankOfCard){
            return 1;       //this card in BigTwo rank system is greater
        }
        else if (big2RankOfThis < big2RankOfCard){
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

