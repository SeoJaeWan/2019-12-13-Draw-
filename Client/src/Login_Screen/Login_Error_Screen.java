package Login_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Login_Error_Screen extends JPanel{
	// 로그인 에러를 나타내는 패널 
		private Image LOGIN_ERROR = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ERROR.png")).getImage();
		private Login_Error_Button LEB;
		
		
		public Login_Error_Screen(Login_Background LB) {
			LEB=new Login_Error_Button(LB);
			setLayout(null);
			setBounds(500,300,744,305);
			add(LEB);
			
			setVisible(false);
		}
		public void paintComponent(Graphics g) {
		
			g.drawImage(LOGIN_ERROR, 0, 0, this.getWidth(), this.getHeight(), this);		

		}
}
