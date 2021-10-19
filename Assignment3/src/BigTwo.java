import java.util.*;

/**
 * This BigTwo class is used to model a Big Two card game, the instance variables and methods detail are shown below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (starting v1.0)
 */

public class BigTwo {
    /**Construstor for creating a Big Two card game. There are 2 procedures:
     * (i) : create 4 players and add them to player list
     * (ii): create a BigTwoUI object for user interface.
     */
    BigTwo(){}


    /**private attributes to specifying the number of players, should be 4 in a normal game */
    private int numOfPlayers;

    /**private attributes to store the deck of cards of the game */
    private Deck deck;

    /**private attributes to record the list of players */
    private ArrayList<CardGamePlayer> playerList;

    /**private attributes to record the list of hands played on Table */
    private ArrayList<Hand> handsOnTable;

    /**private attributes to specifying the index of current player */
    private int currentPlayerIdx;

    /**private UI object for providing User Interface in a normal Big Two game */
    private BigTwoUI ui;


    /**public getter of number of player (private attributes) 
     * @return numOfPlayers, int type
    */
    public int getNumOfPlayers(){return this.numOfPlayers;}

    /**public getter of deck of cards being used 
     * @return deck, Deck type
    */
    public Deck getDeck(){return this.deck;}

    /**public getter of list of players 
     * @return playerList, ArrayList<CardGamePlayer> type
    */
    public ArrayList<CardGamePlayer> getPlayerList(){return this.playerList;}

    /**public getter of list of hands played on table 
     * @return handsOnTable, ArrayList<Hand> type
    */
    public ArrayList<Hand> getHandsOnTable(){return this.handsOnTable;}

    /**public getter of index of current player 
     * @return currentPlayerIdx, int type
    */
    public int getCurrentPlayerIdx(){return this.currentPlayerIdx;}

    /**public methods to start the game, there are 6 procedures:
     * (i)  : remove all the cards from players and Tables
     * (ii) : distribute cards to players
     * (iii): identify the player who holds Diamond 3 (who start the game from)
     * (iv) : set this.currentPlayerIdx and BigTwoUI.activePlayer = (iii)'s' player
     * (v)  : call BigTwoUI.repaint() to show the cards on table
     * (vi) : call BigTwoUI.promptActivePlayer() to prompt user to select cards and make his move
     * @param deck, Deck type
     */
    public void start(Deck deck){

    }

    /**public method for makeing a move by player 
     * This is supposed to be called by BigTwoUI after active player have select cards to make move.
     * just called the checkMove() method and passing all param for now
     * @param playerIdx, int type
     * @param cardIdx, int[] type
    */
    public void makeMove(int playerIdx, int[] cardIdx){
        this.checkMove(playerIdx, cardIdx);
    }

    /**public method for checking a move made by player. Supposed to called from makeMove() method. */
    public void checkMove(int playerIdx, int[] cardIdx){

    }

    /**public static Main method to start a Big Two card game. It should
     * (i)  : create a Big Two card game
     * (ii) : create and shuffle a deck of cards
     * (iii): start the game with deck of cards
     */
    public static void main(String[] args){

    }

    /**public static method returning a valid hand from that player (with his current list of cards)
     * return null if cannot compose a vaild hand list of card
     * @return valid hand card list, Hand type
     */
    public static Hand composeHand(CardGamePlayer player, CardList cards){

    }

    

}
