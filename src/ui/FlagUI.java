package ui;

import model.Flag;

public class FlagUI {
	
	private Flag flag;
	
	public FlagUI(Flag f) {
		flag = f;
	}
	
	public void showFlag() {
		System.out.print(flag.getColombianFlag());
	}
}
