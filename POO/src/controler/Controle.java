package controler;

import java.awt.Dimension;

import vue2.LancePartie;

public class Controle {
	private static Dimension size = new Dimension(800,700);
	public static void main(String[] args){
		
		
		LancePartie part = new LancePartie(size);
		part.affichage();
	}
	
}
