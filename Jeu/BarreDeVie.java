package Jeu;

import java.awt.*;
import javax.swing.*;

public class BarreDeVie extends JPanel {
	private Personnage p = new Personnage();
	private int h,l;
	
	public void setH(int h){
		this.h = h;
	}
	
	public void setL(int l){
		this.l = l;
	}
	
	public BarreDeVie(Personnage p){
		this.p = p;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(h, l, 2*p.getVie(), 10);
	}
}
