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
	
	public void advance(int x, int y, int color) throws InterruptedException {
		int ct1 = 0;
		int ct2 = 0;
		int width = 110;
		int sleep = 10;
		System.out.print(ESC+"2J");
		if(y==0) {
			System.out.print(ESC+"0G"+ESC+"0d");
			while(width>x) {
				ct1 = 0;
				ct2 = 0;
				while(ct1<(height-7)) {
					System.out.print(ESC+color+"m ");
					System.out.print(ESC+"B");
					System.out.print(ESC+"D");
					Thread.sleep(sleep);
					ct1++;
				}
				if(x<(width-1)) {
					while(ct2<9) {
						System.out.print(ESC+"A");
						Thread.sleep(sleep);
						ct2++;
					}
					System.out.print(ESC+"C");
					Thread.sleep(sleep);
				}
				x++;
			}
		}else{
			System.out.print(ESC+x+"G"+ESC+y+"d");
			while(width>x) {
				ct1 = 0;
				ct2 = 0;
				while(ct1<(height-12)) {
					System.out.print(ESC+color+"m ");
					System.out.print(ESC+"B");
					System.out.print(ESC+"D");
					Thread.sleep(sleep);
					ct1++;
				}
				if(x<(width-1)) {
					while(ct2<9) {
						System.out.print(ESC+x+"G"+ESC+y+"d");
						System.out.print(ESC+"A");
						Thread.sleep(sleep);
						ct2++;
					}
					System.out.print(ESC+x+"G"+ESC+y+"d");
					System.out.print(ESC+"C");
					Thread.sleep(sleep);
				}
				x++;
			}
		}
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
