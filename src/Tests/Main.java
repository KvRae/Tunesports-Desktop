/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import Entities.Jeux;
import Entities.Livraison;
import Entities.Mise_a_jour;
import Services.LivraisonService;
import Services.JeuxService;
import Services.MiseAJourService;
import Tools.MaConnexion;

import java.sql.Date;
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


        
        Jeux J1 =new Jeux ("fifa",ch,"17gb","chiheb","Pc and Mobile ps5","chiheb");
        Jeux J2 =new Jeux ("PUBG",dde,"199gb","test","Pc and Mobile and ps4","firas1");
        Jeux J3 =new Jeux (1,"PUBG",dde,"155gb","test", "OS5","firas1");
        Jeux J4=new Jeux(7);
        Jeux J6 =new Jeux ("fortnite",dde,"40gb","test", "Mobile and ps4 and pc","game good");
        
        
        
        

Mise_a_jour m3=new Mise_a_jour("fifa",ch,"hhh","iii","Pc and Mobile and ps4",17);


Livraison l1 = new Livraison("ariana",122.3,6,"fezfz");

     






          JeuxService es = new JeuxService();
          MiseAJourService em =new MiseAJourService();
          LivraisonService ls =new LivraisonService();
          //es.ajouter(J1);
         // em.ajouter(m3);
         // es.supprimer(J4);
         // em.supprimer(m3);
         ls.ajouter(l1);
         ls.sendMail("firasmohsni5@gmail.com");
          

         //es.modifier(J3);
          //em.modifier(m2);
         // System.out.println(es.afficher());
         // System.out.println(em.afficher());
         // System.out.println(ls.afficher());
          //ls.pdf(L2);
          //es.recherche(J4);
          //em.recherche(m3);
          //System.out.println(em.triedesc());
          

          
          //em.affichejeuxmiseajour(8);
        // System.out.println(em.affichejeuxmiseajour(8));

        
          
          

				
    }
    
}
