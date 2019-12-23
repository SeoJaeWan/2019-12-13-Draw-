package gameCharacter_Screen;

import java.util.ArrayList;

import javax.swing.JPanel;

import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Move_Screen;
import Util.Dice_GIF_Thread;
import Util.GIF_Thread;
import position_Imformation.Tile_Position;

//!
public class Position_Screen extends JPanel {
	// 처음 캐릭터 위치 선택하는 클래스

	private static ArrayList<Position> p;
	private static boolean many = false;
	public static ArrayList<Tile_Position> TP = new ArrayList<Tile_Position>();
	private static GameBaord_Background GBB;
	public Position_Screen(GameBaord_Background GBB) {
		this.GBB = GBB;
		p = new ArrayList<Position>();
		p.add(new Position(483, 55, 0));
		p.add(new Position(982, 273, 1));
		p.add(new Position(770, 710, 2));
		p.add(new Position(217, 703, 3));
		p.add(new Position(25, 242, 4));

		for (int i = 0; i < 5; i++) {
			TP.add(new Tile_Position(i * 6, new Character_Imformation()));
		}

		setLayout(null);
		setVisible(true);
		setBounds(230, 0, 1136, 918);
		setOpaque(false);

		for (int i = 0; i < 5; i++) {

			add(TP.get(i));
			add(p.get(i));
		}
	}

	public static void moveUp(String name, String rollR, int size, int position) throws InterruptedException {
		
		Move_Screen MS = new Move_Screen();

		Position_Screen.GBB.add(MS);
		Position_Screen.GBB.revalidate();
		Position_Screen.GBB.repaint();
		new Thread(new GIF_Thread(Position_Screen.GBB, MS, 2000)).start();

		ArrayList<Integer> names = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			System.out.println(i+"번째 TP검사");
			if (TP.get(i).getCI().getName().equals(name)) {
				int beforePosition = TP.get(i).getPosition();
				TP.get(i).getCI().Person();
				TP.get(i).setPosition(position);

				for (int j = 0; j < Integer.parseInt(rollR); j++) {
					if (TP.get(i).getCI().getTileNum() == 29) {
						TP.get(i).setTP(0);
						TP.get(i).getCI().setTileNum(0);
						Thread.sleep(500);
					} else {
						TP.get(i).setTP(TP.get(i).getCI().getTileNum() + 1);
						TP.get(i).getCI().setTileNum(TP.get(i).getCI().getTileNum() + 1);
						// System.out.println(TP[i].getCI().getName()+"가
						// 움직였습니다."+TP[i].getCI().getTileNum());
						Thread.sleep(500);
					}

				}

				checkUser(size, position, name, names, i, beforePosition);
				break;
			}

		}
	}

	public static void moveDown(String name, String rollR, int size, int position) throws InterruptedException {

		
		Move_Screen MS = new Move_Screen();

		Position_Screen.GBB.add(MS);
		Position_Screen.GBB.revalidate();
		Position_Screen.GBB.repaint();
		new Thread(new GIF_Thread(Position_Screen.GBB, MS, 2000)).start();
		
		ArrayList<Integer> names = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			System.out.println(TP.get(i).getCI().getName());
			if (TP.get(i).getCI().getName().equals(name)) {
				int beforePosition = TP.get(i).getPosition();
				TP.get(i).getCI().Person();
				TP.get(i).setPosition(position);

				for (int j = 0; j < Integer.parseInt(rollR); j++) {
					if (TP.get(i).getCI().getTileNum() == 0) {
						TP.get(i).setTP(29);
						TP.get(i).getCI().setTileNum(29);
						Thread.sleep(500);
					} else {
						TP.get(i).setTP(TP.get(i).getCI().getTileNum() - 1);
						TP.get(i).getCI().setTileNum(TP.get(i).getCI().getTileNum() - 1);
						Thread.sleep(500);
					}
				}

				checkUser(size, position, name, names, i, beforePosition);
				break;
			}

		}
	}

	public static void checkUser(int size, int position, String name, ArrayList<Integer> names, int index,
			int beforePosition) {
		// 타일에 유저가 겹쳐있는지 확인하고 겹쳐있으면 이미지 변경

		TP.get(index).getCI().setName(name);

		for (int i = 0; i < TP.size(); i++) {
			if (TP.get(i).getPosition() == beforePosition) {
				TP.get(i).getCI().removeName(name);
			}
		}

		if (size >= 2) {
			for (int j = 0; j < TP.size(); j++) {
				if (TP.get(j).getPosition() == position) {
					TP.get(j).getCI().People(size);
					if (!TP.get(j).getCI().getName().equals(name)) {
						TP.get(j).getCI().addName(name);
						names.add(j);
						TP.get(j).getCI().setMany();
					}
				}
			}
			for (int k = 0; k < names.size(); k++) {
				TP.get(index).getCI().addName(TP.get(names.get(k)).getCI().getName());
			}
			TP.get(index).getCI().setMany();// 여기 건들여따
		}

		TP.get(index).getCI().repaints();
	}

	static public void ChoosePosition(String name, String HP, String positionSt) {
		// Character_Imformation CI = null;
		int position = Integer.parseInt(positionSt);
		TP.get(position / 6).setPosition(position);
		TP.get(position / 6).getCI().setTileNum(position);
		TP.get(position / 6).getCI().setName(name);
		// CI = TP[position / 6].getCI();
		p.get(position / 6).use();

		// CI.setTileNum(position);
//		CI.setHp(HP);
		// CI.setName(name);
		// TP[position / 6].setCI(CI);
		TP.get(position / 6).getCI().Person();
		// TP[position/6].getCI().setOnCIB();
		TP.get(position / 6).setTP(position);
		TP.get(position / 6).getCI().setVisible(true);
		TP.get(position / 6).getCI().repaints();
	}

	static public void MyPosition() {

		for (int i = 0; i < 5; i++) {
			if (p.get(i).getSET())
				p.get(i).addMouseListener(p.get(i));
		}
	}

	static public void NoPosition() {

		for (int i = 0; i < 5; i++) {
			p.get(i).removeMouseListener(p.get(i));
		}
	}

	static public void addListener(int num) {
		if (num == 1) {
			ArrayList<String> ATL = GameBaord_Background.getAttackList();
			for (int a = 0; a < ATL.size(); a++)
				System.out.println(ATL.get(a).toString());
			for (int i = 0; i < TP.size(); i++) {
				for (int j = 0; j < ATL.size(); j++) {
					System.out.println(TP.get(i).getCI().getName() + " " + ATL.get(j) + " "
							+ TP.get(i).getCI().getName().equals(ATL.get(j)));
					if (TP.get(i).getCI().getName().equals(ATL.get(j))) {
						System.out.println("실행됨");
						if (!many)
							TP.get(i).getCI().setOnCIB();
					} else {
						TP.get(i).getCI().setONCSI();
					}

				}

			}

		} else
			for (int i = 0; i < TP.size(); i++) {
				TP.get(i).getCI().setOnCIB();
				TP.get(i).getCI().setONCSI();
			}
	}

	static public void removeListener() {
		ArrayList<String> ATL = GameBaord_Background.getAttackList();
		for (int i = 0; i < TP.size(); i++) {
			if (!many) {
				TP.get(i).getCI().setOffCIB();
			} else {
				TP.get(i).getCI().setOffCSI();
			}
		}

	}

	public static boolean getmany() {
		return many;
	}

	public static void setmany() {
		many = !many;
	}

	public static void DieDelete(String name) {
		// 가제목 니들이 바꿔서 쓰셈
		// 이름은 뒤진 세끼 이름
		for (int i = 0; i < TP.size(); i++) {

			Character_Imformation CI = TP.get(i).getCI();

			if (CI.getName().equals(name)) {
				TP.get(i).setVisible(false);
				TP.remove(i);
			} else
				CI.removeName(name);
		}
	}

}
