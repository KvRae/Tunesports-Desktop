/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import entities.Commande;
import java.sql.PreparedStatement;
import tools.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author achou
 */

public class CommandeServices implements IService<Commande>{
private Connection con;
    private Statement ste;

    public CommandeServices() {
        con = MaConnexion.getInstance().getCnx();}
    @Override
    public void ajouter(Commande c) {
        PreparedStatement pre;
    try {
        pre = con.prepareStatement("INSERT INTO commande (adresseC,dateC,statusC)VALUES (?,?,?);");
        pre.setString(1, c.getAdresseC());
        pre.setString(2, c.getDateC());
         pre.setString(3, c.getStatusC());

        pre.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifier(Commande c) {
       try {
            PreparedStatement pre = con.prepareStatement("UPDATE commande SET adresseC= ? ,dateC = ? , statusC = ?  where idC= ? ;");
            pre.setString(1, c.getAdresseC());
            pre.setString(2, c.getDateC());
            pre.setString(3, c.getStatusC());  
            pre.setInt(4, c.getIdC());   



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
        pre = con.prepareStatement("Delete from commande where idC=? ;");
    
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
    public List<Commande> afficher() { List<Commande> lu = new ArrayList<>();
    try {
        ste = con.createStatement();
    
        ResultSet rs = ste.executeQuery("select idC ,adresseC,dateC,statusC  from commande");
        while (rs.next()) {
            int idCommande=rs.getInt("idC");
            String adresseC = rs.getString("adresseC");
            String dateC = rs.getString("dateC");
             String statusC = rs.getString("statusC");
            Commande j = new Commande(idCommande,adresseC, dateC, statusC);
            lu.add(j);
        }
    } catch (SQLException ex) {
                            System.out.println(ex.getMessage());

    }
    return lu ;
    
}
}
