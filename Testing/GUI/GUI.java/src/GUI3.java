import javax.swing.*;
import java.awt.*;

class GUI3{
	public static void main(String[] args){
	
		JLabel label = new JLabel();
		label.setText("Hi Bitch");
		ImageIcon icon = new ImageIcon("idk.png");
		label.setIcon(icon);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(50, 50, 200, 200);

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0, 0, 250, 250);
		redPanel.setLayout(null);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250, 0, 250, 250);
		bluePanel.setLayout(null);

		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0, 250, 500, 250);
		greenPanel.setLayout(new BorderLayout());
		greenPanel.setLayout(null);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 960);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(redPanel);
		frame.add(bluePanel);
		frame.add(greenPanel);
		redPanel.add(label);
		

	}
}


