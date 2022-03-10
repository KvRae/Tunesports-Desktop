/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.io.BufferedWriter;

import Entities.Commande;
//import Entities.CsvWriter;
import Entities.Produit;
import Services.CommandeServices;
import Services.ProduitServices;
import Tools.MaConnexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author achou
 */
public class CommandeController implements Initializable {
            


    @FXML
    private TextField txtadresse;
            private ObservableList<Commande> CommandeList;

    @FXML
    private TextField txtidp;
    @FXML
    private DatePicker ddate;
    @FXML
    private ComboBox<String> cbstatus;
    ObservableList<String> listS=FXCollections.observableArrayList("valider","nonv");
    @FXML
    private TableView<Commande> TableView;
    @FXML
    private TableColumn<Commande, Integer> idcColumn;
    @FXML
    private TableColumn<Commande, String> adresseColumn;
    @FXML
    private TableColumn<Commande, Date> dateColumn;
    @FXML
    private TableColumn<Commande, String> statusColumn;
    @FXML
    private TableColumn<Commande, Integer> idpColumn;
public ObservableList<Produit> ProduitData = FXCollections.observableArrayList();
    @FXML
    private TextField txtidc;
    @FXML
    private TextField search;
    @FXML
    private TableColumn<Produit, String> nompColumn;
    @FXML
    private TableColumn<Produit, Double> prixpColumn;
    @FXML
    private TableView<Produit> tabp;
    @FXML
    private TableColumn<Produit, String> dispoColumn;
    @FXML
    private TableColumn<Produit, String> couleurColumn;
    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;
    @FXML
    private TableColumn<Produit, String> tailleColumn;
    
    ProduitController P = new ProduitController();
    ProduitServices t = new ProduitServices();
    @FXML
    private Button updatecommande;
    @FXML
    private Button deletecommande;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCommande();
           cbstatus.setItems(listS);
        try {
            validation();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    private Connection cnx;
    private Statement ste;
   public ObservableList<Commande> getCommandeList(){
    	ObservableList<Commande> CommandeList = FXCollections.observableArrayList();
        cnx = MaConnexion.getInstance().getCnx();

    	String query = "SELECT * FROM Commande ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = cnx.createStatement();
			rs = st.executeQuery(query);
			Commande Commande;
			while(rs.next()) {
                            Commande c = new Commande(rs.getInt("IdC"),rs.getString("adresseC"),rs.getDate("dateC"),rs.getString("statusC"),rs.getInt("idP"));
				CommandeList.add(c);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return CommandeList;
    }
public void showCommande() {
    ObservableList<Commande> list = getCommandeList();
    idcColumn.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idC"));
    adresseColumn.setCellValueFactory(new PropertyValueFactory<Commande,String>("adresseC"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Commande,Date>("dateC"));
  	statusColumn.setCellValueFactory(new PropertyValueFactory<Commande,String>("statusC"));
    idpColumn.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idP"));

   
    TableView.setItems(list);  
}


   /* @FXML
    private void insertCommande(ActionEvent event) {
       String adresseC= txtadresse.getText();
        String dateC=String.valueOf(ddate.getValue());
        java.sql.Date dde=java.sql.Date.valueOf(dateC);
        String statusC=cbstatus.getValue();
                 int idP= Integer.parseInt(txtidp.getText());

      //  int nomP= Integer.parseInt(txtidp.getText());
 

Alert alert = new Alert(Alert.AlertType.INFORMATION);

        
        if( (adresseC.equals("") || dateC.equals("")|| statusC.equals("") ) ){
                       //Alert saisie jeux :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
            //Alert saisie jeux !
        }else{
    Commande c=new Commande(adresseC,dde,statusC,idP);
    CommandeServices es= new CommandeServices();
    es.ajouter(c);
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();
   
    showCommande();
    
        }*/
        
    //}

    @FXML
    private void updateCommande(ActionEvent event) throws SQLException, Exception {
        
        
         int idC= Integer.parseInt(txtidc.getText());

        String adresseC= txtadresse.getText();
        String dateC=String.valueOf(ddate.getValue());
        java.sql.Date dde=java.sql.Date.valueOf(dateC);

   int idP= Integer.parseInt(txtidp.getText());
    
    String statusC=cbstatus.getValue();
    
mailling.sendMail("youssef.achour1@esprit.tn");
 
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

        Commande c=new Commande(idC,adresseC,dde,statusC,idP);
    CommandeServices es= new CommandeServices();
    es.modifier(c);
     alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("modifier commande");
             alert.setHeaderText("Results:");
              alert.setContentText("You Have updated successfully!");
              alert.showAndWait();
           showCommande();
           

    }
public String validation() throws SQLException{
  String vald="";
          cnx = MaConnexion.getInstance().getCnx();
String sql="SELECT statusC from commande";
PreparedStatement ste = cnx.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){ vald=rs.getString("statusC");
}return vald;
}
    @FXML
    private void deleteCommande(ActionEvent event) {
        String idC= txtidc.getText();
         int i=Integer.parseInt(idC);
Alert alert = new Alert(Alert.AlertType.INFORMATION);

               Commande c=new Commande(i);

        CommandeServices es=new CommandeServices();

        es.supprimer(c);
       alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("jeu");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have deleted successfully!");
              alert.showAndWait();
       
        showCommande();
      
    }

    @FXML
    private void rechercheEq(MouseEvent event) {
       ObservableList<Commande> list = getCommandeList();
    idcColumn.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idC"));
    adresseColumn.setCellValueFactory(new PropertyValueFactory<Commande,String>("adresseC"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Commande,Date>("dateC"));
  	statusColumn.setCellValueFactory(new PropertyValueFactory<Commande,String>("statusC"));
    idpColumn.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idP"));
   
    TableView.setItems(list); 
         FilteredList<Commande> filteredData = new FilteredList<>(list, m
        -> true);  
 search.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }   
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getAdresseC().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
   
    }else if (person.getStatusC().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
    //else if (String.valueOf(person.getUser_id()).indexOf(lowerCaseFilter)!=-1)
         //return true;// Filter matches email
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Commande> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(TableView.comparatorProperty());  
  TableView.setItems(sortedData);     
        

    }

    @FXML
    private void selectC(MouseEvent event) {
          Commande Commande = TableView.getSelectionModel().getSelectedItem();
 txtidc.setText("" +Commande.getIdC());
txtadresse.setText(Commande.getAdresseC());
ddate.setValue(Commande.getDateC().toLocalDate());

cbstatus.setValue(Commande.getStatusC());
txtidp.setText("" +Commande.getIdP());
           

    }

    @FXML
    private void ViewProduit(ActionEvent event) throws SQLException {
        
                     Commande T = TableView.getSelectionModel().getSelectedItem();
               int idC= T.getIdC();
               
               System.out.println(idC);
                 ProduitData.clear();
               List<Produit> Produit = getProduitbyIdC(idC);
            ProduitData.addAll(Produit);
    	nompColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("nomP"));
    	prixpColumn.setCellValueFactory(new PropertyValueFactory<Produit,Double>("prixP"));
    	dispoColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("dispoP"));
  	couleurColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("couleurP"));
    	quantiteColumn.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantiteP"));
    	tailleColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("tailleP"));

        

        tabp.setItems(ProduitData);

         
        
    }
    
    
      List<Produit> getProduitbyIdC(int idC) throws SQLException{
        List<Produit> arr = new ArrayList<>();
         try {
        PreparedStatement pre = cnx.prepareStatement("SELECT nomP , prixP, dispoP, couleurP,quantiteP,tailleP from produit p , commande c where c.idP=p.idP and c.idC=?;"); //ORDER BY P asc
         pre.setInt(1, idC);
         ResultSet rs = pre.executeQuery();

             while(rs.next()){
                     String nomP = rs.getString("nomP");
                     Double prixP = rs.getDouble("prixP");
                       String dispoP = rs.getString("dispoP");
                        String couleurP = rs.getString("couleurP");
                        int quantiteP = rs.getInt("quantiteP");
                        String tailleP = rs.getString("tailleP"); 
                    
                     Produit m=new Produit(nomP,prixP,dispoP,couleurP,quantiteP,tailleP);
                    arr.add(m);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

  
    
    

    




   
    
    
}
