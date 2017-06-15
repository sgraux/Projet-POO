package uidelegate;
// package uidelegate;
import java.lang.Math; 

public class DamierAbalone extends Damier{
	
	private Case caseSelectione[];
	private String modeJeu;
	
	public DamierAbalone(){
		super(61);
		initialiseGraphe();
	
		caseSelectione=new Case[3];
		
		for(int i=0;i<caseSelectione.length;i++){
			caseSelectione[i]=new Case(-1, null,0,null,null,null,null,null,null);
		}
	}

	public void initialiseGraphe(){
		
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
		
		tabCases[45].setPion(new Pion("rouge"));
		tabCases[46].setPion(new Pion("rouge"));
		tabCases[47].setPion(new Pion("rouge"));
		
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
			
			tabCases[i].setPion(new Pion("rouge"));
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
			
			tabCases[i].setPion(new Pion("rouge"));
		}
	}
	
	public String getModeJeu(){
		return modeJeu;
	}
	
	public void setModeJeu(String mode){
		modeJeu=mode;
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
	
	public boolean estBordure(Case parCase){
		
		int id = parCase.getId();
		
		if((id==0)||(id==1)||(id==2)||(id==3)||(id==4)){
			return true;
		}
		if((id==5)||(id==11)||(id==18)||(id==26)||(id==35)||(id==43)||(id==50)){
			return true;
		}
		if((id==10)||(id==17)||(id==25)||(id==34)||(id==42)||(id==49)||(id==55)){
			return true;
		}
		if((id==56)||(id==57)||(id==58)||(id==59)||(id==60)){
			return true;
		}
		return false;
	}
	
	public void afficherC(){
		/* ETAGE 0 */
		
		System.out.print("    ");
		
		for(int i = 0; i < 5; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
			
		}
		
		System.out.println(" ");
		System.out.print("   ");
		
		/* ETAGE 1 */
		for(int i = 5; i < 11; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		System.out.println(" ");
		System.out.print("  ");
		
		/* ETAGE 2 */
		for(int i = 11; i < 18; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		System.out.println(" ");
		System.out.print(" ");

		/* ETAGE 3 */
		for(int i = 18; i < 26; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		
		System.out.println("");
		/* ETAGE 4 */
		for(int i = 26; i < 35; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		System.out.println(" ");
		System.out.print(" ");
				
		/* ETAGE 5 */
		for(int i = 35; i < 43; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		System.out.println(" ");
		System.out.print("  ");
		
		/* ETAGE 6 */
		for(int i = 43; i < 50; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
			
		}
		System.out.println(" ");
		System.out.print("   ");
		
		/* ETAGE 7 */
		for(int i = 50; i < 56; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		
		System.out.println(" ");
		System.out.print("    ");
		/* ETAGE 8 */
		for(int i = 56; i < 61; i++)
		{
			System.out.print(" ");
			this.afficher_couleur(i);
		}
		
		
		System.out.println(" ");
		System.out.print("       ");
	}
	
	public void afficher(){
		/* ETAGE 0 */
		
		System.out.print("        ");
		
		for(int i = 0; i < 5; i++){
			System.out.print("  0"+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("      ");
		
		/* ETAGE 1 */
		for(int i = 5; i < 11; i++){
			System.out.print("  0"+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("    ");
		
		/* ETAGE 2 */
		for(int i = 11; i < 18; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("  ");

		/* ETAGE 3 */
		for(int i = 18; i < 26; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");
		
		/* ETAGE 4 */
		for(int i = 26; i < 35; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("  ");
		
		/* ETAGE 5 */
		for(int i = 35; i < 43; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("    ");
		
		/* ETAGE 6 */
		for(int i = 43; i < 50; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");
		System.out.print("      ");
		
		/* ETAGE 7 */
		for(int i = 50; i < 56; i++){
			System.out.print("  "+tabCases[i].getId());
			}
		
		System.out.println(" ");	
		System.out.print("        ");
		
		/* ETAGE 8 */
		for(int i = 56; i < 61; i++){
			System.out.print("  "+tabCases[i].getId());
		}
		
		System.out.println(" ");
	}
	
	public String estAligne(Case case1,Case case2,Case case3){
		// prend 3 boules et retourne la direction d'alignement des 3 boules
		
		if(case3.getId()==-1){
			if(case2.getId()==-1){
				return "TOUTES";
			}
			else{
				if((case1.getVoisinHautGauche()==case2)||(case1.getVoisinBasDroit()==case2))
				{return "HAUT_GAUCHE";}
				if((case1.getVoisinHautDroit()==case2)||(case1.getVoisinBasGauche()==case2))
				{return "HAUT_DROITE";}
				if((case1.getVoisinDroit()==case2)||(case1.getVoisinGauche()==case2))
				{return "DROITE";}
				return "AUCUNE";
			}
		}
		
		  
		
		if( (((case1.getVoisinHautDroit()==case2)||(case1.getVoisinHautDroit()==case3))
			&&((case1.getVoisinHautDroit().getVoisinHautDroit()==case2)||(case1.getVoisinHautDroit().getVoisinHautDroit()==case3)))
			||(((case1.getVoisinHautDroit()==case2)||(case1.getVoisinHautDroit()==case3))
			&&((case1.getVoisinBasGauche()==case2)||(case1.getVoisinBasGauche()==case3)))
			||(((case1.getVoisinBasGauche()==case2)||(case1.getVoisinBasGauche()==case3))
			&&((case1.getVoisinBasGauche().getVoisinBasGauche()==case2)||(case1.getVoisinBasGauche().getVoisinBasGauche()==case3)))
		   ){return "HAUT_DROIT";} 
		
		if( (((case1.getVoisinHautGauche()==case2)||(case1.getVoisinHautGauche()==case3))
			&&((case1.getVoisinHautGauche().getVoisinHautGauche()==case2)||(case1.getVoisinHautGauche().getVoisinHautGauche()==case3)))
			||(((case1.getVoisinHautGauche()==case2)||(case1.getVoisinHautGauche()==case3))
			&&((case1.getVoisinBasDroit()==case2)||(case1.getVoisinBasDroit()==case3)))
			||(((case1.getVoisinBasDroit()==case2)||(case1.getVoisinBasDroit()==case3))
			&&((case1.getVoisinBasDroit().getVoisinBasDroit()==case2)||(case1.getVoisinBasDroit().getVoisinBasDroit()==case3)))
		   ){return "HAUT_GAUCHE";} 
		
		if( (((case1.getVoisinDroit()==case2)||(case1.getVoisinDroit()==case3))
			&&((case1.getVoisinDroit().getVoisinDroit()==case2)||(case1.getVoisinDroit().getVoisinDroit()==case3)))
			||(((case1.getVoisinDroit()==case2)||(case1.getVoisinDroit()==case3))
			&&((case1.getVoisinGauche()==case2)||(case1.getVoisinGauche()==case3)))
			||(((case1.getVoisinGauche()==case2)||(case1.getVoisinGauche()==case3))
			&&((case1.getVoisinGauche().getVoisinGauche()==case2)||(case1.getVoisinGauche().getVoisinGauche()==case3)))
		   ){return "DROITE";} 
		
		return "AUCUNE";
	}
	
	public boolean alignementBoule(Case case1,Case case2,Case case3,String direction){
		// determine si la direction choisit est la meme que l'alignement des boules
		
		if((direction=="hautGauche")||(direction=="basDroite")){
			if(estAligne(case1,case2,case3)=="HAUT_GAUCHE"){
				return true;
			}
			else{
				return false;
			}
		}
		
		if((direction=="droite")||(direction=="gauche")){
			if(estAligne(case1,case2,case3)=="DROITE"){
				return true;
			}
			else{
				return false;
			}
		}
		
		if((direction=="hautDroite")||(direction=="basGauche")){
			if(estAligne(case1,case2,case3)=="HAUT_DROITE"){
				return true;
			}
			else{
				return false;
			}
		}
		
		return true;
	}
	
	public void remplirTableau(Case parCase){
		int i=0;
		
		for(int j=0;j<caseSelectione.length;j++){
			if(parCase.getId()==caseSelectione[j].getId()){
				System.out.println("La case a deja ete selectione");
				return ;
			}
		}
		
		if(parCase.getPion()==null){
			System.out.println("La case est vide");
			return ;
		}
		
		while(caseSelectione[i].getId()!=-1){
			i++;
			
			if(i==3)
			{break;}
		}
	
		if(i<=2){
			caseSelectione[i]=parCase;
		}
		else{
			viderTableau();
			caseSelectione[0]=parCase;
		}
	}
	
	public void viderTableau(){
		for(int i=0;i<caseSelectione.length;i++){
			caseSelectione[i]=new Case(-1, null,0,null,null,null,null,null,null);
		}
	}
	
	public void afficherTableau(){ // FONCTION DE DEBEUGUAGE
		for(int i=0;i<3;i++){
			if(caseSelectione[i].getId()==-1)
			{System.out.print(" NULL ");}
			else
			{System.out.print(" "+caseSelectione[i].getId()+" ");}
		}
		System.out.println(" ");
	}
	
	public int nbCaseSelectione(){ // determine le nombre de cases selectionées
		int i=0;
		
		while(caseSelectione[i].getId()!=-1){
			i++;
			
			if(i==3)
			{break;}
		}
		
		return i;
	}

	public Case getCaseSelectione(int indice){
		return caseSelectione[indice];
	}
	
	public int tirageAuSort(){ // renvoit 0 ou 1
		 return (int)( Math.random()*2);
	}
	
	public int nbBouleParCouleur(String couleur){ // Compte le nombre de boule d'une couleur sur le plateau
		int cpt=0;
		
		for(int i=0;i<tabCases.length;i++){
			if(tabCases[i].getPion()!=null){
				if(tabCases[i].getPion().getCouleur()==couleur){
					cpt++;
				}
			}
		}
		return cpt;
	}
	
	public boolean chevauchementCouleur(Case case1,String direction){ // determine si il y a un chevauchement de couleur suivant une direction
		Case case2=new Case();
		int a=0;
		int cpt=0;
		
		if(estBordure(case1)){
			return false;
		}
		
		while(case1.getPion()!=null){
			
			
			if(direction=="hautDroite"){ // HAUT DROITE
				if(estBordure(case1.getVoisinHautDroit())){
					a=1;
				}
				
				case2=case1.getVoisinHautDroit();
				
				if(case2.getPion()==null){
					break;
				}
			}
			if(direction=="droite"){ // DROITE
				if(estBordure(case1.getVoisinDroit())){
					a=1;
				}
				case2=case1.getVoisinDroit();
				
				if(case2.getPion()==null){
					break;
				}
			}
			if(direction=="basDroite"){ // BAS DROITE
				if(estBordure(case1.getVoisinBasDroit())){
					a=1;
				}
				case2=case1.getVoisinBasDroit();
				
				if(case2.getPion()==null){
					break;
				}
			}
			if(direction=="basGauche"){ // BAS GAUCHE
				if(estBordure(case1.getVoisinBasGauche())){
					a=1;
				}
				case2=case1.getVoisinBasGauche();
				
				if(case2.getPion()==null){
					break;
				}
			}
			if(direction=="gauche"){ // GAUCHE
				if(estBordure(case1.getVoisinGauche())){
					a=1;
				}
				case2=case1.getVoisinGauche();
				
				if(case2.getPion()==null){
					break;
				}
			}
			if(direction=="hautGauche"){ // HAUT CAUCHE
				if(estBordure(case1.getVoisinHautGauche())){
					a=1;
				}
				case2=case1.getVoisinHautGauche();
				
				if(case2.getPion()==null){
					break;
				}
			}
			
			if(case1.getPion().getCouleur()!=case2.getPion().getCouleur()){
				cpt++;
			}
			
			if(cpt>=2){
				return true;
			}
			
			if(a==1){
				break;
			}
			
			if(direction=="hautDroite"){ // HAUT DROITE
				case1=case1.getVoisinHautDroit();
			}
			if(direction=="droite"){ // DROITE
				case1=case1.getVoisinDroit();
			}
			if(direction=="basDroite"){ // BAS DROITE
				case1=case1.getVoisinBasDroit();
			}
			if(direction=="basGauche"){ // BAS GAUCHE
				case1=case1.getVoisinBasGauche();
			}
			if(direction=="gauche"){ // GAUCHE
				case1=case1.getVoisinGauche();
			}
			if(direction=="hautGauche"){ // HAUT CAUCHE
				case1=case1.getVoisinHautGauche();
			}	
		}
		return false;
	}
	
	public boolean caseArriveeVide(Case case1,Case case2,Case case3,String direction){ // determine si les cases d'arrivées sont vide
		if(direction=="hautGauche"){
			return testCaseArriveVideHautGauche(case1,case2,case3);
		}
		if(direction=="hautDroite"){
			return testCaseArriveVideHautDroit(case1,case2,case3);
		}
		if(direction=="droite"){
			return testCaseArriveVideDroit(case1,case2,case3);
		}
		if(direction=="basDroite"){
			return testCaseArriveVideBasDroit(case1,case2,case3);
		}
		if(direction=="basGauche"){
			return testCaseArriveVideBasGauche(case1,case2,case3);
		}
		if(direction=="gauche"){
			return testCaseArriveVideGauche(case1,case2,case3);
		}
		
		return true;
	}
	
	public boolean testCaseArriveVideHautGauche(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		
		if(case3.getId()!=-1){
			if(case3.getVoisinHautGauche()==null){
				a=1;
			}
			if((case3.getVoisinHautGauche()!=null)&&(case3.getVoisinHautGauche().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinHautGauche()!=null)&&(case3.getVoisinHautGauche().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinHautGauche()==null){
				b=1;
			}
			if((case2.getVoisinHautGauche()!=null)&&(case2.getVoisinHautGauche().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinHautGauche()!=null)&&(case2.getVoisinHautGauche().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinHautGauche()==null){
			c=1;
		}
		if((case1.getVoisinHautGauche()!=null)&&(case1.getVoisinHautGauche().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinHautGauche()!=null)&&(case1.getVoisinHautGauche().getPion()!=null)){
			c=0;
		}
		
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean testCaseArriveVideHautDroit(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		if(case3.getId()!=-1){
			if(case3.getVoisinHautDroit()==null){
				a=1;
			}
			if((case3.getVoisinHautDroit()!=null)&&(case3.getVoisinHautDroit().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinHautDroit()!=null)&&(case3.getVoisinHautDroit().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinHautDroit()==null){
				b=1;
			}
			if((case2.getVoisinHautDroit()!=null)&&(case2.getVoisinHautDroit().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinHautDroit()!=null)&&(case2.getVoisinHautDroit().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinHautDroit()==null){
			c=1;
		}
		if((case1.getVoisinHautDroit()!=null)&&(case1.getVoisinHautDroit().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinHautDroit()!=null)&&(case1.getVoisinHautDroit().getPion()!=null)){
			c=0;
		}
	
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean testCaseArriveVideDroit(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		if(case3.getId()!=-1){
			if(case3.getVoisinDroit()==null){
				a=1;
			}
			if((case3.getVoisinDroit()!=null)&&(case3.getVoisinDroit().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinDroit()!=null)&&(case3.getVoisinDroit().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinDroit()==null){
				b=1;
			}
			if((case2.getVoisinDroit()!=null)&&(case2.getVoisinDroit().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinDroit()!=null)&&(case2.getVoisinDroit().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinDroit()==null){
			c=1;
		}
		if((case1.getVoisinDroit()!=null)&&(case1.getVoisinDroit().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinDroit()!=null)&&(case1.getVoisinDroit().getPion()!=null)){
			c=0;
		}
	
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean testCaseArriveVideBasDroit(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		if(case3.getId()!=-1){
			if(case3.getVoisinBasDroit()==null){
				a=1;
			}
			if((case3.getVoisinBasDroit()!=null)&&(case3.getVoisinBasDroit().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinBasDroit()!=null)&&(case3.getVoisinBasDroit().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinBasDroit()==null){
				b=1;
			}
			if((case2.getVoisinBasDroit()!=null)&&(case2.getVoisinBasDroit().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinBasDroit()!=null)&&(case2.getVoisinBasDroit().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinBasDroit()==null){
			c=1;
		}
		if((case1.getVoisinBasDroit()!=null)&&(case1.getVoisinBasDroit().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinBasDroit()!=null)&&(case1.getVoisinBasDroit().getPion()!=null)){
			c=0;
		}
	
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean testCaseArriveVideBasGauche(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		if(case3.getId()!=-1){
			if(case3.getVoisinBasGauche()==null){
				a=1;
			}
			if((case3.getVoisinBasGauche()!=null)&&(case3.getVoisinBasGauche().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinBasGauche()!=null)&&(case3.getVoisinBasGauche().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinBasGauche()==null){
				b=1;
			}
			if((case2.getVoisinBasGauche()!=null)&&(case2.getVoisinBasGauche().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinBasGauche()!=null)&&(case2.getVoisinBasGauche().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinBasGauche()==null){
			c=1;
		}
		if((case1.getVoisinBasGauche()!=null)&&(case1.getVoisinBasGauche().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinBasGauche()!=null)&&(case1.getVoisinBasGauche().getPion()!=null)){
			c=0;
		}
	
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean testCaseArriveVideGauche(Case case1,Case case2,Case case3){
		int a=2;
		int b=2; 
		int c=2;
		
		if(case3.getId()!=-1){
			if(case3.getVoisinGauche()==null){
				a=1;
			}
			if((case3.getVoisinGauche()!=null)&&(case3.getVoisinGauche().getPion()==null)){
				a=1;
			}
			if((case3.getVoisinGauche()!=null)&&(case3.getVoisinGauche().getPion()!=null)){
				a=0;
			}
		}
		if(case2.getId()!=-1){
			if(case2.getVoisinGauche()==null){
				b=1;
			}
			if((case2.getVoisinGauche()!=null)&&(case2.getVoisinGauche().getPion()==null)){
				b=1;
			}
			if((case2.getVoisinGauche()!=null)&&(case2.getVoisinGauche().getPion()!=null)){
				b=0;
			}
		}
		
		if(case1.getVoisinGauche()==null){
			c=1;
		}
		if((case1.getVoisinGauche()!=null)&&(case1.getVoisinGauche().getPion()==null)){
			c=1;
		}
		if((case1.getVoisinGauche()!=null)&&(case1.getVoisinGauche().getPion()!=null)){
			c=0;
		}
	
		if((a==0)||(b==0)||(c==0)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public Case determierCaseADeplacer(Case case1,Case case2,Case case3,String direction){ 
		// PREND 3 CASES ET DETERMINE LA QUEL EST A DEPLACER EN PREMIERE
		
		if((case3.getId()==-1)&&(case2.getId()==-1)){
			return case1;
		}
		
		if((case3.getId()==-1)&&(case2.getId()!=-1)){
			if((direction=="hautGauche")||(direction=="hautDroite")||(direction=="gauche")){
				if(case2.getId()>case1.getId()){
					return case2;
				}
				else{
					return case1;
				}
			}
			if((direction=="basDroite")||(direction=="basGauche")||(direction=="droite")){
				if(case2.getId()<case1.getId()){
					return case2;
				}
				else{
					return case1;
				}
			}
		}
		else{
			if((direction=="hautGauche")||(direction=="hautDroite")||(direction=="gauche")){
				if((case3.getId()>case1.getId())&&(case3.getId()>case2.getId())){
					return case3;
				}
				if((case2.getId()>case1.getId())&&(case2.getId()>case3.getId())){
					return case2;
				}
				else{
					return case1;
				}
			}
			if((direction=="basDroite")||(direction=="basGauche")||(direction=="droite")){
				if((case3.getId()<case1.getId())&&(case3.getId()<case2.getId())){
					return case3;
				}
				if((case2.getId()<case1.getId())&&(case2.getId()<case3.getId())){
					return case2;
				}
				else{
					return case1;
				}
			}
		}
		return case1;
	}
	
	public void deplacerBouleDroite(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinDroit()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			
			
			case1=case1.getVoisinDroit();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinDroit()==null)
			{break;}
		}
	}
	
	public void deplacerBouleBasDroite(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinBasDroit()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			case1=case1.getVoisinBasDroit();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinBasDroit()==null)
			{break;}
		}
	}
	
	public void deplacerBouleBasGauche(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinBasGauche()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			
			case1=case1.getVoisinBasGauche();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinBasGauche()==null)
			{break;}
		}
	}
	
	public void deplacerBouleGauche(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinGauche()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			
			case1=case1.getVoisinGauche();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinGauche()==null)
			{break;}
		}
	}
	
	public void deplacerBouleHautGauche(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinHautGauche()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			
			case1=case1.getVoisinHautGauche();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinHautGauche()==null)
			{break;}
		}
	}
	
	public void deplacerBouleHautDroit(Case case1){
		
		String caseTmp1;
		String caseTmp2;
		
		caseTmp1=case1.getPion().getCouleur();
		case1.setPion(null);
		
		if(case1.getVoisinHautDroit()==null) // si la case suivante est null, on sort.
		{return ;}
		
		while(true){
			
			case1=case1.getVoisinHautDroit();
			
			if(case1.getPion()==null){
				Pion p=new Pion(caseTmp1);
				case1.setPion(p);
				// on creer le pion et on initialise sa couleur a celle de la case précédente.
				break;
			}
			
			caseTmp2=case1.getPion().getCouleur();
			case1.getPion().setCouleur(caseTmp1);
			caseTmp1=caseTmp2;
			
			if(case1.getVoisinHautDroit()==null)
			{break;}
		}
	}
	
	

	public void afficher_couleur(int i)
	{
			if(getCase(i).getPion()==null)
			{
				System.out.print(""+"O");
			}
			else
			{
				if (getCase(i).getPion().getCouleur()=="noir")
				{
					System.out.print(""+"N");
				}
				if(getCase(i).getPion().getCouleur()=="rouge")
				{
					System.out.print(""+"R");
				}
			}
			
	}
	
	public boolean sumito(Case a,String direction)
	{ // Determine si il y a position de sumito
		int cptrouge=0,cptnoir=0;
		
		String color =a.getPion().getCouleur();
		
		while((a!=null)&&(a.getPion()!=null))
		{
			if (a.getPion().getCouleur()=="rouge")
			{
				cptrouge++;
			}
			if (a.getPion().getCouleur()=="noir")
			{
				cptnoir++;
			}
			if(direction=="droite")
			{
				a=a.getVoisinDroit();
			}
			if(direction=="gauche")
			{
				a=a.getVoisinGauche();
			}
			if(direction=="hautGauche")
			{
				a=a.getVoisinHautGauche();
			}
			if(direction=="hautDroite")
			{
				a=a.getVoisinHautDroit();
			}
			if(direction=="basDroite")
			{
				a=a.getVoisinBasDroit();
			}
			if(direction=="basGauche")
			{
				a=a.getVoisinBasGauche();
			}
		}
		if (color=="rouge")
		{
			if((cptrouge>cptnoir)&&(cptrouge<=3))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		if (color=="noir")
		{
			if((cptrouge<cptnoir)&&(cptnoir<=3))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean pasDeMur(Case case1,String direction){
		// determine si il y a un mur ou non suivant une direction
		
		while(case1.getPion()!=null){
			
			if(estBordure(case1)){
				return true;
			}
			
			if(direction=="hautGauche"){
				if(case1.getVoisinHautGauche().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinHautGauche();
			}
			if(direction=="hautDroite"){
				if(case1.getVoisinHautDroit().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinHautDroit();
			}
			if(direction=="droite"){
				if(case1.getVoisinDroit().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinDroit();
			}
			if(direction=="basDroite"){
				if(case1.getVoisinBasDroit().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinBasDroit();
			}
			if(direction=="basGauche"){
				if(case1.getVoisinBasGauche().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinBasGauche();			
			}
			if(direction=="gauche"){
				if(case1.getVoisinGauche().getEtat()==1){
					return false;
				}
				case1=case1.getVoisinGauche();
			}
		}
		return true;
	}

	
	public boolean deplacementPossible(Case case1,Case case2,Case case3,String direction){
		// fonction prenant 3 boules et une direction, et determine si un deplacement est possible.
		
		Case caseTest=new Case();
		
		if(estAligne(case1,case2,case3)=="AUCUNE"){
			return false;
		}
		
		if(alignementBoule(case1,case2,case3,direction)){
			caseTest=determierCaseADeplacer(case1,case2,case3,direction);
			
			if(!pasDeMur(caseTest,direction)){
				return false;
			}
			
			if(chevauchementCouleur(caseTest,direction)){
				return false;
			}
			
			if(!sumito(caseTest,direction)){
				return false;
			}
			
			return true; // si il n'y a pas de mur, pas de chevauchement de couleur et sumito alors c'est bon
		}
		else{
			if( (caseArriveeVide(case1,case2,case3,direction))
					&&(pasDeMur(case1,direction))
					&&(pasDeMur(case2,direction))
					&&(pasDeMur(case3,direction)) ){
				return true;
			}
			else{
				return false;
			}
		}	
	}
	
	// Fonction de test
	public void testSumito(Case case1)
	{
		if(sumito(case1,"hautGauche"))
		{
			System.out.println("hautGauche");
		}
		if(sumito(case1,"hautDroite"))
		{
			System.out.println("hautDroite");
		}
		if(sumito(case1,"droite"))
		{
			System.out.println("droite");
		}
		if(sumito(case1,"basDroite"))
		{
			System.out.println("basDroite");
		}
		if(sumito(case1,"basGauche"))
		{
			System.out.println("basGauche");
		}
		if(sumito(case1,"gauche"))
		{
			System.out.println("gauche");
		}
	}
	
	public void testDirection(Case case1,Case case2,Case case3){
		// FONCTION DE TEST
		
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"hautGauche")){
			System.out.println("hautGauche");
		}
				
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"hautDroite")){
			System.out.println("hautDroite");
		}	
		
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"droite")){
			System.out.println("droite");
		}
		
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"basDroite")){
			System.out.println("basDroite");
		}
		
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"basGauche")){
			System.out.println("basGauche");
		}
		
		if(caseArriveeVide(getCaseSelectione(0),getCaseSelectione(1),getCaseSelectione(2),"gauche")){
			System.out.println("gauche");
		}
	}
	
	public void testChevauchementCouleur(Case case1){
		// FONCTION DE TEST
		if(chevauchementCouleur(case1,"hautGauche")){
			System.out.println("hautGauche");
		}
		if(chevauchementCouleur(case1,"hautDroite")){
			System.out.println("hautDroite");
		}
		if(chevauchementCouleur(case1,"droite")){
			System.out.println("droite");
		}
		if(chevauchementCouleur(case1,"basDroite")){
			System.out.println("basDroite");
		}
		if(chevauchementCouleur(case1,"basGauche")){
			System.out.println("basGauche");
		}
		if(chevauchementCouleur(case1,"gauche")){
			System.out.println("gauche");
		}
	}
}


