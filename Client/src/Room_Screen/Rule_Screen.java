package Room_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Rule_Screen extends JPanel{
	// 룰 표시하는 패널
	private Image B = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/Rule_Screen.png")).getImage();
	private Rules_Exit_Button REB;
	private Room_Background RB;
	public Rule_Screen() {
		REB = new Rules_Exit_Button(this);
		setVisible(false);
		setLayout(null);
		setBounds(80,100,1500,850);
		setOpaque(false);
		add(REB);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(B, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}