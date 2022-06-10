package Services;

import Entities.Coach;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoachService implements IService<Coach> {

  Connection cnx = MaConnexion.getInstance().getCnx();

  @Override
  public void ajouter(Coach coach) {}

  @Override
  public List<Coach> afficher() {
    ObservableList<Coach> coaches = FXCollections.observableArrayList();
    String sql = "select * from coach";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Coach ca = new Coach();
        ca.setNickname(rs.getString("nickname"));
        ca.setRank(rs.getString("rank"));
        // ca.setSpecialite(rs.getString("valueRat"));
        coaches.add(ca);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return coaches;
  }

  @Override
  public void modifier(Coach coach) {}

  @Override
  public void supprimer(Coach coach) {}

  @Override
  public void recherche(Coach coach) {}
}
