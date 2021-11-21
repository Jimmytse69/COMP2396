import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {
	JButton button;

	MyFrame(){
		JButton button = new JButton();
		button.setBounds(200, 100, 100, 50);
		button.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(button);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button){
			System.out.println("poo");
		}
	}
}
