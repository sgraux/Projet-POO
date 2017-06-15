package uidelegate;

public class JeuDameChinoise extends Jeu{
	
	private int nbJoueur;

	public JeuDameChinoise(boolean parJoueContreIA, String parVariante, int parNBJoueur) {
		super(parJoueContreIA, parVariante);
		nbJoueur = parNBJoueur;
		setDamier(new DamierDameChinoise());
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
