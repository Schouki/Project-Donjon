package Jeu;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import Contrôles.*;
import Map.Plateau;


public class Inventaire extends JPanel implements KeyListener, ActionListener{
	private int places;
	public static Item empty = new Empty();
	private int X = 135,Y = 120;
	private ArrayList<Item> inv = new ArrayList<Item>();
	private int X1 = 0, Y1 = 0;
	private int Open = 0;
	private boolean use = false;
	
	Timer t = new Timer(100,this);
	
	public int getX(){
		return X;
	}
	public void setX(int X){
		this.X = X;
	}
	public int getY(){
		return Y;
	}
	public void setY(int Y){
		this.Y = Y;
	}
	
	public int getPlaces(){
		return places;
	}
	public void setPlaces(int p){
		if (p > 36){
			p = 36;
		}
		places = p;
	}
	public ArrayList<Item> getInv(){
		return inv;
	}
	public void setInv(Item i){
		inv.add(i);
	}
	
	public Inventaire(){
		t.start();
		places = 10;
		for (int i = 0; i <= places - 1; i++){
			inv.add(empty);
		}
	}
	public Inventaire(int p){
		t.start();
		places = p;
		for (int i = 0; i <= places - 1; i++){
			inv.add(empty);
		}
	}

	public boolean Emplacement(Item i){
		boolean vide = true;
		if (i.equals(empty)){
			vide = false;
		}
		return vide;
		
	}
	public Item getObj(int p){
		return inv.get(p);
	}
	
	public void setObj(Item i){
		int p = 0;
		while (Emplacement(inv.get(p)) == true && inv.get(places - 1).equals(empty)){
			p++;
		}
		inv.set(p, i);
	}
	
	public void addObj(Item i, int p){
		inv.set(p, i);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(110, 100, 750, 740);
		int T = 0;
		int S = 0;
		int y = 120;
		int x = 135;
		g.setColor(Color.GRAY);
		while (T < places){
			if (135 + (S*120) > 739){
				y += 120;
				S = 0;
			}
			g.fillRect(x + (S*120), y, 100, 100);
			g.drawImage(inv.get(T).getImg(), x + (S*120), y, 100, 100, null);
			if (X == x + S*120 && Y == y && use == true){
				inv.get(T).Used(Plateau.p);
			}
			S++;
			T++;
		}
		g.setColor(Color.YELLOW);
		g.drawRect(X, Y, 100, 100);
		
	}
	
	public boolean getUse(){
		return use;
	}
	public void setUse(boolean use){
		this.use = use;
	}
	
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_P){
			use = true;
			System.out.println(Plateau.p.getVie());
		}
		if (c == KeyEvent.VK_I){
			Open += 1;
			if (Open > 1){
				Open = 0;
			}
		}
		if (Open == 1){
			if (c == KeyEvent.VK_Z){
				Y1 = - 120;
			}
			if (c == KeyEvent.VK_S){
				Y1 = 120;
			}
			if (c == KeyEvent.VK_Q){
				X1 = - 120;
			}
			if (c == KeyEvent.VK_D){
				X1 = 120;
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		X1 = 0;
		Y1 = 0;
		
	}
	public void keyTyped(KeyEvent e) {
		int c = e.getKeyCode();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (X < 135){
			X1 = 0;
			X = 135;
		}
		if (Y < 120){
			Y1 = 0;
			Y = 120;
		}
		if (X > 744){
			X1 = 0;
			X = 135;
		}
		if (Y > 729){
			Y1 = 0;
			Y = 120;
		}
		X += X1;
		Y += Y1;
		
	}
}
