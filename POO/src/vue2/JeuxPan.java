package vue2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

public abstract class JeuxPan{
	
	protected JPanel panel;
	public static Fenetre frame = new Fenetre();
	public JeuxPan(Dimension dim){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.gray);
		
	}
	
	protected JPanel getPanel(){
		return this.panel;
	}
	
	protected abstract void initPanel();	
	
}