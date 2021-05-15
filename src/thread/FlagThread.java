package thread;

import model.Flag;

public class FlagThread extends Thread{
	
	private Flag newFlag;
	private int color;
	private long time;
	
	public FlagThread(Flag f, int c, long t) {
		newFlag = f;
		color = c;
		time = t;
	}
	
	public void run() {
		if(color==43) {
			newFlag.advance(0, 0, color);
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(color==44) {
			newFlag.advance(0, 11, color);
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			newFlag.advance(0, 16, color);
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
