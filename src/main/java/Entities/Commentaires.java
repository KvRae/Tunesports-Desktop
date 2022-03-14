
package Entities;

import java.util.Date;

/**DateArticle bb
 *bb
 * @author Amine
 */
public class Commentaires {
    private int idcommentaire;
    private String titrecommentaire;
    private String contenucommentaire ;
    private Date datecommentaire ;
    private Article article = new Article();

    private int user_id;

    public Commentaires(){
    }

    public Commentaires(String titrecommentaire, String contenucommentaire, Date datecommentaire, Article article, int user_id) {
        this.titrecommentaire = titrecommentaire;
        this.contenucommentaire = contenucommentaire;
        this.datecommentaire = datecommentaire;
        this.article = article;
        this.user_id = user_id;
    }

    public Commentaires(int idcommentaire, String titrecommentaire, String contenucommentaire, Date datecommentaire, Article article, int user_id) {
        this.idcommentaire = idcommentaire;
        this.titrecommentaire = titrecommentaire;
        this.contenucommentaire = contenucommentaire;
        this.datecommentaire = datecommentaire;
        this.article = article;
        this.user_id = user_id;
    }

    public int getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(int idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public String getTitrecommentaire() {
        return titrecommentaire;
    }

    public void setTitrecommentaire(String titrecommentaire) {
        this.titrecommentaire = titrecommentaire;
    }

    public String getContenucommentaire() {
        return contenucommentaire;
    }

    public void setContenucommentaire(String contenucommentaire) {
        this.contenucommentaire = contenucommentaire;
    }

    public Date getDatecommentaire() {
        return datecommentaire;
    }

    public void setDatecommentaire(Date datecommentaire) {
        this.datecommentaire = datecommentaire;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Commentaires{" +
                "idcommentaire=" + idcommentaire +
                ", titrecommentaire='" + titrecommentaire + '\'' +
                ", contenucommentaire='" + contenucommentaire + '\'' +
                ", datecommentaire=" + datecommentaire +
                ", article=" + article +
                ", user_id=" + user_id +
                '}';
    }
}







