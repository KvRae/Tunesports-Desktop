

/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import Tools.MaConnexion;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CrudReservation-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 828, 563);
            stage.setTitle("Tunesports");
            stage.getIcons();
            stage.setScene(scene);
            stage.show();

    }
    //******************************************************PSVM*****************************************************************

    public static void main(String[] args) {
        launch();
        //insuring singleton connection to our Db Server
        MaConnexion cnx = MaConnexion.getInstance();

    }
}