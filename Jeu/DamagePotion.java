package Jeu;

import java.awt.Image;
import java.util.Random;

public class DamagePotion extends Potion{

	private int addDM;
	private Image img; 
	
	public int Healing (){
		Random r = new Random();
		addDM = 100 * r.nextInt(10);
			while (addDM == 0){
				addDM = 100 * r.nextInt(10);
			}
		return addDM;
	}

	public String getColor(){
		this.color = "RED";
		return color;
	}
	public Image getImg(){
		return img;
	}
	public void setImg(Image img){
		this.img = img;
	}
	public void Used(Personnage p){
		p.setForce(p.getForce() + Healing());
	}
}