package Controllers;
import Entities.Article;
import Services.ArticleServices;
/*import Services.SendingMail;*/
import com.example.demo.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.Label;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminController implements Initializable{

    ArticleServices as = new ArticleServices();

    @FXML
    private ListView<String> listeviewdesc;

    @FXML
    private ListView<String> listviewdate;

    @FXML
    private ListView<String> listviewtitre;

    @FXML
    private ListView<String> listId;

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupp;

    @FXML
    private TextArea tfdesc;

    @FXML
    private TextField tftitrearicle;

    @FXML
    private TextField tfimage;

    Article a =new Article();
    @FXML

    private TextField searchBarTF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showArticle();
    }

    public void  showArticle(){
        listviewtitre.getItems().clear();
        listeviewdesc.getItems().clear();
        listviewdate.getItems().clear();
        listId.getItems().clear();

        ObservableList<Article> li = as.afficher();

        for(int i=0;i<li.size();i++ ) {
            String title = li.get(i).getTitreArticle();
            listviewtitre.getItems().add(title);
            String listdesc = li.get(i).getDescriptionArticle();
            listeviewdesc.getItems().add(listdesc);
            Date date= li.get(i).getDateArticle();
            listviewdate.getItems().add(String.valueOf(date));
            int id = li.get(i).getIdArticle();
            listId.getItems().add(String.valueOf(id));

        }
    }

    public void ajouterArticle(){


        a.setTitreArticle(tftitrearicle.getText());
        a.setDescriptionArticle(tfdesc.getText());
        a.setImageArticle(tfimage.getText());
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        a.setDateArticle(sqlDate);
        as.ajouter(a);
        /*SendingMail sendingMail = new SendingMail("hello you have a new notification","aminezarrouk96@gmail.com","New Article" );
        SendingMail.envoyer();*/
       showArticle();
    }
    public void supprimerArticle(){
        a.setIdArticle(Integer.parseInt(listId.getSelectionModel().getSelectedItem()));;
        as.supprimer(a);
        showArticle();

    }

    @FXML
    public void modifierArticle (){

         a.setIdArticle(Integer.parseInt(listId.getSelectionModel().getSelectedItem()));;
        a.setTitreArticle(tftitrearicle.getText());
        a.setDescriptionArticle(tfdesc.getText());
        a.setImageArticle(tfimage.getText());
        as.modifier(a);
        showArticle();


    }


   public void  importImage(){
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       if (f != null){
           String filename = f.getAbsolutePath();
           tfimage.setText(filename);}


   }
    public void switchToMainFront(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("userUI.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Commentaires");
        stage.setScene(scene);
        stage.show();




    }
    /*void search(){
        ObservableList l= reservationLV.getItems();
        dataList.addAll(l);
        FilteredList<Article> filteredData = new FilteredList<>(dataList, b -> true);
        searchBarTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(reservation -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(reservation.getIdRes()).toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (String.valueOf(reservation.getDateRes()).indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (String.valueOf(reservation.getHeureRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(reservation.getDispoRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(reservation.getPrixRes()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false;
            });
        });
        SortedList<Article> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(listviewtitre.getItems().sorted().comparatorProperty());
        reservationLV.setItems(sortedData);
    } */
    /* public void importImage(ActionEvent event) throws IOException {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "."),
                new FileChooser.ExtensionFilter("IMAGE FILES", ".jpg", ".png", "*.gif")
        );
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\xampp\\htdocs\\img\\"+"article"+x+".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            tfimage.setText(DBPath);

            int b=0;
            while(b!=-1){
                b=bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
        } else  {
            System.out.println("error");
        }}*/
}