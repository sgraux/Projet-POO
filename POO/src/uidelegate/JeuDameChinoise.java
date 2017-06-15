package uidelegate;

public class JeuDameChinoise extends Jeu{
	
	private int nbJoueur;
	private int nbCouleur;
	private int compteurTour = 0;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur, int parNBCouleur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		nbCouleur = parNBCouleur;
		damier = new DamierDameChinoise();
		((DamierDameChinoise)damier).initialiseCouleur(nbCouleur);
	}

	public void setCaseCourante(Case parCaseCourante){
		//caseCourante = parCaseCourante;
	}
	
	/*public boolean appliquerCoup(){
		//return ((DamierDameChinoise)damier).deplacement(caseCourante, caseDestination);
		
	}*/
	
	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void boucleJeu() {
		// TODO Auto-generated method stub
		
	}
	
	

}
