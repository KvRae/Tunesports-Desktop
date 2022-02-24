/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            String sql="INSERT INTO evenement(id_event,nomevent,datedebevent,datefinevent,descevent) VALUES('"+E.getId_event()+"','"+E.getNomevent()+"','"+E.getDatedebevent()+"','"+E.getDatefinevent()+"','"+E.getDescevent()+"')";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Evenement Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void supprimer(int e){
        try{
        String sql="DELETE FROM evenement WHERE id_event='"+e+"'";
           Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Evenement Supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void modifier(Evenement E){
        try{
        String sql="UPDATE evenement SET id_event='"+E.getId_event()+"',nomevent='"+E.getNomevent()+"',datedebevent='"+E.getDatedebevent()+"',datefinevent='"+E.getDatefinevent()+"',descevent='"+E.getDescevent()+"' WHERE id_event="+E.getId_event();
        Statement ste = cnx.createStatement();
        ste.executeUpdate(sql);
        System.out.println("Evenement Modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
    /*public void ajouter2(Evenement p){
        String sql ="insert into personne(nom,prenom) values(?,?) ";
        try {
            PreparedStatement ste =cnx.prepareStatement(sql);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
            ste.executeUpdate();
            System.out.println("Personne Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    
    
    @Override
        public void rechercher(int e) {
        try {
            String sql="select * from evenement where id_event='"+e+"'";
            Statement ste = cnx.createStatement();
            ResultSet rst=ste.executeQuery(sql);
            rst.last();
            int nbrrow=rst.getRow();
            if(nbrrow!=0){
                 System.out.println("Evenement trouvée");
            }else{
                 System.out.println("Evenement non Ajoutée");
            }
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
                e.setDatedebevent(rs.getString("datedebevent"));
                e.setDatefinevent(rs.getString("datefinevent"));
                e.setDescevent(rs.getString("descevent"));
                evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;
    }
    
}
