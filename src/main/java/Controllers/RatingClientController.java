/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class RatingClientController implements Initializable {
    public static int rateValue;


    @FXML
    private JFXButton backBTN;


    @FXML
    private Rating rating;

    @FXML
    void onHandleAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rateValue = t1.intValue();
            }
        });


    }
}

