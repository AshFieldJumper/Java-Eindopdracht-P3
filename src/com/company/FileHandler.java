package com.company;

import java.io.*;

public class FileHandler implements Serializable{

    public void readFile() {

        String CsvFile = "data.csv";
        String FieldDelimiter = ";";

        BufferedReader br;


        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";", -1);

                Person person = new Person(fields[0], fields[1], fields[2],
                        fields[3], fields[4], fields[5], fields[6], fields[7]);
                System.out.println(fields[0]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);

        }
    }
}
