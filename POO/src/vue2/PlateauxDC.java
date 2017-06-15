package vue2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uidelegate.Case;
import uidelegate.DamierDameChinoise;
import uidelegate.JeuDameChinoise;
import uidelegate.Pion;

public class PlateauxDC extends JeuxPan implements ActionListener {

	private BoutonCase button[][] = new BoutonCase[17][25];
	private JeuDameChinoise jeuDame = new JeuDameChinoise(false, null, 2, 6);
	private int compteurClique = 0;
	private BoutonCase boutonClique;

	public PlateauxDC(Dimension dim) {
		super(dim);
		initPanel();
	}

	int plateau[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 5, 0, 5, 0, 5, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3, 0, 3, 0, 3, 0, 3 },
			{ 0, 5, 0, 5, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3, 0, 3, 0, 3, 0 },
			{ 0, 0, 5, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3, 0, 3, 0, 0 },
			{ 0, 0, 0, 5, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 6, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 0, 0 },
			{ 0, 0, 6, 0, 6, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 2, 0, 0 },
			{ 0, 6, 0, 6, 0, 6, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 2, 0, 2, 0 },
			{ 6, 0, 6, 0, 6, 0, 6, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 2, 0, 2, 0, 2 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	private ImageIcon bArg = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billeargent.png")).getImage());
	private ImageIcon bBle = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billebleu.png")).getImage());
	private ImageIcon bJau = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billejaune.png")).getImage());
	private ImageIcon bBla = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billeblanc.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	private ImageIcon bVer = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billevert.png")).getImage());
	private ImageIcon bRou = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billerouge.png")).getImage());
	private ImageIcon bNoi = new ImageIcon(new ImageIcon(getClass().getResource("/Images/billenoir.png")).getImage());

	private JLabel label = new JLabel("J1(JAUNE):");
	private JLabel label1 = new JLabel("J2(BLEU):");
	private JLabel label2 = new JLabel("scr");
	private JLabel label3 = new JLabel("scr");
	private JLabel label4 = new JLabel("J3(ARGENT):");
	private JLabel label5 = new JLabel("J4(ROUGE):");
	private JLabel label6 = new JLabel("scr");
	private JLabel label7 = new JLabel("scr");
	private JLabel label8 = new JLabel("J5(VERT):");
	private JLabel label9 = new JLabel("J6(NOIR):");
	private JLabel label10 = new JLabel("scr");
	private JLabel label11 = new JLabel("scr");

	@Override
	protected void initPanel() {

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(17, 25));
		panel1.setPreferredSize(new Dimension(600, 600));
		panel1.setLocation(0, 0);
		panel1.setBackground(Color.gray);

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 25; j++) {
				button[i][j] = new BoutonCase();
			}
		}

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 25; j++) {
				button[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				button[i][j].setBorderPainted(false);
				button[i][j].setContentAreaFilled(false);
				button[i][j].setFocusPainted(false);
				button[i][j].setOpaque(false);
				button[i][j].setBounds(0 + i * 10, 0 + j * 10, 10, 10);
				panel1.add(button[i][j]);

			}
		}
		int compteur = 0;
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 25; j++) {
				if (plateau[i][j] == 1) {
					button[i][j].setIcon(bBla);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 2) {
					button[i][j].setIcon(bNoi);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 3) {
					button[i][j].setIcon(bJau);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 4) {
					button[i][j].setIcon(bRou);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 5) {
					button[i][j].setIcon(bArg);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 6) {
					button[i][j].setIcon(bVer);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else if (plateau[i][j] == 7) {
					button[i][j].setIcon(bBle);
					button[i][j].setCasePlateau(jeuDame.getDamier().getCase(compteur));
					compteur++;
					button[i][j].addActionListener(this);
				} else {
					button[i][j].setVisible(false);
				}
			}

		}
		/*
		 * for (int i = 0; i < 17; i++) { for (int j = 0; j < 25; j++) { if
		 * (plateau[i][j] == 1) { button[i][j].addActionListener(this); } } }
		 */
		this.panel.add(panel1);

		/*label.setFont(new Font("Verdana", 1, 30));
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label.setBounds(150, 550, 100, 50);
		this.panel.add(label);

		label1.setFont(new Font("Verdana", 1, 30));
		label1.setForeground(Color.black);
		label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label1.setBounds(300, 550, 100, 50);
		this.panel.add(label1);

		label2.setFont(new Font("Verdana", 1, 30));
		label2.setForeground(Color.black);
		label2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label2.setBounds(110, 0, 575, 50);
		// this.panel.setLayout(null);
		// this.panel.add(label2);

		label3.setFont(new Font("Verdana", 1, 30));
		label3.setForeground(Color.black);
		label3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label3.setBounds(110, 0, 575, 50);
		// this.panel.add(label3);

		label4.setFont(new Font("Verdana", 1, 30));
		label4.setForeground(Color.black);
		label4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label4.setBounds(150, 550, 100, 50);
		this.panel.add(label4);

		label5.setFont(new Font("Verdana", 1, 30));
		label5.setForeground(Color.black);
		label5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label5.setBounds(300, 550, 100, 50);
		this.panel.add(label5);

		label6.setFont(new Font("Verdana", 1, 30));
		label6.setForeground(Color.black);
		label6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label6.setBounds(110, 0, 575, 50);
		// this.panel.setLayout(null);
		// this.panel.add(label6);

		label7.setFont(new Font("Verdana", 1, 30));
		label7.setForeground(Color.black);
		label7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label7.setBounds(110, 0, 575, 50);
		// this.panel.add(label7);

		label8.setFont(new Font("Verdana", 1, 30));
		label8.setForeground(Color.black);
		label8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label8.setBounds(150, 550, 100, 50);
		this.panel.add(label8);

		label9.setFont(new Font("Verdana", 1, 30));
		label9.setForeground(Color.black);
		label9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label9.setBounds(300, 550, 100, 50);
		this.panel.add(label9);

		label10.setFont(new Font("Verdana", 1, 30));
		label10.setForeground(Color.black);
		label10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label10.setBounds(110, 0, 575, 50);
		// this.panel.setLayout(null);
		// this.panel.add(label10);

		label11.setFont(new Font("Verdana", 1, 30));
		label11.setForeground(Color.black);
		label11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label11.setBounds(110, 0, 575, 50);
		// this.panel.add(label11);*/

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		BoutonCase boutonTemp = ((BoutonCase) arg0.getSource());
		//System.out.println(boutonTemp.getCasePlateau().toString());
		
		int resultatCoup = jeuDame.appliqueCoup(boutonTemp);
		if(resultatCoup == 1){
			
			boutonTemp.setIcon(jeuDame.getBoutonCourant().getIcon());
			jeuDame.getBoutonCourant().setIcon(bBla);
			
			jeuDame.reinitialiseBouton();
			
			//System.out.println(jeuDame.getDamier().toSTringCouleur());
			
			System.out.println(jeuDame.victoireRouge());
		}
		else if(resultatCoup == -1)jeuDame.reinitialiseBouton();
	}
}
