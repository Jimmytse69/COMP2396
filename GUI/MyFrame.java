import javax.swing.*;

public class MyFrame extends JFrame{
    

    MyFrame(){
        this.setTitle("Hi Bitch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setIcon();
        this.setPanel();

        this.setSize(1600, 900);
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


}
