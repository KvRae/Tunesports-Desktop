/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commande;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;
/**
 *
 * @author achou
 */

public class CommandeServices implements IService<Commande> {
  private Connection cnx;
  private Statement ste;

  public CommandeServices() { cnx = MaConnexion.getInstance().getCnx(); }
  @Override
  public void ajouter(Commande c) {
    PreparedStatement pre;
    try {
      pre = cnx.prepareStatement(
          "INSERT INTO commande (adresseC,dateC,statusC,idP)VALUES (?,?,?,?);");
      pre.setString(1, c.getAdresseC());
      pre.setDate(2, new Date(c.getDateC().getTime()));

      pre.setString(3, c.getStatusC());
      pre.setInt(4, c.getIdP());
      // pre.setInt(5, c.getIdMen());

      pre.executeUpdate();

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void modifier(Commande c) {
    try {
      PreparedStatement pre = cnx.prepareStatement(
          "UPDATE commande SET adresseC= ? ,dateC = ? , statusC = ? , idP = ?  where idC= ? ;");
      pre.setString(1, c.getAdresseC());
      pre.setDate(2, new Date(c.getDateC().getTime()));
      pre.setString(3, c.getStatusC());
      pre.setInt(4, c.getIdC());
      pre.setInt(5, c.getIdP());
      // pre.setInt(6, c.getIdMen());

      if (pre.executeUpdate() != 0) {
        System.out.println(" Commande updated");
      } else {
        System.out.println("non");
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void suprimer(Commande c) {
    PreparedStatement pre;
    try {
      pre = cnx.prepareStatement("Delete from commande where idC=? ;");

      pre.setInt(1, c.getIdC());
      if (pre.executeUpdate() != 0) {
        System.out.println("commande Deleted");
      }
      System.out.println("id commande not found!!!");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public List<Commande> afficher() {
    List<Commande> lu = new ArrayList<>();
    try {
      ste = cnx.createStatement();

      ResultSet rs = ste.executeQuery(
          "select idC ,adresseC,dateC,statusC,idP  from commande");
      while (rs.next()) {
        int idCommande = rs.getInt("idC");
        String adresseC = rs.getString("adresseC");
        Date dateC = rs.getDate("dateC");
        String statusC = rs.getString("statusC");
        int idP = rs.getInt("idP");
        // int idMen=rs.getInt("idMen");
        Commande j = new Commande(idCommande, adresseC, dateC, statusC, idP);
        lu.add(j);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return lu;
  }

  // @Override
  public void recherchercommande(int e) {
    String requete = "SELECT * FROM commande where idC= " + e;
    Commande c = new Commande();
    try {
      Statement stmt = MaConnexion.getInstance().getCnx().createStatement();
      ResultSet rs = stmt.executeQuery(requete);
      if (rs != null) {
        while (rs.next()) {

          c.setIdC(rs.getInt("idC"));
          c.setAdresseC(rs.getString("adresseC"));
          c.setDateC(rs.getDate("dateC"));
          c.setStatusC(rs.getString("statusC"));
          c.setIdP(rs.getInt("idP"));
          // c.setIdMen(rs.getInt("idMen"));
        }
      }
    } catch (SQLException x) {
      System.out.println(x.getMessage());
    }
    if (c.getIdC() != e)
      System.out.println("commande not found");

    else
      System.out.println("votre commande : \n" + c);
  }
  public List<Commande> trie() {
    List<Commande> Commande = new ArrayList<>();
    String sql = "SELECT * FROM commande ORDER BY idC ASC";
    try {
      Statement ste = cnx.createStatement();
      ResultSet rs = ste.executeQuery(sql);
      while (rs.next()) {
        Commande e = new Commande();
        // p.setId(rs.getInt("id"));
        e.setIdC(rs.getInt("idC"));
        e.setAdresseC(rs.getString("adresseC"));
        e.setDateC(rs.getDate("dateC"));
        e.setStatusC(rs.getString("statusC"));
        e.setIdP(rs.getInt("idP"));

        Commande.add(e);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return Commande;
  }
}
