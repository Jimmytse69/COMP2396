import java.awt.*;
import javax.swing.*;

class GUI4 extends JPanel{
	
	public void paintComponent(Graphics g){
		Image image = new ImageIcon("idk.png").getImage();
		g.drawImage(image, 3, 4, this);
	}

	public static void main(String[] args){
		GUI4 t = new GUI4();

		JFrame jf = new JFrame();

		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.add(t);
	}

}
