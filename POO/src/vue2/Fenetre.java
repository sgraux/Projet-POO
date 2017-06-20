package vue2;
//import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener,Var{

	
	JPanel pan = new JPanel();
	
	
	//Constructeur de la fenetre principale du jeux
	public Fenetre(){
	    this.setTitle("JEUX DC & AB");
	    this.setLayout(null);
	    this.setSize(800,700);
	    this.setLocationRelativeTo(null);             

	    //pan.setBackground(Color.gray);
	    JMenu menu = new JMenu( "Jeux" ) ;
	    JMenuItem redem = new JMenuItem( "Redémarer" ) ;
	    menu.add( redem ) ;
	    JMenuItem save = new JMenuItem( "Sauvgarder" ) ;
	    menu.add( save ) ;
	    JMenuItem quitter = new JMenuItem( "Quitter" ) ;
	    menu.add( quitter ) ;
	    JMenuBar menuBarre = new JMenuBar() ; // créé une barre de menu
	    menuBarre.add( menu ) ; // ajoute un menu à la barre
	    setJMenuBar( menuBarre ) ;
	    JMenu menu2 = new JMenu( "Help" ) ;
	    JMenuItem help = new JMenuItem( "???" ) ;
	    menu2.add( help ) ;
	    JMenuItem info = new JMenuItem( "A propos" ) ;
	    menu2.add( info ) ;
	    JMenuBar menuBarre2 = new JMenuBar() ; // créé une barre de menu
	    menuBarre.add( menu2 ) ;
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre.class.getResource("/Images/Logo.jpg")));
	    
	    
	    this.setContentPane(pan);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Fonctions qui vider le panel principale et mettre les nouveaux composant
	public void accueil(){
		pan.removeAll();
		pan.add(acc.getPanel());
		pan.revalidate();
	}
	
	public void choixPanDC(){
		pan.removeAll();
		pan.add(new ChoixJDC(size).getPanel());
		pan.revalidate();
	}
	
	public void choixPanAB(){
		pan.removeAll();
		pan.add(new ChoixJAB(size).getPanel());
		pan.revalidate();
	}
	
	//Les Constructeurs DC
	
	public void platDCIA(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, true, null,2,2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC2J(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, null,2,2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC3J(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, null,3,3).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC4J(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, null,4,4).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC5J(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, null,5,5).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC6J(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, true, null,6,6).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	public void platDCIApr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, true, "prise",2,2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC2Jpr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, "prise",2,2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC3Jpr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, "prise",3,3).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC4Jpr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, "prise",4,4).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC5Jpr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, false, "prise",5,5).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platDC6Jpr(){
		pan.removeAll();
		pan.add(new PlateauxDC(size, true, "prise",6,6).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	
	//Les Constructeurs AB
	public void platAB(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,null,false,nom1,nom2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	public void platABIA(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,null,true,nom1,"IA").getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	public void platABIATN(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,"trouNoir",true,nom1,"IA").getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	public void platABTN(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,"trouNoir",false,nom1,nom2).getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	public void platABIAMU(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,"mur",true,nom1,"IA").getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	public void platABMU(String nom1,String nom2){
		pan.removeAll();
		pan.add(new PlateauxAB(size,"mur",false,nom1,"IA").getPanel(),BorderLayout.WEST);
		pan.revalidate();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	
}

