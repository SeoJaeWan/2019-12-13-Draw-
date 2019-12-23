package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Voice_Button extends Default_Button_Event{

	private ImageIcon Voice = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/마이크.png"));
	private ImageIcon Voice_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/마이크_enter.png"));
	public Voice_Button() {
		setIcon(Voice);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(520,30, Voice.getIconWidth(), Voice.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(Voice_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(Voice);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
//!!!
		SendServer.SendData(Default_Socket.getOutRoomInfo(), "voice");
		System.out.println("보냄");
	}
}