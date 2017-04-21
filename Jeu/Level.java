package Jeu;

import java.awt.*;

public class Level {
	
	private int xp;
	private int MaxXp = 100;
	private int level = 1;
	private Personnage p;
	
	public Level(Personnage p){
		this.p = p;
		this.xp = p.getXp();
	}
	public void Up(){
		if (level < 10){
			if (p.getXp() >= level*MaxXp){
				p.setMaxVie(p.getMaxVie() + 10);
				p.setForce(p.getForce() + 10);
				p.setXp(p.getXp() - level*MaxXp);
				level++;
			}
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(200, 85, 2*p.getXp()/level, 10);
		g.setColor(Color.GREEN);
		g.drawRect(200, 85, 2*MaxXp, 10);
	}
}
