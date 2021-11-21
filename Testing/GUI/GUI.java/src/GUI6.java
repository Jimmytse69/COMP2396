import java.awt.*;
import javax.swing.*;

class GUI6 extends JPanel{
	public void paintComponent(Graphics g){
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		g.setColor(new Color(red, green, blue));
		g.fillOval(70, 70, 100, 100);
	}

	public static void main (String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GUI6 gui = new GUI6();
		frame.add(gui);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

