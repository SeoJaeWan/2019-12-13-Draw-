package Gameboard_Screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main_Screen.Main_Background;

public class Beer_Screen extends JLabel{
	// Beer 표시하는 패널
	private ImageIcon B = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GIF/BEER.gif"));
	
	public Beer_Screen() {

		
		B.getImage().flush();
		setIcon(B);
		setFocusable(false);
		setBounds(165,274,1200,400);
		
	}
}