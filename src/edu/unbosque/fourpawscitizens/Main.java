package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main
 *
 * @author Miguel Sierra, Sergio Hernandez, Brayan Moreno
 */

public class Main {
    public static Manager manager;

    /**
     * Se genera el main con un mensaje de bienvenida
     * <b>pre</b>Se definen las especificaciones del mensaje<br>
     * <b>post</b>se crea el mensaje y se carga el archivo csv<br>
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        String green = "\033[32m";
        System.out.println(green + ".: Bienvenido al programa FourPawsCitizens:."
                + "\nSe trata de un programa que permite acceder y manipular datos de una lista de mascotas, cumpliendo unos requisitos básicos."
                + "\nA través de este menú elija la opción que necesita");
        manager = new Manager();
        manager.uploadData("src\\data\\pets-citizens.csv");

        int total = 0;
        for (int i = 0; i < manager.listPet.size(); i++) {
            total++;
        }
        System.out.println(green + "\nLa cantidad de archivos cargados es: " + total);
        menu();
    }

    /**
     * Se crea el menu de nuestro programa con los diferentes switch
     * <b>pre</b>Se generan las especificaciones del menu y los diferentes casos del switch<br>
     * <b>post</b>se crea el menu y los diferentes casos del switch <br>
     */
    private static void menu() {
        String yellow = "\033[33m";
        String blue = "\033[34m";
        String red = "\033[31m";
        String purple = "\033[35m";
        Scanner leer = new Scanner(System.in);
        try {

            System.out.println(blue +
                    "\n------------------------------ MENU -----------------------------"
                    + "\n1.Ver informacion de una mascota"
                    + "\n2.Generar iD de todas las mascotas"
                    + "\n3.Cuantos animales hay por specie"
                    + "\n4.Top animales potencialmente peligrosos en una localidad."
                    + "\n5.Buscar ID de mascota por parametros"
                    + "\n6.Imprimir todo"
                    + "\n7.Finalizar" +
                    "\n-----------------------------------------------------------------");
            int opcion1 = leer.nextInt();
            /** Se crea el switch
             * <b>pre</b>Se generan los case que va a tener el switch<br>
             * <b>post</b>se crean los case y sus respectivas funcionalidades<br>
             *
             */
            switch (opcion1) {
                /** Se crea el case 1
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>se busca la informacion de una mascota digitando el numero del microchip<br>
                 */
                case 1:
                    Scanner read = new Scanner(System.in);
                    try {

                        System.out.println("Ingrese microchip");
                        long microchip = read.nextLong();
                        System.out.println(yellow + manager.findByMicrochip(microchip));
                        menu();
                    } catch (NullPointerException e) {
                        System.out.println(red + "Por favor coloque valores correctos");
                        menu();
                    }
                    break;

                /**
                 *  Se crea el case 2
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>valida y general las ideas del caso de haber una repetida se le suma otro numero el microchip<br>
                 */
                case 2:
                    System.out.println(yellow + "Procesando...");
                    int amount = 3;
                    for (int j = 0; j < manager.listPet.size(); j++) {
                        String id = manager.assignID(manager.listPet.get(j).microchip, manager.listPet.get(j).species, manager.listPet.get(j).sex, manager.listPet.get(j).size, manager.listPet.get(j).potentDangerous, manager.listPet.get(j).neighborhood, amount);
                        for (int i = 0; i < manager.listPet.size(); i++) {
                            int auxAmount = amount;
                            if (id.equals(manager.listPet.get(i).id)) {
                                auxAmount++;
                                id = manager.assignID(manager.listPet.get(j).microchip, manager.listPet.get(j).species, manager.listPet.get(j).sex, manager.listPet.get(j).size, manager.listPet.get(j).potentDangerous, manager.listPet.get(j).neighborhood, auxAmount);
                            }
                        }
                        manager.listPet.get(j).setId(id);
                    }
                    System.out.println(yellow + "El proceso de asignación de ids ha finalizado");
                    menu();
                    break;
                /**
                 *  Se crea el case 3
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>valida y busca la informacion del numero de animales segun lo que se halla digitado<br>
                 */
                case 3:
                    read = new Scanner(System.in);
                    System.out.println("Ingrese el tipo de especie" +
                            "\nCANINO o FELINO");
                    String specie = read.nextLine().toUpperCase();

                    if (specie.equals("CANINO") || specie.equals("FELINO")) {
                        System.out.println(yellow + "El numero de animales de la especie " + specie.toUpperCase() + " es:" + manager.countBySpecies(specie.toUpperCase()));
                        menu();
                    } else {
                        System.out.println(red + "Ingrese solamente si es CANINO o FELINO");
                        menu();
                    }

                    break;
                /**
                 *  Se crea el case 4
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>valida el dato que se halla digitado para asi poder mostrar los datos del TOP U LAST de los datos ya almacenados<br>
                 */
                case 4:
                    Scanner entradas = new Scanner(System.in);
                    try {
                        System.out.println("Ingrese la localidad");
                        String localidad = entradas.nextLine();
                        System.out.println("Ingrese la cantidad de animales");
                        String numeroDeAnimales = entradas.nextLine();
                        System.out.println("TOP o LAST");
                        String posicion = entradas.nextLine();

                        manager.findBypotentDangerousInNeighborhood(Integer.parseInt(numeroDeAnimales), posicion, localidad);

                        for (int j = 0; j < manager.pets2.size(); j++) {

                            System.out.println(yellow + "\nID: " + manager.pets2.get(j).id +
                                    "\nSpecies: " + manager.pets2.get(j).species +
                                    "\nGender: " + manager.pets2.get(j).sex +
                                    "\nSize: " + manager.pets2.get(j).size +
                                    "\nPotentially Dangerous: " + manager.pets2.get(j).potentDangerous +
                                    "\nNeighborhood: " + manager.pets2.get(j).neighborhood);
                        }

                        menu();
                    } catch (NumberFormatException e) {
                        System.out.println(red + "Por favor ingrese valores validos");
                        menu();
                    }

                    break;
                /**
                 *  Se crea el case 5
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>valida y busca la ID segun unos datos en especifico<br>
                 */
                case 5:
                    String information = "";
                    read = new Scanner(System.in);
                    System.out.println(yellow + "Ingrese los siguientes datos:"
                            + "\nSexo, especie, tamaño, potencialmente peligroso" +
                            "\nEjemplo:CANINO,HEMBRA,MINIATURA,NO");
                    try {
                        information = read.nextLine();
                        String contador = "";
                        ArrayList<String> separador = new ArrayList();
                        for (int i = 0; i < 4; i++) {
                            contador = information.toUpperCase().split(",")[i];
                            separador.add(contador);
                        }
                        String species = separador.get(0);
                        String sex = separador.get(1);
                        String size = separador.get(2);
                        String potentDangerous = separador.get(3);
                        boolean peligrosidad;
                        peligrosidad = !potentDangerous.equals("NO");

                        manager.findByMultipleFields(sex, species, size, peligrosidad);
                        menu();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(red + "Por favor ingrese los valores como en el ejemplo");
                        menu();
                    }

                    break;

                /**
                 *  Se crea el case 6
                 * <b>pre</b>tener el metodo respectivo que se va a operar en este case<br>
                 * <b>post</b>Imprime todo los datos que hay en el csv<br>
                 */
                case 6:
                    for (int i = 0; i < manager.listPet.size(); i++) {
                        System.out.println(yellow + manager.listPet.get(i).id + ", " + manager.listPet.get(i).microchip +
                                ", " + manager.listPet.get(i).species + ", " + manager.listPet.get(i).sex + ", "
                                + manager.listPet.get(i).size + ", " + manager.listPet.get(i).potentDangerous +
                                ", " + manager.listPet.get(i).neighborhood);
                    }
                    menu();
                    break;

                /**
                 * Se crea el case 7
                 * <b>pre</b>tener claro el mensaje que se va a dar <br>
                 * <b>post</b>finaliza el programa dando un mensaje de despedida y agracedimientos<br>
                 */

                case 7:
                    System.out.println(purple + "Gracias por utilizar el programa FourPawsCitizens" +
                            "\nHasta la proxima.");
                    break;
                default:
                    System.out.println(red + "Por favor coloque el valor correctamente");
                    menu();
            }
        } catch (InputMismatchException e) {
            System.out.println(red + "Por favor coloque valores numericos enteros");
            menu();

        }

    }


}
