package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Manager manager;

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        System.out.println(".: Bienvenido al programa FourPawsCitizens:."
                + "\nSe trata de un programa que permite acceder y manipular datos de una lista de mascotas, cumpliendo unos requisitos básicos."
                + "\nA través de este menú elija la opción que necesita");
        manager = new Manager();
        manager.uploadData("src\\data\\pets-citizens.csv");
        menu();
    }

    /**
     *
     */
    private static void menu() {

        Scanner leer = new Scanner(System.in);
try {
    System.out.println("" + "\nMENU: "+
            "\n-----------------------------------------------------------------"
            + "\n1.Ver informacion de una mascota"
            + "\n2.Generar iD de todas las mascotas"
            + "\n3.Cuantos animales hay por specie"
            + "\n4.Top animales potencialmente peligrosos en una localidad."
            + "\n5.Buscar ID de mascota por parametros"
            + "\n6.Imprimir todo"
            + "\n7.Finalizar" +
            "\n-----------------------------------------------------------------");
    int opcion1 = leer.nextInt();
    switch (opcion1) {
        case 1:
            Scanner read = new Scanner(System.in);
            try {

                System.out.println("Ingrese microchip");
                long microchip = read.nextLong();
                System.out.println(manager.findByMicrochip(microchip));
                menu();
                break;
            }catch (NullPointerException e){
                System.out.println("Por favor coloque valores correctos");
            }


        case 2:
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
            System.out.println("“El proceso de asignación de ids ha finalizado");
            menu();
            break;

        case 3:
            read = new Scanner(System.in);
            System.out.println("Ingrese el tipo de especie" +
                    "\nCANINO o FELINO");
            String specie = read.nextLine().toUpperCase();

            if(specie.equals("CANINO") || specie.equals("FELINO")){
                System.out.println("El numero de animales de la especie " + specie.toUpperCase() + " es:" + manager.countBySpecies(specie.toUpperCase()));
                menu();
            }else{
                System.out.println("Ingrese solamente si es CANINO o FELINO");
                menu();
            }

            break;

        case 4:
            Scanner entradas = new Scanner(System.in);
            System.out.println("Ingrese la localidad");
            String localidad = entradas.nextLine();
            System.out.println("Ingrese la cantidad de animales");
            String numeroDeAnimales = entradas.nextLine();
            System.out.println("TOP o LAST");
            String posicion = entradas.nextLine();

            System.out.println(manager.findBypotentDangerousInNeighborhood(Integer.parseInt(numeroDeAnimales), posicion, localidad));

            menu();
            break;

        case 5:
            String information = "";
            read = new Scanner(System.in);
            System.out.println("Ingrese los siguientes datos:"
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
                if (potentDangerous.equals("NO")) {
                    peligrosidad = false;
                } else {
                    peligrosidad = true;
                }

                manager.findByMultipleFields(sex, species, size, peligrosidad);
                menu();
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Por favor ingrese los valores como en el ejemplo");
                menu();
            }

            break;

        case 6:
            for (int i = 0; i < manager.listPet.size(); i++) {
                System.out.println(manager.listPet.get(i).id + ", " + manager.listPet.get(i).microchip +
                        ", " + manager.listPet.get(i).species + ", " + manager.listPet.get(i).sex + ", "
                        + manager.listPet.get(i).size + ", " + manager.listPet.get(i).potentDangerous +
                        ", " + manager.listPet.get(i).neighborhood);
            }
            menu();
            break;

        case 7:
            System.out.println("Gracias por utilizar el programa FourPawsCitizens" +
                    "\nHasta la proxima");
            break;
        default:
            System.out.println("Por favor coloque el valor correctamente");
            menu();
    }
}catch (InputMismatchException e){
    System.out.println("Por favor coloque valores numericos enteros");
    menu();

}

    }


}
