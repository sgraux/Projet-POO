package test;

import uidelegate.Case;
import uidelegate.Damier;
import uidelegate.DamierAbalone;
import uidelegate.DamierDameChinoise;

public class TestDamier {
	
	public static void main(String []args){
	
	DamierDameChinoise damier = new DamierDameChinoise();
	//System.out.println(damier.toStringDebugV2());
	damier.initialisePion6C();
	//System.out.println(damier.getCase(1).getVoisinGauche().getId());
	//System.out.println(damier.toStringDebug());
	//System.out.println(damier.toStringDebugV2());
	//Case maCase = damier.getCase(7);
	//System.out.println(damier.estBordureD(maCase, 0));
	//System.out.println(maCase.getVoisinDroit().getId());
	//System.out.println(maCase.getVoisinGauche().getId());
	//System.out.println(maCase.getVoisinBasDroit().getId());
	//System.out.println(maCase.getVoisinBasGauche().getId());
	//System.out.println(maCase.getVoisinHautGauche().getId());
	//System.out.println(maCase.getVoisinHautDroit().getId());
	//System.out.println(maCase.getVoisinBasGauche().getPion().getCouleur());
	
	/*System.out.println(damier.estVoisin(damier.getCase(6), damier.getCase(15)));
	System.out.println(damier.estPermis(damier.getCase(6), damier.getCase(15)));
	System.out.println(damier.deplacement(damier.getCase(6), damier.getCase(15)));
	System.out.print(damier.getCase(15).getPion());*/
	
	System.out.println(damier.saut(damier.getCase(4), damier.getCase(17)));
	System.out.println(damier.getCase(17).getPion());
	System.out.println(damier.toSTringCouleur());
	/*Case maCase2 = damier.getCase(1);
	maCase.setVoisinDroit(maCase2);
	maCase2.setVoisinGauche(maCase);*/
	//System.out.println(maCase.getVoisinGauche());
	//System.out.println(damier.estBordureG(maCase, 0));
	
	}
}