package uidelegate;

import vue2.BoutonCase;

public class JeuDameChinoise extends Jeu {

	private int nbJoueur;
	private int nbCouleur;
	private int compteurTour = 0;

	private BoutonCase boutonCourant;
	private BoutonCase boutonNouveau;
	// private int compteurClique = 0;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur, int parNBCouleur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		nbCouleur = parNBCouleur;
		damier = new DamierDameChinoise();
		((DamierDameChinoise) damier).initialiseCouleur(nbCouleur);
	}

	public void setCaseCourante(Case parCaseCourante) {
	}

	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean victoireRouge() {

		try {
			if (damier.getCase(120).getPion().getCouleur() == "rouge"
					&& damier.getCase(119).getPion().getCouleur() == "rouge"
					&& damier.getCase(118).getPion().getCouleur() == "rouge"
					&& damier.getCase(117).getPion().getCouleur() == "rouge"
					&& damier.getCase(116).getPion().getCouleur() == "rouge"
					&& damier.getCase(115).getPion().getCouleur() == "rouge"
					&& damier.getCase(114).getPion().getCouleur() == "rouge"
					&& damier.getCase(113).getPion().getCouleur() == "rouge"
					&& damier.getCase(112).getPion().getCouleur() == "rouge"
					&& damier.getCase(111).getPion().getCouleur() == "rouge") {

				return true;

			}
		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public void boucleJeu() {
		// TODO Auto-generated method stub

	}

	public int appliqueCoup(BoutonCase parBouton) {

		if (!damier.estVoisin(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())) {
			if (((DamierDameChinoise)damier).saut(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())){
				
				return 1;
			}
			else {
				reinitialiseBouton();
				return 0;
				}
		}
		else {
			if (((DamierDameChinoise) damier).deplacement(boutonCourant.getCasePlateau(), parBouton.getCasePlateau())){
				
				return 1;
			}
			else{
				reinitialiseBouton();
				return 0;
			}
		}
	}

		
		
		/*if (compteurClique == 0) {
			
			boutonCourant = parBouton;
			compteurClique++;
			//System.out.println(parBouton.getCasePlateau().getPion().getCouleur());
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

		}*/

	// remet le bouton courant et le compteur à leur valleur de départ
	public void reinitialiseBouton() {
		boutonCourant = null;
		boutonNouveau = null;
		// compteurClique = 0;
	}

	public BoutonCase getBoutonCourant() {
		return boutonCourant;
	}

	public void setBoutonCourant(BoutonCase boutonCourant) {
		if (boutonCourant.getCasePlateau().aUnPion())
			this.boutonCourant = boutonCourant;
	}

	public BoutonCase getBoutonNouveau() {
		return boutonNouveau;
	}

	public void setBoutonNouveau(BoutonCase boutonNouveau) {
		if (!boutonNouveau.getCasePlateau().aUnPion())
			this.boutonNouveau = boutonNouveau;
	}

}
