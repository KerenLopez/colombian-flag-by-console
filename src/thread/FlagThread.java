package thread;

import model.Flag;
import ui.FlagUI;

public class FlagThread extends Thread{
	
	private Flag newFlag;
	private FlagUI newFui;
	private int color;
	private long time;
	
	public FlagThread(Flag f, FlagUI fui, int c, long t) {
		newFlag = f;
		newFui = fui;
		color = c;
		time = t;
	}
	
	public void run() {
		if(color==43) {
			try {
				newFlag.advance(0, 0, color);
				sleep(time);
				newFui.showFlag();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(color==44) {
			try {
				newFlag.advance(0, 9, color);
				sleep(time);
				newFui.showFlag();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			try {
				newFlag.advance(0, 12, color);
				sleep(time);
				newFui.showFlag();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
