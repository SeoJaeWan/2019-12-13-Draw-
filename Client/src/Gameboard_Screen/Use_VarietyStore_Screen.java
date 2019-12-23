package Gameboard_Screen;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Default.Default_Socket;
import card_Imformation.Avoid_Card;
import card_Imformation.Bang_Card;
import card_Imformation.Beer_Card;
import card_Imformation.Draw_Card;
import card_Imformation.Fighting_Card;
import card_Imformation.GatlingGun_Card;
import card_Imformation.IndianAmbush_Card;
import card_Imformation.TavernBrawl_Card;
import card_Imformation.VarietyStore_Card;

public class Use_VarietyStore_Screen extends JPanel{
   static private ArrayList<JPanel> Card = new ArrayList<JPanel>();

   static private ArrayList<Draw_Card> DC = new ArrayList<Draw_Card>();
   static private Use_VarietyStore_Screen a;
   public Use_VarietyStore_Screen() {
       a = this;
      setLayout(new GridLayout(1, 5)); 
      setVisible(true);
      setBounds(420,325,750,300);
      setOpaque(false);
      for(int i=0;i<5;i++) {
         Card.add(i,new JPanel()); 
         Card.get(i).setLayout(null);
         Card.get(i).setSize(120,200);
         Card.get(i).setOpaque(false);
         add(Card.get(i));
      }
   }
   static public void Draw_Card(String cards) {
      /*for (int i = 0; i < Card.size(); i++) {
         Card.get(i).removeAll();
      }*/
      
      String words[] = cards.split(":");
      for (int i = 1; i < words.length; i++) {
         switch(words[i]) {
         case "Bang":
            DC.add(new Bang_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "Beer":
            DC.add(new Beer_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "Avoid":
            DC.add(new Avoid_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "Fighting":
            DC.add(new Fighting_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "GatlingGun":
            DC.add(new GatlingGun_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "IndianAmbush":
            DC.add(new IndianAmbush_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "TavernBrawl":
            DC.add(new TavernBrawl_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         case "VarietyStore":
            DC.add(new VarietyStore_Card());
            DC.get(DC.size()-1).setMyCard(false);
            Card.get(DC.size()-1).add(DC.get(DC.size()-1));
            break;
         }
         
      }
      GameBaord_Background.StoreRepaint();
   }
   //카드 고르기
   static public void StartDraw() {
      System.out.println("작동");
      for (int i = 0; i < DC.size(); i++) {
         DC.get(i).addMouseListener(DC.get(i));
      }
   }
   static public void EndDraw() {
      for (int i = 0; i < DC.size(); i++) {
         DC.get(i).removeMouseListener(DC.get(i));
      }
   }
   static public void removeC(String card) {
      for (int i = 0; i < DC.size(); i++) {
         if(DC.get(i).getName().equals(card) ) {
            Card.get(i).remove(DC.get(i));
            DC.remove(i);
            a.remove(Card.remove(i));   
            Card.add(new JPanel()); 
            Card.get(Card.size()-1).setLayout(new FlowLayout(0,0,60));
            Card.get(Card.size()-1).setSize(120,200);
            Card.get(Card.size()-1).setOpaque(false);
            a.add(Card.get(Card.size()-1));
            a.repaint();
            a.revalidate();
            break;
         }
         
      }
      
   }
}