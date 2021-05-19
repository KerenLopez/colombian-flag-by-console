package ui;

import model.Flag;
import thread.FlagThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int yellow = 43;
		int blue = 44;
		//int red = 41;
		int height = 16;
		int width = 126;
		Flag f = new Flag(height, width);
		FlagUI fui = new FlagUI(f);
		FlagThread thread1 = new FlagThread(f, fui, yellow, 1000);
		FlagThread thread2 = new FlagThread(f, fui, blue, 2500);
		//FlagThread thread3 = new FlagThread(f, fui, red, 5000);
		thread1.start();
		thread2.start();
		//thread3.start();
		//System.out.println(f.getColombianFlag());
	}

}
