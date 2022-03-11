/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;

import com.itextpdf.text.DocumentException;
import Services.CommandeServices;
import Services.ProduitServices;
import java.util.Date;

import Services.LivraisonService;
import Services.JeuxService;
import Services.MiseAJourService;
import Entities.Jeux;
import Entities.Livraison;
import Entities.Produit;
import Entities.Commande;
import Entities.Evenement;
import Entities.Mise_a_jour;
import Entities.Rating;
import Entities.Reclamation;
import Entities.Reservation;
import Entities.Tournoi;
import Entities.utilisateur;
import Services.EvenementService;
import Services.RatingService;
import Services.Reclamationservice;
import Services.ReservationService;
import Services.TournoiService;
import Services.Utilisateurservice;
import Tools.MaConnexion;
//import java.sql.Date;
import static java.lang.String.valueOf;

import java.io.FileNotFoundException;


/**
 *
 * @author 
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws SQLException 
     * @throws DocumentException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, DocumentException, Exception {
        MaConnexion mc = MaConnexion.getInstance();
        
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
         // System.out.println(em.triedesc());
          

          
          //em.affichejeuxmiseajour(8);
        // System.out.println(em.affichejeuxmiseajour(8));

        
          
          

				
    
    



        Date c=new Date();
          CommandeServices su = new CommandeServices();
          //Commande c1 = new Commande("yousefaaaa",c,"dispo",1);
          //Commande c2 = new Commande("test2",c,"indispo");
          
          
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
         Produit p1 = new Produit("youssefachour",25d,"aaaaaa","dispo","rouge",2,"xl");
         Produit p2 = new Produit("guess",250d,"fdfdfd","non","bleu",0,"S");  
          
          //Produit p3 = new Produit(2,"yousefa",5555d,"dfsgd","indispo","bleu");
         // Produit p4 = new Produit(2);
          //pu.ajouter(p1);
          //pu.ajouter(p2);
          
          //pu.modifier (p3);

          //pu.suprimer(p4);
         // pu.rechercherproduit(4);
          
        //System.out.println(pu.afficher());
        //pu.pdf(p1);
        
        
        
        
        //***************************Creating Test Instance for reservation************************************
        Reservation re = new Reservation(new java.util.Date() ,"Disponible",10);
        //Reservation re2 = new Reservation(2,new java.util.Date() , Disponiblity.valueOf("Disponible"),15);
        //Reservation re1 = new Reservation(3,new java.util.Date(),Disponiblity.valueOf("Disponible"),10);
        Reservation re3 = new Reservation(6);
        ReservationService res = new ReservationService();

        //********************Testing Service Reservation*************************

       // System.out.println("-----------------------------------------------");
        //res.ajouter(re);
       // res.recherche(re3);
        //res.modifier(re2);
        //res.supprimer(re3);
        //System.out.println(res.afficher());

        //***************************Creating Test Instance for rating************************************

        //Rating ra = new Rating("12/8/2022", ,new java.util.Date(),4);
        //Rating ra2 = new Rating(2,"User5", new java.util.Date(),1);
        //Rating ra1 = new Rating(1);
       //RatingService ras = new RatingService();

        //********************Testing Service Rating*************************

        //System.out.println("-----------------------------------------------");
        //ras.ajouter(ra2);
        //ras.modifier(ra2);
        //ras.supprimer(ra1);
        //System.out.println(ras.afficher());

    
    
    java.sql.Date d=java.sql.Date.valueOf("2021-11-12");
        java.sql.Timestamp ts=java.sql.Timestamp.valueOf("2021-11-12 10:22:21");
        
          //Personne p = new Personne("Ben Ahmed", "Ali");
          //utilisateur p = new utilisateur(88,2587469,"iheb","rrrrrr","rrrrrrr","rrrrrr","rrrrrrr",d);
          //utilisateur p3 = new utilisateur(11,846621,"qaqa","zeze","ffrr@gmail.com","www","cxcx",d);
       //utilisateur p3 = new utilisateur(9);
          //Utilisateurservice ps=new Utilisateurservice();
         // Utilisateurservice ps= new Utilisateurservice();
         // ps.ajouter(p3);
          //Utilisateurservice.sendMail("ihebzouaoui888@gmail.com");
          //ps.modifier(p3);
          //ps.supprimer(2);
          //ps.rechercher(2);
         // ps.afficher();
          //ps.trie();
          //ps.pdf(p1);
          
          
          
          Reclamation r = new Reclamation(9,"rrr","rrrrr",d,ts);
         // Reclamation r2 = new Reclamation(7,"WW","WW","WWWW","WWWWWW");
          Reclamationservice ks=new Reclamationservice();
          
          //ks.ajouter(r);
          //ks.supprimer(7);
          //ks.modifier(r);
         // ps.recherche(p3);
          //ks.afficher();
          //ks.trie();
          //ks.pdf(r);
        
        
          
          
          
          
          
          
          
          
          
          //Personne p = new Personne("Ben Ahmed", "Ali");
          EvenementService ee = new EvenementService();
          TournoiService tt=new TournoiService();
          

          
          java.sql.Date de=java.sql.Date.valueOf("2021-12-12");
          java.sql.Date dfe=java.sql.Date.valueOf("2022-02-25");
          
          java.sql.Date ddt=java.sql.Date.valueOf("2020-01-12");
          java.sql.Date dft=java.sql.Date.valueOf("2019-05-05");
          
          
          Evenement e= new Evenement(20,"even9",de,dfe,"2éme");
          Tournoi t=new Tournoi(1,"tournoi_9",ddt,dft,"hajhdkdal","gfgdqsf");
          Tournoi t1=new Tournoi(5);
          Tournoi t2=new Tournoi(1,"tournoi_1",ddt,dft,"kkkkkkkk","ddddddddd");
          /*Evenement e1= new Evenement(4,"even2",datedebevent,datefinevent,"2éme");
          Evenement e2= new Evenement(18,"XXXXX",datedebevent,datefinevent,"XXXXX");
          Evenement e3= new Evenement(0,"even3",datedebevent,datefinevent,"3éme");
          Tournoi t1=new Tournoi(2,"tournoi_2",datedebtour,datefintour,"dfsqgvwvw","ererrerere");
          Tournoi t2=new Tournoi(3,"tournoi_2",datedebtour,datefintour,"jjkjjkjkjkj","dsddsdsdsd");
          Tournoi t3=new Tournoi(3,"XXXXXXXX",datedebtour,datefintour,"XXXXXXXX","XXXXXXXX");*/
          
        // es.pdf(e);
       // ts.pdf(t);
          ee.ajouter(e);
          //es.ajouter(e1);
          //es.ajouter(e2);
         // es.supprimer(e3);
          //es.modifier(e2);
        // es.recherche(e);
        
        
       //es.historique();
       // System.out.println(es.historique());
        
        
        // ts.ajouter(t);
          //ts.ajouter(t1);
          //ts.ajouter(t2);
         //ts.ajouter(t2);
          //ts.supprimer(t1);
         // ts.modifier(t2);
        // ts.recherche(t1);
        //ts.historique();
       // System.out.println(ts.historique());
           // es.triedesc();
          //System.out.println(es.triedesc());
          //es.trie();
           //System.out.println(es.trie());
           
           //es.triedesc();
           //System.out.println(ts.triedesc());
           
          //ts.trie();
           //System.out.println(ts.trie());
           
          //es.afficher();
          //System.out.println(es.afficher());
        
    }
}

