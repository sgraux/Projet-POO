package vue2;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import uidelegate.Case;

public class BoutonCase extends JButton{
	
	private Case casePlateau = null;
	private ImageIcon iconNonSelect;
	
	public BoutonCase(){
		casePlateau = null;
	}
	
	public BoutonCase(Case parCasePlateau){
		super();
		casePlateau = parCasePlateau;
	}

	public BoutonCase(ImageIcon parImage) {
		super(parImage);
		iconNonSelect = parImage;
		// TODO Auto-generated constructor stub
	}
	
	public void setIconBase(ImageIcon parIcon){
		this.setIcon(parIcon);
		iconNonSelect = parIcon;
	}

	public Case getCasePlateau() {
		return casePlateau;
	}

	public void setCasePlateau(Case casePlateau) {
		this.casePlateau = casePlateau;
	}
	
	public ImageIcon getIconNonSelect(){
		return iconNonSelect;
	}
	
	

}
