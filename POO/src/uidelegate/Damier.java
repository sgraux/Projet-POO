package uidelegate;

public class Damier {
	
	/*DAMES CHINOISES -> taille = 121 cases*/
	/* ABALONE -> taille = 61 cases*/
	private Case[] tabCases;
	private boolean option; //0 Abalone 1 Dames Chinoises
	
	public Damier(boolean parOption){
		option = parOption;
		if(option){
			tabCases = new Case[121];
			initialiseCases();
			initialiseGrapheDames();
		}
		else {
			tabCases = new Case[61];
			initialiseCases();
			initialiseGrapheAbalone();
		}
	}
	
	public void initialiseCases(){
		
		for(int i = 0; i < tabCases.length; i++){
			tabCases[i] = new Case(i, null,0,null,null,null,null,null,null);
			//tabCases[i].setPion(new Pion());
		}
	}
	
	public void initialiseGrapheAbalone(){
		
		/* ETAGE 0 */
		for(int i = 0; i < 5; i++){
			if(!estBordureG(tabCases[i], 0)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
			}
			if(!estBordureD(tabCases[i], 0)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
			}
			
			tabCases[i].setVoisinBasGauche(tabCases[i+5]);
			tabCases[i].setVoisinBasDroit(tabCases[i+6]);
			
			tabCases[i].setPion(new Pion("noir"));
		}
		
		/* ETAGE 1 */
		for(int i = 5; i < 11; i++){
			if(!estBordureG(tabCases[i], 1)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinHautGauche(tabCases[i-6]);
			}
			if(!estBordureD(tabCases[i], 1)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinHautDroit(tabCases[i-5]);
			}
			tabCases[i].setVoisinBasGauche(tabCases[i+6]);
			tabCases[i].setVoisinBasDroit(tabCases[i+7]);
			
			tabCases[i].setPion(new Pion("noir"));
		}
		
		/* ETAGE 2 */
		for(int i = 11; i < 18; i++){
			if(!estBordureG(tabCases[i], 2)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinHautGauche(tabCases[i-7]);
			}
			if(!estBordureD(tabCases[i], 2)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinHautDroit(tabCases[i-6]);
			}
			tabCases[i].setVoisinBasGauche(tabCases[i+7]);
			tabCases[i].setVoisinBasDroit(tabCases[i+8]);
		}
		
		tabCases[13].setPion(new Pion("noir"));
		tabCases[14].setPion(new Pion("noir"));
		tabCases[15].setPion(new Pion("noir"));

		
		/* ETAGE 3 */
		for(int i = 18; i < 26; i++){
			if(!estBordureG(tabCases[i], 3)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinHautGauche(tabCases[i-8]);
			}
			if(!estBordureD(tabCases[i], 3)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinHautDroit(tabCases[i-7]);
			}
			tabCases[i].setVoisinBasGauche(tabCases[i+8]);
			tabCases[i].setVoisinBasDroit(tabCases[i+9]);
		}
		
		/* ETAGE 4 */
		for(int i = 26; i < 35; i++){
			if(!estBordureG(tabCases[i], 4)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinHautGauche(tabCases[i-9]);
				tabCases[i].setVoisinBasGauche(tabCases[i+8]);
			}
			if(!estBordureD(tabCases[i], 4)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinHautDroit(tabCases[i-8]);
				tabCases[i].setVoisinBasDroit(tabCases[i+9]);
			}
		}
		
		/* ETAGE 5 */
		for(int i = 35; i < 43; i++){
			if(!estBordureG(tabCases[i], 5)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinBasGauche(tabCases[i+7]);
			}
			if(!estBordureD(tabCases[i], 5)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinBasDroit(tabCases[i+8]);
			}
			tabCases[i].setVoisinHautGauche(tabCases[i-9]);
			tabCases[i].setVoisinHautDroit(tabCases[i-8]);
		}
		
		/* ETAGE 6 */
		for(int i = 43; i < 50; i++){
			if(!estBordureG(tabCases[i], 6)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinBasGauche(tabCases[i+6]);
			}
			if(!estBordureD(tabCases[i], 6)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinBasDroit(tabCases[i+7]);
			}
			tabCases[i].setVoisinHautGauche(tabCases[i-8]);
			tabCases[i].setVoisinHautDroit(tabCases[i-7]);
		}
		
		tabCases[45].setPion(new Pion("blanc"));
		tabCases[46].setPion(new Pion("blanc"));
		tabCases[47].setPion(new Pion("blanc"));
		
		/* ETAGE 7 */
		for(int i = 50; i < 56; i++){
			if(!estBordureG(tabCases[i], 7)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
				tabCases[i].setVoisinBasGauche(tabCases[i+5]);
			}
			if(!estBordureD(tabCases[i], 7)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
				tabCases[i].setVoisinBasDroit(tabCases[i+6]);
			}
			tabCases[i].setVoisinHautGauche(tabCases[i-7]);
			tabCases[i].setVoisinHautDroit(tabCases[i-6]);
			
			tabCases[i].setPion(new Pion("blanc"));
		}
		
		/* ETAGE 8 */
		for(int i = 56; i < 61; i++){
			if(!estBordureG(tabCases[i], 8)){
				tabCases[i].setVoisinGauche(tabCases[i-1]);
			}
			if(!estBordureD(tabCases[i], 8)){
				tabCases[i].setVoisinDroit(tabCases[i+1]);
			}
			tabCases[i].setVoisinHautGauche(tabCases[i-6]);
			tabCases[i].setVoisinHautDroit(tabCases[i-5]);
			
			tabCases[i].setPion(new Pion("blanc"));
		}
	}
	
	public void initialiseGrapheDames(){
		
	/* TRIANGLE SOMMET */
	
	//LIGNE 1
	tabCases[0].setVoisinBasGauche(tabCases[1]); tabCases[0].setVoisinBasDroit(tabCases[2]);
	
	//LIGNE 2
	tabCases[1].setVoisinDroit(tabCases[2]); tabCases[1].setVoisinBasGauche(tabCases[3]);
	tabCases[1].setVoisinBasDroit(tabCases[4]); tabCases[1].setVoisinHautDroit(tabCases[0]);
	
	tabCases[2].setVoisinGauche(tabCases[1]); tabCases[2].setVoisinBasGauche(tabCases[4]);
	tabCases[2].setVoisinBasDroit(tabCases[5]); tabCases[2].setVoisinHautGauche(tabCases[0]);
	
	//LIGNE 3
	tabCases[3].setVoisinDroit(tabCases[4]); tabCases[3].setVoisinBasGauche(tabCases[6]);
	tabCases[3].setVoisinBasDroit(tabCases[7]); tabCases[3].setVoisinHautDroit(tabCases[1]);
	
	tabCases[4].setVoisinGauche(tabCases[3]); tabCases[4].setVoisinDroit(tabCases[5]);
	tabCases[4].setVoisinHautGauche(tabCases[1]); tabCases[4].setVoisinHautDroit(tabCases[2]);
	tabCases[4].setVoisinBasGauche(tabCases[7]); tabCases[4].setVoisinBasDroit(tabCases[8]);
	
	tabCases[5].setVoisinHautGauche(tabCases[2]);tabCases[5].setVoisinGauche(tabCases[4]);
	tabCases[5].setVoisinBasGauche(tabCases[8]); tabCases[5].setVoisinBasDroit(tabCases[9]);
	
	
	///////////////////// CORPS DE L'ETOILE //////////////////////
	//ETAGE 0 
	for(int i = 6; i < 10; i++){
		tabCases[i].setVoisinBasDroit(tabCases[i + 9]);
		tabCases[i].setVoisinBasGauche(tabCases[i + 8]);
		if(i != 6){
			tabCases[i].setVoisinHautDroit(tabCases[i - 3]);
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
		}
		if(i != 9){
			tabCases[i].setVoisinHautGauche(tabCases[i - 4]);
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
		}
	}
	
	//ETAGE 1
	for(int i = 10; i < 23; i++){
		if(i != 10){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 12]);
		}
		if(i != 22){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 13]);
		}
	}
	
	tabCases[14].setVoisinHautDroit(tabCases[6]);
	tabCases[15].setVoisinHautGauche(tabCases[6]);tabCases[15].setVoisinHautDroit(tabCases[7]);
	tabCases[16].setVoisinGauche(tabCases[7]); tabCases[16].setVoisinHautDroit(tabCases[8]);
	tabCases[17].setVoisinHautGauche(tabCases[8]); tabCases[17].setVoisinHautDroit(tabCases[9]);
	tabCases[18].setVoisinHautGauche(tabCases[9]);
	
	//ETAGE 2
	for(int i = 23; i < 35; i++){
		if(i != 23){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 11]);
		}
		if(i != 34){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 12]);
		}
		tabCases[i].setVoisinHautGauche(tabCases[i - 13]);
		tabCases[i].setVoisinHautDroit(tabCases[i - 12]);
	}
	
	//ETAGE 3
	for(int i = 35; i < 46; i++){
		if(i != 35){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 10]);
		}
		if(i != 45){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 11]);
		}
		tabCases[i].setVoisinHautDroit(tabCases[i - 11]);
		tabCases[i].setVoisinHautGauche(tabCases[i - 12]);
	}
	
	//ETAGE 4
	for(int i = 46; i < 56; i++){
		if(i != 46){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 9]);
		}
		if(i != 55){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 10]);
		}
		tabCases[i].setVoisinHautDroit(tabCases[i - 10]);
		tabCases[i].setVoisinHautGauche(tabCases[i - 11]);
	}
	
	//ETAGE 5
	for(int i = 56; i < 65; i++){
		if(i != 56)
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
		if(i != 64)
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
		
		tabCases[i].setVoisinHautDroit(tabCases[i - 9]);
		tabCases[i].setVoisinHautGauche(tabCases[i - 10]);
		tabCases[i].setVoisinBasDroit(tabCases[i + 10]);
		tabCases[i].setVoisinBasGauche(tabCases[i + 9]);
	}
	
	//ETAGE 6
	for(int i = 65; i < 75; i++){
		if(i != 65){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinHautGauche(tabCases[i - 10]);
		}
		if(i != 74){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinHautDroit(tabCases[i - 9]);
		}
		tabCases[i].setVoisinBasDroit(tabCases[i + 11]);
		tabCases[i].setVoisinBasGauche(tabCases[i + 10]);
	}
	
	//ETAGE 7
	for(int i = 75; i < 86; i++){
		if(i != 75){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinHautGauche(tabCases[i - 11]);
		}
		if(i != 85){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinHautDroit(tabCases[i - 10]);
		}
		tabCases[i].setVoisinBasDroit(tabCases[i + 12]);
		tabCases[i].setVoisinBasGauche(tabCases[i + 11]);
	}
	
	//ETAGE 8
	for(int i = 86; i < 98; i++){
		if(i != 86){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinHautGauche(tabCases[i - 12]);
		}
		if(i != 97){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinHautDroit(tabCases[i - 11]);
		}
		tabCases[i].setVoisinDroit(tabCases[i + 13]);
		tabCases[i].setVoisinBasGauche(tabCases[i + 12]);
	}
	
	//ETAGE 9
	for(int i = 98; i < 111; i++){
		if(i != 98){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinHautGauche(tabCases[i - 13]);
		}
		if(i != 110){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinHautDroit(tabCases[i - 12]);
		}
	}
	
	tabCases[103].setVoisinBasDroit(tabCases[111]);
	tabCases[103].setVoisinBasGauche(tabCases[111]); tabCases[103].setVoisinBasDroit(tabCases[112]);
	tabCases[104].setVoisinBasGauche(tabCases[112]); tabCases[104].setVoisinBasDroit(tabCases[113]);
	tabCases[105].setVoisinBasGauche(tabCases[113]); tabCases[105].setVoisinBasDroit(tabCases[114]);
	tabCases[107].setVoisinBasGauche(tabCases[114]);
	
	////////////// TRIANGLE DU BAS ////////////////
	//ETAGE 10
	for(int i = 111; i < 115; i++){
		if(i != 111){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 3]);
		}
		if(i != 114){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 4]);
		}
		tabCases[i].setVoisinHautDroit(tabCases[i - 8]);
		tabCases[i].setVoisinHautGauche(tabCases[i - 9]);
	}
	
	for(int i = 115; i < 118; i++){
		if(i != 115){
			tabCases[i].setVoisinGauche(tabCases[i - 1]);
			tabCases[i].setVoisinBasGauche(tabCases[i + 2]);
		}
		if(i != 117){
			tabCases[i].setVoisinDroit(tabCases[i + 1]);
			tabCases[i].setVoisinBasDroit(tabCases[i + 3]);
		}
		tabCases[i].setVoisinHautDroit(tabCases[i - 3]);
		tabCases[i].setVoisinHautGauche(tabCases[i - 4]);
	}
	
	tabCases[118].setVoisinBasGauche(tabCases[119]);
	tabCases[118].setVoisinHautGauche(tabCases[115]); tabCases[118].setVoisinHautDroit(tabCases[116]);
	tabCases[118].setVoisinBasDroit(tabCases[120]);
	
	tabCases[119].setVoisinDroit(tabCases[118]);
	tabCases[119].setVoisinHautGauche(tabCases[116]); tabCases[119].setVoisinHautDroit(tabCases[117]);
	tabCases[119].setVoisinBasGauche(tabCases[120]);
	
	tabCases[120].setVoisinHautGauche(tabCases[118]);
	tabCases[120].setVoisinHautDroit(tabCases[119]);
	}
	
	public boolean estBordureG(Case parCase, int etage){
		
		int id = parCase.getId();
		
		switch(etage){
        case 0:
            if(id == 0) return true;
            break;
        case 1:
            if(id == 5) return true;
            break;
        case 2:
            if(id == 11) return true;
            break;
        case 3:
            if(id == 18) return true;
            break;
        case 4:
            if(id == 26) return true;
            break;
        case 5:
            if(id == 35) return true;
            break;
        case 6:
            if(id == 43) return true;
            break;
        case 7:
            if(id == 50) return true;
            break;
        case 8:
            if(id == 56) return true;
            break;
		}

    return false;
		
	}
	
	public boolean estBordureD(Case parCase, int etage){
		
		int id = parCase.getId();
		
		switch(etage){
        case 0:
            if(id == 4) return true;
            break;
        case 1:
            if(id == 10) return true;
            break;
        case 2:
            if(id == 17) return true;
            break;
        case 3:
            if(id == 25) return true;
            break;
        case 4:
            if(id == 34) return true;
            break;
        case 5:
            if(id == 42) return true;
            break;
        case 6:
            if(id == 49) return true;
            break;
        case 7:
            if(id == 55) return true;
            break;
        case 8:
            if(id == 60) return true;
            break;
		}
    return false;
	}

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

}
