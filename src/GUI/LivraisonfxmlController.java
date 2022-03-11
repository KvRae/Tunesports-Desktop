/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Entities.Livraison;
import Services.CommandeServices;
import Services.LivraisonService;
import Tools.MaConnexion;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXComboBox;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author firas
 */
public class LivraisonfxmlController implements Initializable {
            Connection cnx= MaConnexion.getInstance().getCnx();


    @FXML
    private TextField txtidl;
    @FXML
    private TextField txtidco;
    @FXML
    private TextField txtaddr;
    @FXML
    private TextField txtprix;
    @FXML
     private ListView listL=new ListView() ;
    LivraisonService ls =new LivraisonService();
    CommandeServices com= new CommandeServices();
        private final ObservableList<Livraison> livlist=FXCollections.observableArrayList(ls.afficher());
    private int selectedindex=-1;
  
    @FXML
    private Button btnmodl;
    @FXML
    private Button btnsuppl;
    @FXML
    private Button btnajout;
    @FXML
    private Button BTNPDF;
    @FXML
         private ListView listC=new ListView() ;
            private final ObservableList<Commande> Clist=FXCollections.observableArrayList(com.afficher());
    @FXML
    private TextField txtval;
    @FXML
    private TextField rechj;
    @FXML
    private Button BTNRECHJ;
    @FXML
    private RadioButton rechidj;
    @FXML
    private RadioButton rechnomj;
    @FXML
    private ToggleGroup tril;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listL.setItems(livlist);
        listL.refresh();
        listC.setItems(Clist);
        listC.refresh();
                
                  
        
        // TODO
    }  
    
    
    

    
    @FXML
    private void UpdateLivraison(ActionEvent event) {
        Livraison liv = new Livraison();
        String j= txtidl.getText();
         int idliv=Integer.parseInt(j);
        String i= txtidco.getText();
         int idc=Integer.parseInt(i);
    String adressel= txtaddr.getText();
    Double prixp= Double.parseDouble(txtprix.getText());
    String validation=txtval.getText();

    

Alert alert = new Alert(Alert.AlertType.INFORMATION);

        
        if( (i.equals("") || adressel.equals("")|| prixp.equals("") ) ){
                       //Alert saisie jeux :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie jeux !
        }else{
    

    Livraison L=new Livraison(adressel,prixp,idc);
    LivraisonService ls= new LivraisonService();
    ls.modifier(adressel,prixp,Integer.parseInt(i),8,validation);
    Notifications notification;
            notification = Notifications.create()
                    .title("livraison Modifiée")
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
    livlist.add(new Livraison(idliv,adressel,prixp,idc,validation));
    listL.refresh(); 
    
    
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("modifier jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have updated successfully!");
              alert.showAndWait();
    }
    }

    @FXML
    private void deleteLivraison(ActionEvent event) {
        String idliv= txtidl.getText();
         int j=Integer.parseInt(idliv);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  

         

               Livraison l=new Livraison(j);

        LivraisonService ls=new LivraisonService();
        

        ls.supprimer(l);
        Notifications notification;
            notification = Notifications.create()
                    .title("livraison supprimé")
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
    listL.refresh();
        alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle(" lIVRAISON");
              alert.setHeaderText("Results:"); 
              alert.setContentText("You Have deleted successfully!");
              alert.showAndWait();
       
        
    }



    @FXML
    private void selectL(MouseEvent event) {
        
        Livraison selecteditem=(Livraison) listL.getSelectionModel().getSelectedItem();
        selectedindex=listL.getSelectionModel().getSelectedIndex();
        txtidl.setText(""+selecteditem.getIdliv());
        txtaddr.setText(selecteditem.getAdressel());
        txtprix.setText(""+selecteditem.getPrixp());
        txtidco.setText(""+selecteditem.getIdc());
        txtidl.setText(selecteditem.getValidation());
        
    } 
    @FXML
    private void addlivv(ActionEvent event) throws Exception {
 Livraison liv = new Livraison();
        String i= txtidco.getText();
         int idc=Integer.parseInt(i);
        
    String adressel= txtaddr.getText();
    Double prixp= Double.parseDouble(txtprix.getText());
        String validation=txtval.getText();


    
Alert alert = new Alert(Alert.AlertType.INFORMATION);

        
        if( (i.equals("") || adressel.equals("")|| prixp.equals("")  ) ){
                       //Alert saisie jeux :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie jeux !
        }else{

    Livraison L=new Livraison(adressel,prixp,idc,validation);
    LivraisonService ls= new LivraisonService();
    ls.ajouter(L);
    Notifications notification;
            notification = Notifications.create()
                    .title("livraison Ajoutée")
                    .text("Saved in your DATABASE")
                    // .graphic(new ImageView(img))
                    .graphic(null)
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on notification");
                        }
                    });
        notification.showConfirm();
        notification.darkStyle();
    ls.sendMail("firasmohsni5@gmail.com");
    livlist.add(L);
    listL.refresh();
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();

    }
}

    @FXML
    private void PDFLIV(ActionEvent event) throws FileNotFoundException, DocumentException {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF");
            alert.setContentText("SUCCESS");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){
        LivraisonService ls = new LivraisonService();
        ls.pdf();
    }
}

    @FXML
    private void HandleMouseAction(MouseEvent event) {
                Commande selecteditem=(Commande) listC.getSelectionModel().getSelectedItem();

       // Commande commande = (Commande) listC.getSelectionModel().getSelectedItem();
                // System.out.println("idc"+commande.getIdC());
                // System.out.println("adresse "+commande.getAdresseC());
                  txtaddr.setText(selecteditem.getAdresseC());
                  txtidco.setText(""+selecteditem.getIdC());
    }

    @FXML
    private void recherchj(ActionEvent event) {
        if(rechidj.isSelected()){
        String id= rechj.getText();
        int idliv=Integer.parseInt(id);
        Livraison E=new Livraison(idliv);
        LivraisonService es=new LivraisonService();
        es.recherche(E);
                listL.setItems(FXCollections.observableArrayList(es.recherche(E)));

        } 
        if(rechnomj.isSelected()){
        String nomj= rechj.getText();
        Livraison E=new Livraison(nomj);
        LivraisonService es=new LivraisonService();
        es.recherche(E);
                listL.setItems(FXCollections.observableArrayList(es.recherche(E)));

        }
        
    }
}
