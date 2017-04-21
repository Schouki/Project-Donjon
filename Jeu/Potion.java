package Jeu;
public class Potion extends Item {
	protected String color;
	
	public String getColor (){
		return this.color;
	}
	
	public void OneUse (Potion p){
		p = null;
	}
	public void Used(Personnage p){
		
	}
}