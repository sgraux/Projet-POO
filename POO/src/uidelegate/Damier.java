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
		
		if(parCaseRef.getVoisinHautGauche() == parCaseTest.getVoisinHautGauche())
			return true;
		else if(parCaseRef.getVoisinGauche() == parCaseTest.getVoisinGauche())
			return true;
		else if(parCaseRef.getVoisinBasGauche() == parCaseTest.getVoisinBasGauche())
			return true;
		else if(parCaseRef.getVoisinBasDroit() == parCaseTest.getVoisinBasDroit())
			return true;
		else if(parCaseRef.getVoisinDroit() == parCaseTest.getVoisinDroit())
			return true;
		else if(parCaseRef.getVoisinHautDroit() == parCaseTest.getVoisinHautDroit())
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
	
	public Case getCase(int indice){
		return tabCases[indice];
	}

	public Case[] getTabCases() {
		return tabCases;
	}

	public void setTabCases(Case[] tabCases) {
		this.tabCases = tabCases;
	}
	
	

}
