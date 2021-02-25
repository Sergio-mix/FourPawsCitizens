package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Manager manager;


    public static void main(String[] args) throws IOException {
        System.out.println(".: Bienvenido al programa FourPawsCitizens:."
                + "\nSe trata de un programa que permite acceder y manipular datos de una lista de mascotas, cumpliendo unos requisitos básicos."
                + "\nA través de este menú elija la opción que necesita");
        manager = new Manager();
        manager.uploadData("src\\data\\testCsv.csv");

        menu();
    }


    private static void menu() {

        Scanner leer = new Scanner(System.in);

        System.out.println(""
                + "\n1.Ver informacion de una mascota"
                + "\n2.Generar iD de todas las mascotas"
                + "\n3.Cuantos animales hay por specie"
                + "\n4.Número de animales potencialmente peligrosos en una localidad."
                + "\n5.Buscar mascota por ID"
                + "\n6.Imprimir todo"
                + "\n7.Finalizar");
        int opcion1 = leer.nextInt();
        switch (opcion1) {
            case 1:
                Scanner read = new Scanner(System.in);
                System.out.println("Ingrese microchip");
                long microchip= read.nextLong();
                System.out.println(manager.findByMicrochip(microchip));
                break;
            case 2:
                for (int j = 0; j < manager.listPet.size(); j++) {
                    String id = manager.assignID(manager.listPet.get(j).microchip, manager.listPet.get(j).species, manager.listPet.get(j).sex, manager.listPet.get(j).size, manager.listPet.get(j).potentDangerous, manager.listPet.get(j).neighborhood);
                    manager.listPet.get(j).setId(id);

                }
                for (int i = 0; i < manager.listPet.size(); i++) {
                    System.out.println(manager.listPet.get(i).id);
                }

                System.out.printf("“El proceso de asignación de ids ha finalizado");
                menu();
                break;
            case 3:
                read = new Scanner(System.in);
                System.out.print("Ingrese el tipo de especie"+
                        "\nCANINO o FELINO");
                String specie = read.nextLine();

                System.out.println(manager.countBySpecies(specie));



                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                for (int i = 0; i < manager.listPet.size(); i++) {
                    System.out.println(manager.listPet.get(i).id+", "+manager.listPet.get(i).microchip+
                            ", "+manager.listPet.get(i).species+", "+manager.listPet.get(i).sex+""
                            +manager.listPet.get(i).size+", "+manager.listPet.get(i).potentDangerous+
                            ", "+manager.listPet.get(i).neighborhood);
                }
                menu();

                break;

        }
    }


}
