package Jeu;


public class Monstre1 extends Monstre{
	
	private int vie;
	private int xpdrop;
	private int x = 600, y = 600;
	private Personnage p;
	private int waitTime;
	private int xm = 0,  ym = 0;

	public Monstre1(Personnage p, int waitTime) {
		super(p, waitTime);
		vie = 100;
		xpdrop = 100;
		this.p = p;
		this.waitTime = waitTime;
	}
	public Monstre1(Personnage p, int waitTime, int v, int x) {
		super(p, waitTime, v, x);
		vie = v;
		xpdrop = x;
		this.waitTime = waitTime;
		this.p = p;
	}
	
	public int getMX(){
		return x;
	}
	public int getMY(){
		return y;
	}
	public void setMX(int x){
		this.x = x;
	}
	public void setMY(int y){
		this.y = y;
	}
	
	
	public int getVie(){
		return vie;
	}
	public void setVie(int v){
		vie = v;
	}
	
	public int getXp(){
		return xpdrop;
	}
	public void setXp(int x){
		xpdrop = x;
	}
	
	public void run() {
		while (vie > 0){
			if (vie <= 0){
				vie = 0;
			}
			if ( Math.abs(x - p.getX()) < 400 && Math.abs(y - p.getY()) < 400){
				if (x < p.getX() - 50){
					xm = 1;
				}
				if (x > p.getX() + 30){
					xm = -1;
				}
				if (y < p.getY() - 50){
					ym = 1;
				}
				if (y > p.getY() + 50){
					ym = -1;
				}
				if (p.getX() - 50 < x && x < p.getX() + 30){
					xm = 0;
				}
				if (p.getY() - 20 < y && y < p.getY() + 20){
					ym = 0;
				}
				x = x + xm;
				y = y + ym;
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
