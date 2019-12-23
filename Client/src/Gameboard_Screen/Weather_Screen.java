package Gameboard_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Weather_Screen extends JPanel {
	// 날씨 카드를 나타내는 패널
	private ImageIcon Default_Sunny = new ImageIcon(
			Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/WHEATHERCARD/SUNNY.png"));
	JLabel Wheater_Button = new JLabel(Default_Sunny);

	public Weather_Screen() {
		// 생성자에 스트링 넣어서해

		setLayout(null);
		setVisible(true);
		setBounds(10, 10, 130, 130);
		setOpaque(false);
		Wheater_Button.setFocusable(false);
		Wheater_Button.setEnabled(true);
		Wheater_Button.setSize(130, 130);
		Wheater_Button.setToolTipText("아무 효과 없음");
		add(Wheater_Button);

	}

	public void changeIcon(String str) {
		System.out.println(str);
		ImageIcon a = new ImageIcon(
				Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/WHEATHERCARD/" + str + ".png"));
		
		switch (str) {
		case "SUNNY":			Wheater_Button.setToolTipText("아무 효과 없음");			break;
		case "DARK":			Wheater_Button.setToolTipText("사거리 -1");			break;
		case "WILDS":			Wheater_Button.setToolTipText("사거리 +1");			break;
		case "MIST":			Wheater_Button.setToolTipText("맞출확률 50%");			break;
		case "TORNADO":			Wheater_Button.setToolTipText("선택한 대상 맞출확률 50% + 아무나 맞을확률 50%");			break;
		}
		Wheater_Button.setIcon(a);
		revalidate();
		repaint();

	}
}