package uidelegate;

public class Case {

	private int id;
	private Pion pion;
	private int etat;

	private Case voisinHautGauche;
	private Case voisinGauche;
	private Case voisinBasGauche;
	private Case voisinBasDroit;
	private Case voisinDroit;
	private Case voisinHautDroit;
	
	public Case(){
		
	}
	
	public Case(int parId){
		id = parId;
		pion = null;
		etat = 0;
		
		/*voisinHautGauche = new Case();
		voisinGauche = new Case();
		voisinBasGauche = new Case();
		voisinBasDroit = new Case();
		voisinDroit = new Case();
		voisinHautDroit = new Case();*/
	}

	public Case(int parId, Pion parPion, int parEtat, Case parVoisinHautGauche, Case parVoisinGauche, Case parVoisinBasGauche,
			Case parVoisinBasDroit, Case parVoisinDroit, Case parVoisinHautDroit) {
		
		id = parId;
		pion = parPion;
		etat = parEtat;
		
		voisinHautGauche = parVoisinHautGauche;
		voisinGauche = parVoisinGauche;
		voisinBasGauche = parVoisinBasGauche;
		voisinBasDroit = parVoisinBasDroit;
		voisinDroit = parVoisinDroit;
		voisinHautDroit = parVoisinHautDroit;
		
	}
	
	public String toString(){
		String chaine =  "id = " + id ;
				if(pion != null)
					chaine += "   ---   pion : " + pion.toString();
				chaine += "   ---   etat = " + etat 
				+"\n voisin haut gauche : " + voisinHautGauche.getId() 
				+ "\n voisin gauche : " + voisinGauche.getId()
				+ "\n voisin bas gauche : " + voisinBasGauche.getId()
				+ "\n voisin bas droit : " + voisinBasDroit.getId()
				+ "\n voisin droit : " + voisinDroit.getId()
				+ "\n voisin haut droit : " + voisinHautDroit.getId();
		
		return chaine;
	}
	
	/*public String toStringDebugId(){
		return "mon id est : " + id 
				+ "\n id voisin haut gauche : " + 
		
	}*/
	
	public int getId(){
		return id;
	}

	public Case getVoisinHautGauche() {
		return voisinHautGauche;
	}

	public void setVoisinHautGauche(Case voisinHautGauche) {
		this.voisinHautGauche = voisinHautGauche;
	}

	public Case getVoisinGauche() {
		return voisinGauche;
	}

	public void setVoisinGauche(Case voisinGauche) {
		this.voisinGauche = voisinGauche;
	}

	public Case getVoisinBasGauche() {
		return voisinBasGauche;
	}

	public void setVoisinBasGauche(Case voisinBasGauche) {
		this.voisinBasGauche = voisinBasGauche;
	}

	public Case getVoisinBasDroit() {
		return voisinBasDroit;
	}

	public void setVoisinBasDroit(Case voisinBasDroit) {
		this.voisinBasDroit = voisinBasDroit;
	}

	public Case getVoisinDroit() {
		return voisinDroit;
	}

	public void setVoisinDroit(Case voisinDroit) {
		this.voisinDroit = voisinDroit;
	}

	public Case getVoisinHautDroit() {
		return voisinHautDroit;
	}

	public void setVoisinHautDroit(Case voisinHautDroit) {
		this.voisinHautDroit = voisinHautDroit;
	}
	
	public void setPion(Pion parPion){
		pion = parPion;
	}
	
	public Pion getPion(){
		return pion;
	}
	
}
