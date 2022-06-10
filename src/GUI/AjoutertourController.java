/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Tournoi;
import Services.EvenementService;
import Services.TournoiService;
import Tools.MaConnexion;
import com.itextpdf.text.DocumentException;
import static com.itextpdf.text.pdf.PdfName.E;
import static com.itextpdf.text.pdf.PdfName.T;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.controlsfx.control.Notifications;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 * FXML Controller class
 *
 * @author Chiheb
 */
public class AjoutertourController implements Initializable {

    
    
    
    @FXML
    private AnchorPane Ajoutertour;
    @FXML
    private DatePicker txtdatedebt;
    @FXML
    private DatePicker txtdatefint;
    @FXML
    private Button btn;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btnm;
    @FXML
    private TextField txtidt;
    @FXML
    private TextField txtnomt;
    @FXML
    private TextField txtdesct;
       @FXML
    private TextField txtrecomt;
    @FXML
    private ListView listviewt=new ListView();
    TournoiService ts=new TournoiService();
    private final ObservableList<Tournoi> tournoilist=FXCollections.observableArrayList(ts.afficher());
     private final ObservableList<Tournoi> tourt=FXCollections.observableArrayList(ts.trie());
     private final ObservableList<Tournoi> tourdest=FXCollections.observableArrayList(ts.tried());
     private final ObservableList<Tournoi> tourdesct=FXCollections.observableArrayList(ts.triedesc());
      private final ObservableList<Tournoi> tourdescdt=FXCollections.observableArrayList(ts.triedescd());
      private final ObservableList<Tournoi> histot=FXCollections.observableArrayList(ts.historique());

     private int selectedindex=-1;
    @FXML
    private Button pdft;
    @FXML
    private RadioButton tri_asc;
    @FXML
    private ToggleGroup tris;
    @FXML
    private RadioButton tri_desc;
    @FXML
    private RadioButton dateplt;
    @FXML
    private RadioButton tri_nom;
    @FXML
    private Button btnrecht;
    @FXML
    private RadioButton rdidt;
    @FXML
    private ToggleGroup rech;
    @FXML
    private RadioButton rdnomt;
    @FXML
    private RadioButton rddatet;
    @FXML
    private Button histort;
    @FXML
    private Button btnqt;
    @FXML
    private TextField txtrecht;
    private MaConnexion cnx;
    @FXML
    private Button barcodet;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listviewt.setItems(tournoilist);
       listviewt.refresh();
        // TODO
    }    
    
    
    


    @FXML
    private void addtour(ActionEvent event) {
        String nomt= txtnomt.getText();
        String datedebt=String.valueOf(txtdatedebt.getValue());
        String datefint=String.valueOf(txtdatefint.getValue());
        String desct=txtdesct.getText();
        String recompt=txtrecomt.getText();
        
        java.sql.Date dde=java.sql.Date.valueOf(datedebt);
        java.sql.Date dfe=java.sql.Date.valueOf(datefint);
        
        Tournoi T=new Tournoi(nomt,dde,dfe,desct,recompt);       
        TournoiService ts = new TournoiService();
            if(dfe.before(dde)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date");
            alert.setContentText("configure votre date");
            Optional<ButtonType> result=alert.showAndWait();
        }
            else{
        ts.ajouter(T);
        listviewt.refresh();
        tournoilist.add(T);
         listviewt.refresh();
         Notificationmanager(0);
            }
    }
    
    
        @FXML
    private void deletetournoi(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setContentText("Voulez vous supprimer ce champ?");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){
                String id= txtidt.getText();
         int idev=Integer.parseInt(id);
         tournoilist.remove(selectedindex);
        Tournoi T=new Tournoi(idev);       
        TournoiService se=new TournoiService();
        se.supprimer(T);
        listviewt.refresh();
        txtnomt.clear();
        txtdatedebt.setValue(null);
        txtdatefint.setValue(null);
        txtdesct.clear();
        txtrecomt.clear();
        listviewt.refresh();
        Notificationmanager(1);
    }
    }
    
    
    
            @FXML
    private void modiftournoi(ActionEvent event){
        
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setContentText("Voulez vous modiffier ce champ?");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){
   
        String id= txtidt.getText();
         int idt=Integer.parseInt(id);
        String nomt= txtnomt.getText();
        String datedebt=String.valueOf(txtdatedebt.getValue());
        String datefint=String.valueOf(txtdatefint.getValue());
        String desct=txtdesct.getText();
        String recomt=txtrecomt.getText();
         java.sql.Date dde=java.sql.Date.valueOf(datedebt);
        java.sql.Date dfe=java.sql.Date.valueOf(datefint);
        
        Tournoi T=new Tournoi(idt,nomt,dde,dfe,desct,recomt);         
        TournoiService es = new TournoiService();

       es.modifier(T);
     tournoilist.remove(selectedindex);
     tournoilist.add(T);
        txtnomt.clear();
        txtdatedebt.setValue(null);
        txtdatefint.setValue(null);
        txtdesct.clear();
        txtrecomt.clear();
        Notificationmanager(2);
    }
    }
    
    
    @FXML
    private void gom(ActionEvent event) throws IOException{
     
        Parent home_parent=FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene home_scene=new Scene(home_parent);
        Stage app_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    
    
    


    @FXML
    private void getclickeditemt(MouseEvent event) {
        Tournoi selecteditem=(Tournoi) listviewt.getSelectionModel().getSelectedItem();
        selectedindex=listviewt.getSelectionModel().getSelectedIndex(); 
        txtidt.setText(""+selecteditem.getId_tour());
        txtnomt.setText(selecteditem.getNomtour());
        txtdatedebt.setValue(selecteditem.getDatedebtour().toLocalDate());
        txtdatefint.setValue(selecteditem.getDatefintour().toLocalDate());
        txtdesct.setText(selecteditem.getDesctour());
        txtrecomt.setText(selecteditem.getRecomptour());
    }

    @FXML
    private void pdftou(ActionEvent event) throws FileNotFoundException, DocumentException {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF");
            alert.setContentText("SUCCESS");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK){
        TournoiService ts=new TournoiService();
        ts.pdf();
    }
    }

    @FXML
    private void tri_asct(ActionEvent event) {
        TournoiService es = new TournoiService();
        listviewt.setItems(tourt);
    }

    @FXML
    private void tri_desct(ActionEvent event) {
        
        TournoiService es = new TournoiService();
        listviewt.setItems(tourdesct);
    }

    @FXML
    private void tri_asctd(ActionEvent event) {
                TournoiService es = new TournoiService();
        listviewt.setItems(tourdest);
    }

    @FXML
    private void tri_desctd(ActionEvent event) {
                TournoiService es = new TournoiService();
        listviewt.setItems(tourdescdt);
    }

    @FXML
    private void recherchet(ActionEvent event) {
        if(rdidt.isSelected()){
        String id= txtrecht.getText();
        int idev=Integer.parseInt(id);
        Tournoi T=new Tournoi(idev);       
        TournoiService ts=new TournoiService();
        ts.recherche(T);
        listviewt.setItems(FXCollections.observableArrayList(ts.recherche(T)));
        } 
        if(rdnomt.isSelected()){
        String nom= txtrecht.getText();
        Tournoi E=new Tournoi(nom);       
        TournoiService se=new TournoiService();
        se.recherche(E);
  listviewt.setItems(FXCollections.observableArrayList(ts.recherche(E)));
        }        
        if(rddatet.isSelected()){
       java.sql.Date dde=java.sql.Date.valueOf(txtrecht.getText());
        Tournoi E=new Tournoi(dde);       
        TournoiService se=new TournoiService();
        se.recherche(E);  
        listviewt.setItems(FXCollections.observableArrayList(ts.recherche(E)));
        }
    }

    @FXML
    private void historiquet(ActionEvent event) {
    TournoiService se=new TournoiService();
    listviewt.refresh();
    listviewt.setItems(histot);
    se.historique();
    }

    @FXML
    private void QR_t(ActionEvent event) {
          TournoiService se=new TournoiService();
        try {
            ByteArrayOutputStream out = QRCode.from(se.afficher().toString()).to(ImageType.JPG).stream();
            String f_name="tours.pdf";
            String path_name="C:\\Users\\Chiheb\\Desktop\\Nouveaudossier";
            FileOutputStream fout = new FileOutputStream(new File(path_name +(f_name+ ".PNG")));
            fout.write(out.toByteArray());
            fout.flush();

}catch(Exception e){
    System.out.println(e);
}
    }

    @FXML
    private void Bar_codet(ActionEvent event) {
             TournoiService se=new TournoiService();
        try {
        Code128Bean code128 = new Code128Bean();
        code128.setHeight(15f);
        code128.setModuleWidth(0.3);
        code128.setQuietZone(10);
        code128.doQuietZone(true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 400, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        code128.generateBarcode(canvas,txtidt.getText());
        canvas.finish();
        
        //write to png file
        String f_name="barcode";
        String path_name="C:\\Users\\Chiheb\\Desktop\\Nouveaudossier";
        FileOutputStream fos = new FileOutputStream(new File(path_name +(f_name+ ".PNG")));
        fos.write(baos.toByteArray());
        fos.flush();
        fos.close();
        }catch(Exception e){
    System.out.println(e);
}
    }
    
    
     public void Notificationmanager(int mode) {
           Notifications not = Notifications.create()
                 .graphic(null)
                 .position(Pos.BOTTOM_RIGHT)
                 .onAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle (ActionEvent event) {
             System.out.println("clicked on notification");
         }
         }) ;
           not.darkStyle();
          switch(mode) {
  case 0:

   not.title("Success");
                 not.text("Ajout terminer" );
                 not.showInformation();
    break;
  case 1:

    not.title("Success ");
                 not.text("Suppression terminer");
                 not.showWarning();
    break;
    case 2:

                 not.text("Modification terminer");
                 not.title("Success");
                 not.showInformation();
    break;


  default:

}

    }
    
    
    
}