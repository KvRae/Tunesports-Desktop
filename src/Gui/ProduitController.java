/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Produit;
import Services.ProduitServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Tools.MaConnexion; 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import static java.util.Date.from;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import static jdk.nashorn.internal.objects.NativeString.search;
/**
 * FXML Controller class
 *
 * @author achou
 */
public class ProduitController implements Initializable {
  
    private TextField nomP;
    private TextField prixP;
    private TextField descP;
    @FXML
    private TableView<Produit> TableView;
    @FXML
    private TableColumn<Produit, Integer> idColumn;
    @FXML
    private TableColumn<Produit, String> nomColumn;
    @FXML
    private TableColumn<Produit, Double> prixColumn;
    @FXML
    private TableColumn<Produit, String> descColumn;
    @FXML
    private TableColumn<Produit, String> dispoColumn;
    @FXML
    private TableColumn<Produit, String> couleurColumn;
    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;
    @FXML
    private TableColumn<Produit, String> tailleColumn;
    @FXML
    private Button deleteButton;
    @FXML
    private Button insertbutton;
    private TextField dispoP;
    private TextField couleurP;
    private TextField quantiteP;
    private TextField tailleP;
    private ObservableList<Produit> ProduitList;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtquantite;
    @FXML
    private Button updatebutton;
    @FXML
    private ComboBox<String> cbdispo;
    ObservableList<String> list=FXCollections.observableArrayList("oui","nom");
    @FXML
    private ComboBox<String> cbcouleur;
    ObservableList<String> list1=FXCollections.observableArrayList("bleu","gris","marron","orange","rouge","violet","blanc","jaune","noir","rose","vert");
    @FXML
    private ComboBox<String> cbtaille;
    ObservableList<String> list2=FXCollections.observableArrayList("xs","s","m","l","xl","xxl","xxxl");
    @FXML
    private TextField search;
    @FXML
    private Button btnpdf;
    @FXML
    private TextField txtidP;
        
     private void handleButtonAction(java.awt.event.ActionEvent event){
        System.out.println("you clicked me!");
        if(event.getSource()==updatebutton){
            updateButton();
             }else if (event.getSource()==deleteButton){
                 deleteButton();
             }
       

          
     }
     
 
        
    
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            	showProduit();
   cbdispo.setItems(list);
      cbcouleur.setItems(list1);
   cbtaille.setItems(list2);

    } 
    private Connection cnx;
    private Statement ste;
    public ObservableList<Produit> getProduitList(){
    	ObservableList<Produit> ProduitList = FXCollections.observableArrayList();
        cnx = MaConnexion.getInstance().getCnx();

    	String query = "SELECT * FROM Produit ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = cnx.createStatement();
			rs = st.executeQuery(query);
			Produit Produit;
			while(rs.next()) {
                            Produit p = new Produit(rs.getInt("IdP"),rs.getString("nomP"),rs.getDouble("prixP"),rs.getString("descP"),rs.getString("dispoP"),rs.getString("couleurP"),rs.getInt("quantiteP"),rs.getString("tailleP"));
				ProduitList.add(p);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ProduitList;
    }
    
    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showProduit() {
    	ObservableList<Produit> list = getProduitList();
    	
    	idColumn.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("idP"));
    	nomColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("nomP"));
    	prixColumn.setCellValueFactory(new PropertyValueFactory<Produit,Double>("prixP"));
    	descColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("descP"));
    	dispoColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("dispoP"));
  	couleurColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("couleurP"));
    	quantiteColumn.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantiteP"));
    	tailleColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("tailleP"));

    	TableView.setItems(list);
    }

    @FXML
    private void deleteButton() {
        //(ActionEvent event)
        String query = "DELETE FROM produit WHERE idP="+txtid.getText()+"";
    	executeQuery(query);
    	showProduit();
    }

    @FXML
    private void updateButton(){
//     int idP =Integer.parseInt(txtid.getText());
        String nomP =txtnom.getText();
       Double prixP= Double.parseDouble(txtprix.getText());
       String descP =txtdesc.getText();
        String dispoP =cbdispo.getValue();
        String couleurP =cbcouleur.getValue();
        int quantiteP= Integer.parseInt(txtquantite.getText());
        String tailleP =cbtaille.getValue();
       
    //String query = "UPDATE produit SET nomP="+txtnom.getText()+",prixP="+txtprix.getText()+",descP="+txtdesc.getText()+",dispoP="+cbdispo.getValue()+",couleurP="+cbcouleur.getValue()+" ,quantiteP="+txtquantite.getText()+" ,tailleP="+cbtaille.getValue()+"  WHERE idP="+txtid.getText()+"";
    //executeQuery(query);
    Produit c=new Produit();
    ProduitServices es= new ProduitServices();
    es.modifier(c);
	showProduit();
       
    }

    @FXML
    private void insertButton(ActionEvent event) {
       String nomP =txtnom.getText();
       Double prixP= Double.parseDouble(txtprix.getText());
       String descP =txtdesc.getText();
        String dispoP =cbdispo.getValue();
        String couleurP =cbcouleur.getValue();
        int quantiteP= Integer.parseInt(txtquantite.getText());
        String tailleP =cbtaille.getValue();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if( (nomP.equals("") || prixP.equals("")|| descP.equals("")|| dispoP.equals("") ) ){
                       //Alert saisie jeux :
             alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
        }else{
        Produit p = new Produit(nomP, prixP,descP,dispoP,couleurP,quantiteP,tailleP);
      ProduitServices ps = new ProduitServices();
        ps.ajouter(p);
        alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter commande");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();

        showProduit();
       /* try {
            Parent root = loader.load();
            ProduitController ac = loader.getController();
            ac.setTableView(ps.afficher().toString());
            txtnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
       /*String query = "insert into produit values('"+txtnom.getText()+"',"+txtprix.getText()+",'"+txtdesc.getText()+"','"+txtdispo.getText()+"','"+txtcouleur.getText()+"',"+txtquantite.getText()+",'"+txttaille.getText()+"')";
    	executeQuery(query);
    	showProduit();*/
       
    }
    }
	                                                                        

    private void executeQuery(String query) {
        cnx = MaConnexion.getInstance().getCnx();
    	Statement st;
    	try {
			st = cnx.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

     @FXML
    private void rechercheEq(MouseEvent event) {
            	ObservableList<Produit> list = getProduitList();

      idColumn.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("idP"));
    	nomColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("nomP"));
    	prixColumn.setCellValueFactory(new PropertyValueFactory<Produit,Double>("prixP"));
    	descColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("descP"));
    	dispoColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("dispoP"));
  	couleurColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("couleurP"));
    	quantiteColumn.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantiteP"));
    	tailleColumn.setCellValueFactory(new PropertyValueFactory<Produit,String>("tailleP"));

    	TableView.setItems(list);
        
 FilteredList<Produit> filteredData = new FilteredList<>(list, m
        -> true);  
 search.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }   
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getNomP().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
   
    }else if (person.getDescP().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (person.getDispoP().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (person.getCouleurP().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
    //else if (String.valueOf(person.getUser_id()).indexOf(lowerCaseFilter)!=-1)
         //return true;// Filter matches email
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<Produit> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(TableView.comparatorProperty());  
  TableView.setItems(sortedData);             
    }
        
    void setTableView(String toString) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @FXML
    private void selectP(MouseEvent event) {
        Produit Produit = TableView.getSelectionModel().getSelectedItem();
txtidP.setText("" +Produit.getIdP());
txtnom.setText(Produit.getNomP());
txtprix.setText("" +Produit.getPrixP());
txtdesc.setText(Produit.getDescP());

cbdispo.setValue(Produit.getDispoP());
cbcouleur.setValue(Produit.getCouleurP());

txtquantite.setText("" +Produit.getQuantiteP());
cbtaille.setValue(Produit.getTailleP());

    }

    @FXML
    private void pdfP(ActionEvent event) throws FileNotFoundException, DocumentException  {
            ProduitServices pu = new ProduitServices();
         Produit p1 = new Produit();
         pu.pdf(p1);
        
    }

  /*  int getquantitebyidp(int idp) throws SQLException {

    ste = cnx.createStatement();
        int quantite = 0;

        try {

            PreparedStatement pre = cnx.prepareStatement("SELECT quantiteP  from Produit where idP=?");
            pre.setInt(1, idp);
   
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {


                
                 quantite = rs.getInt("quantiteP");

            }
        } catch (SQLException ex) {
        }

        return quantite;*/


    }

  
    
   
        
    

    
    
  

    

   
    
   
