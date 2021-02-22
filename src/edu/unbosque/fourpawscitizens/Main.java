package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;
import edu.unbosque.fourpawscitizens.model.daos.Pet;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Manager manager = new Manager();
        manager.uploadData("src\\data\\pets-citizens.csv");
//        ArrayList<Pet> pets = new ArrayList<>();
//        for (Pet pet : pets) {
//            System.out.println(manager.assignID(pet.microchip,"FELINO","HEMBRA","PEQUEÑO",false,"USAQUEN"));
//        }
//            menu();


    }

    private static void menu() {

        Scanner leer = new Scanner(System.in);

        System.out.println(".: Welcome to the FourPawsCitizens program :."
                + "\nThis is a program that allows you to access and manipulate this data, fulfilling some basic requirements."
                + "\nThrough this menu choose the option you need");
        System.out.println("Write the number of the option you need below"
                + "\n1.See information of a pet"
                + "\n2.Generate ID of all pets"
                + "\n3.How many animals are there"
                + "\n4.Given number of potentially dangerous animals in a locality."
                + "\n5.Search pet by ID"
                + "\n6.finalize");
        int opcion1 = leer.nextInt();
        switch (opcion1) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

        }
    }
}
