/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Evenement;
import entities.Tournoi;
import java.sql.Connection;
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
 * @author Chiheb
 */
public class TournoiService implements IService<Tournoi>{
    Connection cnx= MaConnexion.getInstance().getCnx();
    @Override
    public void ajouter(Tournoi t) {
               try {
            String sql="insert into tournoi(idtour ,nomtour,datedebtour,datefintour,desctour,recomptour) values('"+t.getId_tour() +"','"+t.getNomtour()+"','"+t.getDatedebtour()+"','"+t.getDatefintour()+"','"+t.getDesctour()+"','"+t.getRecomptour()+"')";
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Tournoi Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void supprimer(int t) {
        try{
        String sql="DELETE FROM tournoi WHERE idtour ='"+t+"'";
           Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Tournoi Supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    @Override
    public void modifier(Tournoi t) {
              try{
        String sql="UPDATE tournoi SET idtour  ='"+t.getId_tour()+"', nomtour='"+t.getNomtour()+"',datedebtour='"+t.getDatedebtour()+"',datefintour='"+t.getDatefintour()+"',desctour='"+t.getDesctour()+"',recomptour='"+t.getRecomptour()+"'WHERE idtour ="+t.getId_tour();
        Statement ste = cnx.createStatement();
        ste.executeUpdate(sql);
        System.out.println("Tournoi Modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        @Override
        public void rechercher(int t) {
        try {
            String sql="select * from tournoi where idtour='"+t+"'";
            Statement ste = cnx.createStatement();
            ResultSet rst=ste.executeQuery(sql);
            rst.last();
            int nbrrow=rst.getRow();
            if(nbrrow!=0){
                 System.out.println("Tournoi trouvée");
            }else{
                 System.out.println("Tournoi non Ajoutée");
            }
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
                t.setDatedebtour(rs.getString("datedebtour"));
                t.setDatefintour(rs.getString("datefintour"));
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
