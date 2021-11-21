import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements MouseListener {
    

	JLabel label;

    MyFrame(){
        this.setTitle("Hi Bitch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
	this.setLayout(null);
	
	label = new JLabel();
	label.setBounds(0,0,100,100);
	label.setBackground(Color.red);
	label.setOpaque(true);
	this.addMouseListener(this);	

        this.setIcon();
        //this.setPanel();
	this.add(label);
        this.setSize(500, 500);
        this.setVisible(true);


        //this.repaint();
    }

    private void setPanel(){
        this.setLayout(null);
        Big2Panel b2 = new Big2Panel();
        b2.setBounds(0, 0, 600, 600);
        this.add(b2);
    }

    private void setIcon(){
        ImageIcon image = new ImageIcon("img/icon/icon.png");
        this.setIconImage(image.getImage());
    }

    @Override
    public void mouseClicked(MouseEvent e){
    	System.out.println("x = " + e.getX() + ", y = " + e.getY());
    }
    
    @Override
    public void mousePressed(MouseEvent e){
	
    	System.out.println("You preesed the Mouse");
	label.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseReleased(MouseEvent e){

    	System.out.println("You relased the Mouse");
	label.setBackground(Color.GREEN);
    }

    @Override
    public void mouseEntered(MouseEvent e){

    	System.out.println("You entered the Mouse");
	label.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e){

	label.setBackground(Color.RED);
    }

}
