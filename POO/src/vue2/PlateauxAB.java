package vue2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uidelegate.JeuAbalone;

public class PlateauxAB extends JeuxPan implements ActionListener{
	
	
	private String mode=null;
	
	public PlateauxAB(Dimension dim) {
		super(dim);
		initPanel();
	}
	//test
	int plateau[][]=
				{
		        {0,0,0,0,3,0,3,0,3,0,3,0,3,0,0,0,0},
		        {0,0,0,3,0,3,0,3,0,3,0,3,0,3,0,0,0},
		        {0,0,1,0,1,0,3,0,3,0,3,0,1,0,1,0,0},
		        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
		        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
		        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
		        {0,0,1,0,1,0,2,0,2,0,2,0,1,0,1,0,0},
		        {0,0,0,2,0,2,0,2,0,2,0,2,0,2,0,0,0},
		        {0,0,0,0,2,0,2,0,2,0,2,0,2,0,0,0,0}};
	
	private BoutonCase button[][]=new BoutonCase[9][17];
	private JeuAbalone jeuAb = new JeuAbalone(false, null);
	
	public PlateauxAB(Dimension dim, String mode) {
		super(dim);
		this.mode = mode;
	}
	private ImageIcon bArg = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billeargent.png")).getImage());
	private ImageIcon bBla = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billeblanc.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	private ImageIcon bNoi = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billenoir.png")).getImage());
	private ImageIcon bRou = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billerouge.png")).getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
	
	private JLabel label = new JLabel("J1(NOIR):");
	private JLabel label1 = new JLabel("J2(BLANC):");
	private JLabel label2 = new JLabel("scr");
	private JLabel label3 = new JLabel("scr");
	
	@Override
	protected void initPanel() {
		
		JPanel panel1 = new JPanel();
	    panel1.setLayout(new GridLayout(9,17));
	    panel1.setPreferredSize(new Dimension(500,500));
	    panel1.setBackground(Color.GRAY);
	    
	    for(int i=0;i<9;i++)
	    {  
	    	for(int j=0;j<17;j++)
	    		{
	    			button[i][j]=new BoutonCase(bArg);	
	    		}
	    }
	   
	    for(int i=0;i<9;i++)
	    {   
	    	for(int j=0;j<17;j++)
	    		{
	    		 button[i][j].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	    		 button[i][j].setBorderPainted(false);
	    		 button[i][j].setContentAreaFilled(false);
	    		 button[i][j].setFocusPainted(false);
	    		 button[i][j].setOpaque(false);
	    		 panel1.add(button[i][j]);
	    		
	    		}
	    }
	    int compteur=0;
	    for(int i=0;i<9;i++)
	    {   
	    	for(int j=0;j<17;j++)
	    		{
	          if(plateau[i][j]==1)
	          {
	        	  button[i][j].setIcon(bArg);
	        	  button[i][j].setCasePlateau(jeuAb.getDamier().getCase(compteur));
	        	  compteur++;
	        	  button[i][j].addActionListener(this);
	          }
	          else if(plateau[i][j]==2)
	          {
	        	  button[i][j].setIcon(bBla);
	        	  button[i][j].setCasePlateau(jeuAb.getDamier().getCase(compteur));
	        	  compteur++;
	        	  button[i][j].addActionListener(this);
	    	   }
	          else if(plateau[i][j]==3)
	          {
	        	  button[i][j].setIcon(bNoi);
	        	  button[i][j].setCasePlateau(jeuAb.getDamier().getCase(compteur));
	        	  compteur++;
	        	  button[i][j].addActionListener(this);
	    	   }
	          else 
	          {
	        	  button[i][j].setVisible(false);
	    	   }
	          if(mode=="mur"){
	        	  button[4][8].setVisible(false);
	          }
	          else if(mode=="trounoir"){
	        	  button[4][8].setIcon(bRou);
	        	  button[4][7].setIcon(bRou);
	        	  button[4][7].setVisible(true);
	        	  button[4][6].setIcon(bRou);
	        	  button[4][9].setIcon(bRou);
	        	  button[4][9].setVisible(true);
	        	  button[4][10].setIcon(bRou);
	        	  button[4][8].setEnabled(false);
	        	  button[4][7].setEnabled(false);
	        	  button[4][6].setEnabled(false);
	        	  button[4][9].setEnabled(false);
	        	  button[4][10].setEnabled(false);
	          }
	          
	    		}
	    }

		this.panel.add(panel1);
		
		
		label.setFont(new Font("Verdana",1,40));
	    label.setForeground(Color.black);
	    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label.setBounds(150,550,100,50);	    
	    this.panel.add(label);
	    
	    label1.setFont(new Font("Verdana",1,40));
	    label1.setForeground(Color.black);
	    label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label1.setBounds(300,550,100,50);  
	    this.panel.add(label1);
	    
	    label2.setFont(new Font("Verdana",1,40));
	    label2.setForeground(Color.black);
	    label2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label2.setBounds(110,0,575,50);
		//this.panel.setLayout(null);	    
	    //this.panel.add(label2);
	    
	    label3.setFont(new Font("Verdana",1,40));
	    label3.setForeground(Color.black);
	    label3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label3.setBounds(110,0,575,50);    
	   // this.panel.add(label3);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
		BoutonCase boutonTemp = ((BoutonCase) arg0.getSource());
		System.out.println("le bouton cliqué a la case :" + boutonTemp.getCasePlateau().getId()
				+ " -- la couleur de mon pion est " + boutonTemp.getCasePlateau().getPion().getCouleur());
	
	}
}
