import javax.swing.*;
import java.awt.*;

public class Big2Panel extends JPanel{
    private static final String[] SUITS = { "d", "c", "h", "s"}; // {Diamond, Club, Heart, Spade}
    private static final String[] RANKS = { "a", "2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k"};

    private static final int avaterWidth = 67;
    private static final int avaterHeight = 100;

    Big2Panel() {
        this.setBackground(Color.green);
        this.setCards();
        this.setAvater();
    }


    private void setAvater() {
        this.setLayout(null);
        for (int j = 0; j < 4; ++j){
            ImageIcon avater = new ImageIcon("img/avater/meman.png");
            JLabel a = new JLabel("Player " + j, (Icon) avater, JLabel.RIGHT);
            a.setBounds(0, 0, avaterWidth, avaterHeight);
            a.setLocation(0, 100*j);
            this.add(a);
        }
    }


    private void setCards() {
        this.setLayout(null);
        for (int i = 12; i > 0; --i){
            for (int j = 0; j < 4; ++j){
                ImageIcon card = new ImageIcon("img/cards/" + RANKS[i] + SUITS[j] + ".gif");
                JLabel c = new JLabel(card);
                c.setBounds(0, 0, 73, 97);
                //overlay 73-30=43 for each "row" of cards
                c.setLocation(avaterWidth + 30*i, 100*j);
                this.add(c);
            }
        }
    }

}
