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
		if(variante=="trouNoir"){
			((DamierAbalone)damier).tabCases[21].setVoisinBasDroit(null);
			((DamierAbalone)damier).tabCases[22].setVoisinBasGauche(null);
			((DamierAbalone)damier).tabCases[29].setVoisinDroit(null);
			((DamierAbalone)damier).tabCases[38].setVoisinHautDroit(null);
			((DamierAbalone)damier).tabCases[39].setVoisinHautGauche(null);
			((DamierAbalone)damier).tabCases[31].setVoisinGauche(null);
		}
		
		if(variante=="mur"){
			((DamierAbalone)damier).tabCases[29].setEtat(1);
			((DamierAbalone)damier).tabCases[30].setEtat(1);
			((DamierAbalone)damier).tabCases[31].setEtat(1);
		}
		
		couleurJoueur="blanc";
	}
	
	public int appliqueCoup(){
		if(nbCaseSelectione()==0){
			return 0;
			// si le joueur n'a pas selectioner de case, alors pas de deplacement possible
		}
		
		if(((DamierAbalone)damier).deplacementPossible(caseSelectione[0],caseSelectione[1],caseSelectione[2],direction,variante)){
			Case tmp=new Case();
			
			if(!((DamierAbalone)damier).alignementBoule(caseSelectione[0],caseSelectione[1],caseSelectione[2],direction)){
				// si la direction d'alignement des boules =/= direction choisit par le Joueur
				
				((DamierAbalone)damier).deplacerBoule(caseSelectione[0],direction);
				
				if(caseSelectione[1].getId()!=-1){
					((DamierAbalone)damier).deplacerBoule(caseSelectione[1],direction);
				}
				if(caseSelectione[2].getId()!=-1){
					((DamierAbalone)damier).deplacerBoule(caseSelectione[2],direction);
				}
				
				if(couleurJoueur=="noir"){
					couleurJoueur="blanc";
				}
				else{
					couleurJoueur="noir";
				}
				viderTableau();
				
				if( (((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8) || (((DamierAbalone)damier).nbBouleParCouleur("noir")<=8) ){
					if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
						viderTableau();
						return 2;
					}
					if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
						viderTableau();
						return 3;
					}
				}
				
				return 1;
			}
			
			tmp=((DamierAbalone)damier).determierCaseADeplacer(caseSelectione[0],caseSelectione[1],caseSelectione[2],direction);
			
			((DamierAbalone)damier).deplacerBoule(tmp,direction);
			
			
			if( (((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8) || (((DamierAbalone)damier).nbBouleParCouleur("noir")<=8) ){
				if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
					viderTableau();
					return 2;
				}
				if(((DamierAbalone)damier).nbBouleParCouleur("blanc")<=8){
					viderTableau();
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
			viderTableau();
			return 1;
		}
		else{
			System.out.println("Pas de deplacement possible avec les boules selectionnees");
			// AFFICHER A L'ECRAN QUE LE DEPLACEMENT N'EST PAS POSSIBLE
			viderTableau();
			return 0;
		}
	}
	
	public int appliqueCoupIA(){
		
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
		return 1;
	}

	public Case[] getCaseSelectione() {
		return caseSelectione;
	}

	public void setCaseSelectione(Case[] caseSelectione) {
		this.caseSelectione = caseSelectione;
	}

	public String getDirection() {
		return direction;
	}

	public void setCouleurJoueur(String couleurJoueur) {
		this.couleurJoueur = couleurJoueur;
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
			
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"hautGauche",variante)&&(colleBouleAdverse(utile,"hautGauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"hautGauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"hautDroite",variante)&&(colleBouleAdverse(utile,"hautDroite"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"hautDroite");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"droite",variante)&&(colleBouleAdverse(utile,"droite"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"droite");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"gauche",variante)&&(colleBouleAdverse(utile,"gauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"gauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"basGauche",variante)&&(colleBouleAdverse(utile,"basGauche"))){
				a=false;
				((DamierAbalone)damier).deplacerBoule(utile,"basGauche");
			}
			if((a)&&((DamierAbalone)damier).deplacementPossible(utile,innutile,innutile,"basDroite",variante)&&(colleBouleAdverse(utile,"basDroite"))){
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
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"basGauche",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"basDroite",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;			
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"droite",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;				
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"gauche",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;				
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"hautGauche",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
				if((b)&&(((DamierAbalone)damier).tabCases[i].getPion()!=null)
						&&(((DamierAbalone)damier).tabCases[i].getPion().getCouleur()=="noir")
						&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[i],innutile,innutile,"hautDroite",variante)){
					remplirPossibiliteDeplacement(i);
					nb++;
					b=false;
				}
			}
			
			alea=petitNombreAlea(nb/3);
						
			if( (c)&&(((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basGauche",variante)
					&&(((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basDroite",variante))) ){
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
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basDroite",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basDroite");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"basGauche",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"basGauche");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"gauche",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"gauche");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"droite",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"droite");
				c=false;			
			}
			if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"hautGauche",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"hautGauche");
				c=false;			
			}if((c)&&((DamierAbalone)damier).deplacementPossible(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],innutile,innutile,"hautDroite",variante)){
				((DamierAbalone)damier).deplacerBoule(((DamierAbalone)damier).tabCases[possibiliteDeplacement[alea]],"hautDroite");
				c=false;			
			}
		}
	}
	
	public void remplirTableau(Case case1,String couleur){
	// remplie le tableau des cases Selectione
		
		int i=0;
		
		for(int j=0;j<caseSelectione.length;j++){
			if(case1.getId()==caseSelectione[j].getId()){
				System.out.println("La case a deja ete selectione");
				return ;
			}
		}
		
		if(case1.getPion()==null){
			System.out.println("La case est vide");
			return ;
		}
		
		while(caseSelectione[i].getId()!=-1){
			i++;
			
			if(i==3)
			{break;}
		}
	
		if(i<=2){
			if(case1.getPion().getCouleur()!=couleur){
				System.out.println("Choisissez une case de votre couleur");
				return ;
			}
			caseSelectione[i]=case1;
		}
		else{
			if(case1.getPion().getCouleur()!=couleur){
				System.out.println("Choisissez une case de votre couleur");
				return ;
			}
			viderTableau();
			caseSelectione[0]=case1;
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
	
	public void setDirection(String parDirecion){
		direction=parDirecion;
	}
	
	public String getCouleurJoueur(){
		return couleurJoueur;
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

