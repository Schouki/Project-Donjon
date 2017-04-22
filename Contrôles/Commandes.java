package Contrôles;

import java.awt.event.*;
import javax.swing.*;

import Jeu.*;
import Map.*;

public class Commandes extends JPanel implements KeyListener, ActionListener {
	private int x1 = 0; 
	private int y1 = 0;
	private Personnage p;
	private Monstre m;
	private Item potion;
	private int H = 1000,L = 1000;
	private Murs wall;
	
	Timer tm = new Timer(10, this);
	
	public Commandes(Personnage p, Monstre m, Item potion, Murs wall){
		tm.start();
		this.p = p;
		this.m = m;
		this.potion = potion;
		this.wall = wall;
	}
	
	public void setH(int H){
		this.H = H;
	}
	
	public void setL(int L){
		this.L = L;
	}
	
	public void actionPerformed(ActionEvent e){
		if (p.getX() < wall.getSW()){
			x1 = 0;
			p.setX(wall.getSW());
		}
		if (p.getY() < wall.getSW()){
			y1 = 0;
			p.setY(wall.getSW());
		}
		if (p.getX() > L - 30 - wall.getSW()){
			x1 = 0;
			p.setX(L - 30 - wall.getSW());
		}
		if (p.getY() > H - 50 - wall.getSW()){
			y1 = 0;
			p.setY(H - 50 - wall.getSW());
		}
		p.setX(p.getX() + x1);
		p.setY(p.getY() + y1);
		if (p.getY() == potion.getY()){
			p.inv.setObj(potion);
			System.out.println(p.inv.getInv());
		}
		finalDraw();
	}
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_UP){
			y1 = - 1;
			//x1 = 0;
		}
		if (c == KeyEvent.VK_DOWN){
			y1 = 1;
			//x1 = 0;
		}
		if (c == KeyEvent.VK_LEFT){
			x1 = - 1;
			//y1 = 0;
		}
		if (c == KeyEvent.VK_RIGHT){
			x1 = 1;
			//y1 = 0;
		}
		if (c == KeyEvent.VK_I){
			p.setOpen(p.getOpen() + 1);
			if (p.getOpen() > 1){
				p.setOpen(0);
			}
		}
		if (c == KeyEvent.VK_SPACE){
			p.setHit(1);
			p.épée(m);
		}
		if (c == KeyEvent.VK_T){
			p.setTir(1);
		}
		/*if (c == KeyEvent.VK_P){
			p.inv.setUse(true);
			p.setXp(p.getXp() + 120);
			//potion.Used(p);
			System.out.println(p.getVie());
		}*/
	}
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_UP || c == KeyEvent.VK_DOWN){
			y1 = 0;
		}
		if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT){
			x1 = 0;
		}
		p.setHit(0);
		p.inv.setUse(false);
	}
	public void keyTyped(KeyEvent e) {
		int c = e.getKeyCode();
		// TODO Auto-generated method stub
		
	}
	
	public void finalDraw(){
		Main.window.repaint();
	}

}
