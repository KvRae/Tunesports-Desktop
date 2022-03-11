/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Services;

import Entities.Rating;
import Entities.Utilisateur;
import Tools.MaConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RatingService implements IService<Rating> {
//******************************Start Connection Instance*****************************
    Connection cnx= MaConnexion.getInstance().getCnx();

//*******************************************************************************************
//*******************************Crud Operations**************************************
//*******************************************************************************************

//********************************Create Operation*****************************************
    @Override
    public void ajouter(Rating ra) {
        PreparedStatement pre;
        try {
            pre = cnx.prepareStatement("INSERT INTO rating (dateRat,valueRat,idCli,idCoa)VALUES (?,?,?,?);");
            pre.setDate(1,  new Date(ra.getDateRat().getTime()));
            pre.setInt(2, ra.getValueRat());
            pre.setInt(3,ra.getIdCli().getId());
            pre.setInt(4,ra.getIdCoa().getId());

            System.out.println("Rating Added");
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    //***************************Read Operation*****************************************
    @Override
    public List<Rating> afficher() {
        ObservableList<Rating> ratings =  FXCollections.observableArrayList();
        String sql ="select * from rating";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Rating ra = new Rating();
                ra.setDateRat(rs.getDate("dateRat"));
                ra.setValueRat(rs.getInt("valueRat"));
                ra.setIdCli(new Utilisateur(rs.getInt("idCli")));
                ra.setIdCoa(new Utilisateur(rs.getInt("idCoa")));
                ratings.add(ra);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ratings;}

    //***************************Update Operation*****************************************
    @Override
    public void modifier(Rating ra) {
        String query = "UPDATE rating SET dateRat = " +
                ra.getDateRat() + ", valueRat= " + ra.getValueRat() +
                " WHERE idCli = " + ra.getIdCli().getId();
        try{
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Rating modifieé");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //***************************Delete Operation*****************************************
    @Override
    public void supprimer(Rating ra) {
        String query = "DELETE FROM rating WHERE idCli = " + ra.getIdCli().getId() +"";
        try{
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Rating supprimer");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    //***********************************************************************************
    //*********************************Extra Operations**********************************
    //***********************************************************************************

    //***************************Search Operation*****************************************
    /*@Override
    public void recherche(Rating rating) {

    }*/
    public List<Rating> getRatingCoa(Rating r) {
        ObservableList<Rating> ratings =  FXCollections.observableArrayList();
        String sql ="select * from rating WHERE idCoa ="+ r.getIdCoa().getId();
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Rating ra = new Rating();
                ra.setDateRat(rs.getDate("dateRat"));
                ra.setValueRat(rs.getInt("valueRat"));
                ratings.add(ra);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ratings;}

}
