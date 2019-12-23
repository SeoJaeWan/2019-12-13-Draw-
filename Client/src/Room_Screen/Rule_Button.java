package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Rule_Button extends Default_Button_Event{
	//방에 레디버튼을 나타내는 클래스
	private ImageIcon Rule_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/RULE_BUTTON.png"));
	private ImageIcon Rule_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/RULE_BUTTON_ENTER.png"));
	private Room_Background RB;
	public Rule_Button(Room_Background RB) {
		this.RB = RB;
		setIcon(Rule_IN);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(749,20, Rule_IN.getIconWidth(), Rule_IN.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(Rule_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(Rule_IN);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void mousePressed(MouseEvent e) {
		RB.Rules();
	}
}