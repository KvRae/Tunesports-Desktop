/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Tests;
import Entities.Reservation;
import Services.ReservationService;
import Tools.MaConnexion;

public class Main {
    public static void main(String[] args) {
        //insuring singleton connection to our Db Server
        MaConnexion cnx = MaConnexion.getInstance();
        //***************************Creating Test Instance for reservation************************************
        Reservation re = new Reservation(new java.util.Date() ,"Disponible",10);
        //Reservation re2 = new Reservation(2,new java.util.Date() , Disponiblity.valueOf("Disponible"),15);
        //Reservation re1 = new Reservation(3,new java.util.Date(),Disponiblity.valueOf("Disponible"),10);
        Reservation re3 = new Reservation(6);
        ReservationService res = new ReservationService();

        //********************Testing Service Reservation*************************

        System.out.println("-----------------------------------------------");
        //res.ajouter(re);
        res.recherche(re3);
        //res.modifier(re2);
        //res.supprimer(re3);
        //System.out.println(res.afficher());

        //***************************Creating Test Instance for rating************************************

        //Rating ra = new Rating("12/8/2022", "12:00",4);
        //Rating ra2 = new Rating(2,"User5", new java.util.Date(),1);
        //Rating ra1 = new Rating(1);
        //RatingService ras = new RatingService();

        //********************Testing Service Rating*************************

        //System.out.println("-----------------------------------------------");
        //ras.ajouter(ra2);
        //ras.modifier(ra2);
        //ras.supprimer(ra1);
        //System.out.println(ras.afficher());

    }
}
