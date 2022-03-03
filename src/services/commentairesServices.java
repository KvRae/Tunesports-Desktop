/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Article;
import Entities.Commentaires;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Amine
 */
public class CommentairesServices implements IService<Commentaires> {
  private Connection cnx;
  private Statement ste;

  public CommentairesServices() { cnx = MaConnexion.getInstance().getCnx(); }

  @Override
  public void ajouter(Commentaires c) {
    String query =
        "INSERT INTO Commentaires(titre_commentaire,contenu_commentaire,date_commentaire,id_art) "
        + "VALUES(?,?,?,?)";
    try {
      PreparedStatement ste = cnx.prepareStatement(query);
      ste.setString(1, c.getTitrecommentaire());
      ste.setString(2, c.getContenucommentaire());
      java.util.Date date = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      ste.setDate(3, sqlDate);
      ste.setInt(4, c.getIdArt());

      ste.executeUpdate();
      System.out.println("commentaire Bien Ajouté");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void modifier(Commentaires c) {
    String query = "UPDATE Commentaires SET titre_commentaire = '" +
                   c.getTitrecommentaire() + "', contenu_commentaire = '" +
                   c.getContenucommentaire() +
                   "' WHERE id_commentaire = " + c.getIdcommentaire() + "";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Commentaire Bien Modifié");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void supprimer(Commentaires c) {
    String query = "DELETE FROM Commentaires WHERE id_commentaire = " +
                   c.getIdcommentaire() + "";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Article Bien Supprimé");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public List<Commentaires> afficher() {
    List<Commentaires> desCommentaires = new ArrayList<>();
    String query = "SELECT * FROM Commentaires";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(query);
      while (rs.next()) {
        Commentaires c = new Commentaires();
        c.setIdcommentaire(rs.getInt("id_commentaire"));
        c.setTitrecommentaire(rs.getString("titre_commentaire"));
        c.setContenucommentaire(rs.getString("contenu_commentaire"));
        c.setDatecommentaire(rs.getDate("date_commentaire"));
        c.setIdArt(rs.getInt("id_art"));
        desCommentaires.add(c);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return desCommentaires;
  }
}
