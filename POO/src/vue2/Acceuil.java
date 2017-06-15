package vue2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Acceuil extends JeuxPan implements ActionListener{
	
	protected String choix;
	public Object source;
	
	public Acceuil(Dimension dim) {
		super(dim);
		initPanel();
	}

	//Fenetre frame = new Fenetre();
	private ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("dc.jpg")).getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT));
	private ImageIcon icon2 = new ImageIcon(new ImageIcon(getClass().getResource("ab.jpg")).getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT));
	private JButton ab = new JButton(icon2);
	public JButton dc = new JButton(icon);
	private JLabel label = new JLabel("Bienvenue Dans DC & AB");
	private JLabel label1 = new JLabel("DCH");
	private JLabel label2 = new JLabel("ABL");
	private JLabel label3 = new JLabel("BEST SC:1000000");
	private JLabel label4 = new JLabel("BEST SC:1000000");
	
	public void initPanel(){
	    
		//Titre
		label.setFont(new Font("Verdana",1,40));
	    label.setForeground(Color.black);
	    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label.setBounds(110,0,575,50);
		this.panel.setLayout(null);	    
	    this.panel.add(label);
	    
	    //dc
	    this.panel.add(label1, BorderLayout.CENTER);
	    label1.setFont(new Font("Verdana",1,40));
	    label1.setForeground(Color.black);
	    label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label1.setBounds(150,500,100,50);
	    //ab
	    this.panel.add(label2);
	    label2.setFont(new Font("Verdana",1,40));
	    label2.setForeground(Color.black);
	    label2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label2.setBounds(550,500,100,50);
	    //Button dc
		dc.setBounds(50,200,300,250);
		this.panel.add(dc);
		dc.addActionListener(this);
		//Button ab
		ab.setBounds(450,200,300,250);
		this.panel.add(ab);
		ab.addActionListener(this);
		
		this.panel.add(label3);
	    label3.setFont(new Font("Verdana",1,20));
	    label3.setForeground(Color.black);
	    label3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label3.setBounds(90,575,220,30);
	    
	    this.panel.add(label4);
	    label4.setFont(new Font("Verdana",1,20));
	    label4.setForeground(Color.black);
	    label4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    label4.setBounds(490,575,220,30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Fenetre frame=new Fenetre();
		source= e.getSource();
		
		
	}

	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}
}