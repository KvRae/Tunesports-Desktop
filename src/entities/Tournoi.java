/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;
/**
 *
 * @author Chiheb
 */
public class Tournoi {
  private int id_tour;
  private String nomtour;
  private Date datedebtour;
  private Date datefintour;
  private String desctour;
  private String recomptour;

  public Tournoi() {}

  public Tournoi(int id_tour, String nomtour, Date datedebtour,
                 Date datefintour, String desctour, String recomptour) {
    this.id_tour = id_tour;
    this.nomtour = nomtour;
    this.datedebtour = datedebtour;
    this.datefintour = datefintour;
    this.desctour = desctour;
    this.recomptour = recomptour;
  }

  public Tournoi(int id_tour) { this.id_tour = id_tour; }

  public int getId_tour() { return id_tour; }

  public String getNomtour() { return nomtour; }

  public Date getDatedebtour() { return datedebtour; }

  public Date getDatefintour() { return datefintour; }

  public String getDesctour() { return desctour; }

  public String getRecomptour() { return recomptour; }

  public void setId_tour(int id_tour) { this.id_tour = id_tour; }

  public void setNomtour(String nomtour) { this.nomtour = nomtour; }

  public void setDatedebtour(Date datedebtour) {
    this.datedebtour = datedebtour;
  }

  public void setDatefintour(Date datefintour) {
    this.datefintour = datefintour;
  }

  public void setDesctour(String desctour) { this.desctour = desctour; }

  public void setRecomptour(String recomptour) { this.recomptour = recomptour; }

  @Override
  public String toString() {
    return "Tournoi{"
        + "id_tour=" + id_tour + ", nomtour=" + nomtour +
        ", datedebtour=" + datedebtour + ", datefintour=" + datefintour +
        ", desctour=" + desctour + ", recomptour=" + recomptour + '}';
  }
}
