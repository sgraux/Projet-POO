package uidelegate;

import java.util.ArrayList;

public class DamierDameChinoise extends Damier{

	public DamierDameChinoise() {
		super(121);
		initialiseGraphe();
	}

	//Initiliase le graphe 
	//la branche au sommet de l'�toile en premier
	//puis toutes les lignes du corps de l'�toile
	//et la branche en bas de l'�toile
	@Override
	public void initialiseGraphe() {

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

	//effectue un d�placement classique
	public boolean deplacement(Case parCaseOri, Case parCaseDest){
		if(estPermis(parCaseOri, parCaseDest)){
			parCaseDest.setPion(parCaseOri.getPion());
			parCaseOri.setPion(null);
			return true;
		}
		return false;
	}
	
	//effectue un saut par dessus un pion 
	public boolean saut(Case parCaseOri, Case parCaseDest){
		try{
		if(parCaseOri.getVoisinHautGauche().aUnPion() == true){
			if(parCaseOri.getVoisinHautGauche().getVoisinHautGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinGauche().aUnPion() == true){
			if(parCaseOri.getVoisinGauche().getVoisinGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinBasGauche().aUnPion() == true){
			if(parCaseOri.getVoisinBasGauche().getVoisinBasGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinBasDroit().aUnPion() == true){
			if(parCaseOri.getVoisinBasDroit().getVoisinBasDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;	
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinDroit().aUnPion() == true){
			if(parCaseOri.getVoisinDroit().getVoisinDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinHautDroit().aUnPion() == true){
			if(parCaseOri.getVoisinHautDroit().getVoisinHautDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				return true;
				
			}
		}
		}catch(Exception e){}
		return false;
	}
	
	//effecue un saut avec prise pour la variante
	public boolean sautPrise(Case parCaseOri, Case parCaseDest){
		try{
		if(parCaseOri.getVoisinHautGauche().aUnPion() == true){
			if(parCaseOri.getVoisinHautGauche().getVoisinHautGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinHautGauche().setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinGauche().aUnPion() == true){
			if(parCaseOri.getVoisinGauche().getVoisinGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinGauche().setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinBasGauche().aUnPion() == true){
			if(parCaseOri.getVoisinBasGauche().getVoisinBasGauche() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinBasGauche().setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinBasDroit().aUnPion() == true){
			if(parCaseOri.getVoisinBasDroit().getVoisinBasDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinBasDroit().setPion(null);
				return true;	
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinDroit().aUnPion() == true){
			if(parCaseOri.getVoisinDroit().getVoisinDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinDroit().setPion(null);
				return true;
			}
		}
		}catch(Exception e){}
		try{
		if(parCaseOri.getVoisinHautDroit().aUnPion() == true){
			if(parCaseOri.getVoisinHautDroit().getVoisinHautDroit() == parCaseDest){
				parCaseDest.setPion(parCaseOri.getPion());
				parCaseOri.setPion(null);
				parCaseOri.getVoisinHautDroit().setPion(null);
				return true;
				
			}
		}
		}catch(Exception e){}
		return false;
	}
	
	//initiliase le nombre de couleur souhait� 
	public void initialiseCouleur(int parNombre){
		switch(parNombre){
		case 2: initialisePion2C();
				break;
		case 3: initialisePion3C();
				break;
		case 4: initialisePion4C();
				break;
		case 6: initialisePion6C();
				break;
		default: initialisePion6C();
				 break;
		}
	}
	
	public void initialiseRouge(){
		for(int i = 0; i < 10; i++){
			tabCases[i].setPion(new Pion("rouge"));
		}
	}
	
	public void initialiseBleu(){
		for(int i = 111; i < 121; i++){
			tabCases[i].setPion(new Pion("bleu"));
		}
	}
	
	public void initialiseBlanc(){
		tabCases[10].setPion(new Pion("blanc"));
		tabCases[11].setPion(new Pion("blanc"));
		tabCases[12].setPion(new Pion("blanc"));
		tabCases[13].setPion(new Pion("blanc"));
		
		tabCases[23].setPion(new Pion("blanc"));
		tabCases[24].setPion(new Pion("blanc"));
		tabCases[25].setPion(new Pion("blanc"));
		
		tabCases[35].setPion(new Pion("blanc"));
		tabCases[36].setPion(new Pion("blanc"));
		
		tabCases[46].setPion(new Pion("blanc"));
	}
	
	public void initialiseJaune(){
		tabCases[19].setPion(new Pion("jaune"));
		tabCases[20].setPion(new Pion("jaune"));
		tabCases[21].setPion(new Pion("jaune"));
		tabCases[22].setPion(new Pion("jaune"));
		
		tabCases[32].setPion(new Pion("jaune"));
		tabCases[33].setPion(new Pion("jaune"));
		tabCases[34].setPion(new Pion("jaune"));
		
		tabCases[44].setPion(new Pion("jaune"));
		tabCases[45].setPion(new Pion("jaune"));
		
		tabCases[55].setPion(new Pion("jaune"));
	}
	
	public void initialiseVert(){
		tabCases[65].setPion(new Pion("vert"));
		
		tabCases[75].setPion(new Pion("vert"));
		tabCases[76].setPion(new Pion("vert"));
		
		tabCases[86].setPion(new Pion("vert"));
		tabCases[87].setPion(new Pion("vert"));
		tabCases[88].setPion(new Pion("vert"));
		
		tabCases[98].setPion(new Pion("vert"));
		tabCases[99].setPion(new Pion("vert"));
		tabCases[100].setPion(new Pion("vert"));
		tabCases[101].setPion(new Pion("vert"));
	}
	
	public void initialiseNoir(){
		tabCases[74].setPion(new Pion("noir"));
		
		tabCases[84].setPion(new Pion("noir"));
		tabCases[85].setPion(new Pion("noir"));
		
		tabCases[95].setPion(new Pion("noir"));
		tabCases[96].setPion(new Pion("noir"));
		tabCases[97].setPion(new Pion("noir"));
		
		tabCases[107].setPion(new Pion("noir"));
		tabCases[108].setPion(new Pion("noir"));
		tabCases[109].setPion(new Pion("noir"));
		tabCases[110].setPion(new Pion("noir"));
	}
	
	public void initialisePion2C(){//BLEU & ROUGE
		initialiseRouge();
		initialiseBleu();
	}
	
	public void initialisePion3C(){
		initialiseRouge();
		initialiseVert();
		initialiseNoir();
	}
	
	public void initialisePion4C(){
		initialiseRouge();
		initialiseBlanc();
		initialiseBleu();
		initialiseNoir();
	}
	
	public void initialisePion6C(){
		initialiseRouge();
		initialiseJaune();
		initialiseNoir();
		initialiseBleu();
		initialiseVert();
		initialiseBlanc();
	}
	
	//IA
	//renvoie une liste des cases contenants un pion bleu
	public ArrayList<Case> listeCaseBleu(){
		ArrayList<Case> liste = new ArrayList<Case>();
		
		for(int i = 0; i < 121; i++){
			if(tabCases[i].getPion() != null && tabCases[i].getPion().getCouleur() == "bleu"){
				liste.add(tabCases[i]);
			}
		}
		
		return liste;
	}
	
	//renvoie la liste des cases de d�placement possible pour une case don�e
	public ArrayList<Case> listeCoupsCase(Case parCase){
		ArrayList<Case> liste = new ArrayList<Case>();
		
		if(parCase.getVoisinHautGauche() != null && estPermis(parCase, parCase.getVoisinHautGauche()))
			liste.add(parCase.getVoisinHautGauche());
		if(parCase.getVoisinGauche() != null && estPermis(parCase, parCase.getVoisinGauche()))
			liste.add(parCase.getVoisinGauche());
		if(parCase.getVoisinBasGauche() != null && estPermis(parCase, parCase.getVoisinBasGauche()))
			liste.add(parCase.getVoisinBasGauche());
		if(parCase.getVoisinBasDroit() != null && estPermis(parCase, parCase.getVoisinBasDroit()))
			liste.add(parCase.getVoisinBasDroit());
		if(parCase.getVoisinDroit() != null && estPermis(parCase, parCase.getVoisinDroit()))
			liste.add(parCase.getVoisinDroit());
		if(parCase.getVoisinHautDroit() != null && estPermis(parCase, parCase.getVoisinHautDroit()))
			liste.add(parCase.getVoisinHautDroit());

		return liste;

	}
}
