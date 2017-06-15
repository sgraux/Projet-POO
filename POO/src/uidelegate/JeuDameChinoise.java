package uidelegate;

public class JeuDameChinoise extends Jeu{
	
	private int nbJoueur;
	private int nbCouleur;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur, int parNBCouleur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		nbCouleur = parNBCouleur;
		setDamier(new DamierDameChinoise());
		((DamierDameChinoise)getDamier()).initialiseCouleur(nbCouleur);
	}

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
