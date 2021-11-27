import java.net.*;
import java.io.*;
import javax.swing.*;

/**
 * This is a class that implement Client side of Big Two Game 
 * @author Tse Chung Wan, 3035689324
 * @version 1.0 26/11/2021
 */

public class BigTwoClient implements NetworkGame{
    /**
     * public constructor for this class
     * @param game
     * @param gui
     */
    BigTwoClient(BigTwo game, BigTwoGUI gui){
        this.game = game;
        this.gui = gui;

        String inputName = JOptionPane.showInputDialog("Please input your name to login to server");
        this.setPlayerName(inputName);
        //not sure how to get playeridx from server now, (PLAYER_LIST)?
        this.setPlayerID(game.getCurrentPlayerIdx());

        //hard coding IP and port
        this.setServerIP("127.0.0.1");
        this.setServerPort(2396);
        this.connect();

        //disable the gui operation until all player ready
        gui.disable();
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
        return playerID;
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
        return playerName;
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
        return serverIP;
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
        return serverPort;
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
     * (ii) create a new thread for receiving messages from the gane server.
     */
    @Override
    public void connect() {
        //setup network connection
        try{
            //(i)
            sock = new Socket(getServerIP(), getServerPort());
            System.out.println("networking established");
            // chaining from socket output stream to oos
            oos = new ObjectOutputStream(sock.getOutputStream());

            //(ii)
            Thread receive = new Thread(new ServerHandler());
            //start the thread and starting to receive msg from server
            receive.start();
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
        if (message.getType() == CardGameMessage.PLAYER_LIST){
            this.playerID = message.getPlayerID();
            //set active player to make it can controll his own panel
            gui.setActivePlayer(playerID);
            String[] names = new String[4];
            names = (String[])message.getData();
            for (int i = 0; i < names.length; ++i){
                //if not null, add to PlayerNamelist to gui
                if (names[i] != null){
                    this.game.getPlayerList().get(i).setName(names[i]);
                }
            }
            sendMessage(new CardGameMessage(CardGameMessage.JOIN, -1, (Object) this.getPlayerName()));
            gui.repaint();

        }
        else if (message.getType() == CardGameMessage.JOIN){
            gui.printMsg((String)message.getData() + "(id: " + message.getPlayerID() + ")" + "has join the game\n");
            if (message.getPlayerID() == this.getPlayerID()){
                sendMessage(new CardGameMessage(CardGameMessage.READY, -1, null));
            }
            gui.repaint();


        }
        else if (message.getType() == CardGameMessage.FULL){
            gui.printMsg("server is full\n");
            gui.repaint();
            try{
                sock.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            
        }
        else if (message.getType() == CardGameMessage.QUIT){
            gui.printMsg((String)message.getData() + "(id: " + message.getPlayerID() + ")" + "has quit the game\n");
            game.getPlayerList().get(message.getPlayerID()).setName("");
            //no idea how to stop the game now
            sendMessage(new CardGameMessage(CardGameMessage.READY, -1, null));
            gui.repaint();

        }
        else if (message.getType() == CardGameMessage.READY){
            gui.printMsg("id: " + message.getPlayerID() + "ready\n");
            gui.repaint();

        }
        else if (message.getType() == CardGameMessage.START){
            //created and shuffed BigTwoDeck
            Deck d = (BigTwoDeck) message.getData();
            game.start(d);
            gui.enable();
            gui.repaint();
        }
        else if (message.getType() == CardGameMessage.MOVE){
            gui.printMsg("id: " + message.getPlayerID() + "make a move\n");
            gui.repaint();
        }
        else if (message.getType() == CardGameMessage.MSG){
            gui.printMsg("(id:" + message.getPlayerID() + ") " + (String)message.getData());
            gui.repaint();
        }
        else{
            System.out.println("not a valid message");
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
                oos.writeObject((Object) message);
            }
            catch (Exception ex){
                System.out.println("Wrong in JOIN");
                ex.printStackTrace();
            }
                break;

            case CardGameMessage.READY:
                try{
                    oos.writeObject((Object) message);
                }
                catch (Exception ex){
                    System.out.println("Wrong in READY");
                    ex.printStackTrace();
                }
                
                break;

            case CardGameMessage.MOVE:
                try{
                    oos.writeObject((Object) message);
                }
                catch (Exception ex){
                    System.out.println("Wrong in MOVE");
                    ex.printStackTrace();
                }
                
                break;

            case CardGameMessage.MSG:
                try{
                    oos.writeObject((Object) message);
                }
                catch (Exception ex){
                    System.out.println("Wrong in MSG");
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
        
        @Override
        public void run() {
            CardGameMessage message;
            //reader message from server
            ObjectInputStream reader;
            try{
                reader = new ObjectInputStream(sock.getInputStream());
                // reads incoming messages from the server
                while ((message = (CardGameMessage)reader.readObject()) != null) {
                    System.out.println("read " + message);
                    // appends the incoming message to the text area
                    gui.printMsg(message + "\n");
                } // close while
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
    }

}
