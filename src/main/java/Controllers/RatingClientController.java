/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;

import Services.RatingService;
import Tests.Main;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class RatingClientController implements Initializable {
    public static int rateValue;
    public static Entities.Rating rate;
    public RatingService rs;


    @FXML
    private JFXButton backBTN;


    @FXML
    private Rating rating;

    @FXML
    void onHandleAction(ActionEvent event) {
        if(event.getSource()==backBTN){
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
                e.printStackTrace();}
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //if(rate.getValueRat()==0) {
            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    rate.setValueRat(t1.intValue());
                    rs.ajouter(rate);
                }
            });
        /*}else {
            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    rate.setValueRat(t1.intValue());
                    rs.modifier(rate);
                }
            });
        }*/


    }
}

