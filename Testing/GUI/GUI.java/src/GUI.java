import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args){
        MyFrame frame = new MyFrame();

        ImageIcon image = new ImageIcon("idk.png");

        JLabel label = new JLabel();
        label.setText("Bro do you even code?");  //set text of label
        label.setIcon(image);
	    label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MB Boli", Font.PLAIN, 20));
        label.setIconTextGap(-25);
        label.setBackground(Color.black);



        frame.add(label);
    }    

}
