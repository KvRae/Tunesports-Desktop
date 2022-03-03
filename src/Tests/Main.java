/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Entities.Article;
import Entities.Commentaires;
import java.sql.SQLException;
import java.util.Date;
import Services.ArticleServices;
import Services.CommentairesServices;
import Tools.MaConnexion;

/**
 *
 * @author Amine
 */
public class Main {

   public static void main(String[] args) throws SQLException {
       
        MaConnexion mc = MaConnexion.getInstance();
     
         ArticleServices su = new ArticleServices();
         
         CommentairesServices cs = new CommentairesServices();

          Article a = new Article("Titrearticle00","Descarticle4","img.jpgarticle4");
         
          Commentaires c = new Commentaires ("Titrecommentaire19","contenucommentaire3",8);
          
         
//su.ajouter(a); 
 
//cs.ajouter(c); 
             
//su.modifier(a);
             
//cs.modifier(c);
          
//su.supprimer(a);
       
//cs.supprimer(c);

//cs.ajouter(c);
      


//System.out.println(su.getCommentOfArticle());;
//System.out.println(cs.afficher());
//System.out.println(su.afficher());

}
}

