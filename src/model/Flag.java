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
	
	public void advance(int x, int y, int color) {
		colombianFlag = ESC+"0G"+ESC+"0d";
		//colombianFlag = ESC+"<"+y+">;<"+x+"> f ";
		//colombianFlag = ESC+"2J ";
		if(y==0) {
			while(y<(height-10)) {
				int cont = x;
				while(cont<width) {
					colombianFlag += ESC+color+"m ";
					cont+=1;
					colombianFlag += ESC+"<"+cont+"> G ";
				}
				y+=1;
				colombianFlag += ESC+"<"+y+"> B ";
			}
		}else{
			while((height-15)<y) {
				int cont = x;
				while(cont<width) {
					colombianFlag += ESC+color+"m ";
					cont+=1;
					colombianFlag += ESC+"<"+cont+"> G ";
				}
				y-=1;
				colombianFlag += ESC+"<"+y+"> B ";
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
