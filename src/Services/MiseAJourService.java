package Services;
import entities.Jeux;
import entities.Livraison;
import entities.Mise_a_jour;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

public class MiseAJourService implements IService<Mise_a_jour> {
  Connection cnx = MaConnexion.getInstance().getCnx();
  private Statement ste;

  @Override
  public void ajouter(Mise_a_jour M) {
    try {
      String sql =
          "INSERT INTO miseajour (idmise,nomjeu,pubmise,versionmise,taillemise,descmise,idjeux)VALUES ('" +
          M.getIdmise() + "','" + M.getNomjeu() + "','" +
          new Date(M.getPubmise().getTime()) + "','" + M.getVersionmise() +
          "','" + M.getTaillemise() + "','" + M.getDescmise() + "','" +
          M.getidjeux() + "')";
      Statement ste = cnx.createStatement();
      ste.executeUpdate(sql);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void modifier(Mise_a_jour M) {
    try {
      PreparedStatement pre = cnx.prepareStatement(
          "UPDATE miseajour SET nomjeu= ? ,pubmise = ? , versionmise = ?,   taillemise = ?,descmise=? , idjeux=? where idmise= ? ;");
      pre.setString(1, M.getNomjeu());
      pre.setDate(2, M.getPubmise());
      pre.setString(3, M.getVersionmise());
      pre.setInt(4, M.getTaillemise());
      pre.setString(5, M.getDescmise());
      pre.setInt(6, M.getidjeux());
      pre.setInt(7, M.getIdmise());

      if (pre.executeUpdate() != 0) {
        System.out.println(" note patch updated");
      } else {
        System.out.println("eror chekc again");
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void supprimer(Mise_a_jour M) {
    PreparedStatement pre;
    try {
      pre = cnx.prepareStatement("Delete from miseajour where idmise=? ;");

      pre.setInt(1, M.getIdmise());
      if (pre.executeUpdate() != 0) {
        System.out.println("note mise ajour Deleted");

      } else
        System.out.println("idmise not found!!");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public List<Mise_a_jour> afficher() {
    {
      List<Mise_a_jour> mi = new ArrayList<>();
      try {
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select *  from miseajour");
        while (rs.next()) {
          int idmise = rs.getInt("idmise");
          String nomjeu = rs.getString("nomjeu");
          Date pubmise = rs.getDate("pubmise");
          String versionmise = rs.getString("versionmise");
          int taillemise = rs.getInt("taillemise");
          String descmise = rs.getString("descmise");
          int idjeux = rs.getInt("idjeux");

          Mise_a_jour M = new Mise_a_jour(idmise, nomjeu, pubmise, versionmise,
                                          taillemise, descmise, idjeux);
          mi.add(M);
        }
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
      return mi;
    }
  }

  public List<Mise_a_jour> affichejeuxmiseajour(int idjeux) {
    {
      List<Mise_a_jour> arr = new ArrayList<>();

      try {
        PreparedStatement pre = cnx.prepareStatement(
            "SELECT j.idjeux , j.nomjeux , m.pubmise , m.versionmise , m.taillemise , m.descmise FROM jeux j , miseajour m where j.idjeux = m.idjeux and m.idjeux=? ");
        pre.setInt(1, idjeux);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

          int idJ = rs.getInt(1);
          String nomj = rs.getString("j.nomjeux");
          Date pubmis = rs.getDate("m.pubmise");

          String versionmise = rs.getString("m.versionmise");
          int taillemise = rs.getInt("m.taillemise");
          String descmise = rs.getString("m.descmise");

          Mise_a_jour Mj = new Mise_a_jour(idJ, nomj, pubmis, versionmise,
                                           taillemise, descmise);
          arr.add(Mj);
        }
      } catch (SQLException ex) {
        Logger.getLogger(MiseAJourService.class.getName())
            .log(Level.SEVERE, null, ex);
      }

      return arr;
    }
  }

  @Override
  public void recherche(Mise_a_jour M) {
    try {
      String sql = "SELECT * FROM miseajour WHERE idmise = ?";
      PreparedStatement ste = cnx.prepareStatement(sql);
      ste.setInt(1, M.getIdmise());
      ResultSet rst = ste.executeQuery();
      if (rst.next()) {
        int idmise = rst.getInt("idmise");

        String nomjeu = rst.getString("nomjeu");
        Date pubmise = rst.getDate("pubmise");
        String versionmise = rst.getString("versionmise");
        int taillemise = rst.getInt("taillemise");
        String descmise = rst.getString("descmise");
        int idjeux = rst.getInt("idjeux");

        Mise_a_jour ME = new Mise_a_jour(idmise, nomjeu, pubmise, versionmise,
                                         taillemise, descmise, idjeux);
        System.out.println(ME);
      } else {
        System.out.println("jeu non trouve");
      }
    }

    catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public List<Mise_a_jour> trie() {
    List<Mise_a_jour> miseajour = new ArrayList<>();
    String sql = "SELECT * FROM miseajour ORDER BY versionmise ASC";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Mise_a_jour M = new Mise_a_jour();
        // p.setId(rs.getInt("id"));
        M.setIdmise(rs.getInt("idmise"));
        M.setNomjeu(rs.getString("nomjeu"));

        M.setPubmise(rs.getDate("pubmise"));
        M.setVersionmise(rs.getString("versionmise"));
        M.setTaillemise(rs.getInt("taillemise"));
        M.setDescmise(rs.getString("descmise"));
        M.setidjeux(rs.getInt("idjeux"));

        miseajour.add(M);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return miseajour;
  }

  @Override
  public List<Mise_a_jour> triedesc() {
    List<Mise_a_jour> miseajour = new ArrayList<>();
    String sql = "SELECT * FROM miseajour ORDER BY idmise DESC";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Mise_a_jour M = new Mise_a_jour();
        // p.setId(rs.getInt("id"));
        M.setIdmise(rs.getInt("idmise"));
        M.setNomjeu(rs.getString("nomjeu"));

        M.setPubmise(rs.getDate("pubmise"));
        M.setVersionmise(rs.getString("versionmise"));
        M.setTaillemise(rs.getInt("taillemise"));
        M.setDescmise(rs.getString("descmise"));
        M.setidjeux(rs.getInt("idjeux"));

        miseajour.add(M);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return miseajour;
  }
}
