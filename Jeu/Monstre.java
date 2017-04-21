package Jeu;

import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Monstre implements Runnable{
	
	private int vie;
	private int xpdrop;
	private int x, y;
	private int tir;
	private ImageIcon icon = new ImageIcon("decors/MonstreInfo.png");
	private Image img = icon.getImage();
	
	public Monstre(Personnage p, int waitTime) {
	}
	public Monstre(Personnage p, int waitTime, int v, int x) {
	}
	
	public int getTir(){
		return tir;
	}
	public void setTir(int tir){
		
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
		// TODO Auto-generated method stub
		
	}
	public void dommage(Personnage p){
		Random r = new Random();
		int c = 17 + r.nextInt(10);
		if (p.getVie() > 0){
			p.setVie(p.getVie() - c);
			if (p.getVie() < 0){
				p.setVie(0);
			}
			System.out.println(p.getVie());
		}
	}
	public Image getImg(){
		return img;
	}
}
