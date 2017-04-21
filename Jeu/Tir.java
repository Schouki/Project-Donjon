package Jeu;

import Map.*;

public class Tir implements Runnable{
	
	private int waitTime = 0;
	private Personnage p;
	private Monstre m;
	private int tx = 0;
	private int x = 0;
	private int y = 0;
	
	public Tir (Personnage p, Monstre m, int waitTime){
		this.waitTime = waitTime;
		this.p = p;
		this.m = m;
	}
	
	public void run() {
		while (Math.abs(tx) <= 500 || m.getTir() == 1){
			if (p.getX() < m.getMX()){
				tx --;
			}
			if (p.getX() > m.getMX()){
				tx ++;
			}
			y = m.getMY();
			if (m.getTir() == 1){
				x = m.getMX() + tx;
			}
			if (m.getTir() != 1 || Math.abs(tx) == 500){
				m.setTir(0);
				tx = 0;
				x = m.getMX();
			}
			if (m.getMX() + tx > p.getX() && m.getMX() + tx < p.getX() + 30 && m.getMY() < p.getY() + 50 && m.getMY() > p.getY() && m.getMY() < p.getY() + 50 && m.getTir() == 1 && p.getVie() > 0){
				m.setTir(0);
				tx = 0;
				x = m.getMX();
				m.dommage(p);
			}
			if (p.getVie() <= 0){
				p.setVie(0);
			}
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}

}
