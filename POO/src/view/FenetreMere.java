package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreMere extends JFrame {

	public FenetreMere(String parTitre) {
		super();
		//PanelCase panelTest = new PanelCase(Color.red);
		PanelDames panelTest = new PanelDames();
		//panelTest.setBackground(Color.blue);

		this.setContentPane(panelTest);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLocation(200, 200);
	}
	
	public static void main(String []args){
		FenetreMere maFenetre = new FenetreMere("OMG CE JEU DE FOU");
	}
}