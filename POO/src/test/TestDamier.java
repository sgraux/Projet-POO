package test;

import java.util.ArrayList;
import java.util.Iterator;

import uidelegate.Case;
import uidelegate.DamierDameChinoise;

public class TestDamier {
	
	public static void main(String []args){
		
		DamierDameChinoise damier = new DamierDameChinoise();
		damier.initialiseCouleur(2);
		/*ArrayList<Case> liste = damier.listeCaseBleu();
		Iterator iterateur = liste.iterator();
		Case caseTemp;
		
		while(iterateur.hasNext()){
			caseTemp = (Case) iterateur.next();
			System.out.println(caseTemp.getId());
		}*/
		//System.out.println(damier.estPermis(damier.getCase(111), damier.getCase(103)));
		Case caseTemp2;
		ArrayList<Case> listeCoups = damier.listeCoupsCase(damier.getCase(111));
		Iterator iterateurCoup = listeCoups.iterator();
		//System.out.println(listeCoups.size());
		System.out.println("liste des coup de la case 111");
		while(iterateurCoup.hasNext()){
			caseTemp2 = (Case) iterateurCoup.next();
			System.out.println(caseTemp2.getId());
		}
		
		/*Case caseTest = damier.getCase(111);
		System.out.println(caseTest.getVoisinHautGauche().getId());
		System.out.println(caseTest.getVoisinHautDroit().getId());
		System.out.println(damier.estPermis(damier.getCase(111), damier.getCase(102)));*/

	
	}
}
