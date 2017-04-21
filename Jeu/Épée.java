package Jeu;

import java.awt.*;

public class �p�e extends Equipment {
	
	private int bonusF;
	private int bonusV;
	private static Image img;
	
	public �p�e(){
		this.bonusF = 30;
		this.bonusV = 100;
	}
	
	public �p�e(int f, int v){
		this.bonusF = f;
		this.bonusV = v;
	}
	
	public void Used(Personnage p){
		p.setForce(p.getForce() + bonusF);
		p.setMaxVie(p.getMaxVie() + bonusV);
		p.setVie(p.getVie() + bonusV);
	}
}
