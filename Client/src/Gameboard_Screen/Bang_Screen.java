package Gameboard_Screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main_Screen.Main_Background;

public class Bang_Screen extends JLabel{
	// 뱅 표시하는 패널
	private ImageIcon B = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GIF/BANG.gif"));
	
	public Bang_Screen() {

		
		B.getImage().flush();
		setIcon(B);
		setFocusable(false);
		setBounds(165,274,1200,400);
		
	}
}