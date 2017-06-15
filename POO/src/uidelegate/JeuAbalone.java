package uidelegate;

public class JeuAbalone extends Jeu{
	
	private String couleurJoueur; // couleur du joueur actuel
	private String direction; // direction selectione par un joueur
	private Case caseSelectione[];

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
	}

	@Override
	public boolean estVictoire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void boucleJeu() {	
		
	}

	public int tirageAuSort(){ // renvoit 0 ou 1
		 return (int)( Math.random()*2);
	}
		
	public void remplirTableau(Case parCase,String couleur){
	// remplie le tableau des cases Selectione
	
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

