/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MainSceneController {

    @FXML
    private HBox topBarHB;

    @FXML
    private JFXButton exitBTN;

    @FXML
    private JFXButton miniBTN;

    @FXML
    void handleOnClick(ActionEvent event) {
        if (event.getSource() == exitBTN) {
            Stage stage =  (Stage)exitBTN.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Fermer l'application");
            alert.setContentText("Voulez vous quitter l'application ?");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){stage.close();}
        } else if (event.getSource() == miniBTN) {

            Stage stage =  (Stage)miniBTN.getScene().getWindow();
            stage.setIconified(true);
        }

    }
}
