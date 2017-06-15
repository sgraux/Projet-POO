package uidelegate;

public abstract class Damier {
	
	/*DAMES CHINOISES -> taille = 121 cases*/
	/* ABALONE -> taille = 61 cases*/
	protected Case[] tabCases;
	
	public Damier(int nombreCases){
		tabCases = new Case[nombreCases];
		initialiseCases();
	}
	
	public void initialiseCases(){
		
		for(int i = 0; i < tabCases.length; i++){
			tabCases[i] = new Case(i, null,0,null,null,null,null,null,null);
		}
	}
	
	public abstract void initialiseGraphe();

	public boolean estVoisin(Case parCaseRef, Case parCaseTest){
		
		if(parCaseRef.getVoisinHautGauche() == parCaseTest)
			return true;
		else if(parCaseRef.getVoisinGauche() == parCaseTest)
			return true;
		else if(parCaseRef.getVoisinBasGauche() == parCaseTest)
			return true;
		else if(parCaseRef.getVoisinBasDroit() == parCaseTest)
			return true;
		else if(parCaseRef.getVoisinDroit() == parCaseTest)
			return true;
		else if(parCaseRef.getVoisinHautDroit() == parCaseTest)
			return true;
		
		return false;
	}
	
	public boolean estPermis(Case parCaseOri, Case parCaseDest){
		if(estVoisin(parCaseOri, parCaseDest) && parCaseDest.getPion() == null)
			return true;
		return false;
	}
	
	public String toStringDebug(){

		int compteur = 0;
		String chaine = "";
		for(int i = 0; i < tabCases.length; i++){
			chaine += tabCases[i].getId() + "\n";
			compteur ++;
		}
		chaine += "nombre de cases parcourues : " + compteur;
		
		return chaine;
	}
	
	public String toStringDebugV2(){
		String chaine = "";
		for(int i = 0; i < tabCases.length; i++){
			chaine += "Case : " + tabCases[i].getId();
			
			if(tabCases[i].getVoisinHautGauche() == null)
				chaine += " -- voisinHG = null";
			else chaine += " -- voisinHG " + tabCases[i].getVoisinHautGauche().getId();
			
			if(tabCases[i].getVoisinGauche() == null)
				chaine += " -- voisinG = null";
			else chaine += " -- voisinG " + tabCases[i].getVoisinGauche().getId();
					
			if(tabCases[i].getVoisinBasGauche() == null)
				chaine += " -- voisinBG = null";
			else chaine += " -- voisinBG " + tabCases[i].getVoisinBasGauche().getId();
			
			if(tabCases[i].getVoisinBasDroit() == null)
				chaine += " -- voisinBD = null";
			else chaine += " -- voisinBD " + tabCases[i].getVoisinBasDroit().getId();
			
			if(tabCases[i].getVoisinDroit() == null)
				chaine += " -- voisinD = null";
			else chaine += " -- voisinD " + tabCases[i].getVoisinDroit().getId();
			
			if(tabCases[i].getVoisinHautDroit() == null)
				chaine += " -- voisinHD = null\n";
			else chaine += " -- voisinHD " + tabCases[i].getVoisinHautDroit().getId() + "\n";
		}
		return chaine;
	}
	
	public Case getCase(int indice){
		return tabCases[indice];
	}

	public Case[] getTabCases() {
		return tabCases;
	}

	public void setTabCases(Case[] tabCases) {
		this.tabCases = tabCases;
	}
	
	public String toSTringCouleur(){
		String chaine = "";
		for(int i = 0; i < 120; i++){
			if(tabCases[i].getPion() != null)
				chaine += tabCases[i].getPion().getCouleur() + "\n";
		}
		return chaine;
	}

	
}
