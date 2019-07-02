package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

public class PersonFileHandler {

    private File file;
    private String delimiter;
    private ArrayList<Watcher> watchers;
    private ArrayList<Person> persons = new ArrayList<Person>();

    public PersonFileHandler(String file, String delimiter) {
        try {
            this.file = new File(file);
            if (!this.file.exists() && !this.file.createNewFile()) {
                throw new IOException("error creating the save file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.watchers = new ArrayList<Watcher>();
        this.delimiter = delimiter;
    }

    public ArrayList<Person> getPersons() {
        readCSV();
        return this.persons;
    }

    private void readCSV() {
        ArrayList<Person> list = new ArrayList<Person>();
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(this.file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(this.delimiter, -1);

                if (fields.length == 8) {
                    list.add(new Person(
                            fields[0],
                            fields[1],
                            fields[2],
                            fields[3],
                            fields[4],
                            fields[5],
                            fields[6],
                            fields[7]
                    ));
                } else {
                    String message;
                    if (fields.length < 8) {
                        message = "Error in person CSV, data fields too short";
                    } else {
                        message = "Error in person CSV, data fields too long";
                    }
                    throw new IOException(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.persons = list;
    }

    // Adds a callback function
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
        callWatchers();
    }



    public void append(Person person) {
        persons.add(person);
        write();
    }

    public void delete(Person person) {
        persons.remove(person);
        write();
    }

    private void write() {
        StringBuilder data = new StringBuilder();
        persons.forEach((Person p) -> {
            data.append(p.getVoornaam() + delimiter);
            data.append(p.getAchternaam() + delimiter);
            data.append(p.getTussenvoegsel() + delimiter);
            data.append(p.getAdres() + delimiter);
            data.append(p.getPostcode() + delimiter);
            data.append(p.getWoonplaats() + delimiter);
            data.append(p.getGeboortedatum() + delimiter);
            data.append(p.getTelefoon() + "\n");
        });
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.file));

            bw.write(data.toString());
            bw.flush();
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        callWatchers();
    }

    private void callWatchers() {
        watchers.forEach((Watcher watcher)-> {
            readCSV();
            watcher.call(this.persons);
        });
    }
}

interface Watcher {
    void call(ArrayList<Person> a);
}