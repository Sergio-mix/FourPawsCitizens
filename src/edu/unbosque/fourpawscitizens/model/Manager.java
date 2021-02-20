package edu.unbosque.fourpawscitizens.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Manager {

    public static final String SEPARADOR = ",";

    public void leer() {

        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader("archivo.csv"));
            String linea = bufferLectura.readLine();
            while (linea != null) {
                String[] campos = linea.split(SEPARADOR);
                System.out.println(Arrays.toString(campos));
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String assignID(long microChip, String species, String sex, String size, boolean potentDangerous, String neighborhood) {
        String newMicroChip = microChip + "";
        String newsMicroChip = newMicroChip.substring(12, 15);
        String newSpecies = species.substring(0, 1);
        String newSex = sex.substring(0, 1);
        String newSize = size.substring(0, 1);
        String newPotentDangerous = potentDangerous + "";
        String newsPotentDangerous = newPotentDangerous.substring(0, 1);

        String id = newsMicroChip + "-" + newSpecies +newSex +  newSize+ newsPotentDangerous + "-" + neighborhood;
        return id.toUpperCase();
    }

}

