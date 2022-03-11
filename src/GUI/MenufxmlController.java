/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author firas
 */
public class MenufxmlController implements Initializable {

    @FXML
    private Button btnjeux;
    
    ImageView myimageview;
    @FXML
    private Button btnproduit;
    @FXML
    private Button btnrec;
    @FXML
    private Button btneven;
    @FXML
    private Button btnuser;
    @FXML
    private Button btnarti;
    @FXML
    private Button btnliv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gojeux(ActionEvent event) throws IOException {
         Parent home_parent=FXMLLoader.load(getClass().getResource("gestionJeux.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    

    

    @FXML
    private void gotoProduit(ActionEvent event) {
    }

    @FXML
    private void gotores(ActionEvent event) {
    }

    @FXML
    private void gotoeven(ActionEvent event) {
    }

    @FXML
    private void gotouser(ActionEvent event) {
    }

    @FXML
    private void gotorec(ActionEvent event) {
    }

    @FXML
    private void gotoarti(ActionEvent event) {
    }

    @FXML
    private void gotoliv(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("livraisonfxml.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    
    
}
