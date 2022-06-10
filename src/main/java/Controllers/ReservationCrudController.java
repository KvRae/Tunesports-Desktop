/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;

import Entities.Reservation;
import Services.ReservationService;
import Tests.SmsSender;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class ReservationCrudController implements Initializable {

  ReservationService res = new ReservationService();

  private final ObservableList<Reservation> dataList =
      FXCollections.observableArrayList();

  @FXML private TableView<Reservation> reservationTV;

  @FXML private TableColumn<Reservation, Date> dateCOL;

  @FXML private TableColumn<Reservation, String> disponibleCOL;

  @FXML private TableColumn<Reservation, Time> heureCOL;

  @FXML private TableColumn<Reservation, Integer> idCOL;

  @FXML private TableColumn<Reservation, Double> prixCOL;

  @FXML private TextField idTF;

  @FXML private TextField dateTF;

  @FXML private TextField heureTF;

  @FXML private ChoiceBox<String> disponibleCB;

  @FXML private TextField prixTF;

  @FXML private Button updateBTN;

  @FXML private Button insertBTN;

  @FXML private Button deleteBTN;

  @FXML private Button resetFieldsBTN;

  @FXML private TextField searchTF;

  @FXML
  public void getSelectedRes(javafx.scene.input.MouseEvent mouseEvent) {
    Reservation r = reservationTV.getSelectionModel().getSelectedItem();
    idTF.setText(String.valueOf(r.getIdRes()));
    dateTF.setText(String.valueOf(r.getDateRes()));
    heureTF.setText(String.valueOf(r.getHeureRes()));
    disponibleCB.setValue(String.valueOf(r.getDispoRes()));
    prixTF.setText(String.valueOf(r.getPrixRes()));
  }

  @FXML
  void handleButtonAction(ActionEvent event) {
    if (event.getSource() == insertBTN) {
      insertReservation();
    } else if (event.getSource() == updateBTN) {
      modifyReservation();
    } else if (event.getSource() == deleteBTN) {
      deleteReservation();
    } else if (event.getSource() == resetFieldsBTN) {
      resetTextsFileds();
    }
  }

  void resetTextsFileds() {
    idTF.setText(null);
    dateTF.setText(null);
    heureTF.setText(null);
    disponibleCB.setValue(null);
    prixTF.setText(null);
  }

  void showReservation() {
    ObservableList<Reservation> list =
        (ObservableList<Reservation>)res.afficher();
    idCOL.setCellValueFactory(
        new PropertyValueFactory<Reservation, Integer>("idRes"));
    dateCOL.setCellValueFactory(
        new PropertyValueFactory<Reservation, Date>("dateRes"));
    heureCOL.setCellValueFactory(
        new PropertyValueFactory<Reservation, Time>("heureRes"));
    disponibleCOL.setCellValueFactory(
        new PropertyValueFactory<Reservation, String>("dispoRes"));
    prixCOL.setCellValueFactory(
        new PropertyValueFactory<Reservation, Double>("prixRes"));
    reservationTV.setItems(list);
    dataList.addAll(list);

    FilteredList<Reservation> filteredData =
        new FilteredList<>(dataList, b -> true);

    // 2. Set the filter Predicate whenever the filter changes.
    searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredData.setPredicate(reservation -> {
        // If filter text is empty, display all persons.

        if (newValue == null || newValue.isEmpty()) {
          return true;
        }

        // Compare first name and last name of every person with filter text.
        String lowerCaseFilter = newValue.toLowerCase();

        if (String.valueOf(reservation.getIdRes())
                .toLowerCase()
                .indexOf(lowerCaseFilter) != -1) {
          return true; // Filter matches first name.
        } else if (String.valueOf(reservation.getDateRes())
                       .toLowerCase()
                       .indexOf(lowerCaseFilter) != -1) {
          return true; // Filter matches last name.
        } else if (String.valueOf(reservation.getHeureRes())
                       .indexOf(lowerCaseFilter) != -1)
          return true;
        else
          return false; // Does not match.
      });
    });

    // 3. Wrap the FilteredList in a SortedList.
    SortedList<Reservation> sortedData = new SortedList<>(filteredData);

    // 4. Bind the SortedList comparator to the TableView comparator.
    // 	  Otherwise, sorting the TableView would have no effect.
    sortedData.comparatorProperty().bind(reservationTV.comparatorProperty());

    // 5. Add sorted (and filtered) data to the table.
    reservationTV.setItems(sortedData);
  }

  boolean ControlNotEmpty() {
    if (dateTF.getText().isEmpty() || heureTF.getText().isEmpty() ||
        disponibleCB.getValue().isEmpty() || prixTF.getText().isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Warning Alert Dialog");
      alert.setContentText("Verifier Vos Champs SVP!");
      alert.showAndWait();
      return false;
    }
    return true;
  }

  boolean notValidHeure() {
    String heure = heureTF.getText();

    if (heure.length() > 5 ||
        Integer.parseInt(heure.substring(0, 1)) > 23 &&
            heure.substring(2, 2) == ":" &&
            Integer.parseInt(heure.substring(3, 4)) > 59) {
      return false;
    }
    return true;
  }

  void insertReservation() {
    if (ControlNotEmpty() || notValidHeure()) {
      Reservation r = new Reservation(
          Date.valueOf(dateTF.getText()), Time.valueOf(heureTF.getText()),
          disponibleCB.getValue(), Double.parseDouble(prixTF.getText()));
      res.ajouter(r);
      Notifications notification =
          Notifications.create()
              .title("Reservation Ajoutée")
              .text("Saved in your DATABASE")
              // .graphic(new ImageView(img))
              .graphic(null)
              .hideAfter(Duration.seconds(5))
              .position(Pos.CENTER)
              .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  System.out.println("Clicked on notification");
                }
              });

      notification.showConfirm();
      notification.darkStyle();
      SmsSender.send(r);
      reservationTV.refresh();
    }
  }

  void modifyReservation() {
    if (ControlNotEmpty()) {

      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Modification");
      alert.setContentText("Voulez vous modifiez ce champ?");
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get() == ButtonType.OK) {
        int index = reservationTV.getSelectionModel().getFocusedIndex();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-MM");
        Reservation r = new Reservation(
            Integer.parseInt(idTF.getText()), Date.valueOf(dateTF.getText()),
            (Time.valueOf(heureTF.getText())), disponibleCB.getValue(),
            Double.parseDouble(prixTF.getText()));
        reservationTV.getItems().set(index, r);
        res.modifier(r);
      }
      Notifications notification =
          Notifications
              .create()

              .title("Reservation Modifier")
              .text("Saved in your DATABASE")
              // .graphic(new ImageView(img))
              .graphic(null)
              .hideAfter(Duration.seconds(5))
              .position(Pos.CENTER)
              .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  System.out.println("Clicked on notification");
                }
              });

      notification.showConfirm();
      notification.darkStyle();
      reservationTV.refresh();
    }
  }

  void deleteReservation() {
    if (ControlNotEmpty()) {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setContentText("Voulez vous supprimer ce champ?");
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get() == ButtonType.OK) {
        Reservation r = reservationTV.getSelectionModel().getSelectedItem();
        reservationTV.getItems().remove(r);
        res.supprimer(r);
        Notifications notification =
            Notifications
                .create()

                .title("Reservation Supprimer")
                .text("Saved in your DATABASE")
                // .graphic(new ImageView(img))
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
                    System.out.println("Clicked on notification");
                  }
                });

        notification.showConfirm();
        notification.darkStyle();
      }
      reservationTV.refresh();
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    showReservation();
    disponibleCB.getItems().addAll("oui", "non");
  }
}
