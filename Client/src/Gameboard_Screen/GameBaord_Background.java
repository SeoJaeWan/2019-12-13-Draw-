package Gameboard_Screen;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.Commend;
import Util.GIF_Thread;
import Util.SendServer;
import gameCharacter_Screen.Position_Screen;
import thread.InRoom_UserInfo;
import thread.RoomInfo;
// 여기 건들였다 

public class GameBaord_Background extends JPanel{
	// 게임 화면을 나타내는 패널 
	private static int Weapon = 0;
	private static int BangCount = 0;
	private static boolean Fightingmood = false;
	private static boolean VarietyStoremood =false;
	private static boolean Bangmood = false;
	private static GameBaord_Background GBB;
	private static boolean myTurn;
	private static boolean phase2;
	private static ArrayList<String> AttackList = new ArrayList<String>();
	private static boolean phase3;
	private static boolean ChooseEnemy = false;
	private static int UserNum;
	private Image GameBaord_Background = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GAMEBOARD_SCREEN.png")).getImage();
	private Default_Frame DF;
	private Game_Chat GC;
	private Finishi_Button FB;
	private static Weather_Screen WS;
	private static Score_Screen SS;
	private static Imformation_Screen IS;
	private static ExpansionCard_Screen ECS;
	private Card_Screen CS;
	private static Finishi_Button FinishB;
	private static Card_Screen CardS;
	private Position_Screen PoS;
	private static Rolling_Button RB;
	private PlayerTurn_Screen PTS;
	private static MoveLeft_Button MLB;
	private static MoveRight_Button MRB;
	private static Use_Card_Screen UCS;
	private static String player_name=""; //  수정했음
	private static String player_hp=""; //  
	private static boolean use = false;
	private static Overlap_Player_Imformation OPI;
	private static Overlap_Player_Screen OPS;
	private static Result_Screen RS;
	private static Use_VarietyStore_Screen UVS;
	private static int WinInspection=0;
	private Tile_Explanation TE;
	
	public GameBaord_Background(Default_Frame DF) {
		this.DF = DF;
		GBB = this;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// Å©±â °íÁ¤
		setLayout(null); 
		GC = new Game_Chat();
		FB = new Finishi_Button();
		WS = new Weather_Screen();
		SS = new Score_Screen();
		IS = new Imformation_Screen();
		CS = new Card_Screen(this);
		PoS = new Position_Screen(this);
		RB = new Rolling_Button(this);
		PTS = new  PlayerTurn_Screen();
		MLB = new MoveLeft_Button();
		MRB = new MoveRight_Button();
		UCS = new Use_Card_Screen();
		TE = new Tile_Explanation();
		//RS = new Result_Screen(SS.getPSS());
		FinishB = FB;
		CardS = CS;
		
		//add(RS);
		add(IS);
		add(GC);
		add(FB);
		add(WS);
		add(SS);
		add(CS);
		add(PoS);
		add(RB);
		add(PTS);
		add(MLB);
		add(MRB);
		add(UCS);
		add(TE);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(GameBaord_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	static public void MoveLR() {
		MLB.setVisible(true);
		MRB.setVisible(true);
	}
	static public void RemoveLR() {
		MLB.setVisible(false);
		MRB.setVisible(false);
	}
	static public void viewResult() {
		RS = new Result_Screen(SS.getPSS(),WinInspection);
		GBB.add(RS);
		GBB.revalidate();
		GBB.repaint();
	}
	static public void ExpansionCard(String card) {
		ECS = new ExpansionCard_Screen(card);
		GBB.add(ECS);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(false);
	}
	static public void ExpansionCardRemove() {
		GBB.remove(ECS);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(true);
	}
	static public void OverlapImformation(ArrayList<JLabel> names) {
		OPI = new Overlap_Player_Imformation(names);
		GBB.add(OPI);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(false);
	}
	
	static public void RemoveOverlapImformation() {
		GBB.remove(OPI);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(true);
	}
	static public void OverlapScreen(ArrayList<JLabel> names) {
		OPS = new Overlap_Player_Screen(names);
		GBB.add(OPS);
		GBB.revalidate();
		GBB.repaint();
	}
	static public void RemoveOverlapScreen() {
		GBB.remove(OPS);
		GBB.revalidate();
		GBB.repaint();
	}
	static public void myTurnStart() {
		myTurn = true;
		RB.setEnabled(true);
		RB.addMouseListener(RB);
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		
	}
	static public void myTurnEnd() {
		FinishB.setEnabled(false);
		FinishB.removeMouseListener(FinishB);
		myTurn = false;
		phase2 = false;
		phase3 = false;
		BangCount = 0;
	
	}
	static public void onPhase2() {
		phase2 = true;
	}
	static public void onPhase3() {
		phase2 = false;
		phase3 = true;
	}
	static public void SemiTurnStart() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setBangmood();
	}
	static public void SemiFightStart() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setFightingmood();
	}
	static public void SemiDraw() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setVarietyStoremood();
	}
	static public void SemiTurnEnd() {
		System.out.println("세미턴 엔드");
		FinishB.setEnabled(false);
		FinishB.removeMouseListener(FinishB);
		if(isBangmood())
			setBangmood();
		if(isFightingmood())
			setFightingmood();
		if(isVarietyStoremood())
			setVarietyStoremood();
	}

	static public void Resume() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
	}
	static public boolean getMyTurn() {
		return myTurn;
	}
	static public boolean getPhase2() {
		return phase2;
	}
	static public boolean getPhase3() {
		return phase3;
	}
	static public boolean getChooseEnemy() {
		return ChooseEnemy;
	}
	static public void setChooseEnemy() {
		ChooseEnemy = !ChooseEnemy;
	}
	static public void cardRepaint() {
		CardS.repaint();
		CardS.revalidate();
	}
	static public void StoreRepaint() {
      UVS.repaint();
      UVS.revalidate();
   }
	static public void setAttackList(String Messege) {
		String[] words = Messege.split(":");
		for (int i = 1; i < words.length; i++) {
			AttackList.add(words[i]);
			
		}
		for(int i = 0; i<AttackList.size();i++)
			System.out.print("공격가능 : "+AttackList.get(i)+" ");
		
	}
	static public ArrayList<String> getAttackList() {
		return AttackList;
	}
	static public void setUserNum(int Num) {
		UserNum = Num;
	}
	static public int getUserNum() {
		return UserNum;
	}
	static public void setInfo(String name, String hp, String job) {
		IS.setProfile(name, hp, job);
		player_name=name;
		player_hp=hp;
	}
	static public void setInfo(String hp) {
		IS.setHP(hp);
	}
	static public void setTable(String table) {
		Player_Score_Screen[] PSS=SS.getPSS() ;
		String[] words = table.split(":");
		for(int i = 0; i < words.length/3;i++ ) {
			if(words[(i*3+1)].equals(player_name)&&!words[(i*3+2)].equals(player_hp))
				setInfo(words[(i*3)+2]);
			
			PSS[i].setPIF(words[(i*3)+1],words[(i*3)+2],words[(i*3)+3]);
			if(words[(i*3)+2].length()>1)
				Position_Screen.DieDelete(words[(i*3)+1]);
			
		}

		if(words.length==14) {
			System.out.println("16:"+words[words.length-2]+" + "+ words[words.length-1]);
			WinInspection=Integer.parseInt(words[words.length-1]);
		}
		else if(words.length==17) {
			System.out.println("16:"+words[words.length-2]+" + "+ words[words.length-1]);
			WinInspection=Integer.parseInt(words[words.length-1]);
		}
	}
	
	public static void gameEnd(Default_Frame DF) {
		viewResult();
		Commend.sleep(10000);
		SendServer.SendData(Default_Socket.getOutRoomInfo(), "End");
		Commend.sleep(100);
		Card_Screen.resetCard();
		
		new InRoom_UserInfo();
		new RoomInfo(DF);
		
		DF.getContentPane().removeAll();
		DF.add(new Room_Background(DF));
		DF.revalidate();
	}
	public static void verify() {
		UCS.setVisible(true);
	}
	public static void yes() {
		use = true;
	}
	public static void no() {
		use = false;
	}
	public static boolean getUse() {
		return use;
	}
	public static boolean isFightingmood() {
		return Fightingmood;
	}
	public static void setFightingmood() {
		Fightingmood = !Fightingmood;
	}
	public static boolean isVarietyStoremood() {
		return VarietyStoremood;
	}
	public static void setVarietyStoremood() {
	if(VarietyStoremood) {
      Use_VarietyStore_Screen.EndDraw();
	}
	  VarietyStoremood = !VarietyStoremood;
	  if(VarietyStoremood) {
		  Use_VarietyStore_Screen.StartDraw();
	  }
	 
      UVS.repaint();
      UVS.revalidate();
      System.out.println("작동한다.");								  
	}
	public static boolean isBangmood() {
		return Bangmood;
	}
	public static void setBangmood() {
		Bangmood = !Bangmood;
	}
	public static String getHP() {
		return player_hp;
	}
	public static void onUcs() {
		
		UCS.setVisible(true);
	}
	public static void offUcs() {
		UCS.setVisible(false);
	}
	public static Use_Card_Screen getUCS() {
		return UCS;
	}
	public static void CutSceen(String act) {
		if(act.equals("Bang")) {

			Bang_Screen BS = new Bang_Screen();

			GBB.add(BS);
			GBB.revalidate();
			GBB.repaint();
			new Thread(new GIF_Thread(GBB, BS, 2000)).start();
			
		}
		else if(act.equals("Beer")) {
			Beer_Screen BrS = new Beer_Screen();

			GBB.add(BrS);
			GBB.revalidate();
			GBB.repaint();
			new Thread(new GIF_Thread(GBB, BrS, 2000)).start();
		}
		else if(act.equals("Avoid")) {
			Avoid_Screen AS = new Avoid_Screen();

			GBB.add(AS);
			GBB.revalidate();
			GBB.repaint();
			new Thread(new GIF_Thread(GBB, AS, 2000)).start();
			
		}
			
	}
	public static String getPlayer_Name() {
		return player_name;
	}
	public static Weather_Screen getWS() {
		return WS;
	}
	
	public static void upBangCount() {
		BangCount++;
	}
	public static int getBangCount () {
		return BangCount;
	}
	public static void setWeapon(int weapon) {
	 Weapon = weapon;
	}
	public static int getWeapon() {
		return Weapon;
	}
	static public void SemiRollStart() {
		RB.setEnabled(true);
		RB.addMouseListener(RB);
	}
	public static void OnUVS() {
      UVS = new Use_VarietyStore_Screen();
      GBB.add(UVS);
      GBB.repaint();
      GBB.revalidate();
   }
   public static void OffUVS() {
      GBB.remove(UVS);
      GBB.repaint();
      GBB.revalidate();
   }
}
