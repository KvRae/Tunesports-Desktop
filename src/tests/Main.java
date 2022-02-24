/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.itextpdf.text.DocumentException;
import entities.Commande;
import entities.Produit;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Time;
import services.CommandeServices;
import services.ProduitServices;
import tools.MaConnexion;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.String.valueOf;

import Services.EvenementService;
import Services.TournoiService;
import com.itextpdf.text.DocumentException;
import entities.Evenement;
import entities.Tournoi;
import java.io.FileNotFoundException;
// import java.util.Date;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tools.MaConnexion;

/**
 *
 * @author achou
 */
public class main {

   public static void main(String[] args) throws SQLException, FileNotFoundException, DocumentException {
        MaConnexion mc = MaConnexion.getInstance();
        Date c=new Date();
          CommandeServices su = new CommandeServices();
          Commande c1 = new Commande("yousefaaaa",c,"dispo",1);
          Commande c2 = new Commande("test2",c,"indispo");
          
          
         //Commande c3 = new Commande("test2",c,"indispo");

         
        Commande c4 = new Commande(20);
        
        
        
       // su.recherchercommande(7);
        su.trie();
        
        //su.ajouter(c1);
          //su.ajouter(c2);
          
          //su.modifier (c3);

          //su.suprimer(c4);
          
        System.out.println(su.afficher());
        
         ProduitServices pu = new ProduitServices();
         //Produit p1 = new Produit("youssefachour",25,"aaaaaa","dispo","rouge",2,"xl");
         //Produit p2 = new Produit("pull",500,"bbbbb","dispo","noir");  
          
          //Produit p3 = new Produit(2,"yousefa",5555,"dfsgd","indispo","bleu");
         // Produit p4 = new Produit(2);
          //pu.ajouter(p1);
          //pu.ajouter(p2);
          
          //pu.modifier (p3);

          //pu.suprimer(p4);
         // pu.rechercherproduit(4);
          
        //System.out.println(pu.afficher());
       // pu.pdf(p1);




               java.sql.Date dde=java.sql.Date.valueOf("2021-12-12");
        java.sql.Date ch=java.sql.Date.valueOf("2000-05-15");


        
        Jeux J1 =new Jeux ("free fire",ch,17,"tttttyyy","Pc and Mobile ps5","chiheb");
        Jeux J2 =new Jeux ("PUBG",dde,17,"test","Pc and Mobile and ps4","firas1");
        Jeux J3 =new Jeux (1,"PUBG",dde,155,"test", "OS5","firas1");
        Jeux J4=new Jeux(1);
        Jeux J6 =new Jeux ("fortnite",dde,40,"test", "Mobile and ps4 and pc","game good");
        
        
        
        

Mise_a_jour m3=new Mise_a_jour(8);




     Livraison L2 =new Livraison (1,"achour",941,3,655,"Ariana");






          JeuxService es = new JeuxService();
          MiseAJourService em =new MiseAJourService();
          LivraisonService ls =new LivraisonService();
          //em.ajouter(m3);
          //es.ajouter(J1);
          //es.supprimer(J4);
         // em.supprimer(m3);
          //ls.ajouter(L2);
          

         //es.modifier(J3);
          //em.modifier(m2);
          //System.out.println(es.afficher());
          //System.out.println(em.afficher());
         // System.out.println(ls.afficher());
          //ls.pdf(L2);
          //es.recherche(J4);
          //em.recherche(m3);
          System.out.println(em.triedesc());
          

          
          //em.affichejeuxmiseajour(8);
        // System.out.println(em.affichejeuxmiseajour(8));
   
    
  /**
   * @param args the command line arguments
   * @throws java.text.ParseException
   */

    // Personne p = new Personne("Ben Ahmed", "Ali");
    EvenementService es = new EvenementService();
    TournoiService ts = new TournoiService();

    java.sql.Date dde = java.sql.Date.valueOf("2021-12-12");
    java.sql.Date dfe = java.sql.Date.valueOf("2022-02-25");

    java.sql.Date ddt = java.sql.Date.valueOf("2020-01-12");
    java.sql.Date dft = java.sql.Date.valueOf("2019-05-05");

    Evenement e = new Evenement(1, "even9", dde, dfe, "2éme");
    Tournoi t = new Tournoi(1, "tournoi_9", ddt, dft, "hajhdkdal", "gfgdqsf");
    Tournoi t1 = new Tournoi(5);
    Tournoi t2 = new Tournoi(1, "tournoi_1", ddt, dft, "kkkkkkkk", "ddddddddd");
    /*Evenement e1= new Evenement(4,"even2",datedebevent,datefinevent,"2éme");
    Evenement e2= new Evenement(18,"XXXXX",datedebevent,datefinevent,"XXXXX");
    Evenement e3= new Evenement(0,"even3",datedebevent,datefinevent,"3éme");
    Tournoi t1=new
    Tournoi(2,"tournoi_2",datedebtour,datefintour,"dfsqgvwvw","ererrerere");
    Tournoi t2=new
    Tournoi(3,"tournoi_2",datedebtour,datefintour,"jjkjjkjkjkj","dsddsdsdsd");
    Tournoi t3=new
    Tournoi(3,"XXXXXXXX",datedebtour,datefintour,"XXXXXXXX","XXXXXXXX");*/

    // es.pdf(e);
    ts.pdf(t);
    // es.ajouter(e);
    // es.ajouter(e1);
    // es.ajouter(e2);
    // es.supprimer(e3);
    // es.modifier(e2);
    // es.recherche(e);

    // es.historique();
    //  System.out.println(es.historique());

    // ts.ajouter(t);
    // ts.ajouter(t1);
    // ts.ajouter(t2);
    // ts.ajouter(t2);
    // ts.supprimer(t1);
    // ts.modifier(t2);
    // ts.recherche(t1);
    // ts.historique();
    // System.out.println(ts.historique());
    // es.triedesc();
    // System.out.println(es.triedesc());
    // es.trie();
    // System.out.println(es.trie());

    // es.triedesc();
    // System.out.println(ts.triedesc());

    // ts.trie();
    // System.out.println(ts.trie());

    // es.afficher();
    // System.out.println(es.afficher());
  }
}



