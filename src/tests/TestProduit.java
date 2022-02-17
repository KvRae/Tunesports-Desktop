/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Produit;
import java.sql.SQLException;
import services.ProduitServices;
import tools.MaConnexion;

/**
 *
 * @author achou
 */
class TestProduit {
  public static void main(String[] args) throws SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        
          ProduitServices su = new ProduitServices();
          Produit p1 = new Produit("youssefachour",1500,"aaaaaa","dispo","rouge");
          Produit p2 = new Produit("pull",500,"bbbbb","dispo","noir");  
          
          Produit p3 = new Produit(2,"yousefa",5555,"dfsgd","indispo","bleu");
          Produit p4 = new Produit(2);
          //su.ajouter(p1);
          //su.ajouter(p2);
          
          su.modifier (p3);

          //su.suprimer(p4);
          
        System.out.println(su.afficher());
    }
    
}
