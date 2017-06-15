package vue2;

import javax.swing.JButton;

import uidelegate.Case;

public class BoutonCase extends JButton{
	
	private Case casePlateau;
	
	public BoutonCase(Case parCasePlateau){
		super();
		casePlateau = parCasePlateau;
	}

}
