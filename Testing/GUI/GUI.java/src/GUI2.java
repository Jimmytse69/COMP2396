import javax.swing.*;
import java.awt.*;

class GUI2{
	public static void main(String[] args){
		//JLabel = a GUI display area for a string of text, an image, or both


		ImageIcon img = new ImageIcon("idk.png");
		JLabel label = new JLabel("Hello Bitches");
		label.setIcon(img);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(0x00FF00));
		label.setFont(new Font("MV Boli", Font.BOLD, 50));
		label.setIconTextGap(20);

		//useless for me
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createLineBorder(Color.green, 3));
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		//label.setBounds(100, 0, 250, 250);


		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(640, 480);
		//frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		frame.pack();
	}
}

