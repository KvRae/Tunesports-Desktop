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
import entities.Evenement;
import entities.Tournoi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

/**
 *
 * @author Fayechi
 */
public class EvenementService  implements IService<Evenement>{
    Connection cnx= MaConnexion.getInstance().getCnx();
    @Override
    public void ajouter(Evenement E) {
        try {
            String sql="INSERT INTO evenement(id_event,nomevent,datedebevent,datefinevent,descevent) VALUES('"+E.getId_event()+"','"+E.getNomevent()+"','"+new Date(E.getDatedebevent().getTime())+"','"+new Date(E.getDatefinevent().getTime())+"','"+E.getDescevent()+"')";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Evenement Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    /*@Override
        public void ajouter(Evenement E) {
       //Statements allow to issue SQL queries to the database

    try {
        Statement ste = cnx.createStatement();

        System.out.println( "INSERT INTO evenement(id_event,nomevent,datedebevent,datefinevent,descevent)"+" values("+ E.getId_event()+","+E.getNomevent()+ ","+E.getDatedebevent()+","+E.getDatefinevent()+","+E.getDescevent()+")");


        Statement.executeUpdate( "INSERT INTO evenement(id_event,nomevent,datedebevent,datefinevent,descevent)"+" VALUES("+E.getId_event()+","+E.getNomevent()+","+E.getDatedebevent()+","+E.getDatefinevent()+","+E.getDescevent()+")");
    }
    catch(Exception e ){System.out.println(e);};
    //Result set get the result of the SQL query
    }
    */
    @Override
    public void supprimer(Evenement e){
        try{
        String sql="DELETE FROM evenement WHERE id_event='"+e.getId_event()+"'";
           Statement ste = cnx.createStatement();
            if (ste.executeUpdate(sql)!=0){
            System.out.println("Evenement Supprimer");
            }
            else
            {System.out.println("Evenement not found");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void modifier(Evenement E){
        try{
        String sql="UPDATE evenement SET id_event='"+ E.getId_event() +"',nomevent='"+E.getNomevent()+"',datedebevent='"+E.getDatedebevent()+"',datefinevent='"+E.getDatefinevent()+"',descevent='"+E.getDescevent()+"' WHERE id_event="+E.getId_event();
        Statement ste = cnx.createStatement();
        if(ste.executeUpdate(sql)!=0){
        System.out.println("Evenement Modifier");
        }else{System.out.println("Evenement not found");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        

    
    
    

    @Override
    public List<Evenement> afficher() {
        List<Evenement> evenement = new ArrayList<>();
        String sql ="select * from evenement";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Evenement e = new Evenement();
               // p.setId(rs.getInt("id"));
                e.setId_event(rs.getInt("id_event"));
                e.setNomevent(rs.getString("nomevent"));
                e.setDatedebevent(rs.getDate("datedebevent"));
                e.setDatefinevent(rs.getDate("datefinevent"));
                e.setDescevent(rs.getString("descevent"));
                evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;
    }

    @Override
    public void recherche(Evenement e) {
               try{
           String sql="SELECT * FROM evenement WHERE id_event ='"+e.getId_event()+"'"; 
           Statement ste= cnx.createStatement();
           ResultSet rst= ste.executeQuery(sql);
           rst.last();
           int nbrRow = rst.getRow();
           if(nbrRow!=0){
               System.out.println("ID= "+e.getId_event());
               System.out.println("Nome= "+e.getNomevent());
               System.out.println("Date debut= "+e.getDatedebevent());
               System.out.println("Date fin= "+e.getDatefinevent());
               System.out.println("description= "+e.getDescevent());
           }else{
                System.out.println("Evenement non trouve");
           }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Evenement> trie() {
        List<Evenement> evenement = new ArrayList<>();
        String sql ="SELECT * FROM evenement ORDER BY id_event ASC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Evenement e = new Evenement();
               // p.setId(rs.getInt("id"));
                e.setId_event(rs.getInt("id_event"));
                e.setNomevent(rs.getString("nomevent"));
                e.setDatedebevent(rs.getDate("datedebevent"));
                e.setDatefinevent(rs.getDate("datefinevent"));
                e.setDescevent(rs.getString("descevent"));
                evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;
    }

    @Override
    public List<Evenement> triedesc() {
        List<Evenement> evenement = new ArrayList<>();
        String sql ="SELECT * FROM evenement ORDER BY id_event DESC";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Evenement e = new Evenement();
               // p.setId(rs.getInt("id"));
                e.setId_event(rs.getInt("id_event"));
                e.setNomevent(rs.getString("nomevent"));
                e.setDatedebevent(rs.getDate("datedebevent"));
                e.setDatefinevent(rs.getDate("datefinevent"));
                e.setDescevent(rs.getString("descevent"));
                evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;    
    }

    @Override
    public List<Evenement> historique() {
                List<Evenement> evenement = new ArrayList<>();
        String sql ="select *  from evenement WHERE datefinevent<Date(NOW())";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Evenement e = new Evenement();
                e.setId_event(rs.getInt("id_event"));
                e.setNomevent(rs.getString("nomevent"));
                e.setDatedebevent(rs.getDate("datedebevent"));
                e.setDatefinevent(rs.getDate("datefinevent"));
                e.setDescevent(rs.getString("descevent"));
              
                evenement.add(e);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;
    }
   
    public void pdf(Evenement E) throws FileNotFoundException, DocumentException {
        try {
        String file_name="C:\\Users\\Chiheb\\Desktop\\pdf\\Events.pdf";
        Document doc =new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        doc.open();
        PreparedStatement ps=null;
        ResultSet rs=null;
         String querry="SELECT * FROM evenement";

            ps=cnx.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()) {
                Paragraph para=new Paragraph(rs.getInt("id_event")+" "+rs.getString("nomevent")+" "+rs.getDate("datedebevent")+" "+rs.getDate("datefinevent")+" "+rs.getString("descevent"));
                doc.add(para);
                doc.add(new Paragraph(" "));

            }
            doc.close();



        }catch(Exception k){
            System.err.println(k);

        }

    }
    
    
    
}
