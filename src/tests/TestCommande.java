/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Commande;
import java.sql.SQLException;
import services.CommandeServices;
import tools.MaConnexion;

/**
 *
 * @author achou
 */
public class TestCommande {

   public static void main(String[] args) throws SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        
          CommandeServices su = new CommandeServices();
          Commande c1 = new Commande("yousefachour","1999-08-26","dispo");
          Commande c2 = new Commande("test2","2022-11-10","indispo");
          
         
          Commande c3 = new Commande("test2","2022-11-10","indispo");

         
        Commande c4 = new Commande(15);
          //su.ajouter(c1);
          //su.ajouter(c2);
          
          //su.modifier (c3);

          su.suprimer(c4);
          
        System.out.println(su.afficher());
    }
}


