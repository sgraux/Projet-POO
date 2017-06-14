package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCase extends JPanel{
	
	private Color couleur;
	
	public PanelCase(Color parCouleur){
		couleur = parCouleur;
		this.setSize(new Dimension(30,30));
	}
	
	public void paintComponent(Graphics g){//Méthode qui s'éxécute pour colorier
		g.setColor(couleur);
		g.fillOval(10, 10, 20, 20);
	}

}
