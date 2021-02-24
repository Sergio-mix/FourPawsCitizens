package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;
import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Main {
    public static Manager manager;

    public static void main(String[] args) throws IOException {
        manager = new Manager();
        manager.uploadData("src\\data\\testCsv.csv");

        menu();
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
                for (int j = 0; j < manager.listPet.size(); j++) {
                    String id = manager.assignID(manager.listPet.get(j).microchip, manager.listPet.get(j).species, manager.listPet.get(j).sex, manager.listPet.get(j).size, manager.listPet.get(j).potentDangerous, manager.listPet.get(j).neighborhood);
                    manager.listPet.get(j).setId(id);
                }

                for (int i = 0; i < manager.listPet.size(); i++) {
                    System.out.println(manager.listPet.get(i).id);
                }

                System.out.printf("Generate ID of all pets");
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

        }
    }

//    public static String callId(long microchip) {
//
//        listPet = new ArrayList<>();
//        manager = new Manager();
//        String id = null;
//        String sex = null;
//        String neighborhood = null;
//        String species = null;
//        String size = null;
//        boolean potentDangerous = false;
//
//
//        for (int i = 0; i < listPet.size(); i++) {
//            if (listPet.get(i).microchip == microchip) {
//                listPet.get(i).getMicrochip();
//                sex = listPet.get(i).getSex();
//                neighborhood = listPet.get(i).getNeighborhood();
//                species = listPet.get(i).getSpecies();
//                size = listPet.get(i).getSize();
//                potentDangerous = listPet.get(i).isPotentDangerous();
//
//
//            }
//
//        }
//        id = manager.assignID(microchip, species, sex, size, potentDangerous, neighborhood);
//
//        return id;
//    }
}
