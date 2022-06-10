
/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Tests;

import Tools.MaConnexion;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(Main.class.getResource("ReservationClient-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 828, 563);
    stage.setTitle("Tunesports");
    stage.initStyle(StageStyle.TRANSPARENT);
    Image icon =
        new Image(getClass().getResourceAsStream("/Pictures/TeLogo.png"));
    stage.getIcons().add(icon);
    stage.setScene(scene);
    stage.show();
  }
  //******************************************************PSVM*****************************************************************

  public static void main(String[] args) {
    launch();
    // insuring singleton connection to our Db Server
    MaConnexion cnx = MaConnexion.getInstance();
  }
}