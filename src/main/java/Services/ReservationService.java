/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Services;

import Entities.Coach;
import Entities.Reservation;
import Entities.Utilisateur;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationService implements IService<Reservation> {
  //******************************Start Connection
  //Instance*****************************
  Connection cnx = MaConnexion.getInstance().getCnx();

  //*******************************************************************************************
  //*******************************Crud
  //Operations**************************************
  //*******************************************************************************************

  //***************************Create
  //Operation*****************************************
  @Override
  public void ajouter(Reservation re) {
    PreparedStatement pre;

    try {
      pre = cnx.prepareStatement(
          "INSERT INTO reservation (dateRes,heureRes,dispoRes,prixRes,idCli,idCoa)VALUES (?,?,?,?,?,?);");
      pre.setDate(1, re.getDateRes());
      pre.setTime(2, re.getHeureRes());
      pre.setString(3, re.getDispoRes());
      pre.setDouble(4, re.getPrixRes());
      pre.setInt(5, re.getIdCoach().getId());
      pre.setInt(6, re.getIdCli().getId());

      System.out.println("Reservation Ajoutée");
      pre.executeUpdate();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  //***************************Read
  //Operation*****************************************
  @Override
  public List<Reservation> afficher() {
    ObservableList<Reservation> reservations =
        FXCollections.observableArrayList();
    String sql = "select * from reservation";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Reservation r = new Reservation();

        r.setIdRes(rs.getInt("idRes"));
        r.setDateRes(rs.getDate("dateRes"));
        r.setHeureRes(rs.getTime("heureRes"));
        r.setDispoRes(rs.getString("dispoRes"));
        r.setPrixRes(rs.getDouble("prixRes"));
        r.setIdCoach(new Utilisateur(rs.getInt("idCoach")));
        r.setIdCli(new Utilisateur(rs.getInt("idCli")));
        reservations.add(r);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return reservations;
  }

  //***************************Update
  //Operation*****************************************
  @Override
  public void modifier(Reservation re) {
    String query =
        "UPDATE reservation SET  dateRes =" + re.getDateRes() +
        ",heureRes =" + re.getHeureRes() + ", dispoRes =" + re.getDispoRes() +
        ", prixRes =" + re.getPrixRes() + " WHERE idRes =" + re.getIdRes();
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Reservation modifieé ");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  //***************************Delete
  //Operation*****************************************
  @Override
  public void supprimer(Reservation re) {
    String query = "DELETE FROM RESERVATION WHERE idRes = " + re.getIdRes();
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Reservation supprimer");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  //***********************************************************************************
  //*********************************Extra
  //Operations**********************************
  //***********************************************************************************

  //***************************Search
  //Operation*****************************************

  /*public Coach getCoach(int idCoach ) {
              String sql="SELECT * FROM coach WHERE idCoach = ?";
               try{
              PreparedStatement ste= cnx.prepareStatement(sql);
              ste.setInt(1,idCoach);
              ResultSet rs= ste.executeQuery();
              if (rs.next()) {
                  Coach coa = new Coach();
                  coa.setIdCoach(rs.getInt("idCoach"));
                  coa.set(rs.getDate("dateRes"));
                  coa.setDispoRes(rs.getString("dispoRes"));
                  coa.setPrixRes(rs.getDouble("prixRes"));
                  System.out.println(res);}
          }
          catch(SQLException ex){
              System.out.println(ex.getMessage());
          }
        return coach;
      }*/

  //***************************DeleteAll
  //Operation*****************************************
  public void supprimerTout() {
    String query = "DELETE FROM RESERVATION";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Toute les Reservation sont supprimer");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  public void reset() {
    String query = "ALTER TABLE RESERVATION AUTO_INCREMENT =1";
    try {
      Statement ste = cnx.createStatement();
      ste.executeUpdate(query);
      System.out.println("Ids reset");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public List<Reservation> getListResCli(Reservation re) {
    ObservableList<Reservation> reservations =
        FXCollections.observableArrayList();
    String sql =
        "select * from reservation where idCli = " + re.getIdCli().getId();
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Reservation r = new Reservation();
        r.setIdRes(rs.getInt("idRes"));
        r.setDateRes(rs.getDate("dateRes"));
        r.setHeureRes(rs.getTime("heureRes"));
        r.setDispoRes(rs.getString("dispoRes"));
        r.setPrixRes(rs.getDouble("prixRes"));
        reservations.add(r);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return reservations;
  }
}
