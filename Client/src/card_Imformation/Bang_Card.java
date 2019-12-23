package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Use_VarietyStore_Screen;
import Main_Screen.Main_Background;
import gameCharacter_Screen.Position_Screen;

public class Bang_Card extends Draw_Card{
	String name;
	// 뱅 카드 버튼을 나타내는 클래스 
	private ImageIcon Bang_Cards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/뱅1.png"));
	public Bang_Card() {
		super("Bang");
		setIcon(Bang_Cards);
		setBorderPainted(false);
		setBounds(0, 50,  Bang_Cards.getIconWidth(), Bang_Cards.getIconHeight());
		setFocusable(false);
		setContentAreaFilled(false);
		//addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("뱅");
		setIcon(Bang_Cards);//흰색으로 바뀜
		setBounds(0, 10, Bang_Cards.getIconWidth(), Bang_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(Bang_Cards);// 다시 원상태로
		setBounds(0, 40, Bang_Cards.getIconWidth(), Bang_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
		enterCheckOff();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!this.getMyCard()) {
			if (enterCheck) {
				if(GameBaord_Background.isVarietyStoremood()){
		         Util.SendServer.SendData(Default_Socket.getOutData(), "Bang");
		         Use_VarietyStore_Screen.EndDraw();
		         GameBaord_Background.ExpansionCardRemove();
		      }
				}
	      }
	      else if(enterCheck) {
			if(this.can(this)) {
				if((GameBaord_Background.getMyTurn() && GameBaord_Background.getBangCount() == 0) || GameBaord_Background.getWeapon() == 1) {
					Card_Screen.useCard(this);
					Position_Screen.addListener(1);
					GameBaord_Background.upBangCount();
					
				}
				else if(GameBaord_Background.isFightingmood()){
					Card_Screen.useCard(this);
				}else{
					System.out.println("못쓴다.");
				}
            
         }
		}
	      GameBaord_Background.ExpansionCardRemove();
	   }

}