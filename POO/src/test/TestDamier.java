package test;

import uidelegate.Case;
import uidelegate.Damier;
import uidelegate.DamierAbalone;
import uidelegate.DamierDameChinoise;

public class TestDamier {
	
	public static void main(String []args){
	
	DamierAbalone damier = new DamierAbalone();
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
	
	damier.deplacement(damier.getCase(13), damier.getCase(21));
	
	Case maCase = damier.getCase(21);
	System.out.println(maCase.getPion());
	
	/*Case maCase2 = damier.getCase(1);
	maCase.setVoisinDroit(maCase2);
	maCase2.setVoisinGauche(maCase);*/
	//System.out.println(maCase.getVoisinGauche());
	//System.out.println(damier.estBordureG(maCase, 0));
	
	}
}
