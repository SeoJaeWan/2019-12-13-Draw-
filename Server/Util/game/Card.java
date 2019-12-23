package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import character.GameCharacter;
import common.Send;

public class Card {
	public String Act, Circum;
	private String[] Active = { "Bang", "Beer", "Avoid", "GatlingGun", "Fighting", "VarietyStore", "IndianAmbush",
			"TavernBrawl" };
	private String[] circumstance = { "Bright", "Fog", "LightOut", "Wilderness", "Tornado", "Snow" };

	public Card() {
		Act = Active[(int)( Math.random() * 8)];
		
		//Circum = circumstance[(int) Math.random() * 6];
	}
	public Card(String act) {
		Act=act;
	}
	public String getActive() {
		return Act;
	}
	public String toString() {
		return Act;
	}
	public String getCircumstance() {
		return Circum;
	}
	public boolean isBeer() {
		return this.toString().equals("Beer");
	}
	public boolean isAvoid() {
		return this.toString().equals("Avoid");
	}
	private static ArrayList<GameCharacter> orders1;
	private static ArrayList<GameCharacter> users=new ArrayList<GameCharacter>();
	static public void Bang(GameCharacter user, ArrayList<GameCharacter> orders) throws IOException {
	      //변경
	      String react;
	         
	         react = Turn.Bang_SemiTurn(user);
	         System.out.println(react);
	         if(react.equals("Avoid")) {
	            user.removeCard(react);
	            Send.sendAll("Result:Avoid", orders, 2);
	         }
	         else if(react.equals("Beer")) {
	            user.removeCard(react);
	            Send.sendAll("Result:Beer", orders, 2);
	         }
	      
	         else {
	         Send.sendAll("뱅뱅뱅", orders, 1);
	         Send.sendAll("Result:Bang", orders, 2);
	         user.DownHp();   
	         }
	         
	         if((!react.equals("Avoid"))&&game.InGame.getShotGun()) {
	            if(user.getCard().size() != 0) {
	               Send.sendData(user.getUserOut(), "ShotGun");
	               String act = InGame.getAct(user);
	               String[] deleteCard = act.split(":");
	               user.removeCard(deleteCard[1]);
	               System.out.println(user.getNickName() + deleteCard[1]);
	            }
	         }
	      
	   }

	
	
	
	static public String CardtoString(GameCharacter user, ArrayList<Card> cards) {//수정
		String C2S = "Hands:";
		for (int i = 0; i < cards.size(); i++) {
			C2S += cards.get(i).toString() + ":";
		}
		
		return C2S;
	}

	static public boolean GatlingGun(ArrayList<GameCharacter> range,ArrayList<GameCharacter> orders,ArrayList<GameCharacter> users,int gameEnd) throws IOException {
		int i = 1;
		for(i = 1; i < range.size();i++) {
			Bang(range.get(i),range);
			if(!Rule.deadRule(orders))
				break;
			sendTable(orders, users);
		}
		if(i < range.size())
			return false;
		
		return true;
	}

	static public void Fighting(GameCharacter Duelist, GameCharacter Receiver) throws IOException {
		String act;
		boolean DuelistT = false;
		boolean Fighting = true;
		while(Fighting){
			if(!DuelistT) {
				act = Turn.FightingSemiturn(Receiver);
				if(act.equals("Bang"))
					DuelistT = true;
				else {
					Fighting = false;
					Receiver.DownHp();
				}
				
			}
			else {
				act = Turn.FightingSemiturn(Duelist);
				if(act.equals("Bang"))
					DuelistT = false;
				else {
					Fighting = false;
					Duelist.DownHp();
				}
			}
			
			
			
		}
		
	}

	static public void VarietyStore(ArrayList<GameCharacter> orders) throws IOException {
     ArrayList<Card> card = new ArrayList<Card>();
      String cards = "";
      String choice;
      for (int i = 0; i < orders.size(); i++) {
         card.add(new Card());   
      } // 카드 유저수만큼 추가
      for (int j = 0; j < card.size(); j++) {
         cards += card.get(j)+":";
      } 
      Send.sendAll("CardList:"+cards,orders, 2); //카드리스트 출력해라
      
      for (int i = 0; i <orders.size(); i++) {
         
         choice = Turn.VarietyStore_SemiTurn(orders.get(i));      
         Send.sendAll("Remove:"+choice, orders, 2);
         cards = "";
      }
      Send.sendAll("CloseStore", orders, 2);
	}

	static public boolean IndianAmbush(ArrayList<GameCharacter> range,ArrayList<GameCharacter> orders,ArrayList<GameCharacter> users,int gameEnd) throws IOException {
		int i = 0;
		for( i = 0; i < range.size();i++) {
			Bang(range.get(i),range);
			if(!Rule.deadRule(orders))
				break;
			sendTable(orders, users);
		}
		if(i < range.size())
			return false;
		return true;
	}

	static public void TavernBrawl(GameCharacter user, ArrayList<GameCharacter> orders) throws  IOException {
		ArrayList<Integer> Dice = new ArrayList<Integer>();
		int [] result =  new int[orders.size()];
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			Dice.add(i);
		} // 1부터 100까지 채우기

		Collections.shuffle(Dice); // 섞기 

		for (int i = 0; i < orders.size(); i++) {
			Turn.TavernBrawl_SemiTurn(orders.get(i)); 
			result[i] = Dice.remove(0);
			if(max < result[i])
				max = result[i];
			Send.sendAll(orders.get(i).getNickName() + ":" +result[i], orders, 1);
		}
		for (int i = 0; i < result.length; i++) {
			if (max > result[i]) {
				orders.get(i).DownHp();//피연동 추가
				Send.sendData(orders.get(i).getChatOut(), "운나쁘면 맞아야지"); // 높은 유저 빼고 피 1다운
			}
		}
	
	
	}
	public static void sendTable(ArrayList<GameCharacter> orders, ArrayList<GameCharacter> send) {
		String s = "Table";
		for (int i = 0; i < orders.size(); i++) {// 준근 수정
			
				s += String.format(":%s:%d:%d", orders.get(i).getNickName(), orders.get(i).getHp(),
						orders.get(i).getCard().size());
			
		}
		Send.sendAll(s, send, 2);
	}
	
}