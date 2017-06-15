package uidelegate;

public class JeuAbalone extends Jeu{

	public JeuAbalone(boolean parJoueContreIA, String parVariante) {
		super(parJoueContreIA, parVariante);
		damier = new DamierAbalone();
	}

	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void boucleJeu() {
	
		
	}

	
	/*  A METTER DANS JEU
	 if(modeJeu=="TrouNoir"){
		tabCases[21].setVoisinBasDroit(null);
		tabCases[22].setVoisinBasGauche(null);
		tabCases[29].setVoisinDroit(null);
		tabCases[38].setVoisinHautDroit(null);
		tabCases[39].setVoisinHautGauche(null);
		tabCases[31].setVoisinGauche(null);
	}
	
	if(modeJeu=="Mur"){
		tabCases[29].setEtat(1);
		tabCases[30].setEtat(1);
		tabCases[31].setEtat(1);
	}
	 */
}
