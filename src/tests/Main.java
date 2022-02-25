/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static java.sql.DriverManager.println;
import static jdk.nashorn.internal.runtime.Debug.id;

import Services.Reclamationservice;
import Services.Utilisateurservice;
import entities.Reclamation;
import entities.utilisateur;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import tools.MaConnexion;

/**
 *
 * @author Fayechi
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    MaConnexion mc = MaConnexion.getInstance();
    java.sql.Date d = java.sql.Date.valueOf("2021-11-12");
    java.sql.Timestamp ts = java.sql.Timestamp.valueOf("2021-11-12 10:22:21");

    // Personne p = new Personne("Ben Ahmed", "Ali");
    // utilisateur p = new
    // utilisateur(88,2587469,"iheb","rrrrrr","rrrrrrr","rrrrrr","rrrrrrr",d);
    utilisateur p1 = new utilisateur(111, 846621, "qaqa", "zeze",
                                     "ffrr@gmail.com", "www", "cxcx", d);
    // utilisateur p3 = new
    // utilisateur(9,11111111,"ddddd","kkkk","pppp","nnnn","ggg","mmm");
    Utilisateurservice ps = new Utilisateurservice();
    // ps.ajouter(p1);Utilisateurservice.sendMail("ihebzouaoui888@gmail.com");
    // ps.modifier(p3);
    // ps.supprimer(2);
    // ps.rechercher(2);
    // ps.afficher();
    // ps.trie();
    // ps.pdf(p1);

    Reclamation r = new Reclamation(9, "rrr", "rrrrr", d, ts);
    // Reclamation r2 = new Reclamation(7,"WW","WW","WWWW","WWWWWW");
    Reclamationservice ks = new Reclamationservice();

    // ks.ajouter(r);
    // ks.supprimer(7);
    // ks.modifier(r);
    // ks.rechercher(8);
    // ks.afficher();
    // ks.trie();
    // ks.pdf(r);
  }
}
