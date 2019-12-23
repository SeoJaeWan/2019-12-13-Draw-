package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Use_VarietyStore_Screen;
import Main_Screen.Main_Background;

public class Avoid_Card extends Draw_Card {
	// 회피 카드 버튼을 나타내는 클래스

	private ImageIcon Avoid_Cards = new ImageIcon(
			Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/빗나감1.png"));

	public Avoid_Card() {
		super("Avoid");
		setIcon(Avoid_Cards);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		//addMouseListener(this);
		setBounds(0, 50, Avoid_Cards.getIconWidth(), Avoid_Cards.getIconHeight());
	}

	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("빗나감");
		setIcon(Avoid_Cards);// 흰색으로 바뀜
		setBounds(0, 10, Avoid_Cards.getIconWidth(), Avoid_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(Avoid_Cards);// 다시 원상태로
		setBounds(0, 40, Avoid_Cards.getIconWidth(), Avoid_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
		enterCheckOff();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	      if(!this.getMyCard()) {
	         if(enterCheck) {
	        	 if(GameBaord_Background.isVarietyStoremood()){
	    	         Util.SendServer.SendData(Default_Socket.getOutData(), this.getName());
	    	         Use_VarietyStore_Screen.EndDraw();
	    	         GameBaord_Background.ExpansionCardRemove();
	    	      }
	           
	         }
	      }
	      else if(enterCheck){
	    	  if(GameBaord_Background.isBangmood()) {
	               Card_Screen.useCard(this);
	            }
	      }
	         GameBaord_Background.ExpansionCardRemove();
	      
	      }
}