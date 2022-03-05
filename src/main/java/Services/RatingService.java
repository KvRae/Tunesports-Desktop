/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Services;

import Entities.Rating;
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
            pre = cnx.prepareStatement("INSERT INTO rating (titleRat,dateRat,valueRat)VALUES (?,?,?);");
            pre.setString(1, ra.getTitleRat());
            pre.setDate(2,  new Date(ra.getDateRat().getTime()));
            pre.setInt(3, ra.getValueRat());
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
                ra.setTitleRat(rs.getString("titleRat"));
                ra.setDateRat(rs.getDate("dateRat"));
                ra.setValueRat(rs.getInt("valueRat"));
                ratings.add(ra);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ratings;}

    //***************************Update Operation*****************************************
    @Override
    public void modifier(Rating ra) {
        String query = "UPDATE rating SET titleRat = '" + ra.getTitleRat() + "', dateRat = '" +
                ra.getDateRat() + "', valueRat= '" + ra.getValueRat() +
                "' WHERE idRat = " + ra.getIdRat() + "";
        try{
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Rating modifieé ");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //***************************Delete Operation*****************************************
    @Override
    public void supprimer(Rating ra) {
        String query = "DELETE FROM rating WHERE idRat = " + ra.getIdRat();
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
    @Override
    public void recherche(Rating rating) {

    }


}
