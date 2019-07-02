package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

class Dialog extends Stage {

    public Dialog(Stage owner, PersonFileHandler handler) {
        super();
        initialize(owner, handler, new Person(), "Toevoegen");
    }

    public Dialog(Stage owner, PersonFileHandler handler, Person person) {
        super();
        initialize(owner, handler, person, "Bewerk");
    }

    private void initialize(Stage owner, PersonFileHandler handler, Person person, String title) {

        setTitle(title);

        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.WHITE);
        setScene(scene);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        Label Voornaam = new Label("Voornaam: ");
        gridpane.add(Voornaam, 0, 1);
        final TextField Voornaamfld = new TextField(person.getVoornaam());
        gridpane.add(Voornaamfld, 1, 1);

        Label Achternaam = new Label("Achternaam: ");
        gridpane.add(Achternaam, 0, 2);
        final TextField Achternaamfld = new TextField(person.getAchternaam());
        gridpane.add(Achternaamfld, 1, 2);

        Label Tussenvoegsel = new Label("Tussenvoegsel: ");
        gridpane.add(Tussenvoegsel, 0, 3);
        final TextField Tussenvoegselfld = new TextField(person.getTussenvoegsel());
        gridpane.add(Tussenvoegselfld, 1, 3);

        Label Adres = new Label("Adres: ");
        gridpane.add(Adres, 0, 4);
        final TextField Adresfld = new TextField(person.getAdres());
        gridpane.add(Adresfld, 1, 4);

        Label Postcode = new Label("Postcode: ");
        gridpane.add(Postcode, 0, 5);
        final TextField Postcodefld = new TextField(person.getPostcode());
        gridpane.add(Postcodefld, 1, 5);

        Label Woonplaats = new Label("Woonplaats: ");
        gridpane.add(Woonplaats, 0, 6);
        final TextField Woonplaatsfld = new TextField(person.getWoonplaats());
        gridpane.add(Woonplaatsfld, 1, 6);

        Label Geboortedatum = new Label("Geboortedatum: ");
        gridpane.add(Geboortedatum, 0, 7);
        final TextField Geboortedatumfld = new TextField(person.getGeboortedatum());
        gridpane.add(Geboortedatumfld, 1, 7);

        Label Telefoon = new Label("Telefoon: ");
        gridpane.add(Telefoon, 0, 8);
        final TextField Telefoonfld = new TextField(person.getTelefoon());
        gridpane.add(Telefoonfld, 1, 8);


        Button Add = new Button(title);
        Add.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (!title.equals("Toevoegen")) {
                    handler.delete(person);
                }

                person.setVoornaam(Voornaamfld.getText());
                person.setAchternaam(Achternaamfld.getText());
                person.setTussenvoegsel(Tussenvoegselfld.getText());
                person.setAdres(Adresfld.getText());
                person.setPostcode(Postcodefld.getText());
                person.setWoonplaats(Woonplaatsfld.getText());
                person.setGeboortedatum(Geboortedatumfld.getText());
                person.setTelefoon(Telefoonfld.getText());

                handler.append(person);
                close();
            }
        });
        gridpane.add(Add, 1, 9);
        GridPane.setHalignment(Add, HPos.RIGHT);
        root.getChildren().add(gridpane);
    }
}