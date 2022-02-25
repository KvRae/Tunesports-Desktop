package Services;

import Entities.Reservation;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements  IService<Reservation> {

    Connection cnx= MaConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Reservation r) {
        try {
            String sql="";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Reservation Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Reservation re) {
        try {
            String sql="";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Reservation Supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reservation re) {
        try {
            String sql="";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Reservation Modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reservation> afficher() {
        List<Reservation> reservation = new ArrayList<>();
        String sql ="select * from reservation";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Reservation r = new Reservation();
                r.setDateRes(rs.getString("date"));
                r.setHeureRes(rs.getString("heure"));
                r.setDispoRes(rs.getString("dispo"));
                r.setPrixRes(rs.getDouble("prix"));
                reservation.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservation;
    }
}
