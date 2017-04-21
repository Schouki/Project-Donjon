package Jeu;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class HealPotion extends Potion {
	private int addLP;
	private Image img;
	private ImageIcon icon;
	private Personnage p;
	private int x,y;
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public HealPotion(){
		addLP = 100;
		this.x = 200;
		this.y = 200;
	}
	
	public HealPotion(int a, int x, int y){
		this.x = x;
		this.y = y;
		this.addLP = a;
	}
	
	public int Healing (){
		Random r = new Random();
		addLP = 1; //100 * r.nextInt(10);
			while (addLP == 0){
				addLP = 1; //100 * r.nextInt(10);
			}
		return addLP;
	}
	public Image getImg(){
		this.icon = new ImageIcon("decors/PotionInfo.png");
		this.img = icon.getImage();
		return img;
	}
	public void setImg(Image img){
		this.img = img;
	}
	public void Used(Personnage p){
		p.setVie(p.getVie() + Healing());
		p.AntiOverLife();
		int T = p.inv.getPlaces() - 1;
		while (T > 0 && !p.inv.getObj(T).equals(this)){
			T -= 1;
		}
		p.inv.addObj(p.inv.empty, T);
	}
}
