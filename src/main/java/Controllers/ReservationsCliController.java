/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;
import Entities.Reservation;
import Entities.Utilisateur;
import Services.ReservationService;
import Tools.MaConnexion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.controlsfx.control.textfield.CustomTextField;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationsCliController implements Initializable {
    ReservationService res = new ReservationService();

    Utilisateur cli= new Utilisateur(111);
    Reservation r= new Reservation(cli);


    @FXML
    private CustomTextField dateResTF;

    @FXML
    private CustomTextField heureResTF;

    @FXML
    private CustomTextField prixResTF;



    @FXML
    private JFXButton addBTN;

    @FXML
    private JFXButton backBTN;

    @FXML
    private JFXButton deleteBTN;

    @FXML
    private JFXButton exitBTN;

    @FXML
    private JFXButton miniBTN;

    @FXML
    private JFXButton rateBTN;

    @FXML
    private ListView<Reservation> reservationCliLV;

    @FXML
    private JFXListView<Reservation> reservationdispoLV;

    @FXML
    private TextField searchBarTF;

    @FXML
    void getSelectedRes(MouseEvent event) {
        if(!(reservationdispoLV.getSelectionModel().isEmpty())){
            Reservation r = reservationdispoLV.getSelectionModel().getSelectedItem();
            dateResTF.setText(String.valueOf(r.getDateRes()));
            heureResTF.setText(String.valueOf(r.getHeureRes()));
            prixResTF.setText(r.getPrixRes() + " DT");

        }
    }

    @FXML
    void getSelectedReserv(MouseEvent event) {
        if (!(reservationCliLV.getSelectionModel().isEmpty())) {
            Reservation r = reservationCliLV.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource()== addBTN){
            addReservation();
        } else if (event.getSource()== deleteBTN){
            deleteReservation();
        }
    }


    public List<Reservation> getListResDispo() {
        Connection cnx= MaConnexion.getInstance().getCnx();
        ObservableList<Reservation> reservations =  FXCollections.observableArrayList();
        String sql ="select * from reservation where dispoRes= 'oui' " ;
        try {
            Statement ste= cnx.createStatement();
            ResultSet rs =ste.executeQuery(sql);
            while(rs.next()){
                Reservation r = new Reservation();
                r.setIdRes(rs.getInt("idRes"));
                r.setDateRes(rs.getDate("dateRes"));
                r.setHeureRes(rs.getTime("heureRes"));
                r.setDispoRes(rs.getString("dispoRes"));
                r.setPrixRes(rs.getDouble("prixRes"));
                reservations.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservations;
    }
    void showMyReservation(){
        ObservableList<Reservation> listCli = (FXCollections.observableArrayList(res.getListResCli(r))) ;
        reservationCliLV.getItems().clear();
        reservationCliLV.getItems().addAll(listCli);
    }

    void showAvailReservation(){
        ObservableList<Reservation> list = (FXCollections.observableArrayList(getListResDispo())) ;
        reservationCliLV.getItems().clear();
        reservationCliLV.getItems().addAll(list);
    }




    void addReservation(){
        if(!reservationdispoLV.getSelectionModel().isEmpty()){
            Reservation reservation = reservationdispoLV.getSelectionModel().getSelectedItem();
            reservation.setDispoRes("non");
            reservation.setIdCli(cli);
            updateReservation(reservation);
            reservationdispoLV.getItems().remove(reservation);
            showMyReservation();
            showAvailReservation();
        }

    }


    void deleteReservation(){
        if(!reservationCliLV.getSelectionModel().isEmpty()){
            Reservation reservation = reservationCliLV.getSelectionModel().getSelectedItem();
            reservation.setDispoRes("oui");
            Utilisateur ut = new Utilisateur();
            reservation.setIdCli(ut);
            updateReservation(reservation);
            reservationCliLV.getItems().remove(reservation);
            showMyReservation();
            showAvailReservation();
        }
    }

    public void updateReservation(Reservation re) {
        Connection cnx= MaConnexion.getInstance().getCnx();
        PreparedStatement pre;

        try {
            pre = cnx.prepareStatement("UPDATE reservation SET dateRes= ?,heureRes= ?,dispoRes= ?,prixRes= ?,idCli= ? where idRes = ?;");
            pre.setDate(1, re.getDateRes());
            pre.setTime(2, re.getHeureRes());
            pre.setString(3, re.getDispoRes());
            pre.setDouble(4, re.getPrixRes());
            pre.setInt(5,re.getIdCli().getId());
            pre.setInt(6,re.getIdRes());


            System.out.println("Reservation Modifier");
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Reservation> listDispo = (FXCollections.observableArrayList(getListResDispo())) ;
        reservationdispoLV.getItems().addAll(listDispo);
        ObservableList<Reservation> listCli = (FXCollections.observableArrayList(res.getListResCli(r))) ;
        reservationCliLV.getItems().addAll(listCli);





    }
}