import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame(){
        this.setTitle("Hi Bitch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600, 900);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("idk.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(123, 50, 250));
    }
}
