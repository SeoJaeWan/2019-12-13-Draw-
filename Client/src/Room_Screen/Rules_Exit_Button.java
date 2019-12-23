package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Rules_Exit_Button extends Default_Button_Event{

	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK_ENTER.png"));
	private Rule_Screen RS;
	public Rules_Exit_Button(Rule_Screen RS) {
		this.RS = RS;
		setIcon(ROOM_BACK);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(500,670, ROOM_BACK.getIconWidth(), ROOM_BACK.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(ROOM_BACK_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ROOM_BACK);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		RS.setVisible(false);
	}
}