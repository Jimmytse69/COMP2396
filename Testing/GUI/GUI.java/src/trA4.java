import javax.swing.*;

import java.awt.*;

class trA4{
	//Big 2 game main frame
	private JFrame frame;
	private JPanel big2Panel;
	
	
	//Const of this
	trA4(){
		frame = initFrame();
		big2Panel = trA4.BigTwoPanel.initBig2Panel();
		/**
		for (int i = 0; i < 4; ++i){
			avater[i] = initAvater("Player " + i, new ImageIcon("idk.png"));
			avater[i].setBounds(0, i*150, 100, 150);
			big2Panel.add(avater[i]);
		}
		*/
		frame.add(big2Panel);

		//bug encountered, use repaint() instead:https://stackoverflow.com/questions/18950065/adding-panels-to-frame-but-not-showing-when-app-is-run
		frame.repaint();
	}
	
	private static JFrame initFrame(){
		final int frameWidth = 1280;
		final int frameHeight = 960;

		JFrame f = new JFrame("Big2");
		
		f.setLayout(null);
		f.setSize(frameWidth, frameHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		//Ref: https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode
		f.setIconImage(new ImageIcon("icon.png").getImage());	

		return f;
	}

	static class BigTwoPanel{

		final static int big2StartX = 0;
		final static int big2StartY = 0;
		final static int big2PanelWidth = 680;
		final static int big2PanelHeight = 860;
		static JLabel[] avater = new JLabel[4];

		private static JPanel initBig2Panel(){
			
	
			JPanel b2 = new JPanel();
			b2.setLayout(null);
			b2.setBackground(new Color(0x35654D));
			b2.setBounds(big2StartX, big2StartY, big2PanelWidth, big2PanelHeight);
			
			//add 5 sub-Panel in here
			JPanel p = new JPanel();
			
			for (int i = 0; i < 4; ++i){
				p = initBig2PlayerPanel(i);
				b2.add(p);
			}

			//b2.setLocation(0, big2PanelHeight*4/5);
	
	
			return b2;
		}
	
		private static JPanel initBig2PlayerPanel(int playerIdx){
			JPanel p = new JPanel();
			p.setLayout(null);
			p.setBounds(big2StartX, big2StartY, big2PanelWidth, big2PanelHeight/5);
			p.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			p.setBackground(new Color(0x35654D));
			p.setLocation(0, big2PanelHeight/5*playerIdx);

			ImageIcon icon = new ImageIcon("idk.png");
			avater[playerIdx] = initAvater("Player " + playerIdx, icon);
			avater[playerIdx].setBounds(0, 0, 100, 150);
			p.add(avater[playerIdx]);

			JLabel card = new JLabel();
			for (int i = playerIdx; i < playerIdx + 14; ++i){
				card = initCards(playerIdx);
				card.setBounds(80+i*30, 40, 500 , 726);
				p.add(card);
			}

			return p;

		}

		//private static JPanel initBig2TablePanel(){

		//}
	
		private static JLabel initAvater(String name, ImageIcon icon){
			JLabel a = new JLabel();
			a.setText(name);
			a.setIcon(icon);
			a.setVerticalTextPosition(JLabel.TOP);
			a.setHorizontalTextPosition(JLabel.CENTER);
			a.setForeground(Color.YELLOW);
			a.setFont(new Font("MV BOLI", Font.PLAIN, 18));
			return a;
		}

		private static JLabel initCards(int playerIdx){
			JLabel a = new JLabel();
			ImageIcon card = new ImageIcon("Cards/2_of_clubs.png");
			a.setIcon(card);
			return a;

		}


	}


	public static void main(String[] args){
		trA4 tr = new trA4();
	}

}

