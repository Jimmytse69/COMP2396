/**
 * This is GUI class for Big2 Game
 * @author Tse Chung Wan, 3035689324
 * @version 1.1, 22/11/2021
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BigTwoGUI implements CardGameUI{

    //private instance variables:
    private BigTwo game;
    private boolean[] selected = new boolean[13]; 
    private int activePlayer;
    private JFrame frame;
    private JPanel bigTwoPanel;
    private JButton playButton;
    private JButton passButton;
    private JTextArea msgArea;
    private JTextField chatInput;
    private JTextArea chatArea;

    private JPanel msgPanel;
    private JPanel buttonPanel;

    /**
     * public constructor for creating a BigTwoGUI. The param is reference to a Big Two card game asscoiates with it
     * @param game
     */
    public BigTwoGUI (BigTwo game){
        this.game = game;
        frame = frameInit();
        setActivePlayer(game.getCurrentPlayerIdx());
    }

    //private for frame initization
    private JFrame frameInit() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Big2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setup Frame icon
        setIcon(frame);

        //setup Menu Bar
        setMenu(frame);

        //setup MsgPanel, includ msgArea, chatArea and Input
        setMsgPanel(frame);

        //setup Buttons
        setButtonPanel(frame);

        //setup BigTwoPanel
        setBigTwoPanel(frame);

        frame.setSize(960, 720);
        //frame.setResizable(false);
        frame.setVisible(true);

        return frame;
    }

    //set Frame icon
    private void setIcon(JFrame frame){
        ImageIcon image = new ImageIcon("image/icon/icon.png");
        frame.setIconImage(image.getImage());
    }

    //set Menu bar by passed a frame
    private void setMenu(JFrame frame){
        JMenuItem restart = new JMenuItem("Restart");
        new RestartMenuItemListener(restart);
        JMenuItem quit = new JMenuItem("Quit");
        new QuitMenuItemListener(quit);

        JMenu game = new JMenu("Game");

        game.add(restart);
        game.add(quit);

        JMenuItem clear = new JMenuItem("Clear");
        new ClearMsgItemListener(clear);

        JMenu msg = new JMenu("Message");
        msg.add(clear);

        JMenuBar m = new JMenuBar();
        m.add(game);
        m.add(msg);
        frame.setJMenuBar(m);
    }

    //initialize and setup Msg Panel
    private void setMsgPanel(JFrame frame) {
        msgPanelInit();
        frame.add(msgPanel, BorderLayout.EAST);
    }

    //setup buttonPanel to frame
    private void setButtonPanel(JFrame frame){
        buttonPanelInit();
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    //setup button widget to panel
    private void buttonPanelInit(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonPanel.setBackground(Color.GREEN);

        setButtons(buttonPanel);
    }

    //detail implementation of init a msg Panel
    private void msgPanelInit() {
        msgPanel = new JPanel();
        msgPanel.setLayout(new BoxLayout(msgPanel, BoxLayout.Y_AXIS));

        //setup msgArea;
        setMsg(msgPanel);

        //setup chatBox;
        setChat(msgPanel);
    }

    //set Msg TextArea by passing a msg panel
    private void setMsg(JPanel p){
        msgArea = new JTextArea(20, 25);
        //cope with text "Overflow" layout problem: https://stackoverflow.com/questions/22914775/how-to-set-jtextarea-to-fixed-size/22914880
        msgArea.setLineWrap(true);

        
        msgArea.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        msgArea.setEditable(false);
        msgArea.setBackground(Color.PINK);
        //msgArea.append("Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123Mic Testing 123");
        
        //no idea why still cannot autoscroll, ref: https://stackoverflow.com/questions/2483572/making-a-jscrollpane-automatically-scroll-all-the-way-down
        msgArea.setCaretPosition(msgArea.getDocument().getLength());
        JScrollPane sp = new JScrollPane(msgArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setAutoscrolls(true);

        p.add(sp);
    }

    //set Chat Area and Input by passing a msg panel
    private void setChat(JPanel p) {
        //Chat Area adding
        chatArea = new JTextArea("Welcome to Chat\n", 20, 25);
        chatArea.setLineWrap(true);


        chatArea.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        chatArea.setEditable(false);
        chatArea.setBackground(Color.CYAN);

        //no idea why still cannot autoscroll, ref: https://stackoverflow.com/questions/2483572/making-a-jscrollpane-automatically-scroll-all-the-way-down
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
        JScrollPane sp2 = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setAutoscrolls(true);
        
        p.add(sp2);

        //Chat Input adding
        chatInput = new JTextField("Send message here", 25);
        new ChatInputListener(chatInput);

        chatInput.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        chatInput.setEditable(true);
        chatInput.setBackground(Color.LIGHT_GRAY);

        
        
        p.add(chatInput);

    }

    private void setButtons(JPanel p) {
        playButton = new JButton("Play");
        passButton = new JButton("Pass");

        new PlayButtonListener(playButton);
        new PassButtonListener(passButton);

        p.add(playButton);
        p.add(passButton);
    }


    private void setBigTwoPanel(JFrame frame){
        bigTwoPanel = new BigTwoPanel();
        frame.add(bigTwoPanel, BorderLayout.CENTER);
    }

    


    /**
     * a method for setting the index of the active player (i.e. who have the control of GUI)
     * @Override
     * @param activePlayer (int)
     */
    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * a method fro repainting the GUI
     * @Override
     */
    
    public void repaint() {
        frame.repaint();
    }

    /**
     * a method for printint the specified string to the message area of the GUI
     * @param msg (String)
     * @Override
     */
    public void printMsg(String msg) {
        msgArea.append(msg);
    }

    /**
     * a method for clearing the message area of the GUI
     * @Override
     */
    public void clearMsgArea() {
        msgArea.setText(null);
    }

    /**
     * a method the for resetting the GUI.
     * (i)   reset list of selected cards
     * (ii)  clear msg area
     * (iii) enable user interactions
     * @Override
     */
    public void reset() {
        //(i)
        for (int i = 0; i < selected.length; ++i){
            selected[i] = false;
        }

        //(ii)
        clearMsgArea();

        //(iii)
        enable();
    }

    /**
     * a method for enabling user interactions with the GUI.
     * (i)   enable play button and pass button
     * (ii)  enable the chat input
     * (iii) enable the BigTwoPanel for select cards by mouse click
     * @Override
     */
    public void enable() {
        //(i)
        playButton.setEnabled(true);
        passButton.setEnabled(true);

        //(ii)
        chatInput.setEnabled(true);

        //(iii)
        bigTwoPanel.setEnabled(true);
    }

    /**
     * a method for disabling user interactions with GUI
     * (i)   disable the play button and pass button
     * (ii)  disable the chat input
     * (iii) disable the BigTwoPanel for select cards by mouse click
     * @Override
     */
    public void disable() {
        //(i)
        playButton.setEnabled(false);
        passButton.setEnabled(false);

        //(ii)
        chatInput.setEnabled(false);

        //(iii)
        bigTwoPanel.setEnabled(false);
    }

    /**
     * a method for prompting the active player to select cards and make move.
     * a message should be displayed in the msg area showing it is his/her turn
     */
    public void promptActivePlayer() {
        setActivePlayer(activePlayer);
        msgArea.append("Player " + activePlayer + "'s turn:" + "\n");
    }

    private class PlayButtonListener implements ActionListener{

        PlayButtonListener(JButton b){
            playButton.addActionListener(this);
        }

        @Override
        /**
         * player button action event handling
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            //System.out.println("I have been clicked");

            int[] cardSelected = getCardSelected();
            if (cardSelected != null){
                resetCardPosition();
                game.makeMove(activePlayer, cardSelected);
            }   
        }


        private void resetCardPosition() {
            for (int i = 0; i < selected.length; ++i){
                selected[i] = false;
            }
        }

        private int[] getCardSelected(){
            int[] cardSelected;
            int count = 0;
            for (int i = 0; i < selected.length; ++i) {
                if (selected[i] == true){
                    count += 1;
                }
            }
            if (count == 0){
                cardSelected = null;
            }
            else{
                cardSelected = new int[count];
                count = 0;
                for (int i = 0; i < selected.length; ++i) {
                    if (selected[i] == true){
                        //add that card idx
                        cardSelected[count] = i;
                        count += 1;
                    }
                }
            }
            return cardSelected;
        }

    }

    private class PassButtonListener implements ActionListener{
        
        
        PassButtonListener(JButton b){
            b.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Is me, Pass button");
            resetCardPosition();
            game.makeMove(activePlayer, null);
        }
        private void resetCardPosition() {
            for (int i = 0; i < selected.length; ++i){
                selected[i] = false;
            }
        }
        
    }

    private class ChatInputListener implements KeyListener{

        ChatInputListener(JTextField chatInput){
            chatInput.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                String msg = chatInput.getText();
                chatArea.append("Player " + activePlayer + ": " + msg + "\n");
                chatInput.setText("");
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

    }
    
    private class RestartMenuItemListener implements ActionListener{

        RestartMenuItemListener(JMenuItem jmi){
            jmi.addActionListener(this);
        }

        @Override
        /**
         * restart the game when this menuitem pressed
         * (i)  create a new BigTwoDeck obj and call shuffle
         * (ii) call the start() from game with (i) obj as arg
         * @param ActionEvent e
         */
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //(i)
            BigTwoDeck d = new BigTwoDeck();
            d.shuffle();

            //(ii)
            msgArea.append("Game Restarted!\n");
            game.start(d);
        }

    }

    private class QuitMenuItemListener implements ActionListener{

        QuitMenuItemListener(JMenuItem jmi){
            jmi.addActionListener(this);
        }

        @Override
        /**
         * terminate program
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.exit(0);
        }

    }

    //additional MenuItem Clear Msg
    private class ClearMsgItemListener implements ActionListener{

        ClearMsgItemListener(JMenuItem jmi){
            jmi.addActionListener(this);
        }

        @Override
        /**
         * clear system msg from msgArea
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            clearMsgArea();
        }
        
    }

    private class BigTwoPanel extends JPanel implements MouseListener{
        private final String[] SUITS = { "d", "c", "h", "s"}; // {Diamond, Club, Heart, Spade}
        private final String[] RANKS = { "a", "2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k"};
    
        private final int avaterWidth = 60;
        //not used now:
        //private final int avaterHeight = 60;
        private final int cardWidth = 73;
        private final int cardHeight = 97;

        private final Image avater = new ImageIcon("image/avater/a.png").getImage();
        //image array rep ranks then suit
        private final Image[][] cards = new Image[13][4];
        private final Image cardBack = new ImageIcon("image/cards/b.gif").getImage();
    
        BigTwoPanel() {
            this.setBackground(new Color(0x35654d));
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            //register MouseListener
            this.addMouseListener(this);
            
            this.setCards();
            
        }

        private void setCards() {
            for (int i = 0; i < RANKS.length; ++i){
                for (int j = 0; j < SUITS.length; ++j){
                        cards[i][j] = new ImageIcon("image/cards/" + RANKS[i] + SUITS[j] + ".gif").getImage();
                }
            }
        }

        /**
         * painting the screen of Table Panel
         * @param Graphics g
         */
        public void paintComponent(Graphics g){
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(new Color(0x35654d));
            //it cover whole table
            g2D.fillRect(0, 0, 2000, 2000);

            //draw avater
            for (int i = 0; i < game.getNumOfPlayers(); ++i){
                if (i == activePlayer){
                    g2D.setColor(Color.RED);
                }
                else{
                    g2D.setColor(Color.BLACK);
                }
                g2D.drawString("Player " + i, 10, 30 + (i*120));
                g2D.drawImage(avater, 10, 40 + (i*120), this);
            }
            g2D.setColor(Color.BLUE);
            g2D.drawString("Table", 10, 30 + (4 * 120));
            g2D.setColor(Color.BLACK);
            if (!game.getHandsOnTable().isEmpty()){
                g2D.drawString(game.getHandsOnTable().get(game.getHandsOnTable().size() - 1).getPlayer().getName(), 10, 30 + (4 * 120) + 20);
            }

            //draw cards
            for (int j = 0; j < game.getNumOfPlayers(); ++j){
                if (j == activePlayer){
                    for (int i = 0; i < game.getPlayerList().get(j).getNumOfCards(); ++i){
                        //each row of cards starts from 20, advanced by 40
                        //each column starts from 30, advanced by 120
                        //print card by searching that player's hand i'th card's rank and suit
                        int curRank = game.getPlayerList().get(j).getCardsInHand().getCard(i).getRank();
                        int curSuit = game.getPlayerList().get(j).getCardsInHand().getCard(i).getSuit();
                        if (selected[i] == true){
                            //move it higher if it is selected
                            g2D.drawImage(cards[curRank][curSuit], avaterWidth + 20 + (i*40), 30 + (j*120) - 15, this);
                        }
                        else{
                            g2D.drawImage(cards[curRank][curSuit], avaterWidth + 20 + (i*40), 30 + (j*120), this);
                        }
                        
                    }
                }
                else{
                    for (int i = 0; i < game.getPlayerList().get(j).getNumOfCards(); ++i){
                        //not active player, so print back side only
                        g2D.drawImage(cardBack, avaterWidth + 20 + (i*40), 30 + (j*120), this);
                    }
                }
                g2D.drawLine(0, 15+((j+1)*120), 1500, 15+((j+1)*120));
            }

            //draw Table
            if (!game.getHandsOnTable().isEmpty()){
                for (int i = 0; i < game.getHandsOnTable().get(game.getHandsOnTable().size() - 1).size(); ++i){
                    //Table curRank and Suit
                    int curRank = game.getHandsOnTable().get(game.getHandsOnTable().size() - 1).getCard(i).getRank();
                    int curSuit = game.getHandsOnTable().get(game.getHandsOnTable().size() - 1).getCard(i).getSuit();

                    g2D.drawImage(cards[curRank][curSuit], avaterWidth + 20 + (i * 40), 30 + (4*120), this);
                }
                super.repaint();
            }

            
        }

        @Override
        //ref: Moodle and https://stackoverflow.com/questions/12396066/how-to-get-location-of-a-mouse-click-relative-to-a-swing-window
        /**
         * Overriding method for MouseEvent handling of Selcet card
         * @param MouseEvent e
         */
        public void mouseClicked(MouseEvent e) {
            int x=e.getX();
            int y=e.getY();
            //check if it is clicking the "card"
            int heightOfCards = 30 + (activePlayer * 120);
            if (y > heightOfCards && y < heightOfCards + cardHeight){
                for (int i = 0; i < game.getPlayerList().get(activePlayer).getCardsInHand().size(); ++i){
                    //last card of an row, "wider" selectable
                    if (i == game.getPlayerList().get(activePlayer).getCardsInHand().size() - 1){
                        if (x > (avaterWidth + 20 + i * 40) && x < (avaterWidth +20 + i*40 + cardWidth)) {
                            if (selected[i] == true){
                                selected[i] = false;
                            }
                            else{
                                selected[i] = true;
                            }
                        }
                    }
                    else{
                        if (x > (avaterWidth + 20 + i*40) && x < (avaterWidth + 20 + i*40 + 40)){
                            //toggle the selected state if it is clicked
                            if (selected[i] == true){
                                selected[i] = false;
                            }
                            else{
                                selected[i] = true;
                            }
                        }
                    }
                }
            }

            this.repaint();

            //for debug
            
            //fun experiment
            //game.getPlayerList().get(activePlayer).getCardsInHand().removeCard(0);
            //this.repaint();

            //System.out.println(x+","+y);//these co-ords are relative to the component
            //System.out.println(activePlayer);
            //System.out.println(game.getPlayerList().get(activePlayer).getCardsInHand().size());
            //for (int i = 0; i < 13; ++i){
            //    System.out.print(selected[i]);
            //}
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
    }

}