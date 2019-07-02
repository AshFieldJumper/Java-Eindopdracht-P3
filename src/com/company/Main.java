package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public class Main extends Application {
    private final PersonFileHandler psf = new PersonFileHandler("data.csv", ";");
    private final TableView<Person> table = new TableView<Person>();

    
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        psf.addWatcher((ArrayList<Person> persons) -> {
            table.setItems(FXCollections.observableArrayList(persons));
        });

        Scene scene = new Scene(new Group());
        stage.setWidth(850);
        stage.setHeight(550);
        stage.setTitle("Java eindopdracht P3");

        TableColumn<Person, String> voornaam = new TableColumn<Person,String>("Voornaam");
        voornaam.setMinWidth(100);
        voornaam.setCellValueFactory(
                new PropertyValueFactory("voornaam"));

        TableColumn achternaam = new TableColumn<Person,String>("Achternaam");
        achternaam.setMinWidth(100);
        achternaam.setCellValueFactory(
                new PropertyValueFactory<>("achternaam"));

        TableColumn<Person,String> tussenvoegsel = new TableColumn<Person,String>("Tussenvoegsel");
        tussenvoegsel.setMinWidth(100);
        tussenvoegsel.setCellValueFactory(
                new PropertyValueFactory<>("tussenvoegsel"));

        TableColumn<Person,String> adres = new TableColumn<Person,String>("Adres");
        adres.setMinWidth(100);
        adres.setCellValueFactory(
                new PropertyValueFactory<>("adres"));

        TableColumn<Person,String> postcode = new TableColumn<Person,String>("Postcode");
        postcode.setMinWidth(100);
        postcode.setCellValueFactory(
                new PropertyValueFactory<>("postcode"));

        TableColumn<Person,String> woonplaats = new TableColumn<Person,String>("Woonplaats");
        woonplaats.setMinWidth(100);
        woonplaats.setCellValueFactory(
                new PropertyValueFactory<>("woonplaats"));

        TableColumn<Person,String> geboortedatum = new TableColumn<Person,String>("Geboortedatum");
        geboortedatum.setMinWidth(100);
        geboortedatum.setCellValueFactory(
                new PropertyValueFactory<>("geboortedatum"));

        TableColumn<Person,String> telefoon = new TableColumn<Person,String>("Telefoon");
        telefoon.setMinWidth(100);
        telefoon.setCellValueFactory(
                new PropertyValueFactory<>("telefoon"));




        table.getColumns().addAll(voornaam, achternaam, tussenvoegsel, adres, postcode, woonplaats, geboortedatum,telefoon);


        final Button addButton = new Button("Toevoegen");
        addButton.setOnAction((ActionEvent e) -> {
            Stage Dialog = new Dialog(stage, psf);
            Dialog.sizeToScene();
            Dialog.showAndWait();
        });

        final Button removeButton = new Button("Verwijderen");
        removeButton.setOnAction((ActionEvent e) -> {
            psf.delete(table.getSelectionModel().getSelectedItem());
        });

        final Button editButton = new Button("Bewerk");
        editButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();
            if (person != null) {
                Stage Dialog = new Dialog(stage, psf, person);
                Dialog.sizeToScene();
                Dialog.showAndWait();
            }
        });

        hb.getChildren().addAll(addButton, editButton, removeButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}