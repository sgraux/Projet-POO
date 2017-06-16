package uidelegate;

public class JeuAbalone extends Jeu{
	
	private int numCase;
	private String couleurJoueur; // couleur du joueur actuel
	private String direction; // direction selectione par un joueur
	private Case caseSelectione[];

	private int positionBouleIA[];
	private int possibiliteDeplacement[];

	public JeuAbalone(boolean parJoueContreIA, String parVariante) {
		super(parJoueContreIA, parVariante);
		damier = new DamierAbalone();

		// creation du tableau de case selectionees
		caseSelectione=new Case[3];
		       
		for(int i=0;i<caseSelectione.length;i++){
			caseSelectione[i]=new Case(-1, null,0,null,null,null,null,null,null);
		}
		
		// Implementation des variantes
		if(variante=="TrouNoir"){
			((DamierAbalone)damier).tabCases[21].setVoisinBasDroit(null);
			((DamierAbalone)damier).tabCases[22].setVoisinBasGauche(null);
			((DamierAbalone)damier).tabCases[29].setVoisinDroit(null);
			((DamierAbalone)damier).tabCases[38].setVoisinHautDroit(null);
			((DamierAbalone)damier).tabCases[39].setVoisinHautGauche(null);
			((DamierAbalone)damier).tabCases[31].setVoisinGauche(null);
		}
		
		if(variante=="Mur"){
			((DamierAbalone)damier).tabCases[29].setEtat(1);
			((DamierAbalone)damier).tabCases[30].setEtat(1);
			((DamierAbalone)damier).tabCases[31].setEtat(1);
		}
		
		couleurJoueur="blanc";
	}

	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void boucleJeu() {	
		
	}
	
	public int appliquerCoup(){
		if((joueContreIA)&&(couleurJoueur=="noir")){ // tour de l'IA
			IA();
			couleurJoueur="blanc";
			
			if( (((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8) || (((DamierAbalone)damier).nbBouleParCouleur("noir")<=8) ){
				if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
					return 2;
				}
				if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
					return 3;
				}
			}
		}
		else{ // tour d'un joueur
			if(nbCaseSelectione()==0){
				return 0;
				// si le joueur n'a pas selectioner de case, alors pas de deplacement possible
			}
			
			if(((DamierAbalone)damier).deplacementPossible(caseSelectione[0],caseSelectione[1],caseSelectione[2],direction)){
				Case tmp=new Case();
				
				tmp=((DamierAbalone)damier).determierCaseADeplacer(caseSelectione[0],caseSelectione[1],caseSelectione[2],direction);
				
				((DamierAbalone)damier).deplacerBoule(tmp,direction);
				
				
				if( (((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8) || (((DamierAbalone)damier).nbBouleParCouleur("noir")<=8) ){
					if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
						return 2;
					}
					if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
						return 3;
					}
				}
				
				// On change la couleur du joueur actuel
				if(couleurJoueur=="noir"){
					couleurJoueur="blanc";
				}
				else{
					couleurJoueur="noir";
				}
				return 1;
			}
			else{
				System.out.println("Pas de deplacement possible avec les boules selectionnees");
				// AFFICHER A L'ECRAN QUE LE DEPLACEMENT N'EST PAS POSSIBLE
				return 0;
			}
		}
		
		return 0;
	}

	public void IA(){
		int cpt=0;
		initIA();
		initPossibiliteDeplacementBoule();
		
		for(int i=0;i<((DamierAbalone)damier).tabCases.length;i++){
			if(((DamierAbalone)damier).tabCases[i].getPion()!=null){
				if(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir"){
					cpt++;
					remplirBouleIA(i);
				}
			}
		}
		
		Case utile=new Case();
		Case innutile=new Case(-1, null,0,null,null,null,null,null,null);		
		boolean a=true;
		
		for(int i=0;i<cpt;i++){ // si on peut faire bouger une boule de l'adversaire
			
			utile=((DamierAbalone)damier).tabCases[positionBouleIA[i]];
			
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"hautGauche")&&(colleBouleAdverse(utile,"hautGauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"hautGauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"hautDroite")&&(colleBouleAdverse(utile,"hautDroite"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"hautDroite");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"droite")&&(colleBouleAdverse(utile,"droite"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"droite");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"gauche")&&(colleBouleAdverse(utile,"gauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"gauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"basGauche")&&(colleBouleAdverse(utile,"basGauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"basGauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"basDroite")&&(colleBouleAdverse(utile,"basDroite"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"basDroite");
			}
		}
		
		boolean b=true;
		boolean c=true;
		int nb=0;
		int alea=0;
		
		if(a){ // si on arrive ici, c'est que l'IA n'a pas reussit a faire bouger de boule adverse
			for(int i=0;i<((DamierAbalone)damier).tabCases.length;i++){
				b=true;
				
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"basGauche")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"basDroite")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;			
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"droite")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;				
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"gauche")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;				
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"hautGauche")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"hautDroite")){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
			}
			
			alea=petitNombreAlea(nb/3);
						
			if( (c)&&(((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basGauche")
					&&(((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basDroite"))) ){
				int x=petitNombreAlea(1);
				
				if(x==0){
					((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basDroite");
					c=false;
				}
				else{
					((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basGauche");
					c=false;
				}
			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basDroite")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basDroite");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basGauche")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basGauche");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"gauche")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"gauche");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"droite")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"droite");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"hautGauche")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"hautGauche");
				c=false;			
			}if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"hautDroite")){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"hautDroite");
				c=false;			
			}
		}
	}
	
	public void remplirTableau(String couleur){
	// remplie le tableau des cases Selectione
		
		Case parCase=new Case();
		
		parCase=((DamierAbalone)damier).getCase(this.numCase);
		
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
			if(parCase.getPion().getCouleur()!=couleur){
				System.out.println("Choisissez une case de votre couleur");
				return ;
			}
			caseSelectione[i]=parCase;
		}
		else{
			if(parCase.getPion().getCouleur()!=couleur){
				System.out.println("Choisissez une case de votre couleur");
				return ;
			}
			viderTableau();
			caseSelectione[0]=parCase;
		}
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
	
	public Case getCaseSelectione(int indice){
		return caseSelectione[indice];
	}

	public void setNumCase(int parNumCase){
		numCase=parNumCase;
	}
	
	public int getNumCase(){
		return numCase;
	}
	
	public void remplirBouleIA(int indice){
		for(int i=0;i<positionBouleIA.length;i++){
			if(positionBouleIA[i]==-1){
				positionBouleIA[i]=indice;
				i=positionBouleIA.length;
			}
		}
	}
	
	public boolean colleBouleAdverse(Case case1,String direction){
		
		while(case1!=null){
			if(case1.getPion()!=null){
				if(case1.getPion().getCouleur()=="blanc"){
					return true;
				}
				else{
					if(direction=="hautGauche"){
						case1=case1.getVoisinHautGauche();
					}
					if(direction=="hautDroite"){
						case1=case1.getVoisinHautDroit();
					}
					if(direction=="droite"){
						case1=case1.getVoisinDroit();
					}
					if(direction=="gauche"){
						case1=case1.getVoisinGauche();
					}
					if(direction=="basDroite"){
						case1=case1.getVoisinBasDroit();
					}
					if(direction=="basGauche"){
						case1=case1.getVoisinBasGauche();
					}
				}
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	public void initIA(){
		positionBouleIA=new int[14];
		
		for(int i=0;i<positionBouleIA.length;i++){
			positionBouleIA[i]=-1;
		}
	}
	
	public void initPossibiliteDeplacementBoule(){
		possibiliteDeplacement=new int[14];
		
		for(int i=0;i<possibiliteDeplacement.length;i++){
			possibiliteDeplacement[i]=-1;
		}
	}
	
	public void remplirPossibiliteDeplacement(int indice){
		for(int i=0;i<possibiliteDeplacement.length;i++){
			if(possibiliteDeplacement[i]==-1){
				possibiliteDeplacement[i]=indice;
				i=possibiliteDeplacement.length;
			}
		}
	}
	
	
	public int petitNombreAlea(int nb){
		return (int) (Math.random() * (nb+1));
	}
}

/* 	    
TANT QUE LE JOUEUR N'A PAS CLIQUE SUR UNE FLECHE DIRECTIONELLE 
|
|   // Des que le joueur clique sur une case
|	damier.remplirTableau(CASE SUR LAQUEL LE JOUEUR A CLIQUER,couleurJoueur);
|_____	
 
// Des que le joueur clique sur une fleche directionelle

if(damier.nbCaseSelectione()==0){
	System.out.println("Vous n'avez selectionnez aucune case");
}
else{
	ON ENREGISTRE LA DIRECTION QUE LE JOUEUR A SELECTIONE

	// CONVENTION DE CODE POUR LES NOMS DE DIRECTION
	// hautGauche hautDroite droite gauche basGauche basDroite // 
	
	if(damier.deplacementPossible(LES 3 CASES SELECTONEES, DIRECTION)){
		Case tmp=new Case();
		
		tmp=damier.determinerCaseADeplacer(LES 3 CASES SELECTIONEES, DIRECTION);
		
		damier.deplacerBoule(tmp, DIRECTION);
		
		// On change la couleur du joueur actuel
		if(damier.getCouleurJoueur()=="noir"){
			damier.setCouleurJoueur("rouge");
		}
		else{
			damier.setCouleurJoueur("noir");
		}
		
	}
	else{
		System.out.println("Pas de deplcement possible avec les boules selectionnees");
		// AFFICHER A L'ECRAN QUE LE DEPLACEMENT N'EST PAS POSSIBLE
	}
}
*/

