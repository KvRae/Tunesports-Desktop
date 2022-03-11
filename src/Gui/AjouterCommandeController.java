/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Commande;
import Services.CommandeServices;
import Tools.MaConnexion;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author achou
 */
public class AjouterCommandeController implements Initializable {

    @FXML
    private TextField txtadresse;
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
    @FXML
    private Button inserttcommande;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCommande();
           cbstatus.setItems(listS);
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

    @FXML
    private void selectC(MouseEvent event) {
    }

    @FXML
    private void insertCommande(ActionEvent event) throws IOException {
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
    
    Calendar(adresseColumn.getText(),ddate.getValue().format(DateTimeFormatter.ISO_DATE),ddate.getValue().format(DateTimeFormatter.ISO_DATE));
    
    alert.setAlertType(Alert.AlertType.INFORMATION);
              alert.setTitle("ajouter commande");
              alert.setHeaderText("Results:");
              alert.setContentText("You Have added successfully!");
              alert.showAndWait();
   
    showCommande();
    }

    
   
}
    
    
    
    
    
public void Calendar(String Titre , String Datedeb , String Datefin) throws MalformedURLException, IOException{
        // Using Calendar api
          URL url = new URL("https://www.googleapis.com/calendar/v3/calendars/c_58flhjcaq4i1v34lr15h3vcpcs@group.calendar.google.com/events/");
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Authorization", "Bearer ya29.A0ARrdaM9HAnPYybXWl5DKlorUXlxgT5wr0g9Nqkjoo5p_OICbIr1BJyJcSw_9OFWMSj_Abpk55VOrAtGEC0LmxPqVxOVlJHukE_u8eaa1rIahtPOav9r0MJ0NOw4W0CvcsMyaAU_ekRzfTaHOfuESL9SYEcVf");
http.setRequestProperty("Content-Type", "application/json");

String data = "{\n\"summary\": \""+Titre+"\",\n  \"location\": \"tunesport Application\",\n  \"start\": {\n    \"dateTime\": \""+Datedeb+"T10:00:00.000-07:00\"\n  },\n  \"end\": {\n    \"dateTime\": \""+Datefin+"T10:25:00.000-07:00\"\n    }\n\n}";
//String data = "{\n\"summary\": \"tournament\",\n  \"location\": \"Arena Application\",\n  \"start\": {\n    \"dateTime\": \""+tfDateDebut.getValue().format(DateTimeFormatter.ISO_DATE)+"T10:00:00.000-07:00\"\n  },\n  \"end\": {\n    \"dateTime\": \""+tfDateFin.getValue().format(DateTimeFormatter.ISO_DATE)+"\n    },\n\"etag\": \"\", \n      \"backgroundColor\": \"#b80672\", \n      \"timeZone\": \"UTC\", \n      \"accessRole\": \"reader\",\n\"kind\": \"calendar#calendarListEntry\", \n      \"foregroundColor\": \"#ffffff\", \n      \"defaultReminders\": [], \n      \"colorId\": \"2\"\n\n}\n";
byte[] out = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(out);

System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + "Tournmend Event added to Calendar Successfully");
http.disconnect();
        
        // end Calendar 
}

    @FXML
    private void GoToMenu(ActionEvent event) throws IOException {
        Parent home_parent=FXMLLoader.load(getClass().getResource("Menumembre.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    
    
    
    
    
    
    
    
    
}

