/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;
import Entities.Rating;
import Entities.Reservation;
import Entities.Utilisateur;
import Services.RatingService;
import Services.ReservationService;
import Tests.Main;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import  java.util.regex.Pattern;


public class CrudReservationController implements Initializable {
    private Stage stage;
    RatingService ras = new RatingService();
    ReservationService res = new ReservationService();

    Utilisateur cli = new Utilisateur();
    Utilisateur coa = new Utilisateur(111);

    Rating r =new Rating(coa);

    private final ObservableList<Reservation> dataList = FXCollections.observableArrayList();

    @FXML
    private ListView<Rating> ratingLV;

    @FXML
    private ListView<Reservation> reservationLV;

    @FXML
    private TextField idTF;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TextField heureTF;

    @FXML
    private ComboBox<String> dispoCB;

    @FXML
    private TextField prixTF;



    @FXML
    private JFXButton deleteBTN;

    @FXML
    private JFXButton modifyBTN;

    @FXML
    private JFXButton resetReservationsBTN;

    @FXML
    private JFXButton resetTfBTN;

    @FXML
    private JFXButton addBTN;

    @FXML
    private JFXButton ratingsBTN;

    @FXML
    private JFXButton backBTN;



    @FXML
    private JFXButton exitBTN;

    @FXML
    private JFXButton miniBTN;

    @FXML
    private TextField searchBarTF;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == addBTN) {
            insertReservation();
        } else if (event.getSource() == modifyBTN) {
            updateReservation();
        } else if (event.getSource() == deleteBTN) {
            deleteReservation();
        } else if (event.getSource() ==resetReservationsBTN)
        {deleteAll();
        } else if (event.getSource() ==resetReservationsBTN) {
            //resetTextsFileds();
        } else if (event.getSource() == exitBTN) {
            Stage stage =  (Stage)exitBTN.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Fermer l'application");
            alert.setContentText("Voulez vous quitter l'application ?");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){stage.close();}

            } else if (event.getSource() == miniBTN) {
            Stage stage =  (Stage)miniBTN.getScene().getWindow();
            stage.setIconified(true);
            }else if(event.getSource()== backBTN) {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ReservationClient-view.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Tunesports");
            stage.initStyle(StageStyle.TRANSPARENT);
            Image icon = new Image (getClass().getResourceAsStream("/Pictures/TeLogo.png"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();}}


    }

    //*********************************Get Selected Item from the list*******************************
    @FXML
    public void getSelectedRes(javafx.scene.input.MouseEvent mouseEvent) {
        if((reservationLV.getSelectionModel().isEmpty())==false){
            Reservation r = reservationLV.getSelectionModel().getSelectedItem();
            idTF.setText(String.valueOf(r.getIdRes()));
            dateDP.setValue(LocalDate.parse(String.valueOf(r.getDateRes())));
            heureTF.setText(String.valueOf(r.getHeureRes()));
            dispoCB.setValue(String.valueOf(r.getDispoRes()));
            prixTF.setText(String.valueOf(r.getPrixRes()));}
    }


    @FXML
    void onClick(MouseEvent event) {

    }



    //*******************************************************************************
    //**********************************Controls Statement***************************
    //*******************************************************************************
    public boolean controlNotEmpty() {
        if (dateDP.getValue()==null || heureTF.getText().isEmpty() || dispoCB.getValue()==null || prixTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Please Verify Your Input Fields");
            alert.showAndWait();
            return false;
        }else if (!Pattern.matches("[0.0-50.0]*", prixTF.getText())||Double.valueOf(prixTF.getText())>50.0) {
            prixTF.requestFocus();
            prixTF.selectEnd();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Price Invalid");
            alert.showAndWait();
            return false;
        }
        else if ((!Pattern.matches("[00:00-23:59]*", heureTF.getText()))||(!Pattern.matches("[00:00:00-23:59:00]*", heureTF.getText()))) {
            prixTF.requestFocus();
            prixTF.selectEnd();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Time Invalid");
            alert.showAndWait();
            return false;
        }
        return true;
    }



    //*******************************************************************************
    //**********************************CRUD Operations******************************
    //*******************************************************************************

    //***************Insert Reservation In Our List View and DB**********************
    protected void insertReservation(){
        if (controlNotEmpty()){
            Reservation r = new Reservation(Date.valueOf(dateDP.getValue()),Time.valueOf(LocalTime.parse(heureTF.getText())), dispoCB.getValue(), Double.parseDouble(prixTF.getText()), cli, coa);
            res.ajouter(r);
            reservationLV.refresh();
            Notifications notification = Notifications.create()
                .title("Confirmation")
                .text("Votre Reservation est ajoutée ")
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
            notification.darkStyle();}
        showReservations();

        }
        //******************************* Update Reservations **********************************
        protected void updateReservation (){
            if(controlNotEmpty()){
                int index = reservationLV.getSelectionModel().getSelectedIndex();
                if(!reservationLV.getSelectionModel().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modification");
                alert.setContentText("Voulez vous modifiez ce champ?");
                Optional<ButtonType> result=alert.showAndWait();
                if (result.isPresent()&& result.get()==ButtonType.OK){
                        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm");
                        Reservation r = new Reservation(Integer.valueOf(idTF.getText()),Date.valueOf(dateDP.getValue()),Time.valueOf(LocalTime.parse(heureTF.getText())), dispoCB.getValue(), Double.parseDouble(prixTF.getText()), cli, coa);
                        reservationLV.getItems().set(index,r);
                        res.modifier(r);
                        Notifications notification = Notifications.create()
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
                notification.darkStyle();}
                    }else{
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setTitle("Modification Fail");
                    alert1.setContentText("Voulez vous selectionner un champ?");
                }}
                showReservations();
                search();

        }
    //***************Delete Reservation From Our List View and DB**************************
        void deleteReservation() {
            if(controlNotEmpty()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Suppression");
                alert.setContentText("Voulez vous supprimer ce champ?");
                Optional<ButtonType> result=alert.showAndWait();
                if (result.isPresent()&& result.get()==ButtonType.OK){
                    Reservation r= reservationLV.getSelectionModel().getSelectedItem();
                    reservationLV.getItems().remove(r);
                    res.supprimer(r);
                    Notifications notification = Notifications.create()
                        .title("Reservation Deleted")
                        .text("Saved in your DATABASE")
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
            }}
            showReservations();
            search();
    }

    //***************Delete All Reservations From Our List View and DB*********************
     void deleteAll(){
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Suppression");
         alert.setContentText("Voulez vous supprimer tous les reservations?");
         Optional<ButtonType> result=alert.showAndWait();
         if (result.isPresent()&& result.get()==ButtonType.OK){res.supprimerTout();res.reset();}
         showReservations();


     }

    //***************Display Reservation from Our List View and DB**************************
    protected  void showReservations()
    {
        ObservableList<Reservation> list = FXCollections.observableList(res.afficher()) ;
        reservationLV.getItems().clear();
        reservationLV.getItems().addAll(list);
    }

    void search(){
        ObservableList l= reservationLV.getItems();
        dataList.addAll(l);
        FilteredList<Reservation> filteredData = new FilteredList<>(dataList, b -> true);
        searchBarTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(reservation -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(reservation.getIdRes()).toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (String.valueOf(reservation.getDateRes()).indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (String.valueOf(reservation.getHeureRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(reservation.getDispoRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(reservation.getPrixRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false;
            });
        });
        SortedList<Reservation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(reservationLV.getItems().sorted().comparatorProperty());
        reservationLV.setItems(sortedData);
    }


    void showRating() {
        ObservableList<Rating> list = FXCollections.observableArrayList(ras.getRatingCoa(r));
        ratingLV.getItems().addAll(list);

    }

    //*************************         Switch Scene            ******************
    public void switchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("reservationCrud-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    //*******************Initiliaze method which contains the Search Method***********************
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Reservation> list = (FXCollections.observableArrayList(res.afficher())) ;
        ObservableList<Rating> list1 = (FXCollections.observableArrayList(ras.getRatingCoa(r))) ;
        reservationLV.getItems().addAll(list);
        ratingLV.getItems().addAll(list1);
        dispoCB.getItems().addAll("oui", "non");











    }
}
