package uidelegate;

public class DamierAbalone extends Damier{

	public DamierAbalone(){
		super(61);
		initialiseGraphe();
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
}
