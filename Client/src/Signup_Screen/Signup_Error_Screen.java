package Signup_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Login_Screen.Login_Error_Button;
import Main_Screen.Main_Background;

public class Signup_Error_Screen extends JPanel{
	// 회원가입 에러를 나타내는 패널 
	private Image LOGIN_ERROR = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGN_UP_ERROR.png")).getImage();
	private Signup_Error_Button SEB;
	
	
	public Signup_Error_Screen(Signup_Background SB) {
		SEB = new Signup_Error_Button(SB);
		setLayout(null);
		setBounds(500,300,744,305);
		add(SEB);
		
		setVisible(false);
	}
	public void paintComponent(Graphics g) {
	
		g.drawImage(LOGIN_ERROR, 0, 0, this.getWidth(), this.getHeight(), this);		

	}
}

