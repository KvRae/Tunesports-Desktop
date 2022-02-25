/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Services;

import Entities.Reservation;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReservationService implements  IService<Reservation> {
//******************************Start Connection Instance*****************************
    Connection cnx= MaConnexion.getInstance().getCnx();

//*******************************************************************************************
//*******************************Crud Operations**************************************
//*******************************************************************************************

//***************************Create Operation*****************************************
    @Override
    public void ajouter(Reservation re) {
        PreparedStatement pre;

        try {
            pre = cnx.prepareStatement("INSERT INTO reservation (dateRes,dispoRes,prixRes)VALUES (?,?,?);");
            pre.setDate(1, new Date(re.getDateRes().getTime()));
            pre.setString(2, re.getDispoRes());
            pre.setDouble(3, re.getPrixRes());
            System.out.println("Reservation Ajoutée");
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //***************************Read Operation*****************************************
    @Override
    public List<Reservation> afficher() {
        List<Reservation> reservations = new ArrayList<>();
        String sql ="select * from reservation";
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Reservation r = new Reservation();
                r.setIdRes(rs.getInt("idRes"));
                r.setDateRes(rs.getDate("dateRes"));
                r.setDispoRes(rs.getString("dispoRes"));
                r.setPrixRes(rs.getDouble("prixRes"));
                reservations.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservations;
    }

    //***************************Update Operation*****************************************
    @Override
    public void modifier(Reservation re) {
        String query = "UPDATE reservation SET  dateRes = '" +
                re.getDateRes() +
                "', dispoRes = '" + re.getDispoRes() +  "', prixRes = '" + re.getPrixRes()+
                "' WHERE idRes = " + re.getIdRes() + "";
        try{
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Reservation modifieé ");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //***************************Delete Operation*****************************************
    @Override
    public void supprimer(Reservation re) {
        String query = "DELETE FROM RESERVATION WHERE idRes = " + re.getIdRes() ;
        try{
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Reservation supprimer");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //***************************Search Operation*****************************************
    @Override
    public void recherche(Reservation re) {
                String sql="SELECT * FROM reservation WHERE idRes = ?";
                 try{
                PreparedStatement ste= cnx.prepareStatement(sql);
                ste.setInt(1,re.getIdRes());
                ResultSet rs= ste.executeQuery();
                if (rs.next()) {
                    Reservation res = new Reservation();
                    res.setIdRes(rs.getInt("idRes"));
                    res.setDateRes(rs.getDate("dateRes"));
                    res.setDispoRes(rs.getString("dispoRes"));
                    res.setPrixRes(rs.getDouble("prixRes"));
                    System.out.println(res);
                } else{
                    System.out.println("Reservation non trouvée");
                }
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }

        }

}
