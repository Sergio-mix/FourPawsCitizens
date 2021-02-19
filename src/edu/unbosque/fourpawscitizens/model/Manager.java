package edu.unbosque.fourpawscitizens.model;

public class Manager {
    Lector de CSVReader = nulo ;
    public void leer(){
        // analizar un archivo CSV en el constructor de la clase CSVReader
        lector = nuevo CSVReader ( nuevo FileReader ( "C: \\ Users \ Dell \ Desktop \ csvDemo.csv" )) ;
        String [] nextLine;
        // lee una línea a la vez
        while (( nextLine = reader. readNext ()) ! = null ) {
            for ( String token: nextLine ) {
                Sistema. fuera . imprimir ( token ) ;
            }
            Sistema. fuera . imprimir ( "\ n" ) ;
        }

    }

    captura ( Excepción e ) {
        mi. printStackTrace () ;
    }
}

