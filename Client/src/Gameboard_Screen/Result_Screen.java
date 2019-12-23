package Gameboard_Screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Result_Screen extends JPanel{
	// 게임결과 나타내는 패널 
		private Image RESULT = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/RESULT_SCREEN.png")).getImage();
		private ImageIcon WINIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/WIN.png"));
		private ImageIcon ResultIMG;
		private JPanel layout;
		private JLabel[] IMF = new JLabel[5];
		private JPanel[] imformation = new JPanel[5];
		private JLabel[] IMG = new JLabel[5];
		private JLabel[] WIN = new JLabel[5];
		private JLabel[] LLL = new JLabel[3];
		private Result_Button RB;
		public Result_Screen(Player_Score_Screen[] PSS ,int WinInspection) {
			RB = new Result_Button();
			add(RB);
			setLayout(null); 
			setVisible(true);
			setBounds(420,60,780,780);
			setOpaque(false);
			layout = new JPanel();
			layout.setBounds(168,170,450,450);
			layout.setLayout(new GridLayout(0,1));
			layout.setOpaque(false);
			//String JOB;
			
			ResultIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/JOB/보안관.png"));
			//ResultIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/JOB/"+JOB+".png"));
			for(int i =0;i<PSS.length;i++) {
				LLL=PSS[i].getIMF();
				imformation[i] = new JPanel();
				imformation[i].setBounds(0,0,410,90);
				imformation[i].setLayout(null);
				imformation[i].setOpaque(false);
				IMF[i] = new JLabel(PSS[i].getIMF()[0].getText());
				IMF[i].setHorizontalAlignment(JLabel.CENTER);
				IMF[i].setHorizontalTextPosition(JLabel.CENTER);
				IMF[i].setBounds(160, 0, 120, 90);
				IMF[i].setFont(new Font("굴림", Font.BOLD, 15));
				imformation[i].add(IMF[i]);
				IMG[i] = new JLabel();
				IMG[i].setBounds(0, 15, 160, 90);
				if(!LLL[1].getText().equals("0"))
					IMG[i].setIcon(new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/JOB/"+LLL[1].getText()+".png")));
				imformation[i].add(IMG[i]);
				WIN[i] = new JLabel();
				WIN[i].setBounds(320,0,90,90);
				WIN[i].setIcon(WINIMG);
				System.out.println("WIN INSPEC : "+WinInspection);
				if(WinInspection==1&&i==0) 
					imformation[i].add(WIN[i]);
				else if(WinInspection==2&&(i==0||i==1))
					imformation[i].add(WIN[i]);
				else if(WinInspection==3&&(i==0||i==1))
					imformation[i].add(WIN[i]);
				else if(WinInspection==5&&i==0)
					imformation[i].add(WIN[i]);
				
				layout.add(imformation[i]);
			}
			add(layout);
				
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(RESULT, 0, 0, this.getWidth(), this.getHeight(), this);

		}
}
