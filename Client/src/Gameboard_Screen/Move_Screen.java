package Gameboard_Screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main_Screen.Main_Background;

public class Move_Screen extends JLabel{
	// 이동 표시 패널 
	private ImageIcon B = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GIF/Move.gif"));
	
	public Move_Screen() {

		
		B.getImage().flush();
		setIcon(B);
		setFocusable(false);
		setBounds(165,274,1200,400);
		
	}
}