package uidelegate;

import vue2.BoutonCase;

public class JeuDameChinoise extends Jeu {

	private int nbJoueur;
	private int nbCouleur;
	private int compteurTour = 0;

	private BoutonCase boutonCourant;
	private BoutonCase boutonNouveau;
	private int compteurClique = 0;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur, int parNBCouleur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		nbCouleur = parNBCouleur;
		damier = new DamierDameChinoise();
		((DamierDameChinoise) damier).initialiseCouleur(nbCouleur);
	}

	public void setCaseCourante(Case parCaseCourante) {
		// caseCourante = parCaseCourante;
	}

	/*
	 * public boolean appliquerCoup(){ //return
	 * ((DamierDameChinoise)damier).deplacement(caseCourante, caseDestination);
	 * 
	 * }
	 */

	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void boucleJeu() {
		// TODO Auto-generated method stub

	}

	public int appliqueCoup(BoutonCase parBouton) {

		
		if (compteurClique == 0) {
			
			boutonCourant = parBouton;
			compteurClique++;
			System.out.println(parBouton.getCasePlateau().getPion().getCouleur());
			return 0;
		} else if (!damier.estVoisin(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())) {
			if (((DamierDameChinoise)damier).saut(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())) {
				return 1;
			} else {
				boutonCourant = parBouton;
				return 0;
			}
		} else {
			if (((DamierDameChinoise) damier).deplacement(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())) {
				return 1;
			} else
				return -1;

		}

	}
	//remet le bouton courant et le compteur à leur valleur de départ
	public void reinitialiseBouton() {
		boutonCourant = null;
		compteurClique = 0;
	}

	public BoutonCase getBoutonCourant() {
		return boutonCourant;
	}

	public void setBoutonCourant(BoutonCase boutonCourant) {
		this.boutonCourant = boutonCourant;
	}

	public BoutonCase getBoutonNouveau() {
		return boutonNouveau;
	}

	public void setBoutonNouveau(BoutonCase boutonNouveau) {
		this.boutonNouveau = boutonNouveau;
	}

}
