package ui;

import model.Flag;
import thread.FlagThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int yellow = 43;
		int blue = 44;
		//int red = 41;
		int height = 20;
		int width = 126;
		Flag f = new Flag(height, width);
		FlagThread thread1 = new FlagThread(f, yellow, 0);
		FlagThread thread2 = new FlagThread(f, blue, 2500);
		//FlagThread thread3 = new FlagThread(f, red, 5000);
		thread1.start();
		thread2.start();
		//thread3.start();
		thread1.join();
		thread2.join();
		//thread3.join();
		System.out.println(f.getColombianFlag());
	}

}
