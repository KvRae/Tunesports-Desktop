/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Entities;

import java.util.Date;

public class Rating {

  private int idRat;
  private Date dateRat;
  private int valueRat;
  private Utilisateur idCoa;
  private Utilisateur idCli;

  //****************************************************Constructors*********************************

  public Rating(Utilisateur idCoa) { this.idCoa = idCoa; }

  public Rating(Utilisateur idCoa, Utilisateur idCli) {
    this.idCoa = idCoa;
    this.idCli = idCli;
  }

  public Rating(int idRat, Date dateRat, int valueRat, Utilisateur idCoa,
                Utilisateur idCli) {
    this.idRat = idRat;
    this.dateRat = dateRat;
    this.valueRat = valueRat;
    this.idCoa = idCoa;
    this.idCli = idCli;
  }

  public Rating() {}

  public Rating(Date dateRat, int valueRat) {
    this.dateRat = dateRat;
    this.valueRat = valueRat;
  }

  public Rating(int idRat, String titleRat, Date dateRat, int valueRat) {
    this.idRat = idRat;
    this.dateRat = dateRat;
    this.valueRat = valueRat;
  }

  public Rating(int idRat) { this.idRat = idRat; }

  //***********************************************Getters&Setters**********************************************

  public int getIdRat() { return idRat; }

  public void setIdRat(int idRat) { this.idRat = idRat; }

  public Date getDateRat() { return dateRat; }

  public void setDateRat(Date dateRat) { this.dateRat = dateRat; }

  public int getValueRat() { return valueRat; }

  public void setValueRat(int valueRat) { this.valueRat = valueRat; }

  public Utilisateur getIdCoa() { return idCoa; }

  public void setIdCoa(Utilisateur idCoa) { this.idCoa = idCoa; }

  public Utilisateur getIdCli() { return idCli; }

  public void setIdCli(Utilisateur idCli) { this.idCli = idCli; }

  //***********************************************ToString =
  //Display**********************************************

  @Override
  public String toString() {
    return "RatingService{"
        + "idRat='" + idRat + '\'' + ", dateRat='" + dateRat + '\'' +
        ", valueRat='" + valueRat + '\'' + '}';
  }
}
