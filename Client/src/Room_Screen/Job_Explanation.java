package Room_Screen;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Job_Explanation extends JPanel{
	
	private JLabel[] tile = new JLabel[4]; 
	
	
	public Job_Explanation() {
		setLayout(new GridLayout(4,1));
		setBounds(1262,100,373,644);
		setOpaque(false);
		setVisible(true);
		for(int i =0;i<4;i++) {
			tile[i] = new JLabel();
			tile[i].setOpaque(false);
			add(tile[i]);
		}
		tile[0].setToolTipText("보안관 : 무법자와 배신자를 처치하면 승리합니다.");
		tile[1].setToolTipText("부관 : 보안관과 함께 무법자와 배신자를 처치하면 승리합니다.");
		tile[2].setToolTipText("무법자 : 무법자가 보안관을 처치하면 승리합니다.");
		tile[3].setToolTipText("배신자 : 보안관과의 1대1상황에서 보안관을 처치하면 승리합니다.");
		
	}

}
