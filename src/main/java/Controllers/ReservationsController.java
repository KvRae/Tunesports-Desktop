/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;
import Entities.Reservation;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReservationsController implements Initializable {

  @FXML private DatePicker DatePick;

  @FXML private TableColumn<Reservation, Time> Heure;

  @FXML private TableColumn<Reservation, Double> Prix;

  @FXML private TableView<Reservation> TableReservation;

  @FXML private Button ValiderDate;

  @FXML private Button Back;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {}
}
