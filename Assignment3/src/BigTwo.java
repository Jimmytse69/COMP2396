import java.util.*;

/**
 * This BigTwo class is used to model a Big Two card game, the instance variables and methods detail are shown below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.1
 * @date 19/10/2021 (starting v1.0); 5/11/2021 (starting v1.1)
 * v1.0: NullPointerException, instance var didn't initialize coursing it.
 * v1.1: fixing by redo checkmove(), but seems there are minor bug still.
 */

public class BigTwo implements CardGame{
    /**Construstor for creating a Big Two card game. There are 2 procedures:
     * (i) : create 4 players and add them to player list
     * (ii): create a BigTwoUI object for user interface.
     */
    BigTwo(){
        CardGamePlayer p1 = new CardGamePlayer("Player 0");
        CardGamePlayer p2 = new CardGamePlayer("Player 1");
        CardGamePlayer p3 = new CardGamePlayer("Player 2");
        CardGamePlayer p4 = new CardGamePlayer("Player 3");
        this.playerList = new ArrayList<CardGamePlayer>(List.of(p1, p2, p3, p4));
        //end of (i)

        BigTwoUI Big2UI = new BigTwoUI(this);        //idk what i am doing, is UI obj in BigTwoUI to construct need BigTwo type object named game? (update): resolved by forum
        this.ui = Big2UI;
    }

    private int numOfPlayers = 4;

    private Deck deck = new Deck();

    private ArrayList<CardGamePlayer> playerList = new ArrayList<CardGamePlayer>();

    private ArrayList<Hand> handsOnTable = new ArrayList<Hand>();

    private int currentPlayerIdx = 0;

    private BigTwoUI ui = new BigTwoUI(this);


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
        //step (i)
        for (int i = 0; i < this.getNumOfPlayers(); ++i){
            this.getPlayerList().get(i).removeAllCards();   //remove all cards from players
        }
        this.handsOnTable.clear();    //remove all cards from table by create a new empty ArrayList of Hand and overwrite it

        //step (ii)
        deck.shuffle(); //shuffle the ordered deck
        for (int j = 0; j < deck.size(); ++j){
            if (j < deck.size()/4){     //card #0-12(shuffled), distribute to p1
                this.getPlayerList().get(0).addCard(deck.getCard(j));   
            }
            else if (j < deck.size()*2/4){   //card #13-25, distribute to p2
                this.getPlayerList().get(1).addCard(deck.getCard(j));
            }
            else if (j < deck.size()*3/4){  //card #26-38
                this.getPlayerList().get(2).addCard(deck.getCard(j));
            }
            else{
                this.getPlayerList().get(3).addCard(deck.getCard(j));
            }
        }

        //extra step by me (because assumed player's cardList is sorted)
        this.getPlayerList().get(0).sortCardsInHand();
        this.getPlayerList().get(1).sortCardsInHand();
        this.getPlayerList().get(2).sortCardsInHand();
        this.getPlayerList().get(3).sortCardsInHand();

        //step (iii)&(iv)
        for (int i = 0; i < this.numOfPlayers; ++i){
            for (int j = 0; j < deck.size()/4; ++j){
                if (this.getPlayerList().get(i).getCardsInHand().getCard(j).getRank() == 2  &&
                    this.getPlayerList().get(i).getCardsInHand().getCard(j).getSuit() == 0){    //(0,2) = diamond 3
                        this.currentPlayerIdx = i;  //current player = who holding diamond 3
                        this.ui.setActivePlayer(i); //ui obj in this class's private attribute ActivePlayer = who holding diamond 3
                }
            }
        }

        //step (v)
        this.ui.repaint();

        //step (vi)
        this.ui.promptActivePlayer();


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

    private int resetCounter = 0;  //reset state if the player plays a hand and passed by others 3 players (need to player abriary valid hand)
    /**public method for checking a move made by player. Supposed to called from makeMove() method. */
    public void checkMove(int playerIdx, int[] cardIdx){
        boolean validHand = false;
        
        String handType = "NULL";
        int handTypeIdx = -1;

        if (this.endOfGame() == true){      //check end game
            System.out.println("Game ends");
            System.out.println("Player 0 has " + playerList.get(0).getNumOfCards() + " cards in hand.");
            System.out.println("Player 1 has " + playerList.get(1).getNumOfCards() + " cards in hand.");
            System.out.println("Player 2 has " + playerList.get(2).getNumOfCards() + " cards in hand.");
            System.out.println("Player 3 has " + playerList.get(3).getNumOfCards() + " cards in hand.");
            System.exit(0);     //exit the game
        }
        
        if (cardIdx == null){       //if this is null, implies player passed (space, enter), resetCounter = 3 means it cannot be pass
            if (resetCounter < 3){
                System.out.println("{Pass}");
                currentPlayerIdx = (playerIdx + 1) % 4;
                resetCounter += 1;
            }
        }
        else{
            CardList possibleCardList = new CardList();     //all card that player played
            for (int i = 0; i < cardIdx.length; ++i){
                possibleCardList.addCard(playerList.get(playerIdx).getCardsInHand().getCard(cardIdx[i]));
            }

            //i think these code should use ComposeHand instaead in v1.1
            Single pS = new Single(playerList.get(playerIdx), possibleCardList);
            Pair pP = new Pair(playerList.get(playerIdx), possibleCardList);
            Triple pT = new Triple(playerList.get(playerIdx), possibleCardList);
            Straight pSt = new Straight(playerList.get(playerIdx), possibleCardList);
            Flush pF = new Flush(playerList.get(playerIdx), possibleCardList);
            FullHouse pFH = new FullHouse(playerList.get(playerIdx), possibleCardList);
            Quad pQ = new Quad(playerList.get(playerIdx), possibleCardList);
            StraightFlush pSF = new StraightFlush(playerList.get(playerIdx), possibleCardList);
            ArrayList<Hand> hands = new ArrayList<Hand>(List.of(pS, pP, pT, pSt, pF, pFH, pQ, pSF));
            for (int i = 0; i < hands.size(); ++i){
                if (hands.get(i).isValid()){
                    handType = hands.get(i).getType();
                    handTypeIdx = i;
                    System.out.println(handType);

                }
            }
            
            if (handType != "NULL"){        //is a Valid hand
                if (handsOnTable.size() == 0){
                    if (possibleCardList.contains(new BigTwoCard(0, 2))){     //contain diamond 3
                        validHand = true;
                    }
                }
                else{   //not fist move
                    if (hands.get(handTypeIdx).beats(handsOnTable.get(handsOnTable.size() - 1))){       //beats Top hands in handsOnTable
                        validHand = true;
                    }   
                }
                
                if (resetCounter == 3){
                    resetCounter = 0;
                    validHand = true;       //back to origin player who play a hand makes other 3 passed
                }
            }


            if (validHand){   
                currentPlayerIdx = (playerIdx + 1) % 4;
                handsOnTable.add(hands.get(handTypeIdx));   //add this Valid hand to table
                playerList.get(playerIdx).removeCards(possibleCardList);
                
            }
            else{
                System.out.println("Not a legal move!!!");
                currentPlayerIdx = playerIdx;   //prompt this user again until valid move
            }
        }
        ui.setActivePlayer(currentPlayerIdx);
        ui.repaint();
        ui.promptActivePlayer();
    }

    /**public method for checking if the game ends. */  
    public boolean endOfGame(){
        for (int i = 0; i < 4; ++i){
            if (playerList.get(i).getNumOfCards() == 0){
                return true;
            }
        }
        return false;
    }

    /**public static Main method to start a Big Two card game. It should
     * (i)  : create a Big Two card game
     * (ii) : create and shuffle a deck of cards
     * (iii): start the game with deck of cards
     */
    public static void main(String[] args){
        BigTwo game = new BigTwo();

        BigTwoDeck deck = new BigTwoDeck();
        deck.initialize();
        deck.shuffle();
        
        game.start(deck);
    }

    /**public static method returning a valid hand from that player (with his current list of cards)
     * return null if cannot compose a vaild hand list of card
     * @return valid hand card list, Hand type
     */
    public static Hand composeHand(CardGamePlayer player, CardList cards){  //not quite sure what i am doing in v1.0
        StraightFlush isStraightFlush = new StraightFlush(player, cards);
        Quad isQuad = new Quad(player, cards);
        FullHouse isFullHouse = new FullHouse(player, cards);
        Flush isFlush = new Flush(player, cards);
        Straight isStraight = new Straight(player, cards);
        Triple isTriple = new Triple(player, cards);
        Pair isPair = new Pair(player, cards);
        Single isSingle = new Single(player, cards);

        if (isStraightFlush.isValid()){
            return isStraightFlush;
        }
        else if (isQuad.isValid()){
            return isQuad;
        }
        else if (isFullHouse.isValid()){
            return isFullHouse;
        }
        else if (isFlush.isValid()){
            return isFlush;
        }
        else if (isStraight.isValid()){
            return isStraight;
        }
        else if (isTriple.isValid()){
            return isTriple;
        }
        else if (isPair.isValid()){
            return isPair;
        }
        else if (isSingle.isValid()){
            return isSingle;
        }
        else{
            return null;
        }


    }

    

}
