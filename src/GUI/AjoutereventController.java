/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.itextpdf.text.pdf.PdfName.NAME;
import static java.awt.SystemColor.window;
import static jdk.nashorn.internal.runtime.Debug.id;
import static jdk.nashorn.tools.ShellFunctions.input;

import Entities.Evenement;
import Services.EvenementService;
import Tools.MaConnexion;
import com.barcodelib.barcode.Linear;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.DocumentException;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import net.connectcode.Code128Auto;
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
public class AjoutereventController implements Initializable {

  @FXML private TextField txtid;
  @FXML private TextField txtnom;
  @FXML private DatePicker txtdatedebevent;
  @FXML private DatePicker txtdatefinevent;
  @FXML private TextField txtdescevent;
  @FXML private Button btn;
  @FXML private Button btn2;
  @FXML private Button btn3;
  @FXML private Button btnm;

  private TextField txtaf;

  @FXML private TextField txtrech;
  @FXML private Button btnrechev;
  @FXML private RadioButton rdnomev;
  @FXML private RadioButton rddateev;
  @FXML private RadioButton rdidev;
  @FXML private RadioButton tri_asc;
  @FXML private RadioButton tri_desc;
  @FXML private ToggleGroup tri_descendant;
  @FXML private RadioButton dateplev;
  @FXML private RadioButton dateanev;
  @FXML private Button pdfev;
  @FXML private ListView listview = new ListView();
  @FXML private AnchorPane Ajouterevent;
  EvenementService se = new EvenementService();

  private final ObservableList<Evenement> EvenementList =
      FXCollections.observableArrayList(se.afficher());
  private final ObservableList<Evenement> tra =
      FXCollections.observableArrayList(se.trie());
  private final ObservableList<Evenement> trad =
      FXCollections.observableArrayList(se.triedesc());
  private final ObservableList<Evenement> tradd =
      FXCollections.observableArrayList(se.tried());
  private final ObservableList<Evenement> tradf =
      FXCollections.observableArrayList(se.triedescd());
  private final ObservableList<Evenement> histo =
      FXCollections.observableArrayList(se.historique());

  private int selectedindex = -1;
  @FXML private ToggleGroup rech;
  @FXML private Button histor;
  @FXML private Button btnbar;
  @FXML private Label jLabell;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    listview.refresh();
    listview.setItems(EvenementList);
    listview.refresh();
  }

  @FXML
  private void addevenement(ActionEvent event) {
    String nomev = txtnom.getText();
    String datedebev = String.valueOf(txtdatedebevent.getValue());
    String datefinev = String.valueOf(txtdatefinevent.getValue());
    String descev = txtdescevent.getText();
    java.sql.Date dde = java.sql.Date.valueOf(datedebev);
    java.sql.Date dfe = java.sql.Date.valueOf(datefinev);

    Evenement E = new Evenement(nomev, dde, dfe, descev);
    EvenementService es = new EvenementService();
    EvenementService se = new EvenementService();
    if (dfe.before(dde)) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Date");
      alert.setContentText("configure votre date");
      Optional<ButtonType> result = alert.showAndWait();
    } else {
      es.ajouter(E);
      listview.refresh();
      EvenementList.add(E);
      tra.add(E);
      trad.add(E);
      tradd.add(E);
      tradf.add(E);
      Notificationmanager(0);
    }
  }

  @FXML
  private void deletevenement(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Suppression");
    alert.setContentText("Voulez vous supprimer ce champ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      String id = txtid.getText();
      int idev = Integer.parseInt(id);
      EvenementList.remove(selectedindex);
      EvenementService se = new EvenementService();
      Evenement E = new Evenement(idev);
      listview.refresh();
      se.supprimer(E);
      listview.refresh();
      txtnom.clear();
      txtdatedebevent.setValue(null);
      txtdatefinevent.setValue(null);
      txtdescevent.clear();
      listview.refresh();
      Notificationmanager(1);
    }
  }

  @FXML
  private void modifevenement(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Suppression");
    alert.setContentText("Voulez vous modiffier ce champ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      String id = txtid.getText();
      int idev = Integer.parseInt(id);
      String nomev = txtnom.getText();
      String datedebev = String.valueOf(txtdatedebevent.getValue());
      String datefinev = String.valueOf(txtdatefinevent.getValue());
      String descev = txtdescevent.getText();
      java.sql.Date dde = java.sql.Date.valueOf(datedebev);
      java.sql.Date dfe = java.sql.Date.valueOf(datefinev);
      Evenement E = new Evenement(idev, nomev, dde, dfe, descev);
      EvenementService es = new EvenementService();
      es.modifier(E);
      listview.refresh();
      EvenementList.remove(selectedindex);
      listview.refresh();
      EvenementList.add(E);
      listview.refresh();
      txtnom.clear();
      txtdatedebevent.setValue(null);
      txtdatefinevent.setValue(null);
      txtdescevent.clear();
      Notificationmanager(2);
    }
  }
  @FXML
  private void gom(ActionEvent event) throws IOException {
    Parent home_parent = FXMLLoader.load(getClass().getResource("menu.fxml"));
    Scene home_scene = new Scene(home_parent);
    Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    app_stage.setScene(home_scene);
    app_stage.show();
  }

  @FXML

  private void recherchev(ActionEvent event) {
    if (rdidev.isSelected()) {
      String id = txtrech.getText();
      int idev = Integer.parseInt(id);
      Evenement E = new Evenement(idev);
      EvenementService se = new EvenementService();
      se.recherche(E);
      listview.setItems(FXCollections.observableArrayList(se.recherche(E)));
    }
    if (rdnomev.isSelected()) {
      String nom = txtrech.getText();
      Evenement E = new Evenement(nom);
      EvenementService se = new EvenementService();
      se.recherche(E);
      listview.setItems(FXCollections.observableArrayList(se.recherche(E)));
    }
    if (rddateev.isSelected()) {
      java.sql.Date dde = java.sql.Date.valueOf(txtrech.getText());
      Evenement E = new Evenement(dde);
      EvenementService se = new EvenementService();
      se.recherche(E);

      listview.setItems(FXCollections.observableArrayList(se.recherche(E)));
    }
  }

  @FXML
  private void tri_ascev(ActionEvent event) {
    EvenementService se = new EvenementService();
    listview.refresh();
    listview.setItems(EvenementList);
    listview.refresh();
  }

  @FXML
  private void tri_descev(ActionEvent event) {
    EvenementService se = new EvenementService();
    listview.refresh();
    listview.setItems(trad);
    listview.refresh();
  }

  @FXML
  private void tri_ascevd(ActionEvent event) {
    EvenementService se = new EvenementService();
    listview.refresh();
    listview.setItems(tradd);
    listview.refresh();
  }

  @FXML
  private void tri_descevd(ActionEvent event) {
    EvenementService se = new EvenementService();
    listview.refresh();
    listview.setItems(tradf);
    listview.refresh();
  }

  @FXML
  private void pdfevent(ActionEvent event)
      throws FileNotFoundException, DocumentException {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("PDF");
    alert.setContentText("SUCCESS");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      EvenementService es = new EvenementService();
      es.pdf();
    }
  }

  @FXML
  private void getclickeditem(MouseEvent event) {
    Evenement selecteditem =
        (Evenement)listview.getSelectionModel().getSelectedItem();
    selectedindex = listview.getSelectionModel().getSelectedIndex();
    txtid.setText("" + selecteditem.getId_event());
    txtnom.setText(selecteditem.getNomevent());
    txtdatedebevent.setValue(selecteditem.getDatedebevent().toLocalDate());
    txtdatefinevent.setValue(selecteditem.getDatefinevent().toLocalDate());
    txtdescevent.setText(selecteditem.getDescevent());
  }

  @FXML
  private void QR_code(ActionEvent event) {
    EvenementService es = new EvenementService();
    try {
      ByteArrayOutputStream out =
          QRCode.from(se.afficher().toString()).to(ImageType.JPG).stream();
      String f_name = "Events.pdf";
      String path_name = "C:\\Users\\Chiheb\\Desktop\\Nouveaudossier";
      FileOutputStream fout =
          new FileOutputStream(new File(path_name + (f_name + ".PNG")));
      fout.write(out.toByteArray());
      fout.flush();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  private void historique(ActionEvent event) {
    EvenementService se = new EvenementService();
    listview.refresh();
    listview.setItems(histo);
    se.historique();
  }

  @FXML
  private void Bar_code(ActionEvent event) throws Exception {
    EvenementService es = new EvenementService();
    try {
      Code128Bean code128 = new Code128Bean();
      code128.setHeight(15f);
      code128.setModuleWidth(0.3);
      code128.setQuietZone(10);
      code128.doQuietZone(true);

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      BitmapCanvasProvider canvas = new BitmapCanvasProvider(
          baos, "image/x-png", 400, BufferedImage.TYPE_BYTE_BINARY, false, 0);
      code128.generateBarcode(canvas, txtid.getText());
      canvas.finish();

      // write to png file
      String f_name = "barcode";
      String path_name = "C:\\Users\\Chiheb\\Desktop\\Nouveaudossier";
      FileOutputStream fos =
          new FileOutputStream(new File(path_name + (f_name + ".PNG")));
      fos.write(baos.toByteArray());
      fos.flush();
      fos.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void Notificationmanager(int mode) {
    Notifications not = Notifications.create()
                            .graphic(null)
                            .position(Pos.BOTTOM_RIGHT)
                            .onAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent event) {
                                System.out.println("clicked on notification");
                              }
                            });
    not.darkStyle();
    switch (mode) {
    case 0:

      not.title("Success");
      not.text("Ajout terminer");
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