package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Use_VarietyStore_Screen;
import Main_Screen.Main_Background;

public class Beer_Card extends Draw_Card{ // 추상클래스 Draw_Card를 상속받는 모습
	// 맥주 카드 버튼을 나타내는 클래스 
	private ImageIcon BeerCards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/맥주1.png"));
	public Beer_Card() {
		super("Beer");
		setIcon(BeerCards);
		setBorderPainted(false);
		setFocusable(false);
		setBounds(0, 50,  BeerCards.getIconWidth(), BeerCards.getIconHeight());
		setContentAreaFilled(false);
		//addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("맥주");
		setIcon(BeerCards);//흰색으로 바뀜
		setBounds(0,10, BeerCards.getIconWidth(), BeerCards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(BeerCards);// 다시 원상태로
		setBounds(0,40, BeerCards.getIconWidth(), BeerCards.getIconHeight());
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
	    	      }
	           
	         }
	      }
	      else if(enterCheck){
	    	  if(GameBaord_Background.isBangmood()||GameBaord_Background.getMyTurn()) {
	               Card_Screen.useCard(this);
	            }
	      }
	         GameBaord_Background.ExpansionCardRemove();
	      
	      }

}