package Controllers;
import Entities.Article;
import Entities.Commentaires;
import Services.ArticleServices;
import Services.CommentairesServices;
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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    ArticleServices as = new ArticleServices();
    @FXML
    private ListView<String> listeviewdesc;

    @FXML
    private ListView<String> listviewdate;

    @FXML
    private ListView<String> listviewtitre;
    @FXML
    private ListView<String> listviewCommentaire;

    @FXML
    private TextArea textArea;

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnmodifier;

    @FXML
    private TextArea tfdesc;

    @FXML
    private TextField tftitrearicle;

    @FXML
    private ListView<String> tfidarticle;

    @FXML
    private ListView<String> tfcomment;

    @FXML
    private TextField tfimage;

    /* @FXML
    private Button btnsupp;*/

    Article a = new Article();
    Commentaires c = new Commentaires();
    CommentairesServices cs = new CommentairesServices();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showArticle();
        showCommentaire();
    }


    public void showCommentaire() {

        List<Commentaires> licom = cs.afficher();
        for (Commentaires c : licom) {
            String Contenu = c.getContenucommentaire();
            String Titre = c.getTitrecommentaire();
            String date = String.valueOf(c.getDatecommentaire());
            String titreA = c.getArticle().getTitreArticle();
            listviewCommentaire.getItems().add(Contenu +   "     "   +    Titre  +  "      " + date + "     "    +   titreA);
            tfcomment.getItems().add(String.valueOf(c.getIdcommentaire()));
        }


    }

    public void switchToarticle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TEMP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Articles");
        stage.setScene(scene);
        stage.show();
    }




    public void showArticle() {
        listviewtitre.getItems().clear();
        listeviewdesc.getItems().clear();
        listviewdate.getItems().clear();
        tfidarticle.getItems().clear();

        ObservableList<Article> li = as.afficher();

        for (int i = 0; i < li.size(); i++) {
            String title = li.get(i).getTitreArticle();
            listviewtitre.getItems().add(title);
            String listdesc = li.get(i).getDescriptionArticle();
            listeviewdesc.getItems().add(listdesc);
            Date date = li.get(i).getDateArticle();
            listviewdate.getItems().add(String.valueOf(date));
            int id = li.get(i).getIdArticle();
            tfidarticle.getItems().add(String.valueOf(id));

        }
    }






    @FXML
    public void comment (){
       CommentairesServices cs = new CommentairesServices();
        Commentaires c = new Commentaires();
        c.setTitrecommentaire("amine");
        String s = (tfidarticle.getSelectionModel().getSelectedItem());
        int i = Integer.parseInt(s);
        Boolean BW = false ;
        ArrayList<String> badwords = new ArrayList<>();
        badwords.add("bad1");
        badwords.add("bad2");
        badwords.add("bad3");
        badwords.add("bad4");

        for( int j=0;j<badwords.size();j++ ){

            if (textArea.getText().contains(badwords.get(j)))
            {
                BW=true ;
                System.out.println(badwords.get(j));
            }

        }
        if (BW==false)
        { c.setContenucommentaire(textArea.getText());}
        else
        {c.setContenucommentaire("****"); }
        //c.setContenucommentaire(textArea.getText());
        c.getArticle().setIdArticle(i);
        c.setArticle(c.getArticle());
        cs.ajouter(c);
        listviewCommentaire.getItems().clear();
        showCommentaire();

    }
     /*public void supprimerComment(){
       String s= tfcomment.getSelectionModel().getSelectedItem();
       int i = Integer.parseInt(s);
        c.setIdcommentaire(i);
        cs.supprimer(c);
        listviewCommentaire.getItems().clear();
        tfcomment.getItems().clear();
        showCommentaire();
*/


}