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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */

public class ArticleServices implements IService<Article> {
  private Connection cnx;
  private Statement ste;

  public ArticleServices() { cnx = MaConnexion.getInstance().getCnx(); }
  @Override
  public void ajouter(Article article) {
    String query =
        "INSERT INTO ARTICLE(titre_article,description_article,date_article,image_article) "
        + "VALUES(?,?,?,?)";
    try {
      PreparedStatement ste = cnx.prepareStatement(query);
      ste.setString(1, article.getTitreArticle());
      ste.setString(2, article.getDescriptionArticle());
      java.util.Date date = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      ste.setDate(3, sqlDate);
      ste.setString(4, article.getImageArticle());
      ste.executeUpdate();
      System.out.println("Article Bien Ajouté");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void supprimer(Article article) {
    String query =
        "DELETE FROM ARTICLE WHERE id_article = " + article.getIdArticle() + "";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Article Bien Supprimé");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public List<Article> afficher() {
    List<Article> articles = new ArrayList<>();
    String query = "SELECT * FROM ARTICLE";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(query);
      while (rs.next()) {
        Article article = new Article();
        article.setIdArticle(rs.getInt("id_article"));
        article.setTitreArticle(rs.getString("titre_article"));
        article.setDescriptionArticle(rs.getString("description_article"));
        article.setDateArticle(rs.getDate("date_article"));
        article.setImageArticle(rs.getString("image_article"));
        articles.add(article);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return articles;
  }

  @Override
  public void modifier(Article article) {
    String query = "UPDATE ARTICLE SET titre_article = '" +
                   article.getTitreArticle() + "', description_article = '" +
                   article.getDescriptionArticle() + "', image_article = '" +
                   article.getImageArticle() +
                   "' WHERE id_article = " + article.getIdArticle() + "";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Article Bien Modifié");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}

/*public List<Commentaires> getCommentOfArticle(){
       List<Commentaires> listComments = new ArrayList<>();
       String query = "select
commentaires.id_commentaire,commentaires.titre_commentaire,commentaires.contenu_commentaire,"
               + "commentaires.date_commentaire  from commentaires INNER join
article on article.id_article = commentaires.id_art;"; try{ Statement ste =
cnx.createStatement(); ResultSet rs = ste.executeQuery(query); while(rs.next()){
               Commentaires c = new Commentaires();
               c.setIdcommentaire(rs.getInt("id_commentaire"));
               c.setTitrecommentaire(rs.getString("titre_commentaire"));
               c.setContenucommentaire(rs.getString("contenu_commentaire"));
               c.setDatecommentaire(rs.getDate("date_commentaire"));
                c.setIdArt(rs.getInt("id_art"));
               listComments.add(c);
           }

       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       return listComments;
   }

}


   */
