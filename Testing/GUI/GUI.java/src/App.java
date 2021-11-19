import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
