package uidelegate;

import java.sql.*;
import java.util.*;
public class ConnexionBD {

public void se_connecter()
{
	try
	{
	
	//creer une connection avec la base de donnees
	Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeuabdc","root","");
	//faire une declaration de requete
	Statement s1=myCon.createStatement();
	
	//requetes sql execution
	ResultSet rs1=s1.executeQuery("select * from infojoueur");
	int maxscore = 0;
	PreparedStatement s2= myCon.prepareStatement("SELECT MAX(score) FROM infojoueur where jeu=?");    
	s2.setString(1, "Abalone");    
	ResultSet rs2 = s2.executeQuery();
	PreparedStatement s3= myCon.prepareStatement("SELECT MAX(score) FROM infojoueur where jeu=?");    
	s3.setString(1, "DC");    
	ResultSet rs3 = s3.executeQuery();
	PreparedStatement s4= myCon.prepareStatement("SELECT MIN(score) FROM infojoueur where jeu=?");    
	s4.setString(1, "DC");    
	ResultSet rs4= s4.executeQuery();
	PreparedStatement s5= myCon.prepareStatement("SELECT MIN(score) FROM infojoueur where jeu=?");    
	s5.setString(1, "abalone");    
	ResultSet rs5 = s5.executeQuery();
    //String insert="insert into infojoueur(pseudo,score,jeu)"+"values ('TOM','24','DC')";
     
	

	//les resultats
	/*VALEURS DANS LA BD*/
	while(rs1.next())
	{
		System.out.println(rs1.getString("pseudo")+"  ,  "+rs1.getString("score"));
	}
    /*Score gagnant DAme chinoise*/
	while ( rs3.next() )
	{
	  System.out.println("Le meilleur score est pour le jeu de dame chinoise est "+ rs3.getInt(1));
	}
	/* Score gagnant Abalone*/
	while ( rs2.next() )
	{
	  System.out.println("Le meilleur score est pour abalone est "+ rs2.getInt(1));
	}
	/*Score perdant Dame chinoise*/
	while ( rs4.next() )
	{
	  System.out.println("perdant dame chinoise "+ rs4.getInt(1));
	}
	/*Score perdant abalone*/
	while ( rs5.next() )
	{
	  System.out.println("perdant abalone "+ rs5.getInt(1));
	}
	/*EXCECUTION INSERTION*/
	//mystat.executeUpdate(insert);
	
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}

