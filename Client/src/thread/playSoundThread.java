package thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class playSoundThread implements Runnable{
	public playSoundThread() {
		new Thread(this).start();
	}
	public void run() {
		while(true){
				FileInputStream fis;
				try {
					Player playMp3;
					playMp3 = new Player(getClass().getResourceAsStream("/Music/OST.mp3"));
					playMp3.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
		}
		
	}
}
