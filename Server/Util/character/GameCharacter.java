package character;

import java.net.Socket;
import java.util.ArrayList;

import game.Card;

public class GameCharacter extends Character{
   // 게임 캐릭터 클래스
   
   private int Job = 0;   //   직업
   private int Hp;//   체력
   private int position;
   private int haveBeer = 0;
   private int haveAvoid = 0;
   private String[] hand = new String[4];
   private int Weapon = 0;
   private ArrayList<Card> Card = new ArrayList<Card>();//   소지하고 있는 카드   
   
   public GameCharacter(String id,String nickName, Socket userInfo,Socket chat, Socket roomInfo,int channel) {
      super(id,nickName, userInfo, chat, roomInfo, channel);
   }
   
   public int getJob() {
      return Job;
   }
   public void setJob(int job) {
      Job = job;
   }
   public int getHp() {
      return Hp;
   }
   public void setHp(int hp) {
      Hp = hp;
   }
   public void DownHp() {
	 Hp -= 2;
	 if(Hp < 0)
		 Hp=0;
   }
   public void UpHP() {
	   for (int i = 0; i < 2; i++) {
		   if(!((this.Job==1&&this.Hp==6)||Hp==5))
				Hp++;
	}
	  
   }
   public ArrayList<Card> getCard() {
      return Card;
   }
   public void setCard(ArrayList<Card> card) {
      Card = card;
   }
   public void addCard(Card card) {
      Card.add(card);
   }
   public void removeCard(String card) {
	  int index = 0;
	  boolean find = false;
	   for (int j = 0; j < Card.size(); j++) {
		if(Card.get(j).toString().equals(card)) {
			index = j;
			find = true;
		}
	}
      if(find)
    	  Card.remove(index);
      System.out.println(Card.toString());
   }

   public void reset() {
      Card.removeAll(Card);
      Hp = 0;
   }
   
   public int getPosition() {
      return position;
   }

   public void setPosition(int position) {
      this.position = position;
   }
   public void getAvoid(){
      haveAvoid++;
   }
   public void getBeer() {
      haveBeer++;
   }
   public void useAvoid() {
      haveAvoid--;
   }
   public void useBeer() {
      haveBeer--;
   }
   public int getHaveAvoid() {
      return haveAvoid;
   }
   public int getHaveBeer() {
      return haveBeer;
   }

   public int getWeapon() {
      return Weapon;
   }

   public void setWeapon(int weapon) {
      Weapon = weapon;
   }
}