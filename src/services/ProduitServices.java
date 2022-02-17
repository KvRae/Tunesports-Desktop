/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MaConnexion;

/**
 *
 * @author achou
 */
public class ProduitServices implements IService<Produit> {
    private Connection con;
    private Statement ste;

    public ProduitServices() {
        con = MaConnexion.getInstance().getCnx();}

    @Override
    public void ajouter(Produit p) {
          PreparedStatement pre;
    try {
        pre = con.prepareStatement("INSERT INTO Produit (nomP,prixP,descP,dispoP,couleurP)VALUES (?,?,?,?,?);");
        pre.setString(1, p.getNomP());
        pre.setInt(2, p.getPrixP());
        pre.setString(3, p.getDescP());
        pre.setString(4, p.getDispoP());
        pre.setString(5, p.getCouleurP());


        pre.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifier(Produit p) {
        try {
            PreparedStatement pre = con.prepareStatement("UPDATE Produit SET nomP= ? ,prixP = ? , descP = ?, dispoP = ?, couleurP = ?  where idP= ? ;");
        pre.setString(1, p.getNomP());
        pre.setInt(2, p.getPrixP());
        pre.setString(3, p.getDescP());
        pre.setString(4, p.getDispoP());
        pre.setString(5, p.getCouleurP());  
        pre.setInt(6, p.getIdP());   



            if (pre.executeUpdate() != 0) {
                System.out.println(" Produit updated");
                 } else {
                System.out.println("non");
            }
                 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void suprimer(Produit p) {
        PreparedStatement pre;
    try {
        pre = con.prepareStatement("Delete from produit where idP=? ;");
    
        pre.setInt(1, p.getIdP());
        if (pre.executeUpdate() != 0) {
            System.out.println("produit Deleted");
            
        }
        System.out.println("id produit not found!!!");
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

            
        }
    }

    @Override
    public List<Produit> afficher() { List<Produit> lu = new ArrayList<>();
        try {
        ste = con.createStatement();
    
        ResultSet rs = ste.executeQuery("select idP ,nomP,prixP,descP,dispoP,couleurP  from produit");
        while (rs.next()) {
            int idProduit=rs.getInt("idP");
            String nomP = rs.getString("nomP");
            int prixP = rs.getInt("prixP");
            String descP = rs.getString("descP");
            String dispoP = rs.getString("dispoP");
            String couleurP = rs.getString("couleurP");

            Produit j = new Produit(idProduit,nomP, prixP, descP ,dispoP,couleurP);
            lu.add(j);
        }
    } catch (SQLException ex) {
                            System.out.println(ex.getMessage());

    }
    return lu ;
    
    }
    
    
}
