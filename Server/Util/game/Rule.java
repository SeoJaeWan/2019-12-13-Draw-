package game;

import java.util.ArrayList;

import character.GameCharacter;

public class Rule {

	public static int endRule(ArrayList<GameCharacter> aliveJob) {
		boolean live1 = false;
		boolean live5 = false;
		boolean live3_4 = false ;
		ArrayList<GameCharacter> alive = aliveJob; 
		for (int i = 0; i < aliveJob.size(); i++) {
			if(alive.get(i).getJob() == 1)
				live1 = true;
			if(alive.get(i).getJob() == 3 || alive.get(i).getJob() == 4)
				live3_4 = true;
			if(alive.get(i).getJob() == 5)
				live5 = true;
		}
		
		
		if(live1 == false) {
			if(!live5 && !live3_4)
				return 1;
			else if(alive.size() == 1 && live5 == true)
				return 5;   // 보안관이 죽고, 배신자 혼자 살아남았을 경우 배신자 승리
			else{
				return 3;   // 아닐경우 무법자 승리
				
			}
		}
		else if(live5 == false && live3_4 == false)
			return 1;       // 무법자와 배신자가 모두 탈락할 경우 승리
		else
			return -1;      // 게임이 안끝났음
	}
	
	public static boolean deadRule(ArrayList<GameCharacter> aliveJob) {
		boolean live1 = false;
		boolean live3_4_5 = false;
		for (int i = 0; i < aliveJob.size(); i++) {
			if(aliveJob.get(i).getJob() == 1 && aliveJob.get(i).getHp() > 0)
				live1 = true;
			if((aliveJob.get(i).getJob() == 3 && aliveJob.get(i).getHp() > 0) || (aliveJob.get(i).getJob() == 4 && aliveJob.get(i).getHp() > 0)|| (aliveJob.get(i).getJob() == 5 && aliveJob.get(i).getHp() > 0))
				live3_4_5 = true;
		}
		if(live1 &&live3_4_5)
			return true;
		else
			return false;
	}
}
