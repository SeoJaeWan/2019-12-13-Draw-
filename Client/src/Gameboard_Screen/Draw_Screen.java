package Gameboard_Screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main_Screen.Main_Background;

public class Draw_Screen extends JLabel{
	// 주사위 표시하는 패널
	private ImageIcon Dice1; 
	
	public Draw_Screen() {
		
		Dice1 = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GIF/draw.gif"));
		
		Dice1.getImage().flush();
		setIcon(Dice1);
		setFocusable(false);
		setBounds(-2,576,1216,456);
		
	}
}