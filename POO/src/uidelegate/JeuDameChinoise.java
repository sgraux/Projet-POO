package uidelegate;

import java.util.ArrayList;
import java.util.Random;

import vue2.BoutonCase;

public class JeuDameChinoise extends Jeu {

	private int nbJoueur;
	private int nbCouleur;
	private int compteurTour = 0;

	private BoutonCase boutonCourant;//premier bouton cliqu�
	private BoutonCase boutonNouveau;//deuxi�me bouton cliqu�
	// private int compteurClique = 0;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur, int parNBCouleur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		nbCouleur = parNBCouleur;
		damier = new DamierDameChinoise();
		((DamierDameChinoise) damier).initialiseCouleur(nbCouleur);
	}

	public int victoire() { //Test si un des joueurs a gagn� 
		if (nbJoueur != 3) {
			if (victoireRouge())
				return 2;
			else if (victoireBlanc())
				return 3;
			else if (victoireVert())
				return 4;
			else if (victoireBleu())
				return 5;
			else if (victoireNoir())
				return 6;
			else if (victoireJaune())
				return 7;
		} else {
			if (victoireRouge3C())
				return 2;
			else if (victoireVert3C())
				return 4;
			else if (victoireNoir3C())
				return 6;
		}

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

	public boolean victoireBlanc() {

		try {
			if (damier.getCase(74).getPion().getCouleur() == "blanc"
					&& damier.getCase(84).getPion().getCouleur() == "blanc"
					&& damier.getCase(85).getPion().getCouleur() == "blanc"
					&& damier.getCase(95).getPion().getCouleur() == "blanc"
					&& damier.getCase(96).getPion().getCouleur() == "blanc"
					&& damier.getCase(97).getPion().getCouleur() == "blanc"
					&& damier.getCase(107).getPion().getCouleur() == "blanc"
					&& damier.getCase(108).getPion().getCouleur() == "blanc"
					&& damier.getCase(109).getPion().getCouleur() == "blanc"
					&& damier.getCase(110).getPion().getCouleur() == "blanc") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireJaune() {

		try {
			if (damier.getCase(65).getPion().getCouleur() == "jaune"
					&& damier.getCase(75).getPion().getCouleur() == "jaune"
					&& damier.getCase(76).getPion().getCouleur() == "jaune"
					&& damier.getCase(86).getPion().getCouleur() == "jaune"
					&& damier.getCase(87).getPion().getCouleur() == "jaune"
					&& damier.getCase(88).getPion().getCouleur() == "jaune"
					&& damier.getCase(98).getPion().getCouleur() == "jaune"
					&& damier.getCase(99).getPion().getCouleur() == "jaune"
					&& damier.getCase(100).getPion().getCouleur() == "jaune"
					&& damier.getCase(101).getPion().getCouleur() == "jaune") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireVert() {

		try {
			if (damier.getCase(19).getPion().getCouleur() == "vert"
					&& damier.getCase(20).getPion().getCouleur() == "vert"
					&& damier.getCase(21).getPion().getCouleur() == "vert"
					&& damier.getCase(22).getPion().getCouleur() == "vert"
					&& damier.getCase(32).getPion().getCouleur() == "vert"
					&& damier.getCase(33).getPion().getCouleur() == "vert"
					&& damier.getCase(34).getPion().getCouleur() == "vert"
					&& damier.getCase(44).getPion().getCouleur() == "vert"
					&& damier.getCase(450).getPion().getCouleur() == "vert"
					&& damier.getCase(55).getPion().getCouleur() == "vert") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireBleu() {

		try {
			if (damier.getCase(0).getPion().getCouleur() == "vert" && damier.getCase(1).getPion().getCouleur() == "vert"
					&& damier.getCase(2).getPion().getCouleur() == "vert"
					&& damier.getCase(3).getPion().getCouleur() == "vert"
					&& damier.getCase(4).getPion().getCouleur() == "vert"
					&& damier.getCase(5).getPion().getCouleur() == "vert"
					&& damier.getCase(6).getPion().getCouleur() == "vert"
					&& damier.getCase(7).getPion().getCouleur() == "vert"
					&& damier.getCase(8).getPion().getCouleur() == "vert"
					&& damier.getCase(9).getPion().getCouleur() == "vert") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireNoir() {

		try {
			if (damier.getCase(10).getPion().getCouleur() == "vert"
					&& damier.getCase(11).getPion().getCouleur() == "vert"
					&& damier.getCase(12).getPion().getCouleur() == "vert"
					&& damier.getCase(13).getPion().getCouleur() == "vert"
					&& damier.getCase(23).getPion().getCouleur() == "vert"
					&& damier.getCase(24).getPion().getCouleur() == "vert"
					&& damier.getCase(25).getPion().getCouleur() == "vert"
					&& damier.getCase(35).getPion().getCouleur() == "vert"
					&& damier.getCase(36).getPion().getCouleur() == "vert"
					&& damier.getCase(46).getPion().getCouleur() == "vert") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireRouge3C() {

		try {
			if (damier.getCase(65).getPion().getCouleur() == "rouge"
					&& damier.getCase(75).getPion().getCouleur() == "rouge"
					&& damier.getCase(76).getPion().getCouleur() == "rouge"
					&& damier.getCase(86).getPion().getCouleur() == "rouge"
					&& damier.getCase(87).getPion().getCouleur() == "rouge"
					&& damier.getCase(88).getPion().getCouleur() == "rouge"
					&& damier.getCase(98).getPion().getCouleur() == "rouge"
					&& damier.getCase(99).getPion().getCouleur() == "rouge"
					&& damier.getCase(100).getPion().getCouleur() == "rouge"
					&& damier.getCase(101).getPion().getCouleur() == "rouge") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireVert3C() {

		try {
			if (damier.getCase(74).getPion().getCouleur() == "vert"
					&& damier.getCase(84).getPion().getCouleur() == "vert"
					&& damier.getCase(85).getPion().getCouleur() == "vert"
					&& damier.getCase(95).getPion().getCouleur() == "vert"
					&& damier.getCase(96).getPion().getCouleur() == "vert"
					&& damier.getCase(97).getPion().getCouleur() == "vert"
					&& damier.getCase(107).getPion().getCouleur() == "vert"
					&& damier.getCase(108).getPion().getCouleur() == "vert"
					&& damier.getCase(109).getPion().getCouleur() == "vert"
					&& damier.getCase(110).getPion().getCouleur() == "vert") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean victoireNoir3C() {

		try {
			if (damier.getCase(0).getPion().getCouleur() == "noir" && damier.getCase(1).getPion().getCouleur() == "noir"
					&& damier.getCase(2).getPion().getCouleur() == "noir"
					&& damier.getCase(3).getPion().getCouleur() == "noir"
					&& damier.getCase(4).getPion().getCouleur() == "noir"
					&& damier.getCase(5).getPion().getCouleur() == "noir"
					&& damier.getCase(6).getPion().getCouleur() == "noir"
					&& damier.getCase(7).getPion().getCouleur() == "noir"
					&& damier.getCase(8).getPion().getCouleur() == "noir"
					&& damier.getCase(9).getPion().getCouleur() == "noir"
					&& damier.getCase(110).getPion().getCouleur() == "noir") {

				return true;

			}
		} catch (Exception e) {
		}
		return false;
	}


	public int appliqueCoup() {//applique le coup en fonction des boutons pass�s par la fen�tre
								//renvoie un entier signifiant si le coup � �t� effectu� ou non
								//ou si un joueur a gagn� 
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

	//renvoie une liste contenant deux ID de case
	//le premier sera la case d'origine 
	//le seconde sela la case de destination pour le d�placement
	public ArrayList<Integer> idCoupIA() {
		ArrayList<Integer> listeID = new ArrayList<Integer>();
		
		Random generateurAlea = new Random();
		ArrayList<Case> listeCasesBleues = ((DamierDameChinoise) damier).listeCaseBleu();
		int i = generateurAlea.nextInt(listeCasesBleues.size());
		
		ArrayList<Case> listeCoupsCase = ((DamierDameChinoise) damier).listeCoupsCase(listeCasesBleues.get(i));
		while(listeCoupsCase.size() == 0){
			i = generateurAlea.nextInt(10);
			listeCoupsCase = ((DamierDameChinoise) damier).listeCoupsCase(listeCasesBleues.get(i));
		}
		listeID.add(listeCasesBleues.get(i).getId());
		int j = generateurAlea.nextInt(listeCoupsCase.size());
		listeID.add(listeCoupsCase.get(j).getId());
		
		//System.out.println("i de fin = " + i);
		//System.out.println(listeCoupsCase);
		
		return listeID;

	}

	// remet le bouton courant et le compteur � leur valleur de d�part
	public void reinitialiseBouton() {
		boutonCourant = null;
		boutonNouveau = null;
		// compteurClique = 0;
	}

	//D�termine la ou les couleurs qui peuvent �tre jou�es pendant ce tour
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
		} else if (nbJoueur == 6) {
			if (compteurTour % 6 == 0) {
				listeCouleur.add("rouge");
			} else if (compteurTour % 6 == 1) {
				listeCouleur.add("bleu");
			} else if (compteurTour % 6 == 2) {
				listeCouleur.add("blanc");
			} else if (compteurTour % 6 == 3) {
				listeCouleur.add("noir");
			}else if (compteurTour % 6 == 4) {
				listeCouleur.add("vert");
			}
			else
				listeCouleur.add("jaune");
		}
		return listeCouleur;
	}

	public BoutonCase getBoutonCourant() {
		return boutonCourant;
	}

	//le premier bouton cliqu� sera toujours un bouton avec un pion
	public void setBoutonCourant(BoutonCase boutonCourant) {
		if (boutonCourant.getCasePlateau().aUnPion()
				&& couleurTour().contains(boutonCourant.getCasePlateau().getPion().getCouleur()))
			this.boutonCourant = boutonCourant;
	}

	public BoutonCase getBoutonNouveau() {
		return boutonNouveau;
	}

	//le deuxi�me bouton doit toujours �tre libre
	public void setBoutonNouveau(BoutonCase boutonNouveau) {
		if (!boutonNouveau.getCasePlateau().aUnPion())
			this.boutonNouveau = boutonNouveau;
	}

	public int getNBCouleur() {
		return nbCouleur;
	}

	public int getNBJoueur() {
		return nbJoueur;
	}

}
