/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Article;
import entities.Commentaires;
import java.sql.SQLException;
import java.util.Date;
import services.ArticleServices;
import services.commentairesServices;
import tools.MaConnexion;

/**
 *
 * @author Amine
 */
public class Main {

   public static void main(String[] args) throws SQLException {
       
        MaConnexion mc = MaConnexion.getInstance();
     
         ArticleServices su = new ArticleServices();
         
         commentairesServices cs = new commentairesServices();

          Article a = new Article(7,"Titrearticle45","Descarticle4","img.jpgarticle4");
         
          Commentaires c = new Commentaires (2,"Titrecommentaire3","contenucommentaire3",7);
          
         
//su.ajouter(a); 
        
        
 //cs.ajouter(c); 
        
        
// su.modifier(a);
        
        
//cs.modifier(c);
     
         
//su.supprimer(a);
       
        
//cs.supprimer(c);

//cs.ajouter(c);
      
 System.out.println(su.getCommentOfArticle());;

System.out.println(su.afficher());
//System.out.println(cs.afficher());
      
}
}

