/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Jeux;
import java.sql.Time;
import Services.JeuxService;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Tools.MaConnexion;
import com.mysql.jdbc.MySQLConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class JeuxfxmlController implements Initializable {
    Connection cnx= MaConnexion.getInstance().getCnx();

    @FXML
    private TextField txtidj;
    @FXML
    private TextField txtnomj;
    @FXML
    private TextField txttaillej;
    @FXML
    private TextField txtdesj;
    @FXML
    private TextField txtplatj;
    @FXML
    private TextField txtconj;
    @FXML
    private DatePicker datej;
    @FXML
    private Button btnajoutj;
    @FXML
    private Button btnmodj;
    @FXML
    private Button btnsuppj;
    @FXML
    private ListView listJ=new ListView() ;
    JeuxService es =new JeuxService();
    private final ObservableList<Jeux> jeuxlist=FXCollections.observableArrayList(es.afficher());
    private int selectedindex=-1;
    @FXML
    private TextField rechj;
    @FXML
    private Button BTNRECHJ;
    @FXML
    private RadioButton rechidj;
    @FXML
    private ToggleGroup trij;
    @FXML
    private RadioButton rechnomj;
    @FXML
    private RadioButton rechdatej;
    @FXML
    private Button btnretour;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listJ.setItems(jeuxlist);
        listJ.refresh();
    }    

    
   
    @FXML
    private void addJeux(){
        String datesortjeux=String.valueOf(datej.getValue());
        java.sql.Date dde=java.sql.Date.valueOf(datesortjeux);
        Jeux jeux = new Jeux();
    String nomjeux= txtnomj.getText();
    String taillejeux=txttaillej.getText();
    String descjeux= txtdesj.getText();
    String platdispojeux=txtplatj.getText();
    String conreqjeux=txtconj.getText() ;

Alert alert = new Alert(Alert.AlertType.INFORMATION);

        
        if( (nomjeux.equals("") || datesortjeux.equals("")|| taillejeux.equals("")|| descjeux.equals("")|| platdispojeux.equals("")|| conreqjeux.equals("") ) ){
                       //Alert saisie jeux :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie jeux !
        }else{
    

    Jeux j=new Jeux(nomjeux,dde,taillejeux,descjeux,platdispojeux,conreqjeux);
    JeuxService es= new JeuxService();
    es.ajouter(j);
    jeuxlist.add(j);
    listJ.refresh();
    Notifications notification;
            notification = Notifications.create()
                    .title("jeux Ajoutée")
                    .text("Saved in your DATABASE")
                    // .graphic(new ImageView(img))
                    .graphic(null)
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
        notification.showConfirm();
        notification.darkStyle();
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();
                  

              
}
    }

    @FXML
    private void UpdateJeux(ActionEvent event) {
         String i= txtidj.getText();
         int idjeux=Integer.parseInt(i);
        String nomjeux= txtnomj.getText();
        String datesortjeux=String.valueOf(datej.getValue());
    
    String taillejeux=txttaillej.getText();
    String descjeux= txtdesj.getText();
    String platdispojeux=txtplatj.getText();
    String conreqjeux=txtconj.getText() ;
         java.sql.Date dde=java.sql.Date.valueOf(datesortjeux);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);


        Jeux J=new Jeux(idjeux,nomjeux,dde,taillejeux,descjeux,platdispojeux,conreqjeux);
        JeuxService es = new JeuxService();

       es.modifier(J);
       Notifications notification;
            notification = Notifications.create()
                    .title("jeux modifié")
                    .text("Saved in your DATABASE")
                    // .graphic(new ImageView(img))
                    .graphic(null)
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
        notification.showConfirm();
        notification.darkStyle();
       jeuxlist.remove(selectedindex);
       jeuxlist.add(new Jeux(idjeux,nomjeux,dde,taillejeux,descjeux,platdispojeux,conreqjeux));
               txtidj.clear();
        txtnomj.clear();
        datej.setValue(null);
        txttaillej.clear();
        txtdesj.clear();
        txtplatj.clear();
        txtconj.clear();
        listJ.refresh();
       alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("modifier jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have updated successfully!");
              alert.showAndWait();
       
       
        
    }

    @FXML
    private void DeleteJeux(ActionEvent event) {
        String idjeux= txtidj.getText();
         int i=Integer.parseInt(idjeux);
Alert alert = new Alert(Alert.AlertType.INFORMATION);

               Jeux J=new Jeux(i);

        JeuxService es=new JeuxService();
         jeuxlist.remove(selectedindex);
        es.supprimer(J);
        Notifications notification;
            notification = Notifications.create()
                    .title("jeux Supprimé")
                    .text("Saved in your DATABASE")
                    // .graphic(new ImageView(img))
                    .graphic(null)
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
        notification.showConfirm();
        notification.darkStyle();
        txtidj.clear();
        txtnomj.clear();
        datej.setValue(null);
        txttaillej.clear();
        txtdesj.clear();
        txtplatj.clear();
        txtconj.clear();
        listJ.refresh();
        alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have deleted successfully!");
              alert.showAndWait();
       
        
    }

    





    @FXML
    private void selectJ(MouseEvent event) {
        Jeux selecteditem=(Jeux) listJ.getSelectionModel().getSelectedItem();
        selectedindex=listJ.getSelectionModel().getSelectedIndex();
        txtidj.setText(""+selecteditem.getIdjeux());
        txtnomj.setText(selecteditem.getNomjeux());
        datej.setValue(selecteditem.getDatesortjeux().toLocalDate());
        txttaillej.setText(selecteditem.getTaillejeux());
        txtdesj.setText(selecteditem.getDescjeux());
        txtplatj.setText(selecteditem.getPlatdispojeux());
        txtconj.setText(selecteditem.getConreqjeux());
    }

    @FXML
    private void recherchj(ActionEvent event) {
        if(rechidj.isSelected()){
        String id= rechj.getText();
        int idjeux=Integer.parseInt(id);
        Jeux E=new Jeux(idjeux);
        JeuxService es=new JeuxService();
        es.recherche(E);
                listJ.setItems(FXCollections.observableArrayList(es.recherche(E)));

        } 
        if(rechnomj.isSelected()){
        String nomj= rechj.getText();
        Jeux E=new Jeux(nomj);
        JeuxService es=new JeuxService();
        es.recherche(E);
                listJ.setItems(FXCollections.observableArrayList(es.recherche(E)));

        }
        
                if(rechdatej.isSelected()){
        java.sql.Date ddj=java.sql.Date.valueOf(rechj.getText());
        Jeux E=new Jeux(ddj);
        JeuxService se=new JeuxService();
        se.recherche(E);
                listJ.setItems(FXCollections.observableArrayList(es.recherche(E)));

        }
    }

    @FXML
    private void gotomenuj(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("gestionJeux.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    

    }

    




