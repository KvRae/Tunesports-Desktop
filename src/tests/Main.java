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
    }
}


