package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Main_Screen.Main_Background;

public class Result_Button extends Default_Button_Event{
	// 사용 결과창 버튼 
	private ImageIcon RESULT = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/RESULT_SCREEN_BUTTON.png"));
	private ImageIcon RESULT_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/RESULT_SCREEN_BUTTON_ENTER.png"));
	public Result_Button() {
		setIcon(RESULT);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(312,641, RESULT.getIconWidth(), RESULT.getIconHeight());
		addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(RESULT_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(RESULT);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}
}
