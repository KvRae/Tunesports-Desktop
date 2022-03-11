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
    @FXML
    private Button btnmiseajour;
    @FXML
    private Button btnlivraison;
    
    ImageView myimageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gojeux(ActionEvent event) throws IOException {
         Parent home_parent=FXMLLoader.load(getClass().getResource("Jeuxfxml.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    @FXML
    private void gomiseajour(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("Miseajoufxml.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }

    @FXML
    private void golivraison(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("Livraisonfxml.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    
    
}
