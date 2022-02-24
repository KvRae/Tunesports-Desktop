/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

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
 * @author Fayechi
 */
public class Main {

  /**
   * @param args the command line arguments
   * @throws java.text.ParseException
   */
  public static void main(String[] args)
      throws ParseException, FileNotFoundException, DocumentException {
    MaConnexion mc = MaConnexion.getInstance();
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
