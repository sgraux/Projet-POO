package test;

import uidelegate.Case;
import uidelegate.Pion;

public class TestCase {
	
public static void main(String []args){
		
		Pion monPion = new Pion("rouge");
		
		Case caseHautGauche = new Case(1);
		Case caseGauche = new Case(2);
		Case caseBasGauche = new Case(3);
		Case caseBasDroit = new Case(4);
		Case caseDroit = new Case(5);
		Case caseHautDroit = new Case(6);

		
		Case maCaseCentrale = new Case(0, monPion, 0, caseHautGauche, caseGauche, caseBasGauche, caseBasDroit, caseDroit, caseHautDroit);
		System.out.println(maCaseCentrale.toString());
		
	}

}
