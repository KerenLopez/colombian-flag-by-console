package thread;

import model.Flag;
import ui.FlagUI;

public class FlagThread extends Thread{

	private Flag newFlag;
	private FlagUI newFui;
	private int color;

	public FlagThread(Flag f, FlagUI fui, int c) {
		newFlag = f;
		newFui = fui;
		color = c;
	}

	public void run() {
		int ct1 = 0, ct2 = 0, x = 0, y = 0, sleep = 10;
		if(color==43) {
			synchronized(newFui) {
				newFlag.resetScreen();
				newFui.showFlag();	
			}
			try {
				synchronized(newFui) {
					newFlag.resetPosition1();
					newFui.showFlag();	
				}
				while(newFlag.getWidth()>x) {
					ct1 = 0;
					ct2 = 0;
					while(ct1<((newFlag.getHeight())-8)) {
						synchronized(newFui) {
							newFlag.resetPosition2(x,ct1);
							newFui.showFlag();
							newFlag.goDown(color);
							newFui.showFlag();
						}
						Thread.sleep(sleep);
						ct1++;
					}
					if(x<newFlag.getWidth()) {
						while(ct2<8) {
							synchronized(newFui) {
								newFlag.resetPosition2(x,ct2);
								newFui.showFlag();
								newFlag.goUp();
								newFui.showFlag();	
							}	
							ct2++;
						}	
						synchronized(newFui) {
							newFlag.resetPosition2(x,y);
							newFui.showFlag();
							newFlag.goRight();
							newFui.showFlag();	
							y++;
						}
					}
					x++;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(color==44) {
			x = 0;
			y = 7;
			sleep = 25;
			try {
				advance(x,y,ct1,ct2,sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			x = 0;
			y = 11;
			sleep = 30;
			try {
				advance(x,y,ct1,ct2,sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	

	}

	public void advance(int x, int y, int ct1, int ct2, int sleep) throws InterruptedException {
		int cy = y;
		newFlag.resetPosition2(x,y);
		newFui.showFlag();	
		while(newFlag.getWidth()>x) {
			ct1 = 0;
			ct2 = 0;
			while(ct1<((newFlag.getHeight())-12)) {
				synchronized(newFui) {
					newFlag.resetPosition2(x,y);
					newFui.showFlag();
					newFlag.goDown(color);
					newFui.showFlag();
					y++;
				}
				Thread.sleep(sleep);
				ct1++;				
			}
			y = cy;
			if(x<((newFlag.getWidth())-1)) {
				while(ct2<4) {
					synchronized(newFui) {
						newFlag.resetPosition2(x,y);
						newFui.showFlag();
						newFlag.goUp();
						newFui.showFlag();	
					}	
					ct2++;
				}
				synchronized(newFui) {
					newFlag.resetPosition2(x,y);
					newFui.showFlag();
					newFlag.goRight();
					newFui.showFlag();
					y++;
				}
			}
			x++;	
		}
	}
}
