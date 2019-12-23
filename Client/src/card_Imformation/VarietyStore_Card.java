package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Use_VarietyStore_Screen;
import Main_Screen.Main_Background;

public class VarietyStore_Card  extends Draw_Card{
	// 잡화점 카드 버튼을 나타내는 클래스 
	private ImageIcon VarietyStore_Cards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/잡화점1.png"));
	public VarietyStore_Card() {
		super("VarietyStore");
		setIcon(VarietyStore_Cards);
		setBorderPainted(false);
		setBounds(0, 50,  VarietyStore_Cards.getIconWidth(), VarietyStore_Cards.getIconHeight());
		setFocusable(false);
		setContentAreaFilled(false);
		//addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("잡화점");
		setIcon(VarietyStore_Cards);
		setBounds(0, 10, VarietyStore_Cards.getIconWidth(), VarietyStore_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(VarietyStore_Cards);
		setBounds(0, +40, VarietyStore_Cards.getIconWidth(), VarietyStore_Cards.getIconHeight());
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
	    	  if(this.can(this)) {
	               Card_Screen.useCard(this);
	            }
	      }
	         GameBaord_Background.ExpansionCardRemove();
	      
	      }

}