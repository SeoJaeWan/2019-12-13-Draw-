package Gameboard_Screen;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Default.Default_Socket;
import Util.GIF_Thread;
import Util.SendServer;
import card_Imformation.Avoid_Card;
import card_Imformation.Bang_Card;
import card_Imformation.Beer_Card;
import card_Imformation.Draw_Card;
import card_Imformation.Fighting_Card;
import card_Imformation.GatlingGun_Card;
import card_Imformation.IndianAmbush_Card;
import card_Imformation.TavernBrawl_Card;
import card_Imformation.VarietyStore_Card;

public class Card_Screen extends JPanel{
	// 카드 놓는곳 영역 패널 
	//private ImageIcon Fight_Card = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/기관총1.png"));
	static private ArrayList<JPanel> Card = new ArrayList<JPanel>();
	//static private JPanel[] Card = new JPanel[5];
	static private ArrayList<Draw_Card> DC = new ArrayList<Draw_Card>(); // 모든 카드를 담을 수 있는 Draw_Card 타입 ArrayList
	static private Card_Screen a;
	static private GameBaord_Background GBB;
	static private Draw_Card using_card;
	
	public Card_Screen(GameBaord_Background GBB) {
		this.GBB = GBB;
		a = this;
		setLayout(new GridLayout(1, 5)); 
		setVisible(true);
		setBounds(420,825,750,200);
		setOpaque(false);
		for(int i=0;i<5;i++) {
			Card.add(i,new JPanel()); 
			Card.get(i).setLayout(null);
			Card.get(i).setSize(120,200);
			Card.get(i).setOpaque(false);
			add(Card.get(i));
		}
		//Card[0].add(DC);
	//	Card[1].add(DC1);
	//	Card[2].add(DC2);
	//	Card[3].add(DC3);
	//	Card[4].add(DC4);
			
	}
	static public void Draw_Card(String cards) {// 수정
		String words[] = cards.split(":");
		System.out.println(words);
		Draw_Screen DS = new Draw_Screen();

		for (int i = 1; i < words.length; i++) {
			switch(words[i]) {
			case "Bang":
				//DC.add();
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new Bang_Card());
				DC.get(DC.size()-1).setMyCard(true);
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Beer":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new Beer_Card());
				DC.get(DC.size()-1).setMyCard(true);
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Avoid":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new Avoid_Card());
				DC.get(DC.size()-1).setMyCard(true);
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Fighting":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new Fighting_Card());
				DC.get(DC.size()-1).setMyCard(true);
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "GatlingGun":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new GatlingGun_Card());
				DC.get(DC.size()-1).setMyCard(true);
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "IndianAmbush":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new IndianAmbush_Card());
				DC.get(DC.size()-1).setMyCard(true);
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "TavernBrawl":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new TavernBrawl_Card());
				//Card.get(i-1).add(DC.get(i-1));
				DC.get(DC.size()-1).setMyCard(true);
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "VarietyStore":
				Card_Screen.GBB.add(DS);
				Card_Screen.GBB.revalidate();
				Card_Screen.GBB.repaint();
				new Thread(new GIF_Thread(Card_Screen.GBB, DS, 2400)).start();
				DC.add(new VarietyStore_Card());
				//Card.get(i-1).add(DC.get(i-1));
				DC.get(DC.size()-1).setMyCard(true);
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			}
			
		}
	}
	static public void ShotgunCard() {
		int RandomNum = (int) ((Math.random() * DC.size() - 1));
		Card.get(RandomNum).remove(DC.get(RandomNum));
		DC.remove(RandomNum);
		a.remove(Card.remove(RandomNum));	
		Card.add(new JPanel()); 
		Card.get(Card.size()-1).setLayout(new FlowLayout(0,0,40));
		Card.get(Card.size()-1).setSize(120,200);
		Card.get(Card.size()-1).setOpaque(false);
		a.add(Card.get(Card.size()-1));
		a.repaint();
		a.revalidate();
		
		SendServer.SendData(Default_Socket.getOutData(),"ShotGun:"+DC.get(RandomNum).getName());
	}

	static public void useCard(Draw_Card card) {
		String s = "";
		using_card = card;
		s = card.getName();
		if(!using_card.getName().equals("Bang")&&(!using_card.getName().equals("Fighting")))
			remove();
		else if(using_card.getName().equals("Bang") && GameBaord_Background.isFightingmood())
			remove();
		System.out.println("선택 카드"+s );
			Util.SendServer.SendData(Default_Socket.getOutData(), s);
		
	}
	static public void remove() {
		for (int i = 0; i < DC.size(); i++) {
			if(DC.get(i) == using_card) { // 만약 패에 뱅이 여러장 있을 때 자신이 사용한 자리의 카드를 없애기위해 equals가 아니라 ==를 통해 메모리를 참조한 모습
				Card.get(i).remove(DC.get(i));
				DC.remove(i);
				a.remove(Card.remove(i));	
				Card.add(new JPanel()); 
				Card.get(Card.size()-1).setLayout(new FlowLayout(0,0,40));
				Card.get(Card.size()-1).setSize(120,200);
				Card.get(Card.size()-1).setOpaque(false);
				a.add(Card.get(Card.size()-1));
				a.repaint();
				a.revalidate();
			}
			
		}
		
	}
	
	public static void resetCard() {
		Card.removeAll(Card);
		DC.removeAll(DC);
	}

}
	

