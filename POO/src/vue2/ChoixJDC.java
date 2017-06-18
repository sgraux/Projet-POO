package vue2;
import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChoixJDC extends JeuxPan implements ActionListener {
	
	public ChoixJDC(Dimension dim) {
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

	
	private CheckboxGroup joGroup = new CheckboxGroup();
	private JRadioButton j2Button = new JRadioButton("2J");
    private JRadioButton j3Button = new JRadioButton("3J");
    private JRadioButton j4Button = new JRadioButton("4J");
    private JRadioButton j6Button = new JRadioButton("6J");
    private JRadioButton jaiButton = new JRadioButton("AI");
    
    private CheckboxGroup moGroup = new CheckboxGroup();
	private JRadioButton mCButton = new JRadioButton("Classic");
    private JRadioButton mRButton = new JRadioButton("Rapide");
    
    private JTextField tj1 = new JTextField("NomeJ1", 20);
    private JTextField tj2 = new JTextField("NomeJ2", 20);
    private JTextField tj3 = new JTextField("NomeJ3", 20);
    private JTextField tj4 = new JTextField("NomeJ4", 20);
    private JTextField tj5 = new JTextField("NomeJ5", 20);
    private JTextField tj6 = new JTextField("NomeJ6", 20);
    
    private JButton v1 = new JButton("Valider");
    private JButton v2 = new JButton("Valider");
    private	JButton v3 = new JButton("Valider");
    private JButton v4 = new JButton("Valider");
    private	JButton v5 = new JButton("Valider");
    private	JButton v6 = new JButton("Valider");
    
    JButton com = new JButton("Commencer");
	
    private String var;
	private boolean ia;
	private int nbJ;
	private String nom;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbJ() {
		return nbJ;
	}

	public void setNbJ(int nbJ) {
		this.nbJ = nbJ;
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
			    JLabel label = new JLabel("Dame Chinoise:");	    
			    this.panel.add(label);
			    label.setFont(new Font("Verdana",1,40));
			    label.setForeground(Color.black);
			    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			    label.setBounds(10,0,375,50);
				//nbJ
			    
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
			    
			    //choix
			    jaiButton.setSelected(true);

			    //Group the radio buttons.
			    ButtonGroup groupN = new ButtonGroup();
			    groupN.add(j2Button);
			    groupN.add(j3Button);
			    groupN.add(j4Button);
			    groupN.add(j6Button);
			    groupN.add(jaiButton);
			    
			    ButtonGroup groupM = new ButtonGroup();
			    groupM.add(mCButton);
			    groupM.add(mRButton);
			    
			    //Register a listener for the radio buttons.
			    j2Button.addActionListener(this);
			    j3Button.addActionListener(this);
			    j4Button.addActionListener(this);
			    j6Button.addActionListener(this);
			    jaiButton.addActionListener(this);
			    
			    mCButton.addActionListener(this);
			    mRButton.addActionListener(this);
			    //
			    
			    this.panel.add(j2Button);
		        j2Button.setBounds(140, 150, 50, 30);
		        j2Button.setBackground(Color.GRAY);
		        j2Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(j3Button);
		        j3Button.setBounds(200, 150, 50, 30);
		        j3Button.setBackground(Color.GRAY);
		        j3Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(j4Button);
		        j4Button.setBounds(260, 150, 50, 30);
		        j4Button.setBackground(Color.GRAY);
		        j4Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(j6Button);
		        j6Button.setBounds(320, 150, 50, 30);
		        j6Button.setBackground(Color.GRAY);
		        j6Button.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(jaiButton);
		        jaiButton.setBounds(440, 150, 50, 30);
		        jaiButton.setBackground(Color.GRAY);
		        jaiButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
			    
		        this.panel.add(mCButton);
		        mCButton.setBounds(410, 500, 100, 40);
		        mCButton.setBackground(Color.GRAY);
		        mCButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        this.panel.add(mRButton);
		        mRButton.setBounds(510, 500, 100, 40);
		        mRButton.setBackground(Color.GRAY);
		        mRButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		        
		        this.panel.add(tj1);
		        tj1.setBounds(300, 200, 100, 30);
		        
		        this.panel.add(tj2);
		        
		        this.panel.add(tj3);
		        
		        this.panel.add(tj4);
		        
		        this.panel.add(tj5);
		        
		        this.panel.add(tj6);
		        
		        
				v1.setBounds(425,200,100,30);
				this.panel.add(v1);
				v1.addActionListener(this);
				
				this.panel.add(v2);
				v2.addActionListener(this);
				
				this.panel.add(v3);
				v3.addActionListener(this);
				
				this.panel.add(v4);
				v4.addActionListener(this);
				
				this.panel.add(v5);
				v5.addActionListener(this);
				
				this.panel.add(v6);
				v6.addActionListener(this);
				
				
				com.setBounds(300,550,200,40);
				this.panel.add(com);
				com.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source==j2Button){
			tj2.setBounds(300, 250, 100, 30);
			v2.setBounds(425,250,100,30);
			setNbJ(2);
			setIa(false);
		}
		else if(source==j3Button){
			tj2.setBounds(300, 250, 100, 30);
			v2.setBounds(425,250,100,30);
			v3.setBounds(425,300,100,30);
			tj3.setBounds(300, 300, 100, 30);
			setNbJ(3);
			setIa(false);
		}
		else if(source==j4Button){
			tj2.setBounds(300, 250, 100, 30);
			v2.setBounds(425,250,100,30);
			v3.setBounds(425,300,100,30);
			tj3.setBounds(300, 300, 100, 30);
			v4.setBounds(425,350,100,30);
			tj4.setBounds(300, 350, 100, 30);
			setNbJ(4);
			setIa(false);
		}
		else if(source==j6Button){
			tj2.setBounds(300, 250, 100, 30);
			v2.setBounds(425,250,100,30);
			v3.setBounds(425,300,100,30);
			tj3.setBounds(300, 300, 100, 30);
			v4.setBounds(425,350,100,30);
			tj4.setBounds(300, 350, 100, 30);
			v5.setBounds(425,400,100,30);
			tj5.setBounds(300, 400, 100, 30);
			v6.setBounds(425,450,100,30);
			tj6.setBounds(300, 450, 100, 30);
			setNbJ(6);
			setIa(false);
			
			
		}
		else if(source==jaiButton){
			setNbJ(2);
			setIa(true);
		}
		else if(source==com){
			if(getNbJ()==2 && getIa()==false){
				frame.platDC2J();
			}
			else if(getIa()==true){
				frame.platDCIA();
				}
			else if(getNbJ()==3){
				frame.platDC3J();
				}
			else if(getNbJ()==4){
				frame.platDC4J();
				}
			else if(getNbJ()==5){
				frame.platDC5J();
				}
			else{
				frame.platDC6J();
			}
		}
		
		if(source==v1){
			setNom(tj1.getText());
		}
		else if(source==v2){
			setNom(tj2.getText());
		}
		else if(source==v3){
			setNom(tj3.getText());
		}
		else if(source==v4){
			setNom(tj4.getText());
		}
		else if(source==v5){
			setNom(tj5.getText());
		}
		else if(source==v6){
			setNom(tj6.getText());
		}
	}
	
}