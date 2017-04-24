package Map;
//je te montre comment ca marche
import java.awt.*;

public class Murs {
	
	private int sizewall = 50;
	private int sizemapH = 1000;
	private int sizemapL = 1000;
	
	public Murs(int sw,int sm){
		this.sizewall = sw;
		this.sizemapH = sm;
	}
	
	public void setSM(int sm){
		this.sizemapH = sm;
	}
	public void setSML(int sml){
		this.sizemapL = sml;
	}
	
	public int getSW(){
		return sizewall;
	}
	
	public void paint(Graphics g){
		int T = 0;
		int S = 0;
		while (sizemapH / sizewall > T - 1){
			g.setColor(Color.ORANGE);
			g.fillRect(0, sizewall*T, sizewall, sizewall);
			g.fillRect(sizemapL - sizewall, sizewall*T, sizewall, sizewall);
			g.setColor(Color.BLACK);
			g.drawRect(0, sizewall*T, sizewall, sizewall);
			g.drawRect(sizemapL - sizewall, sizewall*T, sizewall, sizewall);
			T++;
		}
		while (sizemapL / sizewall > S - 1){
			g.setColor(Color.ORANGE);
			g.fillRect(sizewall*S, 0, sizewall, sizewall);
			g.fillRect(sizewall*S, sizemapH - sizewall, sizewall, sizewall);
			g.setColor(Color.BLACK);
			g.drawRect(sizewall*S, 0, sizewall, sizewall);
			g.drawRect(sizewall*S, sizemapH - sizewall, sizewall, sizewall);
			S++;
		}
	}
	
}
