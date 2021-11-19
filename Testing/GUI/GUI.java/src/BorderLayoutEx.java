import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx {
	public static void main(String[] args){
		BorderLayoutEx gui = new BorderLayoutEx();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton east = new JButton("East");
		JButton west = new JButton("West");
		JButton north = new JButton("North");
		JButton south = new JButton("South");
		JButton center = new JButton("Center");

		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);

		frame.setSize(300, 300);
		frame.setVisible(true);
		}
}

