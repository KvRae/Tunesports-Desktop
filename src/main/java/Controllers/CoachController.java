/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Controllers;

import Entities.Coach;
import Entities.Jeux;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CoachController {


    @FXML
    private TableView<Coach> Coachs;

    @FXML
    private TableColumn<Coach, String> Nickname;

    @FXML
    private TableColumn<Coach, Double> PrixUnit;

    @FXML
    private TableColumn<Coach, String> Rank;

    @FXML
    private TableColumn<Coach, Integer> Reviews;

    @FXML
    private TableColumn<Coach, String> Specialite;

    @FXML
    private TableColumn<Coach, String> Contact;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Ajouter;

    @FXML
    private Button Modifier;

    @FXML
    private Button Back;

}
