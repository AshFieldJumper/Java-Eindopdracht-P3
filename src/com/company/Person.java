package com.company;


import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty voornaam;
    private final SimpleStringProperty achternaam;
    private final SimpleStringProperty tussenvoegsel;
    private final SimpleStringProperty adres;
    private final SimpleStringProperty postcode;
    private final SimpleStringProperty woonplaats;
    private final SimpleStringProperty geboortedatum;
    private final SimpleStringProperty telefoon;


    public Person(String voornaam,
                  String achternaam,
                  String tussenvoegsel,
                  String adres,
                  String postcode,
                  String woonplaats,
                  String geboortedatum,
                  String telefoon) {

        this.voornaam = new SimpleStringProperty(voornaam);
        this.achternaam = new SimpleStringProperty(achternaam);
        this.tussenvoegsel = new SimpleStringProperty(tussenvoegsel);
        this.adres = new SimpleStringProperty(adres);
        this.postcode = new SimpleStringProperty(postcode);
        this.woonplaats = new SimpleStringProperty(woonplaats);
        this.geboortedatum = new SimpleStringProperty(geboortedatum);
        this.telefoon = new SimpleStringProperty(telefoon);


    }


    public String getVoornaam() {
        return voornaam.get();
    }

    public SimpleStringProperty voornaamProperty() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam.set(voornaam);
    }

    public String getAchternaam() {
        return achternaam.get();
    }

    public SimpleStringProperty achternaamProperty() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam.set(achternaam);
    }

    public String getTussenvoegsel() {
        return tussenvoegsel.get();
    }

    public SimpleStringProperty tussenvoegselProperty() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel.set(tussenvoegsel);
    }

    public String getAdres() {
        return adres.get();
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }

    public String getPostcode() {
        return postcode.get();
    }

    public SimpleStringProperty postcodeProperty() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode.set(postcode);
    }

    public String getWoonplaats() {
        return woonplaats.get();
    }

    public SimpleStringProperty woonplaatsProperty() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats.set(woonplaats);
    }

    public String getGeboortedatum() {
        return geboortedatum.get();
    }

    public SimpleStringProperty geboortedatumProperty() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum.set(geboortedatum);
    }

    public String getTelefoon() {
        return telefoon.get();
    }

    public SimpleStringProperty telefoonProperty() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon.set(telefoon);
    }
}