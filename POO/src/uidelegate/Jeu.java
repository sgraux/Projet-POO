package uidelegate;

public abstract class Jeu {
	
	private boolean joueContreIA;
	private String variante;
	protected Damier damier;
	
	public Jeu(boolean parJoueContreIA, String parVariante){
		joueContreIA = parJoueContreIA;
		variante = parVariante;
	}
	
	public void setDamier(Damier parDamier){
		damier = parDamier;
	}
	
	public abstract boolean estVictoire();
	
	public abstract void boucleJeu();
	
	public Damier getDamier(){
		return damier;
	}

}
