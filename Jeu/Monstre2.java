package Jeu;

import java.util.Random;

import Jeu.*;

public class Monstre2 extends Monstre{

	private int vie;
	private int xpdrop;
	private int x = 700, y = 700;
	private Personnage p;
	private int waitTime;
	private int xm = 0,  ym = 0;
	private int tir = 0;
	
	public Monstre2(Personnage p, int waitTime) {
		super(p, waitTime);
		vie = 200;
		xpdrop = 100;
		this.p = p;
		this.waitTime = waitTime;
	}
	public Monstre2(Personnage p, int waitTime, int v, int x) {
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
	
	public int getTir(){
		return tir;
	}
	public void setTir(int t){
		tir = t;
	}
	
	
	public void run() {
		while (vie > 0){
			if (vie <= 0){
				vie = 0;
			}
			if ( Math.abs(x - p.getX()) < 400 && Math.abs(y - p.getY()) < 400){
				while (tir == 1){
					xm = 0;
					ym = 0;
				}
				if (x < p.getX() - 250){
					xm = 1;
				}
				if (x > p.getX() + 230){
					xm = -1;
				}
				if (y < p.getY() - 20){
					ym = 1;
				}
				if (y > p.getY()){
					ym = -1;
				}
				if (p.getX() - 250 < x && x < p.getX() + 230){
					xm = 0;
				}
				if (p.getY() + 40 > y && y > p.getY()){
					ym = 0;
				}
				if (p.getX() - 250 < x && x < p.getX() + 230 && p.getY() + 40 > y && y > p.getY()){
					tir = 1;
				}
				else {
					tir = 0;
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
