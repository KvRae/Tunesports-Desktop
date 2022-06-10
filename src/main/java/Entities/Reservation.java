/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Entities;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
  private int idRes;
  private Date dateRes;
  private Time heureRes;
  private String dispoRes;
  private double prixRes;
  private Utilisateur idCli;
  private Utilisateur idCoa;

  //***********************************************************Constructors*********************************

  public Reservation() {}

  public Reservation(Date dateRes, Time heureRes) {
    this.dateRes = dateRes;
    this.heureRes = heureRes;
  }

  public Reservation(int idRes, Date dateRes, Time heureRes, String dispoRes,
                     double prixRes, Utilisateur idCli, Utilisateur idCoa) {
    this.idRes = idRes;
    this.dateRes = dateRes;
    this.heureRes = heureRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
    this.idCli = idCli;
    this.idCoa = idCoa;
  }
  public Reservation(Date dateRes, Time heureRes, String dispoRes,
                     double prixRes, Utilisateur idCli, Utilisateur idCoa) {
    this.dateRes = dateRes;
    this.heureRes = heureRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
    this.idCli = idCli;
    this.idCoa = idCoa;
  }

  public Reservation(Date dateRes, String dispoRes, double prixRes) {
    this.dateRes = dateRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
  }

  public Reservation(Date dateRes, Time heureRes, String dispoRes,
                     double prixRes) {
    this.dateRes = dateRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
    this.heureRes = heureRes;
  }

  public Reservation(int idRes, Date dateRes, String dispoRes, double prixRes) {
    this.idRes = idRes;
    this.dateRes = dateRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
  }

  public Reservation(int idRes) { this.idRes = idRes; }

  public Reservation(Date dateRes) { this.dateRes = dateRes; }

  public Reservation(int idRes, Date dateRes, Time heureRes, String dispoRes,
                     double prixRes) {
    this.idRes = idRes;
    this.dateRes = dateRes;
    this.heureRes = heureRes;
    this.dispoRes = dispoRes;
    this.prixRes = prixRes;
  }

  public Reservation(Utilisateur cli) { this.idCli = cli; }

  //***********************************************Getters&Setters**********************************************

  public int getIdRes() { return idRes; }

  public void setIdRes(int idRes) { this.idRes = idRes; }

  public Date getDateRes() { return dateRes; }

  public void setDateRes(Date dateRes) { this.dateRes = dateRes; }

  public double getPrixRes() { return prixRes; }

  public void setPrixRes(double prixRes) { this.prixRes = prixRes; }

  public String getDispoRes() { return dispoRes; }

  public void setDispoRes(String dispoRes) { this.dispoRes = dispoRes; }

  public Time getHeureRes() { return heureRes; }

  public void setHeureRes(Time heureRes) { this.heureRes = heureRes; }

  public Utilisateur getIdCoach() { return idCoa; }

  public void setIdCoach(Utilisateur idCoach) { this.idCoa = idCoach; }

  public Utilisateur getIdCli() { return idCli; }

  public void setIdCli(Utilisateur idCli) { this.idCli = idCli; }

  //***********************************************ToString = afficher
  //**********************************************

  @Override
  public String toString() {
    return "Reservation Number: " + getIdRes();
  }
}
