package Jeu;
import java.util.Random;
import Map.*;

public class Personnage {
	private int vie;
	private int xp;
	private int force;
	private int x;
	private int y;
	private int hit = 0;
	private int tir = 0;
	private int open = 0;
	private int maxVie;
	public Inventaire inv = new Inventaire(36);
	
	
	public Personnage(){
		x = 100;
		y = 100;
		vie = 100;
		xp = 0;
		force = 20;
		maxVie = 100;
	}
	public Personnage(int v, int xp, int f, int x, int y, int m){
		vie = v;
		this.xp = xp;
		force = f;
		this.x = x;
		this.y = y;
		maxVie = m;
	}
	
	
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public int getVie(){
		return vie;
	}
	public void setVie(int v){
		vie = v;
	}
	public int getMaxVie(){
		return maxVie;
	}
	public void setMaxVie(int maxVie){
		this.maxVie = maxVie;
	}
	public void AntiOverLife(){
		if (vie >= maxVie){
			vie = maxVie;
		}
	}
	
	public int getXp(){
		return xp;
	}
	public void setXp(int x){
		xp = x;
	}
	
	public int getForce(){
		return force;
	}
	public void setForce(int f){
		force = f;
	}
	public int getHit(){
		return hit;
	}
	public void setHit(int h){
		hit = h;
	}
	public int getTir(){
		return tir;
	}
	public void setTir(int t){
		tir = t;
	}
	
	public int getOpen(){
		return open;
	}
	public void setOpen(int open){
		this.open = open;
	}
	
	public void dommage(Monstre m){
		Random r = new Random();
		int c = 17 + r.nextInt(10);
		if (m.getVie() > 0){
			m.setVie(m.getVie() - c);
			if (m.getVie() < 0){
				m.setVie(0);
			}
			System.out.println(m.getVie());
		}
	}
	public void épée(Monstre m){
		if (m.getMX() <= x + 60 && m.getMX() + 50 >= x + 30 && m.getMY() <= y + 30 && m.getMY() + 50 >= y + 20){
			dommage(m);
		}
	}
}
