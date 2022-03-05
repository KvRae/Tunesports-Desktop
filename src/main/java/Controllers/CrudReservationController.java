/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;
import Entities.Reservation;
import Services.ReservationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class CrudReservationController implements Initializable {
    ReservationService res = new ReservationService();

    private ListView<Reservation> reservationLV;

    @FXML
    private Button addBTN;

    @FXML
    private Button deleteBTN;

    @FXML
    private Button modifyBTN;

    @FXML



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Reservation> list = (FXCollections.observableArrayList(res.afficher())) ;
        reservationLV.setItems(list);

    }
}
