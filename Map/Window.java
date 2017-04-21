package Map;

import javax.swing.*;


public class Window extends JFrame{
	private Plateau p = new Plateau();
	
	public Window(String i){
		setTitle(i);
		setSize(1000,1000);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		add(p);
	}
	public void update(){
		this.p.redraw();
	}

}
