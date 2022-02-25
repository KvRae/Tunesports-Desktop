package Tests;

import Entities.Reservation;
import Services.ReservationService;
import Tools.Connexion;


public class Main {
    public static void main(String[] args) {
        Connexion cx = Connexion.getInstance();
        Reservation re = new Reservation("12/8/2022", "12:00","Dispo",10);
        ReservationService res = new ReservationService();
        res.ajouter(re);
      //  System.out.println(rs.afficher());
    }
}
