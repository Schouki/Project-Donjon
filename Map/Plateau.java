package Map;

import javax.swing.*;
import javax.swing.text.View;

import Contrôles.*;
import java.awt.*;

import Jeu.*;

public class Plateau extends JPanel{

	private ImageIcon icon1, icon3;
	private Image img1, img3;
	private Murs wall = new Murs(50, getHeight());
	public static Personnage p = new Personnage();
	private Monstre m1 = new Monstre1(p,100);
	private Monstre m = new Monstre2(p,50);
	private Tir T = new Tir(p,m,5);
	private Item potion = new HealPotion();
	private Commandes com = new Commandes(p, m, potion, wall);
	private BarreDeVie barre = new BarreDeVie(p);
	private Sol sol = new Sol(wall);
	private Level level = new Level(p);

	
	Thread t = new Thread(m);
	Thread tt = new Thread(T);
	Thread ttt = new Thread(m1);
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//System.out.println(p.inv.getUse());
		
		com.setH(getHeight());
		com.setL(getWidth());
		
		sol.setH(getHeight());
		sol.setL(getWidth());
		sol.paint(g);
		
		wall.setSML(getWidth());
		wall.setSM(getHeight());
		wall.paint(g);
		
		barre.setH(200);
		barre.setL(70);
		barre.paintComponent(g);
		
		level.Up();
		level.paint(g);
		
		icon1 = new ImageIcon("decors/PersoInfo.png");
		img1 = icon1.getImage();
		g.drawImage(img1, p.getX(), p.getY(), 30, 50, null);
		
		if (m.getVie() > 0){
			g.drawImage(m.getImg(), m.getMX(), m.getMY(), 50, 50, null);
		}
		if (m1.getVie() > 0){
			g.drawImage(m1.getImg(), m1.getMX(), m1.getMY(), 50, 50, null);
		}
		icon3 = new ImageIcon("decors/PersoInfo.png");
		img3 = icon3.getImage();
		g.drawImage(potion.getImg(), potion.getX(), potion.getY(), 25, 30, null);
		
		g.setColor(Color.CYAN);
		
		if (p.getOpen() == 1){
			p.inv.paintComponent(g);
		}
		if (p.getHit() == 1){
			g.fillRect(p.getX() + 30, p.getY() + 20, 30, 10);
		}
		if (m.getTir() == 1){
			g.fillRect(T.getX(), T.getY(), 10, 10);
		}
	}
	public Plateau(){
		t.start();
		tt.start();
		ttt.start();
		this.addKeyListener(p.inv);
		this.addKeyListener(com);
		this.setFocusable(true);
	}
	
	public void redraw(){
		this.redraw();
	}
}