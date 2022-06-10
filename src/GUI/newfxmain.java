/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Tournoi;
import Tools.MaConnexion;
import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Chiheb
 */
public class newfxmain extends Application {
  @Override
  public void start(Stage primaryStage) {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("menu.fxml"));
      Scene scene = new Scene(root);

      primaryStage.setTitle("Tournoi");
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) { launch(args); }
}
