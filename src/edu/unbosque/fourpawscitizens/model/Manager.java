package edu.unbosque.fourpawscitizens.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Manager {

    public static final String SEPARADOR = ",";

   public void leer(){

       BufferedReader bufferLectura = null;
       try {
           bufferLectura = new BufferedReader(new FileReader("archivo.csv"));
           String linea = bufferLectura.readLine();
           while (linea != null) {
               String[] campos = linea.split(SEPARADOR);
               System.out.println(Arrays.toString(campos));
               linea = bufferLectura.readLine();
           }
       }
       catch (IOException e) {
           e.printStackTrace();
       }
       finally {
           if (bufferLectura != null) {
               try {
                   bufferLectura.close();
               }
               catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
}

