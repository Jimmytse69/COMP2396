/**
 * This is a class that implement Client side of Big Two Game 
 * @author Tse Chung Wan, 3035689324
 * @version 1.0 26/11/2021, 1.1 30/11/2021 (redo)
 */

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class BigTwoClient implements NetworkGame {

    /**
     * public constructor for this class
     * @param game
     * @param gui
     */
    public BigTwoClient(BigTwo game, BigTwoGUI gui){
        this.game = game;
        this.gui = gui;

        this.playerName = JOptionPane.showInputDialog("Please input your name");

        this.setServerIP("127.0.0.1");
        this.setServerPort(2396);
        this.connect();
        this.gui.clearMsgArea();
        
    }

    //private instance variables
    private BigTwo game;
    private BigTwoGUI gui;
    private Socket sock;
    private ObjectOutputStream oos;
    private int playerID;
    private String playerName;
    private String serverIP;
    private int serverPort; 


    /**
     * public getter of playerID (index) of the local player.
     * @return player ID (int)
     */
    @Override
    public int getPlayerID() {
        return this.playerID;
    }

    /**
     * public setter of player ID (index) of local player, 
     * should called from parseMessage() when server received message type PLAYER_LIST.
     * @param playerID
     */
    @Override
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    /**
     * public getter of player name of the local player.
     * @return player name (String)
     */
    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * public setter of player name of local player.
     * @param playerName
     */
    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * public getter of IP address of the game server.
     * @return serverIP (String)
     */
    @Override
    public String getServerIP() {
        return this.serverIP;
    }

    /**
     * public setter of IP address of the game server.
     * @param serverIP
     */
    @Override
    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    /**
     * public getter of TCP port of the game server.
     * @return serverPort (int)
     */
    @Override
    public int getServerPort() {
        return this.serverPort;
    }

    /**
     * public setter of TCP Port of the game server.
     * @param serverPort
     */
    @Override
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * a public method for making a socket connection with the game server.
     * (i)  create an ObjectOutputStream for sending message to the game server.
     * (ii) create a new thread for receiving messages from the game server.
     */
    @Override
    public void connect() {
        try{
            //(i)
            sock = new Socket(getServerIP(), getServerPort());
            //chaining
            oos = new ObjectOutputStream(sock.getOutputStream());

            //(ii)
            Thread t = new Thread(new ServerHandler());
            t.start();




        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Explosion");
        }
        
    }

    /**
     * a public method for parsing the messages received from the game server.
     * This method should be called from the thread responsible for receiving message from the server.
     * Based on the message type, different actions will be carried out
     * @param message
     */
    @Override
    public void parseMessage(GameMessage message) {

        // parses the message based on it type
		switch (message.getType()) {
            case CardGameMessage.PLAYER_LIST:
                this.setPlayerID(message.getPlayerID());
                this.game.getPlayerList().get(playerID).setName(this.getPlayerName());
                String[] names = (String[])message.getData();
                for (int i = 0; i < names.length; ++i){
                    if (i != this.playerID){
                        if (names[i] != null){
                            game.getPlayerList().get(i).setName(names[i]);
                        }
                        else{
                            //not exist player
                            game.getPlayerList().get(i).setName("Dummy");
                        }
                    }
                }
                gui.repaint();
                try{
                    sendMessage(new CardGameMessage(CardGameMessage.JOIN, -1, this.playerName));
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Explosion in JOIN");
                }
                break;
            case CardGameMessage.JOIN:
                if (this.playerID == message.getPlayerID()){
                    try{
                        sendMessage(new CardGameMessage(CardGameMessage.READY, -1, null));
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                        System.out.println("Explosion in READY");
                    }
                }
                else{
                    game.getPlayerList().get(message.getPlayerID()).setName((String) message.getData());
                }
                gui.repaint();
                break;
            case CardGameMessage.FULL:
                gui.printMsg("Server is full");
                gui.repaint();
                //disconnected?
                break;
            case CardGameMessage.QUIT:
                if (game.getGameStarted()){
                    //"Stop" the game
                    gui.disableButtons();
                    sendMessage(new CardGameMessage(CardGameMessage.READY, -1, null));
                }
                game.getPlayerList().get(message.getPlayerID()).setName("");
                gui.printMsg((String) message.getData() + " has leaved");
                gui.repaint();
                break;
            case CardGameMessage.READY:
                gui.printMsg("player ID: " + message.getPlayerID() + " ready\n");
                gui.repaint();
                break;
            case CardGameMessage.START:
                //start the game with server created deck
                this.game.start((Deck) message.getData());
                gui.enable();
                game.setGameStarted(true);
                gui.repaint();
                break;
            case CardGameMessage.MOVE:
                game.checkMove(message.getPlayerID(), (int[])message.getData());
                gui.repaint();
                break;
            case CardGameMessage.MSG:
                gui.getChatArea().append((String) message.getData() + "\n");
                gui.repaint();
                break;
            default:
                System.out.println("Wrong message type: " + message.getType());
                // invalid message
                gui.repaint();
                break;
            }
            
    }

    /**
     * a public method for sending the specified message to the game server.
     * This method should be called whenever the client wants to communicate with the game server or other clients.
     * @param message
     */
    @Override
    public void sendMessage(GameMessage message) {
        switch (message.getType()) {
            case CardGameMessage.JOIN:
            try{
                oos.writeObject(message);
            }
            catch (Exception ex){
                System.out.println("Error in JOIN");
                ex.printStackTrace();
            }
                break;

            case CardGameMessage.READY:
                try{
                    oos.writeObject(message);
                }
                catch (Exception ex){
                    System.out.println("Error in READY");
                    ex.printStackTrace();
                }
                
                break;

            case CardGameMessage.MOVE:
                try{
                    oos.writeObject(message);
                }
                catch (Exception ex){
                    System.out.println("Error in MOVE");
                    ex.printStackTrace();
                }
                
                break;

            case CardGameMessage.MSG:
                try{
                    oos.writeObject(message);
                }
                catch (Exception ex){
                    System.out.println("Error in MSG");
                    ex.printStackTrace();
                }
                
                break;

            default:
                System.out.println("Invalid message");
                // invalid message
                break;
            }
        
    }

    /**
     * a public inner class to handle server message
     */
    public class ServerHandler implements Runnable {

        /**
         * runnable interface override method, run the new thread
         */
        @Override
        public void run() {
            CardGameMessage message;
            //reader message from server
            ObjectInputStream reader;
            try{
                reader = new ObjectInputStream(sock.getInputStream());
                // reads incoming messages from the server
                while ((message = (CardGameMessage)reader.readObject()) != null) {
                    parseMessage(message);
                    //System.out.println("read " + message);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        
    }

    /** self added public method to print dialog box in game end */
    public void endGameMessage(){
        JOptionPane.showMessageDialog(null, "Game End, playerID: " + game.getCurrentPlayerIdx() + " win.");
    }

    /** self added public method to restart the game (call server) when game end */
    public void restart() {
        sendMessage(new CardGameMessage(CardGameMessage.READY, -1, null));
    }
    
    
}
