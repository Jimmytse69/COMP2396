import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class BigTwoGUI implements CardGameUI{

    //private instance variables:
    private BigTwo game;
    private boolean[] selected = new boolean[13]; 
    private int activePlayer;
    private JFrame frame;
    private JPanel bigTwoPanel;
    private JButton playerButton;
    private JButton passButton;
    private JTextArea msgArea;
    //this include chatArea and input
    private ChatBox chat;

    /**
     * public constructor for creating a BigTwoGUI. The param is reference to a Big Two card game asscoiates with it
     * @param game
     */
    public BigTwoGUI (BigTwo game){
        this.game = game;
        
        frame = frameInit();

        chat = chatInit();
        
        frame.setLayout(new BorderLayout());
        frame.add(chat, BorderLayout.EAST);
        


        //bigTwoPanel = big2Init();
        //frame.add(bigTwoPanel);
        //this is the real show!!!, only this .setVisible will update the frame
        frame.setVisible(true);
        

        
        
        
        
    }

    //init of frame obj
    static private JFrame frameInit(){
        JFrame frame = new JFrame();
        frame.setTitle("Big2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(900, 900);    //fixed size of 900*900
        

        
        
        ImageIcon image = new ImageIcon("image/icon/icon.png");
        frame.setIconImage(image.getImage());

        

        return frame;
    }

    //inti of chat box
    static private ChatBox chatInit(){
        ChatBox chat = new ChatBox();
        chat.setLayout(new BorderLayout (1, 1));
        return chat;
    }

    //inti of Big2Panel
    static private JPanel big2Init(){
        JPanel big2 = new BigTwoPanel();
        big2.setLayout(new BoxLayout(big2, BoxLayout.Y_AXIS));
        return big2;
    }


    /**
     * a method for setting the index of the active player (i.e. who have the control of GUI)
     * @Override
     * @param activePlayer (int)
     */
    public void setActivePlayer(int activePlayer) {
        if (activePlayer < 0 || activePlayer >= game.getPlayerList().size()) {
			this.activePlayer = -1;
		} else {
			this.activePlayer = activePlayer;
		}
    }

    /**
     * a method fro repainting the GUI
     * @Override
     */
    
    public void repaint() {
        
    }

    /**
     * a method for printint the specified string to the message area of the GUI
     * @param msg (String)
     * @Override
     */
    public void printMsg(String msg) {
    }

    /**
     * a method for clearing the message area of the GUI
     * @Override
     */
    public void clearMsgArea() {
    }

    /**
     * a method the for resetting the GUI.
     * (i)   reset list of selected cards
     * (ii)  clear msg area
     * (iii) enable user interactions
     * @Override
     */
    public void reset() {
    }

    /**
     * a method for enabling user interactions with the GUI.
     * (i)   enable play button and pass button
     * (ii)  enable the chat input
     * (iii) enable the BigTwoPanel for select cards by mouse click
     * @Override
     */
    public void enable() {
    }

    /**
     * a method for disabling user interactions with GUI
     * (i)   disable the play button and pass button
     * (ii)  disable the chat input
     * (iii) disable the BigTwoPanel for select cards by mouse click
     * @Override
     */
    public void disable() {
    }

    /**
     * a method for prompting the active player to select cards and make move.
     * a message should be displayed in the msg area showing it is his/her turn
     */
    public void promptActivePlayer() {
        printMsg(game.getPlayerList().get(activePlayer).getName() + "'s turn: ");
		//int[] cardIdx = getSelected();
		//resetSelected();
		//game.makeMove(activePlayer, cardIdx);
    }

    //inner class
    static class BigTwoPanel extends JPanel{
        private JPanel bigTwoPanel = new JPanel();
        private Image[] avater = new Image[4];
        

        public BigTwoPanel(){
            //add image: https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
            for (int i = 0; i < avater.length; ++i){
                BufferedImage myPicture = null;
                try{
                    myPicture = ImageIO.read(new File("image/avater/a1.gif"));
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                add(picLabel);
                bigTwoPanel.add(picLabel);
            }
        }

    }

    class PlayButtonListener{

    }

    class PassButtonListener{

    }
    
    class RestartMenuItemListener{

    }

    class QuitMenuItemListener{

    }

    //ref https://stackoverflow.com/questions/9560600/java-no-enclosing-instance-of-type-foo-is-accessible/9560660
    static class ChatBox extends JPanel{
        private JTextArea chatArea;
        private JTextField chatInput;
        private static final int CHAT_COL = 50;

        public ChatBox(){
            chatArea = new JTextArea("Welcome to Chat Room", 10, CHAT_COL);
            chatInput = new JTextField(CHAT_COL);
            chatArea.setEditable(false);
            add(chatArea);
            add(chatInput);
        }

        public JTextField getChatInput(){
            return this.chatInput;
        }
        public JTextArea getChatArea(){
            return this.chatArea;
        }
        
    }
    
}

