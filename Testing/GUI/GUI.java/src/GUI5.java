import javax.swing.*;
import java.awt.event.*;

class GUI5 implements ActionListener{
	JButton button;

	public static void main(String[] args){
		GUI5 gui = new GUI5();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("click me");
		button.addActionListener(this);

		frame.add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		button.setText("I 've clicked!");
	}

}


