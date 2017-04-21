package Map;

import java.awt.*;

public class Sol {
	
	private int caseSize = 90;
	private int H;
	private int L;
	private Murs wall;
	
	public Sol(Murs wall){
		this.wall = wall;
	}
	public void setH(int H){
		this.H = H;
	}
	public void setL(int L){
		this.L = L;
	}
	
	public void paint(Graphics g){
		int T = 0;
		int S = 0;
		while (L / caseSize > S - 1){
			while (H / caseSize > T - 1){
				g.setColor(Color.BLACK);
				g.fillRect(wall.getSW() + 2*S*caseSize,wall.getSW() + 3*T*caseSize, caseSize, caseSize);
				g.setColor(Color.BLACK);
				g.drawRect(wall.getSW() + S*caseSize, wall.getSW() + T*caseSize, caseSize, caseSize);
				T++;
			}
			S++;
			T = 0;
		}
	}
}
