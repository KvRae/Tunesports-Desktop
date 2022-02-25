/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import Entities.Produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Tools.MaConnexion;

/**
 *
 * @author achou
 */
public class ProduitServices implements IService<Produit> {
    private Connection cnx;
    private Statement ste;

    public ProduitServices() {
        cnx = MaConnexion.getInstance().getCnx();}

    @Override
    public void ajouter(Produit p) {
          PreparedStatement pre;
    try {
        pre = cnx.prepareStatement("INSERT INTO Produit (nomP,prixP,descP,dispoP,couleurP,quantiteP,tailleP)VALUES (?,?,?,?,?,?,?);");
        pre.setString(1, p.getNomP());
        pre.setDouble(2, p.getPrixP());
        pre.setString(3, p.getDescP());
        pre.setString(4, p.getDispoP());
        pre.setString(5, p.getCouleurP());
        pre.setInt(6, p.getQuantiteP());
        pre.setString(7, p.getTailleP());



        pre.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifier(Produit p) {
        try {
            PreparedStatement pre = cnx.prepareStatement("UPDATE Produit SET nomP= ? ,prixP = ? , descP = ?, dispoP = ?, couleurP = ? , quantiteP = ?, tailleP = ? where idP= ? ;");
        pre.setString(1, p.getNomP());
        pre.setDouble(2, p.getPrixP());
        pre.setString(3, p.getDescP());
        pre.setString(4, p.getDispoP());
        pre.setString(5, p.getCouleurP());  
        pre.setInt(6, p.getIdP());
        pre.setInt(7, p.getQuantiteP());
        pre.setString(8, p.getTailleP()); 



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
        pre = cnx.prepareStatement("Delete from produit where idP=? ;");
    
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
        ste = cnx.createStatement();
    
        ResultSet rs = ste.executeQuery("select idP ,nomP,prixP,descP,dispoP,couleurP,quantiteP,tailleP  from produit");
        while (rs.next()) {
            int idProduit=rs.getInt("idP");
            String nomP = rs.getString("nomP");
            Double prixP = rs.getDouble("prixP");
            String descP = rs.getString("descP");
            String dispoP = rs.getString("dispoP");
            String couleurP = rs.getString("couleurP");
            int quantiteP = rs.getInt("quantiteP");
            String tailleP = rs.getString("tailleP");


            Produit j = new Produit(idProduit,nomP, prixP, descP ,dispoP,couleurP,quantiteP,tailleP);
            lu.add(j);
        }
    } catch (SQLException ex) {
                            System.out.println(ex.getMessage());

    }
    return lu ;
    
    }

   
        public void rechercherproduit(int e) {
        String requete = "SELECT * FROM produit where idP= "+e;
        Produit p = new Produit();
        try {
            Statement stmt = MaConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            if(rs != null)
            {
            while (rs.next()) {
                
                p.setIdP(rs.getInt("idP"));
                p.setNomP(rs.getString("nomP"));
                p.setPrixP(rs.getDouble("prixP"));
                p.setDescP(rs.getString("descP"));
                p.setDispoP(rs.getString("dispoP"));
                p.setCouleurP(rs.getString("CouleurP"));
                p.setQuantiteP(rs.getInt("quantiteP"));
                p.setTailleP(rs.getString("tailleP"));

               
            }
            }
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        }
        if(p.getIdP()!= e)
            System.out.println("produit not found");
        
        else
        System.out.println("votre produit : \n"+p);
}
        public List<Produit> trie() {
        List<Produit> Produit = new ArrayList<>();
        String sql ="SELECT * FROM produit ORDER BY idP DESC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Produit e = new Produit();
               // p.setId(rs.getInt("id"));
                e.setIdP(rs.getInt("idP"));
                e.setNomP(rs.getString("nomP"));
                e.setPrixP(rs.getDouble("prixP"));
                e.setDescP(rs.getString("descP"));
                e.setDispoP(rs.getString("dispoP"));
                e.setCouleurP(rs.getString("couleur"));
                e.setQuantiteP(rs.getInt("quntiteP"));
                e.setTailleP(rs.getString("tailleP"));
                Produit.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Produit;
    }

        


public void pdf(Produit p) throws FileNotFoundException, DocumentException {
        try {
        String file_name="C:\\Users\\achou\\Desktop\\pdf\\youssef.pdf";
        Document doc =new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        doc.open();
        PreparedStatement ps=null;
        ResultSet rs=null;
         String querry="SELECT * FROM produit";

            ps=cnx.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()) {
                Paragraph para=new Paragraph(rs.getInt("idP")+" "+rs.getString("nomP")+" "+rs.getDouble("prixP")+" "+rs.getString("descP")+" "+rs.getString("dispoP")+" "+rs.getString("couleurP")+" "+rs.getInt("quantiteP")+" "+rs.getString("tailleP"));
                doc.add(para);
                doc.add(new Paragraph(" "));

            }
            doc.close();



        }catch(Exception E){
            System.err.println(E);

        }

    }
    

    
    }
    
    

