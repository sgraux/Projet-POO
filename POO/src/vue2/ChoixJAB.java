package vue2;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChoixJAB extends JeuxPan implements ActionListener,Var {
	
	public ChoixJAB(Dimension dim) {
		super(dim);
		initPanel();
	}

	private String choixJ;
	
	public String getChoixJ() {
		return choixJ;
	}

	public void setChoixJ(String choixJ) {
		this.choixJ = choixJ;
	}
	
	
	
	private JRadioButton j2Button = new JRadioButton("2J");
	private	JRadioButton j3Button = new JRadioButton("AI");
	
	private CheckboxGroup moGroup = new CheckboxGroup();
	private JRadioButton mCButton = new JRadioButton("Classic");
    private JRadioButton mTNButton = new JRadioButton("Trou Noir");
    private JRadioButton mMuButton = new JRadioButton("Mur");
    
	private JButton v2 = new JButton("Valider");
	private	JButton v1 = new JButton("Valider");
	
	private JTextField tj2 = new JTextField("NomeJ2", 20);
	private JTextField tj1 = new JTextField("NomeJ1", 20);
	
	JButton com = new JButton("Commencer");
	
	private Object source;
	
	private String var;
	private boolean ia=true;
	private String nom;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	private String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public boolean getIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}
	

	@Override
	protected void initPanel() {
		//titre
				this.panel.setLayout(null);
			    JLabel label = new JLabel("Abalone:");	    
			    this.panel.add(label);
			    label.setFont(new Font("Verdana",1,40));
			    label.setForeground(Color.black);
			    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			    label.setBounds(10,0,220,50);
			    //nbj
			    JLabel label2 = new JLabel("#NB Joueur:#");	    
			    this.panel.add(label2);
			    label2.setFont(new Font("Verdana",1,40));
			    label2.setForeground(Color.black);
			    label2.setBounds(75,75,375,40);
			    
			    JLabel label3 = new JLabel("#Mode JEUX:#");	    
			    this.panel.add(label3);
			    label3.setFont(new Font("Verdana",1,30));
			    label3.setForeground(Color.black);
			    label3.setBounds(50,500,375,40);
			    
			    //radioButton
			    
			    j3Button.setSelected(true);
			    
			    
			    ButtonGroup group = new ButtonGroup();
			    group.add(j2Button);
			    group.add(j3Button);
			    
			    j2Button.addActionListener(this);
			    j3Button.addActionListener(this);
			    
			    ButtonGroup groupM = new ButtonGroup();
			    groupM.add(mCButton);
			    groupM.add(mTNButton);
			    groupM.add(mMuButton);
			    
			    mCButton.addActionListener(this);
			    mTNButton.addActionListener(this);
			    mMuButton.addActionListener(this);
			    
			    this.panel.add(j2Button);
		        j2Button.setBounds(200, 150, 50, 30);
		        j2Button.setBackground(Color.GRAY);
		        j2Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(j3Button);
		        j3Button.setBounds(400, 150, 50, 30);
		        j3Button.setBackground(Color.GRAY);
		        j3Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
				
		        this.panel.add(mCButton);
		        mCButton.setBounds(410, 500, 100, 40);
		        mCButton.setBackground(Color.GRAY);
		        mCButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(mTNButton);
		        mTNButton.setBounds(510, 500, 150, 40);
		        mTNButton.setBackground(Color.GRAY);
		        mTNButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(mMuButton);
		        mMuButton.setBounds(660, 500, 100, 40);
		        mMuButton.setBackground(Color.GRAY);
		        mMuButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        
		        this.panel.add(tj1);
		        tj1.setBounds(300, 200, 100, 30);
		        
		        
		        this.panel.add(tj2);
		        
		        
				v1.setBounds(425,200,100,30);
				this.panel.add(v1);
				v1.addActionListener(this);
				
				
				this.panel.add(v2);
				v2.addActionListener(this);
				
				com.setBounds(300,550,200,40);
				this.panel.add(com);
				com.addActionListener(this);
			    
		
	}
	
	@Override	
	public void actionPerformed(ActionEvent e) {
		source = e.getSource();
		
		if(source==j2Button){
			v2.setBounds(425,250,100,30);
			tj2.setBounds(300, 250, 100, 30);
			setIa(false);
		}
		else if(source==j3Button){
			setIa(true);
		}
		if(source==mCButton){
			setVar("rien");
				}
		else if(source==mTNButton){
			setVar("trouNoir");
		}
		else if(source==mMuButton){
			setVar("mur");
		}
		else if(source==com){
			if(getIa()==false && getVar()=="trouNoir"){
				frame.platABTN();
			}
			else if(getIa()==true && getVar()=="trouNoir"){
				frame.platABIATN();
				}
			else if(getIa()==false && getVar()=="mur"){
				frame.platABMU();
				}
			else if(getIa()==true && getVar()=="mur"){
				frame.platABIAMU();
				}
			else if(getIa()==false && getVar()=="rien"){
				frame.platAB();
				}
			else{
				frame.platABIA();
			}
		}
		if(source==v1){
			setNom(tj1.getText());
		}
		else if(source==v2){
			setNom(tj2.getText());
		}

}
}