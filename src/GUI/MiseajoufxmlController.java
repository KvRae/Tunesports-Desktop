/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Mise_a_jour;
import Services.MiseAJourService;
import Tools.MaConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class MiseajoufxmlController implements Initializable {
        Connection cnx= MaConnexion.getInstance().getCnx();


    @FXML
    private TextField txtidm;
    @FXML
    private TextField txtnomjm;
    @FXML
    private TextField txtverm;
    @FXML
    private TextField txttaillem;
    @FXML
    private TextField txtdescm;
    @FXML
    private TextField txtidjm;
    @FXML
    private DatePicker datem;
    
    @FXML
    private Button btnajoutm;
    @FXML
    private Button btnmodifm;
    @FXML
    private Button btnsuppm;
    private TableView<Mise_a_jour> tabm;
    @FXML
private ListView listM=new ListView() ;
    MiseAJourService em =new MiseAJourService();
    private final ObservableList<Mise_a_jour> miselist=FXCollections.observableArrayList(em.afficher());
    private int selectedindex=-1;
    @FXML
    private TextField rechj;
    @FXML
    private Button BTNRECHJ;
    @FXML
    private RadioButton rechidj;
    @FXML
    private RadioButton rechnomj;
    @FXML
    private RadioButton rechdatej;
    @FXML
    private ToggleGroup trim;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
        listM.setItems(miselist);
        listM.refresh();
    }    

    


    @FXML
    private void addMiseajour(ActionEvent event) {
        String pubmise=String.valueOf(datem.getValue());
        java.sql.Date dpm=java.sql.Date.valueOf(pubmise);
        
    String nomjeux= txtnomjm.getText();
    
    String taillemise=txttaillem.getText();
    String descmise= txtdescm.getText();
    String versionmise=txtverm.getText();
String i= txtidjm.getText();
         int idjeux=Integer.parseInt(i);
Alert alert = new Alert(Alert.AlertType.INFORMATION);

        
        if( (nomjeux.equals("") || pubmise.equals("")|| taillemise.equals("")|| descmise.equals("")|| versionmise.equals("")|| i.equals("") ) ){
                       //Alert saisie mise :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie mise !
        }else{
    

    Mise_a_jour m=new Mise_a_jour(nomjeux,dpm,versionmise,taillemise,descmise,idjeux);
    MiseAJourService em= new MiseAJourService();
    em.ajouter(m);
    Notifications notification;
            notification = Notifications.create()
                    .title("mise a jour Ajoutée")
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
    miselist.add(m);
    listM.refresh();
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter mise a jour");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();
    
}
    }

    @FXML
    private void updateMiseajour(ActionEvent event) {
        String i= txtidjm.getText();
         int idmise=Integer.parseInt(i);
        String nomjeu= txtnomjm.getText();
        String pubmise=String.valueOf(datem.getValue());
    
    String versionmise=txtverm.getText();
    String taillemise= txttaillem.getText();
    String descmise=txtdescm.getText();
    String k= txtidjm.getText();
         int idjeux=Integer.parseInt(k);
         java.sql.Date dpm=java.sql.Date.valueOf(pubmise);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);

         
         if( (i.equals("") ||nomjeu.equals("") || pubmise.equals("")|| taillemise.equals("")|| descmise.equals("")|| versionmise.equals("")|| k.equals("") ) ){
                       //Alert saisie mise :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie mise !
         }else{

        Mise_a_jour m=new Mise_a_jour(idmise,nomjeu,dpm,versionmise,taillemise,descmise,idjeux);
        MiseAJourService es = new MiseAJourService();

       es.modifier(m);
       Notifications notification;
            notification = Notifications.create()
                    .title("Mise a jour modifiée")
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
       miselist.remove(selectedindex);
               txtidm.clear();
        txtnomjm.clear();
        datem.setValue(null);
        txtverm.clear();
        txttaillem.clear();
        txtdescm.clear();
        txtidjm.clear();
        listM.refresh();
       alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("update mise a jour");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have updated successfully!");
              alert.showAndWait();
    }
    }

    @FXML
    private void deleteMiseajour(ActionEvent event) {
        String idmise= txtidm.getText();
         int j=Integer.parseInt(idmise);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);

         

               Mise_a_jour m=new Mise_a_jour(j);

        MiseAJourService em=new MiseAJourService();

        em.supprimer(m);
        Notifications notification;
            notification = Notifications.create()
                    .title("Mise a jour Supprimée")
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
         miselist.remove(selectedindex);
               txtidm.clear();
        txtnomjm.clear();
        datem.setValue(null);
        txtverm.clear();
        txttaillem.clear();
        txtdescm.clear();
        txtidjm.clear();
        listM.refresh();
        alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("supprimer mise a jour");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have deleted successfully!");
              alert.showAndWait();
       
    }

    

    

    @FXML
    private void selectM(MouseEvent event) {
        Mise_a_jour selecteditem=(Mise_a_jour) listM.getSelectionModel().getSelectedItem();
        selectedindex=listM.getSelectionModel().getSelectedIndex(); 
        txtidm.setText(""+selecteditem.getIdmise());
        txtnomjm.setText(selecteditem.getNomjeu());
        datem.setValue(selecteditem.getPubmise().toLocalDate());
        txtverm.setText(selecteditem.getVersionmise());
        txttaillem.setText(selecteditem.getTaillemise());
        txtdescm.setText(selecteditem.getDescmise());
        txtidjm.setText(""+selecteditem.getidjeux());
    }

    @FXML
    private void recherchj(ActionEvent event) {
        if(rechidj.isSelected()){
        String id= rechj.getText();
        int idmise=Integer.parseInt(id);
        Mise_a_jour E=new Mise_a_jour(idmise);
        MiseAJourService es=new MiseAJourService();
        es.recherche(E);
                listM.setItems(FXCollections.observableArrayList(es.recherche(E)));

        } 
        if(rechnomj.isSelected()){
        String nomjeu= rechj.getText();
        Mise_a_jour E=new Mise_a_jour(nomjeu);
        MiseAJourService es=new MiseAJourService();
        es.recherche(E);
                listM.setItems(FXCollections.observableArrayList(es.recherche(E)));

        }
           if(rechdatej.isSelected()){
        java.sql.Date dpm=java.sql.Date.valueOf(rechj.getText());
        Mise_a_jour E=new Mise_a_jour(dpm);
        MiseAJourService es=new MiseAJourService();
        es.recherche(E);
                listM.setItems(FXCollections.observableArrayList(es.recherche(E)));

        }
    
}

    @FXML
    private void gotomenujj(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("gestionJeux.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
}

