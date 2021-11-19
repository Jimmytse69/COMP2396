import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g){
        Image image = new ImageIcon("kelvin.jpg").getImage();
        g.drawImage(image, 3, 4, this);
    }
}
