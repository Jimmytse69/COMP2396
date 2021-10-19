import java.util.*;

/**
 * This BigTwo class is used to model a Big Two card game, the instance variables and methods detail are shown below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * @date 19/10/2021 (starting v1.0)
 */

public class BigTwo {
    /** Construstor for creating a Big Two card game. There are 2 procedures:
     * (i) : create 4 players and add them to player list
     * (ii): create a BigTwoUI object for user interface.
     */
    BigTwo(){}


    /** private attributes to specifying the number of players, should be 4 in a normal game */
    private int numOfPlayers;

    /** private attributes to store the deck of cards of the game */
    private Deck deck;

    /** private attributes to record the list of players */
    private ArrayList<CardGamePlayer> playerList;

    /** private attributes to record the list of hands played on Table */
    private ArrayList<Hand> handsOnTable;

    /** private attributes to specifying the index of current player */
    private int currentPlayerIdx;

    /** private UI object for providing User Interface in a normal Big Two game */
    private BigTwoUI ui;


    /** public getter of number of player (private attributes) */
    public int getNumOfPlayers(){}

    

}
