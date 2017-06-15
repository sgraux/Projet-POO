package uidelegate;

public class JeuAbalone extends Jeu{

	public JeuAbalone(boolean parJoueContreIA, String parVariante) {
		super(parJoueContreIA, parVariante);
		setDamier(new DamierAbalone());
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
