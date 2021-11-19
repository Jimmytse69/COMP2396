import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel {
  public void paintComponent(Graphics g) {
//    g.setColor(Color.ORANGE);
//    g.fillRect(20, 50, 100, 70);
	
    Image image = new ImageIcon("batman.jpg").getImage();
    g.drawImage(image, 3, 4, this);
	  
//	  int red = (int) (Math.random() * 256);
//	  int green = (int) (Math.random() * 256);
//	  int blue = (int) (Math.random() * 256);
//	  g.setColor(new Color(red, green, blue));
//	  g.fillOval(70, 70, 100, 100);
	  
//	  Graphics2D g2D = (Graphics2D) g;
//	  GradientPaint paint = new GradientPaint(70, 70, Color.BLUE, 150, 150, Color.ORANGE);
//	  g2D.setPaint(paint);
//	  g2D.fillOval(70, 70, 100, 100);
  }  
}