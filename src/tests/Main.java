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
import java.text.SimpleDateFormat;
import java.util.Date;
import services.CommandeServices;
import services.ProduitServices;
import tools.MaConnexion;
/**
 *
 * @author achou
 */
public class main {

  public static void main(String[] args)
      throws SQLException, FileNotFoundException, DocumentException {
    MaConnexion mc = MaConnexion.getInstance();
    Date c = new Date();
    CommandeServices su = new CommandeServices();
    Commande c1 = new Commande("yousefaaaa", c, "dispo", 1);
    Commande c2 = new Commande("test2", c, "indispo");

    // Commande c3 = new Commande("test2",c,"indispo");

    Commande c4 = new Commande(20);

    // su.recherchercommande(7);
    su.trie();

    // su.ajouter(c1);
    // su.ajouter(c2);

    // su.modifier (c3);

    // su.suprimer(c4);

    System.out.println(su.afficher());

    ProduitServices pu = new ProduitServices();
    // Produit p1 = new
    // Produit("youssefachour",25,"aaaaaa","dispo","rouge",2,"xl"); Produit p2 =
    // new Produit("pull",500,"bbbbb","dispo","noir");

    // Produit p3 = new Produit(2,"yousefa",5555,"dfsgd","indispo","bleu");
    // Produit p4 = new Produit(2);
    // pu.ajouter(p1);
    // pu.ajouter(p2);

    // pu.modifier (p3);

    // pu.suprimer(p4);
    // pu.rechercherproduit(4);

    // System.out.println(pu.afficher());
    // pu.pdf(p1);

    java.sql.Date dde = java.sql.Date.valueOf("2021-12-12");
    java.sql.Date ch = java.sql.Date.valueOf("2000-05-15");

    Jeux J1 = new Jeux("free fire", ch, 17, "tttttyyy", "Pc and Mobile ps5",
                       "chiheb");
    Jeux J2 =
        new Jeux("PUBG", dde, 17, "test", "Pc and Mobile and ps4", "firas1");
    Jeux J3 = new Jeux(1, "PUBG", dde, 155, "test", "OS5", "firas1");
    Jeux J4 = new Jeux(1);
    Jeux J6 = new Jeux("fortnite", dde, 40, "test", "Mobile and ps4 and pc",
                       "game good");

    Mise_a_jour m3 = new Mise_a_jour(8);

    Livraison L2 = new Livraison(1, "achour", 941, 3, 655, "Ariana");

    JeuxService es = new JeuxService();
    MiseAJourService em = new MiseAJourService();
    LivraisonService ls = new LivraisonService();
    // em.ajouter(m3);
    // es.ajouter(J1);
    // es.supprimer(J4);
    // em.supprimer(m3);
    // ls.ajouter(L2);

    // es.modifier(J3);
    // em.modifier(m2);
    // System.out.println(es.afficher());
    // System.out.println(em.afficher());
    // System.out.println(ls.afficher());
    // ls.pdf(L2);
    // es.recherche(J4);
    // em.recherche(m3);
    System.out.println(em.triedesc());

    // em.affichejeuxmiseajour(8);
    // System.out.println(em.affichejeuxmiseajour(8));
  }
}
