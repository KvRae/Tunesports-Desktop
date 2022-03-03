 
package Entities;

import java.util.Date;

/**
 *
 * @author Amine
 */
public class Commentaires {
    private int idcommentaire;
    private String titrecommentaire;
    private String contenucommentaire ;
    private Date datecommentaire ;
    private int idArt;
    
    public Commentaires(){
    }

  

    public Commentaires(int idcommentaire, String titrecommentaire, String contenucommentaire, Date datecommentaire, int idArt) {
        this.idcommentaire = idcommentaire;
        this.titrecommentaire = titrecommentaire;
        this.contenucommentaire = contenucommentaire;
        this.datecommentaire = datecommentaire;
        this.idArt = idArt;
    }
      public Commentaires(int idcommentaire, String titrecommentaire, String contenucommentaire) {
        this.idcommentaire = idcommentaire;
        this.titrecommentaire = titrecommentaire;
        this.contenucommentaire = contenucommentaire;
      
    }
      public Commentaires(String titrecommentaire, String contenucommentaire,  int idArt) {
        this.titrecommentaire = titrecommentaire;
        this.contenucommentaire = contenucommentaire;
        this.idArt = idArt;
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

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    @Override
    public String toString() {
        return "Commentaires{" + "idcommentaire=" + idcommentaire + ", titrecommentaire=" + titrecommentaire + ", contenucommentaire=" + contenucommentaire + ", datecommentaire=" + datecommentaire + ", idArt=" + idArt + '}';
    }
}
    
    
            




