package Login_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.SendServer;

public class Login_Error_Button extends Default_Button_Event{
	// 로그인 오류
	private ImageIcon LOGIN_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ERROR_BUTTON.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ERROR_BUTTON_ENTER.png"));
	private Login_Background LB;
	public Login_Error_Button(Login_Background LB) {
		this.LB = LB;
		setIcon(LOGIN_BACK);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(270,190, LOGIN_BACK.getIconWidth(), LOGIN_BACK.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOGIN_BACK_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_BACK);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		LB.getError().setVisible(false);
	}
}
