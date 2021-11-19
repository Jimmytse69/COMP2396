import javax.swing.*;

public class BigTwoGUI implements CardGameUI{

    /**
     * public constructor for creating a BigTwoGUI. The param is reference to a Big Two card game asscoiates with it
     * @param game
     */
    public BigTwoGUI (BigTwo game){
        frame.add(bigTwoPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    //private instance variables:
    private BigTwo game = new BigTwo();
    private boolean[] selected = new boolean[13];
    private int activePlayer = 0;
    private JFrame frame = new JFrame();
    private JPanel bigTwoPanel = new JPanel();
    private JButton playerButton = new JButton();
    private JButton passButton = new JButton();
    private JTextArea msgArea = new JTextArea();
    private JTextArea chatArea = new JTextArea();
    private JTextField chatInput = new JTextField();


    /**
     * a method for setting the index of the active player (i.e. who have the control of GUI)
     * @Override
     * @param activePlayer (int)
     */
    public void setActivePlayer(int activePlayer) {
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
    }

    //inner class
    class BigTwoPanel{

    }

    class PlayButtonListener{

    }

    class PassButtonListener{

    }
    
    class RestartMenuItemListener{

    }

    class QuitMenuItemListener{

    }
    
}
