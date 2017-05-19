package uidelegate;

public class Pion {
	
	/*DAMES CHNOISES -> noir, rouge, vert, jaune; blanc, bleu*/
	/*ABALONE -> noir, blanc*/
	private String couleur;
	
	public Pion(){
		
	}
	
	public Pion(String parCouleur){
		couleur = parCouleur;
	}
	
	public String toString(){
		return "couleur = " + couleur;
	}
	
	public String getCouleur(){
		return couleur;
	}
	
	//PAS FORCEMENT UTILE
	/*public void setCouleur(String parCouleur){
		couleur = parCouleur;
	}*/
}
