package Services;

import Entities.Rating;
import Tools.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RatingService implements IService<Rating> {
    Connection cnx= Connection.getInstance().getCnx();


    @Override
    public void ajouter(Rating rating) {
        try {
            String sql = "";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Rating Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Rating rating) {
        try {
            String sql = "";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Rating Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Rating rating) {

    }

    @Override
    public List<Rating> afficher() {
        return null;
    }
}
