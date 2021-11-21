import java.util.*;

/**
 * This BigTwo class is used to model a Big Two card game, the instance variables and methods detail are shown below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.3
 * @date 19/10/2021 (starting v1.0); 5/11/2021 (starting v1.1); 6/11/2021 (starting v1.2); 11/11/2021 ("refactored" for Assignment 4&5); 21/11/2021 (update for Assignment 4)
 * v1.0: NullPointerException, instance var didn't initialize coursing it.
 * v1.1: fixing by redo checkmove(), resetCounter(pass) minor bug fix
 * (minor bug unfix: player with diamond 3 cannot pass in first turn)
 * (update: that minor bug fixed after redo or refactoring)
 */

class BigTwo {

    private static final String[] SUITS = { "\u2666", "\u2663", "\u2665", "\u2660" }; // {Diamond, Club, Heart, Spade}
	private static final String[] RANKS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K" };


    /**Construstor for creating a Big Two card game. There are 2 procedures:
     * (i) : create 4 players and add them to player list
     * (ii): create a BigTwoUI object for user interface.
     */
    BigTwo(){
        //(i)
        playerList.add(new CardGamePlayer("Player0"));
        playerList.add(new CardGamePlayer("Player1"));
        playerList.add(new CardGamePlayer("Player2"));
        playerList.add(new CardGamePlayer("Player3"));
        //(ii) is done in initiallize private instance var. process
        this.gui = new BigTwoGUI(this);
    }

    //private instance vairbles
    private int numOfPlayers = 4;
    private Deck deck = new Deck();
    private ArrayList<CardGamePlayer> playerList = new ArrayList<CardGamePlayer>();
    private ArrayList<Hand> handsOnTable = new ArrayList<Hand>();
    private int currentPlayerIdx = 0;
    private BigTwoGUI gui;

    /**public getter of number of player (private attributes) 
     * @return numOfPlayers, int type
    */
    public int getNumOfPlayers(){return numOfPlayers;}

    /**public getter of deck of cards being used 
     * @return deck, Deck type
    */
    public Deck getDeck(){return deck;}

    /**public getter of list of players 
     * @return playerList, ArrayList<CardGamePlayer> type
    */
    public ArrayList<CardGamePlayer> getPlayerList(){return playerList;}

    /**public getter of list of hands played on table 
     * @return handsOnTable, ArrayList<Hand> type
    */
    public ArrayList<Hand> getHandsOnTable(){return handsOnTable;}

    /**public getter of index of current player 
     * @return currentPlayerIdx, int type
    */  
    public int getCurrentPlayerIdx(){return currentPlayerIdx;}

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
        //(i)
        for (int i = 0; i < numOfPlayers; ++i){
            playerList.get(i).getCardsInHand().removeAllCards();
        }
        handsOnTable.clear();

        //(ii)
        for (int i = 0; i < deck.size(); ++i){
            if (i < deck.size()/4){
                playerList.get(0).addCard(deck.getCard(i));
            }
            else if (i < deck.size()*2/4){
                playerList.get(1).addCard(deck.getCard(i));
            }
            else if (i < deck.size()*3/4){
                playerList.get(2).addCard(deck.getCard(i));
            }
            else{
                playerList.get(3).addCard(deck.getCard(i));
            }
        }
        for (int j = 0; j < numOfPlayers; ++j){
            playerList.get(j).sortCardsInHand();
        }

        //(iii, iv)
        for (int i = 0; i < numOfPlayers; ++i){
            if (playerList.get(i).getCardsInHand().contains(new Card(0, 2))){
                    currentPlayerIdx = i;
                    gui.setActivePlayer(i);
            }
        }

        

        //(v)
        gui.repaint();

        //(vi)
        gui.promptActivePlayer();
    }

    /**public method for makeing a move by player 
     * This is supposed to be called by BigTwo(G)UI after active player have select cards to make move.
     * just called the checkMove() method and passing all param for now
     * @param playerIdx, int type
     * @param cardIdx, int[] type
    */
    void makeMove(int playerIdx, int[] cardIdx){
        checkMove(playerIdx, cardIdx);
    }

    /**public method for checking a move made by player. Supposed to called from makeMove() method. */
    void checkMove(int playerIdx, int[] cardIdx){
            boolean valid = false;
            if (cardIdx == null){   //you intended to pass
                if (handsOnTable.size() == 0){  //can't skip in 1st round
                    System.out.println("Not a legal move!!!");
                    gui.printMsg("Not a legal move!!!\n");
                }
                else{
                    if (handsOnTable.get(handsOnTable.size() - 1).getPlayer() == playerList.get(playerIdx)){
                        //cannot pass bc you are the one who play the table hand
                        System.out.println("Not a legal move!!!");
                        gui.printMsg("Not a legal move!!!\n");
                    }
                    else{
                        System.out.println("{Pass}");
                        gui.printMsg("{Pass}\n");
                        currentPlayerIdx = (playerIdx + 1) % 4;     //it is looping 0-3, ++ 1
                        valid = true;
                    }
                }
            }
            else{   //you try to make some move
                CardList cards = new CardList();
                for (int i = 0; i < cardIdx.length; ++i){
                    //add all cardIdx of this player to cards to compose
                    cards.addCard(playerList.get(playerIdx).getCardsInHand().getCard(cardIdx[i]));     
                }
                Hand tryComposeHand = composeHand(playerList.get(playerIdx), cards);

                //so it is your first turn and try to play sth
                if (handsOnTable.size() == 0){
                    //if it contains diamond 3 and make a valid move, it must be a ok move
                    if (tryComposeHand != null && cards.contains(new Card(0, 2))){
                        handsOnTable.add(tryComposeHand);
                        playerList.get(playerIdx).removeCards(cards);
                        currentPlayerIdx = (playerIdx + 1) % 4;
                        System.out.print("{" + tryComposeHand.getType() + "} ");
                        tryComposeHand.print();
                        System.out.println();
                        valid = true;
                    }
                    else{
                        System.out.println("Not a legal move!!!");
                        gui.printMsg("Not a legal move!!!\n");
                    }
                }
                //so it is not first turn and you try to play sth; if logic: not a and not b
                else {
                    //when you make move, and the Top handsOnTable are also made by you, so you can freely choose your hand type
                    if (handsOnTable.get(handsOnTable.size() - 1).getPlayer() == playerList.get(playerIdx)){ 
                        if (tryComposeHand != null){
                            handsOnTable.add(tryComposeHand);
                            playerList.get(playerIdx).removeCards(cards);
                            currentPlayerIdx = (playerIdx + 1) % 4;
                            System.out.print("{" + tryComposeHand.getType() + "} ");
                            tryComposeHand.print();
                            System.out.println();
                            valid = true;
                        }
                        else{
                            System.out.println("Not a legal move!!!");
                            gui.printMsg("Not a legal move!!!\n");
                        }
                    }
                    //you need to follow the beat rule to beat Top handsOnTable
                    else{
                        if (tryComposeHand != null){
                            if (tryComposeHand.beats(handsOnTable.get(handsOnTable.size() - 1))){
                                handsOnTable.add(tryComposeHand);
                                playerList.get(playerIdx).removeCards(cards);
                                currentPlayerIdx = (playerIdx + 1) % 4;
                                System.out.print("{" + tryComposeHand.getType() + "} ");
                                tryComposeHand.print();
                                System.out.println();
                                valid = true;
                            }
                            else{
                                System.out.println("Not a legal move!!!");
                                gui.printMsg("Not a legal move!!!\n");
                            }
                        }
                        else{
                            System.out.println("Not a legal move!!!");
                            gui.printMsg("Not a legal move!!!\n");
                        }
                    }
                }
            }
        gui.setActivePlayer(currentPlayerIdx);
        if (!endOfGame()){
            if (valid){
                gui.repaint();
                //from BigTwoUI
                Hand lastHandOnTable = (handsOnTable.isEmpty()) ? null : handsOnTable.get(handsOnTable.size() - 1);
                if (lastHandOnTable != null && cardIdx != null) {
                    gui.printMsg("{" + lastHandOnTable.getType() + "} ");
                    for (int i = 0; i < lastHandOnTable.size(); ++i){
                        gui.printMsg("[" + SUITS[lastHandOnTable.getCard(i).getSuit()] + RANKS[lastHandOnTable.getCard(i).getRank()] + "]");
                    }
                    gui.printMsg("\n");
                    lastHandOnTable.print(true, false);
                }
            }
            gui.promptActivePlayer();
        }
    }

    /**public method for checking if the game ends. */  
    boolean endOfGame(){
        int winner = -1;    //check who win or no one win still
        for (int i = 0; i < numOfPlayers; ++i){
            if (playerList.get(i).getNumOfCards() == 0){
                winner = i;
            }
        }
        if (winner != -1){  //someone actually win and end the game

            
            
            for (int i = 0; i < 4; ++i){
                System.out.println("<" + playerList.get(i).getName() + ">");
                System.out.print("    ");
				playerList.get(i).getCardsInHand().print(true, true);
            }
            System.out.println("<Table>");
            Hand lastHandOnTable = (handsOnTable.isEmpty()) ? null : handsOnTable.get(handsOnTable.size() - 1);
            if (lastHandOnTable != null) {
                System.out
                        .print("    <" + lastHandOnTable.getPlayer().getName() + "> {" + lastHandOnTable.getType() + "} ");
                lastHandOnTable.print(true, false);
            } else {
                System.out.println("  [Empty]");
            }
            System.out.println();

            System.out.println("Game ends");
            for (int i = 0; i < numOfPlayers; ++i){
                if (winner != i){
                    System.out.println("Player " + i + " has " + playerList.get(i).getNumOfCards() + " cards in hand.");
                }
                else{
                    System.out.println("Player " + winner + " wins the game.");
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    /**public static Main method to start a Big Two card game. It should
     * (i)  : create a Big Two card game
     * (ii) : create and shuffle a deck of cards
     * (iii): start the game with deck of cards
     */
    public static void main(String[] args){
        //(i)
        BigTwo game = new BigTwo();

        //(ii)
        
        BigTwoDeck deck = new BigTwoDeck();
        deck.shuffle();
        

        //(iii)
        game.start(deck);
        

    }
    

    /**public static method returning a valid hand from that player (with his current list of cards)
     * return null if cannot compose a vaild hand list of card
     * @return valid hand card list, Hand type
     */
    public static Hand composeHand(CardGamePlayer player, CardList cards){
        ArrayList<Hand> possibleHand = new ArrayList<Hand>();
        //add those possible hand if it is valid class of it, else add null
        possibleHand.add(new Single(player, cards).isValid() ? new Single(player, cards) : null);
        possibleHand.add(new Pair(player, cards).isValid() ? new Pair(player, cards) : null);
        possibleHand.add(new Triple(player, cards).isValid() ? new Triple(player, cards) : null);
        possibleHand.add(new Straight(player, cards).isValid() ? new Straight(player, cards) : null);
        possibleHand.add(new Flush(player, cards).isValid() ? new Flush(player, cards) : null);
        possibleHand.add(new FullHouse(player, cards).isValid() ? new FullHouse(player, cards) : null);
        possibleHand.add(new Quad(player, cards).isValid() ? new Quad(player, cards) : null);
        possibleHand.add(new StraightFlush(player, cards).isValid() ? new StraightFlush(player, cards) : null);

        //the larger i the "power" is larger, you don't want StraightFlush treat as Straight
        for (int i = possibleHand.size() - 1; i >= 0; --i){
            if (possibleHand.get(i) != null){
                return possibleHand.get(i);
            }
        }
        return null;
    }
}