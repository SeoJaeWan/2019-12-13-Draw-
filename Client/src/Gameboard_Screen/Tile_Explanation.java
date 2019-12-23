package Gameboard_Screen;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Tile_Explanation extends JPanel{
	
	private ImageIcon pistol = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/icon/pistol.png"));
	private ImageIcon revolver = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/icon/revolver.png"));
	private ImageIcon shotgun = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/icon/shotgun.png"));
	private ImageIcon sniper = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/icon/sniper.png"));
	private JLabel[] tile = new JLabel[4]; 
	
	
	public Tile_Explanation() {
		setLayout(new GridLayout(4,1));
		setBounds(20,328,220,278);
		setOpaque(false);
		setVisible(true);
		for(int i =0;i<4;i++) {
			tile[i] = new JLabel();
			tile[i].setOpaque(false);
			add(tile[i]);
		}
		tile[0].setIcon(sniper);
		tile[0].setToolTipText("스나이퍼 \n 사거리가 2가 됩니다.");
		tile[1].setIcon(shotgun);
		tile[1].setToolTipText("샷건 \n 맞은사람은 카드 1장을 버립니다.");
		tile[2].setIcon(revolver);
		tile[2].setToolTipText("리볼버 \n 뱅을 연속사용할수 있습니다.");
		tile[3].setIcon(pistol);
		tile[3].setToolTipText("권총 \n 사거리 1인 총입니다.");
		
	}

}
