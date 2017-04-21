package Jeu;

import java.awt.*;

public class Épée extends Equipment {
	
	private int bonusF;
	private int bonusV;
	private static Image img;
	
	public Épée(){
		this.bonusF = 30;
		this.bonusV = 100;
	}
	
	public Épée(int f, int v){
		this.bonusF = f;
		this.bonusV = v;
	}
	
	public void Used(Personnage p){
		p.setForce(p.getForce() + bonusF);
		p.setMaxVie(p.getMaxVie() + bonusV);
		p.setVie(p.getVie() + bonusV);
	}
}
