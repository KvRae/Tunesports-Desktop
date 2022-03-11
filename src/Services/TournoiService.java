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
import Entities.Evenement;
import Entities.Tournoi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Tools.MaConnexion;
/**
 *
 * @author Chiheb
 */
public class TournoiService implements IService<Tournoi>{
    Connection cnx= MaConnexion.getInstance().getCnx();
    
    
    @Override
    public void ajouter(Tournoi t) {
               try {
            String sql="insert into tournoi(nomtour,datedebtour,datefintour,desctour,recomptour) values('"+t.getNomtour()+"','"+new Date(t.getDatedebtour().getTime())+"','"+new Date(t.getDatefintour().getTime())+"','"+t.getDesctour()+"','"+t.getRecomptour()+"')";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Tournoi Ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

       @Override
    public void supprimer(Tournoi t) {
        try{
        String sql="DELETE FROM tournoi WHERE idtour ='"+t.getId_tour()+"'";
           Statement ste = cnx.createStatement();
            if(ste.executeUpdate(sql)!=0){
            System.out.println("Tournoi Supprimer");
            }else{System.out.println("Tournoi not found");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    
    @Override
    public void modifier(Tournoi t) {
              try{
        String sql="UPDATE tournoi SET idtour  ='"+t.getId_tour()+"', nomtour='"+t.getNomtour()+"',datedebtour='"+t.getDatedebtour()+"',datefintour='"+t.getDatefintour()+"',desctour='"+t.getDesctour()+"',recomptour='"+t.getRecomptour()+"'WHERE idtour ="+t.getId_tour();
        Statement ste = cnx.createStatement();
        if(ste.executeUpdate(sql)!=0){
        System.out.println("Tournoi Modifier");
        }else{System.out.println("Tournoi not found");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        
        
            @Override
    public List<Tournoi> afficher(){
        List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select * from tournoi";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("recomptour"));
                tournoi.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi;
    }

   
    public List<Tournoi> recherche(Tournoi t) {
        List<Tournoi> tournoi = new ArrayList<>();
       String sql="SELECT * FROM tournoi WHERE idtour  ='"+t.getId_tour()+"'OR nomtour='"+t.getNomtour()+"'OR datedebtour='"+t.getDatedebtour()+"'";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                 Tournoi tt = new Tournoi();
                tt.setId_tour(rs.getInt("idtour"));
                tt.setNomtour(rs.getString("nomtour"));
                tt.setDatedebtour(rs.getDate("datedebtour"));
                tt.setDatefintour(rs.getDate("datefintour"));
                tt.setDesctour(rs.getString("desctour"));
                tt.setRecomptour(rs.getString("recomptour"));
                tournoi.add(tt);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi;
    }


    public List<Tournoi>trie() {
        List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select *  from tournoi ORDER BY idtour  ASC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("desctour"));
                tournoi.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi;
    }


    public List<Tournoi> triedesc() {
        List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select *  from tournoi ORDER BY idtour  DESC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("desctour"));
                tournoi.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi;    }

  
    public List<Tournoi> historique() {
        List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select *  from tournoi WHERE datefintour<Date(NOW())";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("desctour"));
                tournoi.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi; 
    }
    
    
        public void pdf() throws FileNotFoundException, DocumentException {
        try {
        String file_name="C:\\Users\\Chiheb\\Desktop\\pdf\\tours.pdf";
        Document doc =new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        doc.open();
        PreparedStatement ps=null;
        ResultSet rs=null;
         String querry="SELECT * FROM tournoi";

            ps=cnx.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()) {
                Paragraph para=new Paragraph(rs.getInt("idtour")+" "+rs.getString("nomtour")+" "+rs.getDate("datedebtour")+" "+rs.getDate("datefintour")+" "+rs.getString("desctour")+" "+rs.getString("recomptour"));
                doc.add(para);
                doc.add(new Paragraph(" "));

            }
            doc.close();



        }catch(Exception k){
            System.err.println(k);

        }

    }

    
    public List<Tournoi> tried() {
                List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select *  from tournoi ORDER BY datedebtour";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("desctour"));
                tournoi.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi; 
    }

   
    public List<Tournoi> triedescd() {
                       List<Tournoi> tournoi = new ArrayList<>();
        String sql ="select *  from tournoi ORDER BY nomtour";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId_tour(rs.getInt("idtour"));
                t.setNomtour(rs.getString("nomtour"));
                t.setDatedebtour(rs.getDate("datedebtour"));
                t.setDatefintour(rs.getDate("datefintour"));
                t.setDesctour(rs.getString("desctour"));
                t.setRecomptour(rs.getString("desctour"));
                tournoi.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tournoi; 
    }
    
    
    
    
    
    
}
