package Services;

import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Jeux;
import entities.Livraison;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class LivraisonService implements IService<Livraison> {
  Connection cnx = MaConnexion.getInstance().getCnx();
  private Statement ste;

  @Override
  public void ajouter(Livraison L) {
    PreparedStatement pre;
    try {
      pre = cnx.prepareStatement(
          "INSERT INTO livraison (idcom,nomliv,telliv,fraisliv,prixltot,lieuxliv)VALUES (?,?,?,?,?,?);");
      pre.setInt(1, L.getIdcom());
      pre.setString(2, L.getNomliv());
      pre.setInt(3, L.getTelliv());
      pre.setInt(4, L.getFraisliv());
      pre.setInt(5, L.getPrixltot());
      pre.setString(6, L.getLieuxliv());

      pre.executeUpdate();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void modifier(Livraison L) {
    try {
      PreparedStatement pre = cnx.prepareStatement(
          "UPDATE livraison SET idcom= ?  , nomliv = ?, telliv = ?, fraisliv = ?,prixltot=?, lieuxliv=?  where idliv= ? ;");

      pre.setInt(1, L.getIdcom());
      pre.setString(3, L.getNomliv());
      pre.setInt(4, L.getTelliv());
      pre.setInt(5, L.getFraisliv());
      pre.setInt(6, L.getPrixltot());
      pre.setString(7, L.getLieuxliv());
      pre.setInt(8, L.getIdliv());

      if (pre.executeUpdate() != 0) {
        System.out.println(" livraison updated");
      } else {
        System.out.println("non");
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void supprimer(Livraison L) {
    PreparedStatement pre;
    try {
      pre = cnx.prepareStatement("Delete from livraison where idliv=? ;");

      pre.setInt(1, L.getIdliv());
      if (pre.executeUpdate() != 0) {
        System.out.println("livraison Deleted");

      } else
        System.out.println("idliv not found!!!");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public List<Livraison> afficher() {
    List<Livraison> Le = new ArrayList<>();
    try {
      ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery("select * from livraison");
      while (rs.next()) {
        int idliv = rs.getInt("idliv");
        int idcom = rs.getInt("idcom");
        String nomliv = rs.getString("nomliv");
        int telliv = rs.getInt("telliv");
        int fraisliv = rs.getInt("fraisliv");
        int prixltot = rs.getInt("prixltot");
        String lieuxliv = rs.getString("lieuxliv");

        Livraison L = new Livraison(idliv, idcom, nomliv, telliv, fraisliv,
                                    prixltot, lieuxliv);
        Le.add(L);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return Le;
  }

  public void pdf(Livraison L) throws FileNotFoundException, DocumentException {
    try {
      String file_name = "C:\\Users\\firas\\OneDrive\\Bureau\\pdff\\firas.pdf";
      Document doc = new Document();
      PdfWriter.getInstance(doc, new FileOutputStream(file_name));
      doc.open();
      PreparedStatement ps = null;
      ResultSet rs = null;
      String querry = "SELECT * FROM livraison";

      ps = cnx.prepareStatement(querry);
      rs = ps.executeQuery();
      while (rs.next()) {
        Paragraph para = new Paragraph(
            rs.getInt("idliv") + " " + rs.getInt("idcom") + " " +
            rs.getString("nomliv") + " " + rs.getInt("telliv") + " " +
            rs.getInt("telliv") + " " + rs.getInt("fraisliv") + " " +
            rs.getInt("prixltot") + " " + rs.getInt("prixltot") + " " +
            rs.getString("lieuxliv"));
        doc.add(para);
        doc.add(new Paragraph(" "));
      }
      doc.close();

    } catch (Exception E) {
      System.err.println(E);
    }
  }

  @Override
  public void recherche(Livraison L) {
    try {
      String sql =
          "SELECT * FROM livraison WHERE id_event ='" + L.getIdliv() + "'";
      Statement ste = cnx.createStatement();
      ResultSet rst = ste.executeQuery(sql);
      rst.last();
      int nbrRow = rst.getRow();
      if (nbrRow != 0) {
        System.out.println("ID livraison= " + L.getIdliv());
        System.out.println("id commande= " + L.getIdcom());
        System.out.println("nom livreur= " + L.getNomliv());
        System.out.println("tel livreur= " + L.getTelliv());
        System.out.println("frais livraison end dt= " + L.getFraisliv());
        System.out.println("prix total= " + L.getPrixltot());
        System.out.println("lieux livraison= " + L.getLieuxliv());

      } else {
        System.out.println("livraison non trouve");
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public List<Livraison> trie() {
    List<Livraison> livraison = new ArrayList<>();
    String sql = "SELECT * FROM livraison ORDER BY idliv ASC";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Livraison L = new Livraison();
        // p.setId(rs.getInt("id"));
        L.setIdliv(rs.getInt("idliv"));
        L.setIdcom(rs.getInt("idcom"));

        L.setNomliv(rs.getString("nomliv"));
        L.setTelliv(rs.getInt("telliv"));
        L.setFraisliv(rs.getInt("fraisliv"));
        L.setPrixltot(rs.getInt("prixltot"));
        L.setLieuxliv(rs.getString("lieuxliv"));

        livraison.add(L);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return livraison;
  }

  @Override
  public List<Livraison> triedesc() {
    List<Livraison> livraison = new ArrayList<>();
    String sql = "SELECT * FROM livraison ORDER BY idliv DESC";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Livraison L = new Livraison();
        // p.setId(rs.getInt("id"));
        L.setIdliv(rs.getInt("idliv"));
        L.setIdcom(rs.getInt("idcom"));

        L.setNomliv(rs.getString("nomliv"));
        L.setTelliv(rs.getInt("telliv"));
        L.setFraisliv(rs.getInt("fraisliv"));
        L.setPrixltot(rs.getInt("prixltot"));
        L.setLieuxliv(rs.getString("lieuxliv"));

        livraison.add(L);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return livraison;
  }
}
