import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        GradientPaint paint = new GradientPaint(70, 70, Color.BLUE, 100, 150, Color.ORANGE);

        g2D.setPaint(paint);
        g2D.fillOval(70, 70, 100, 100);
    }
}
