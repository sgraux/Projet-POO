package uidelegate;

import java.util.ArrayList;

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

	public int victoire(){
		if(victoireRouge()) return 2;
		
		return 1;
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

	public int appliqueCoup() {// quand on select un pion, on peut pas le
								// déselect pour le moment
		if (boutonCourant.getCasePlateau().getId() == boutonNouveau.getCasePlateau().getId()) {
			reinitialiseBouton();
			return 0;
		} else if (!damier.estVoisin(boutonCourant.getCasePlateau(), boutonNouveau.getCasePlateau())) {
			if (((DamierDameChinoise) damier).saut(boutonCourant.getCasePlateau(), boutonNouveau.getCasePlateau())) {
				compteurTour++;
				return victoire();
			} else {
				boutonCourant = boutonNouveau;
				boutonNouveau = null;
				return 0;
			}
		} else {
			if (((DamierDameChinoise) damier).deplacement(boutonCourant.getCasePlateau(),
					boutonNouveau.getCasePlateau())) {
				compteurTour++;
				return victoire();
			} else {
				boutonCourant = boutonNouveau;
				boutonNouveau = null;
				return 0;
			}
		}
	}

	// remet le bouton courant et le compteur à leur valleur de départ
	public void reinitialiseBouton() {
		boutonCourant = null;
		boutonNouveau = null;
		// compteurClique = 0;
	}

	public ArrayList<String> couleurTour() {
		if (nbCouleur == 2)
			return couleurTour2C();
		else if (nbCouleur == 3)
			return couleurTour3C();
		else if (nbCouleur == 4)
			return couleurTour4C();
		else
			return couleurTour6C();

	}

	public ArrayList<String> couleurTour2C() {
		ArrayList<String> listeCouleur = new ArrayList<String>();

		if (compteurTour % 2 == 0) {
			listeCouleur.add("rouge");
		} else
			listeCouleur.add("bleu");

		return listeCouleur;
	}

	public ArrayList<String> couleurTour3C() {
		ArrayList<String> listeCouleur = new ArrayList<String>();

		if (compteurTour % 3 == 0) {
			listeCouleur.add("rouge");
		} else if (compteurTour % 3 == 1)
			listeCouleur.add("vert");
		else
			listeCouleur.add("noir");

		return listeCouleur;
	}

	public ArrayList<String> couleurTour4C() {
		ArrayList<String> listeCouleur = new ArrayList<String>();

		if (nbJoueur == 2) {
			if (compteurTour % 2 == 0) {
				listeCouleur.add("rouge");
				listeCouleur.add("blanc");
			} else {
				listeCouleur.add("bleu");
				listeCouleur.add("noir");
			}
		} else {
			if (compteurTour % 4 == 0) {
				listeCouleur.add("rouge");
			} else if (compteurTour % 4 == 1) {
				listeCouleur.add("bleu");
			} else if (compteurTour % 4 == 2) {
				listeCouleur.add("blanc");
			} else
				listeCouleur.add("noir");
		}
		return listeCouleur;
	}

	public ArrayList<String> couleurTour6C() {
		ArrayList<String> listeCouleur = new ArrayList<String>();

		if (nbJoueur == 2) {
			if (compteurTour % 2 == 0) {
				listeCouleur.add("rouge");
				listeCouleur.add("blanc");
				listeCouleur.add("jaune");
			} else {
				listeCouleur.add("bleu");
				listeCouleur.add("noir");
				listeCouleur.add("vert");
			}
		} else if (nbJoueur == 3) {
			if (compteurTour % 3 == 0) {
				listeCouleur.add("rouge");
				listeCouleur.add("blanc");
			} else if (compteurTour % 3 == 1) {
				listeCouleur.add("bleu");
				listeCouleur.add("vert");
			} else if (compteurTour % 3 == 2) {
				listeCouleur.add("jaune");
				listeCouleur.add("noir");
			}
		} else if (nbJoueur == 4) {
			if (compteurTour % 4 == 0) {
				listeCouleur.add("rouge");
			} else if (compteurTour % 4 == 1) {
				listeCouleur.add("bleu");
			} else if (compteurTour % 4 == 2) {
				listeCouleur.add("blanc");
			} else
				listeCouleur.add("noir");
		}
		return listeCouleur;
	}

	public BoutonCase getBoutonCourant() {
		return boutonCourant;
	}

	public void setBoutonCourant(BoutonCase boutonCourant) {
		if (boutonCourant.getCasePlateau().aUnPion()
				&& couleurTour().contains(boutonCourant.getCasePlateau().getPion().getCouleur()))
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
