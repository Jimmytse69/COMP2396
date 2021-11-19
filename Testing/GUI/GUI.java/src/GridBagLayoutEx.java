import javax.swing.*;
import java.awt.*;

public class GridBagLayoutEx {
	public static void main(String[] args) {
		GridBagLayoutEx gui = new GridBagLayoutEx();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;	//default value
		c.gridheight = 1;	//def
		c.weightx = 0.0;	//def
		c.weighty = 0.0;	//def
		c.anchor = GridBagConstraints.CENTER;	//def
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);	//def
		c.ipadx = 0;	//def
		c.ipady = 0;	//def

		JButton button = new JButton("Button 1");
		c.weightx = 0.5;
		panel.add(button, c);

		JButton button2 = new JButton("Button 2");
		c.gridx = 1;	//2nd Column
		panel.add(button2, c);

		JButton button3 = new JButton("Button 3");
		c.gridx = 2;	//3rd Column
		panel.add(button3, c);

		JButton button4 = new JButton("Button 4");
		c.gridx = 0;	//1st Column
		c.gridy = 1;	//2nd row
		c.gridwidth = 3;	//spans 3 columns
		c.weightx = 0.0;
		c.ipady = 40;	//maek it tall
		panel.add(button4, c);

		JButton button5 = new JButton("Button 5");
		c.gridx = 1;	//2nd column
		c.gridy = 2;	//3rd row
		c.gridwidth = 2;	//spans 2 columns
		c.weighty = 1.0;	//takes up extra vertical space
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(10, 0, 0, 0);	//top padding
		c.ipady = 0;
		panel.add(button5, c);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}

