package model;


public class Flag {
	
	private String colombianFlag;
	private int height;
	private int width;
	public final static String ESC = "\u001b[";
	
	public Flag(int h, int w) {
		height = h;
		width = w;
		colombianFlag = "";
	}
	
	public void goDown(int color) {
		colombianFlag = ESC+color+"m "+ESC+"B"+ESC+"D";
	}
	
	public void goUp() {
		colombianFlag = ESC+"A";
	}
	
	public void goRight() {
		colombianFlag = ESC+"C";
	}
	
	public void resetScreen() {
		colombianFlag = ESC+"2J";
	}
	
	public void resetPosition1() {
		colombianFlag = ESC+"0G"+ESC+"0d";
	}
	
	public void resetPosition2(int x, int y) {
		colombianFlag = ESC+x+"G"+ESC+y+"d";
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getColombianFlag() {
		return colombianFlag;
	}
}
