/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Services.EvenementService;
import Services.TournoiService;
import entities.Evenement;
import entities.Tournoi;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import tools.MaConnexion;
import java.text.SimpleDateFormat;

/**
 *
 * @author Fayechi
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        MaConnexion mc = MaConnexion.getInstance();
          //Personne p = new Personne("Ben Ahmed", "Ali");
          EvenementService es = new EvenementService();
          TournoiService ts=new TournoiService();
          Evenement e= new Evenement(15,"even1","15/08/2022","22/08/2022","2éme");
          Evenement e1= new Evenement(16,"even2","20/09/2022","28/09/2022","2éme");
          Evenement e2= new Evenement(16,"XXXXX","XXXXX","XXXXX","XXXXX");
          Tournoi t=new Tournoi(1,"tournoi_1","15/08/2022","22/08/2022","hajhdkdal","gfgdqsf");
          Tournoi t1=new Tournoi(2,"tournoi_2","01/09/2022","22/09/2022","dfsqgvwvw","ererrerere");
          Tournoi t2=new Tournoi(3,"tournoi_2","20/08/2022","24/08/2022","jjkjjkjkjkj","dsddsdsdsd");
          Tournoi t3=new Tournoi(3,"XXXXXXXX","XXXXXXXX","XXXXXXXX","XXXXXXXX","XXXXXXXX");
          
         
          //es.ajouter(e);
          //es.ajouter(e1);
          //es.supprimer(15);
          //es.modifier(e2);
          //es.rechercher(20);
          //ts.ajouter(t);
          //ts.ajouter(t1);
          //ts.ajouter(t2);
          //ts.supprimer(2);
          //ts.modifier(t3);
          //ts.rechercher(5);
          
          es.afficher();
          System.out.println(es.afficher());
    }
   
    
}
