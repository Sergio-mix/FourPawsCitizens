package edu.unbosque.fourpawscitizens.model;

import com.opencsv.CSVReader;
import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**Clase Manager
 * @author Miguel Sierra, Sergio Hernandez, Brayan Moreno
 */

/**Se crean nuestras dos listas ambas de tipo Pet para alamacenar los diferente datos
 * <b>pre</b>debe existir la clase Pet para poder crear estos tipos de arraylist br>
 * <b>post</b>se crean los dos arraylist tipo Pet <br>
 */
public class Manager {

    public ArrayList<Pet> listPet;
    public ArrayList<Pet> pets2;

    /**
     * Se crea el constructor de Manager
     * <b>pre</b>Debe existir la clase Manager.<br>
     * <b>post</b>Se genera el constructor de Manager<br>
     */
    public Manager() {

    }

    /**Se crea el metodo para subir los datos
     * <b>pre</b>Debe existir la lista que va a almacenar los datos del archivo cvs<br>
     * <b>post</b>Se suben los datos del cvs al arraylist "listPet"<br>
     * @param file
     * @throws IOException
     */
    public void uploadData(String file) throws IOException {
        listPet = new ArrayList<Pet>();
        char SEPARATOR = ';';
        final char QUOTE = '"';
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(file), SEPARATOR, QUOTE);
            String[] nextLine = null;
            while ((nextLine = reader.readNext()) != null) {
                try {
                    boolean parametro = nextLine[4].equals("SI");

                    String nextLine2 = nextLine[0];
                    String nextLine3 = nextLine[1];
                    String nextLine4 = nextLine[2];
                    String nextLine5 = nextLine[3];
                    String nextLine6 = nextLine[5];

                    if (!nextLine2.equals("SIN IDENTIFICAR")
                            && !nextLine3.equals("SIN IDENTIFICAR")
                            && !nextLine4.equals("SIN IDENTIFICAR")
                            && !nextLine5.equals("SIN IDENTIFICAR")
                            && !nextLine6.equals("SIN IDENTIFICAR")) {
                        Pet pet = new Pet("NO-ID", Long.parseLong(nextLine[0]), nextLine[1], nextLine[2], nextLine[3], parametro, nextLine[5]);
                        listPet.add(pet);
                    }
                } catch (NumberFormatException e) {
                    e.getSuppressed();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (null != reader) {
            reader.close();
        }
    }


    /**Se crea el metodo para asignar ID
     * <b>pre</b>Recibir los valores de entrada que van a conformar ese ID<br>
     * <b>post</b>Se genera los ID con unas modificaciones y uniones de los valores de entradav<br>
     * @param microChip
     * @param species
     * @param sex
     * @param size
     * @param potentDangerous
     * @param neighborhood
     * @param amount
     * @return
     */
    public String assignID(long microChip, String species, String sex, String size, boolean potentDangerous, String neighborhood, int amount) {
        String id = "";
        try {
            String newMicroChip = microChip + "";
            String potentialDanger;
            String newsMicroChip = newMicroChip.substring(newMicroChip.length() - amount);
            String newSpecies = species.substring(0, 1);
            String newSex = sex.substring(0, 1);
            String newSize = size.substring(0, 1);
            if (!potentDangerous) {
                potentialDanger = "F";
            } else {
                potentialDanger = "T";
            }
            id = newsMicroChip + "-" + newSpecies + newSex + newSize + potentialDanger + "-" + neighborhood;

            for (Pet pet : listPet) {
                if (id.equals(pet.id)) {
                    amount = amount + 1;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id.toUpperCase();
    }

    /**Se crea el metodo buscar por microchip
     * <b>pre</b>Recibir los valores de entrada tipo long que va a ser el microchip<br>
     * <b>post</b>Se muestra en pantalla el resultado de la busqueda que en este caso es todos los datos del animal<br>
     * @param microchip
     * @return
     */
    public String findByMicrochip(long microchip) {
        String mensaje = "";
        String id = null;
        String sex = null;
        String neighborhood = null;
        String species = null;
        String size = null;
        boolean potentDangerous = false;
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).microchip == microchip) {
                species = listPet.get(i).species;
                id = listPet.get(i).id;
                size = listPet.get(i).size;
                neighborhood = listPet.get(i).neighborhood;
                potentDangerous = listPet.get(i).potentDangerous;
                sex = listPet.get(i).sex;

            }
        }
        if (!id.equals(null) && !species.equals(null)) {
            mensaje = "ID: " + id +
                    "\nSpecies: " + species +
                    "\nGender: " + sex +
                    "\nSize: " + size +
                    "\nPotentially Dangerous: " + potentDangerous +
                    "\nNeighborhood: " + neighborhood;
        } else {
            mensaje = "No se encontraron mascotas, por favor verifique el microchip";
        }

        return mensaje;
    }

    /**se crea el metodo countBySpecies
     * <b>pre</b>Recibir los valores de tipo string que va a ser species para asi poder encontrar cuantos hay de esa especie<br>
     * <b>post</b>Se muestra en pantalla el numero de animales que hay de esa especie<br>
     * @param species
     * @return
     */
    public int countBySpecies(String species) {
        int cont = 0;
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).species.equals(species)) {
                species = listPet.get(i).species;
                cont++;
            }
        }
        return cont;
    }

    /**se crea el metodo findBypotentDangerousInNeighborhood
     * <b>pre</b>Recibir los valores de tipo string y int los cuales nos van a idicar si el usuario que saber si los primeros datos o los ultimos segun el int que digite<br>
     * <b>post</b>Se muestra en pantalla los datos extraidos de la lista tipo Pet segun lo digitado por el usuario<br>
     * @param n
     * @param top
     * @param neighborhood
     * @return
     */
    public ArrayList<Pet> findBypotentDangerousInNeighborhood(int n, String top, String neighborhood) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets2 = new ArrayList<>();
        String id = null;
        String sex = null;
        long micro = 0;
        String neighborhood1 = null;
        String species = null;
        String size = null;
        boolean potentDangerous = true;
        boolean condicion = true;

        for (Pet pet : listPet) {
            if (pet.potentDangerous && pet.neighborhood.equals(neighborhood.toUpperCase())) {
                species = pet.species;
                id = pet.id;
                micro = pet.microchip;
                size = pet.size;
                neighborhood1 = pet.neighborhood;
                potentDangerous = pet.potentDangerous;
                sex = pet.sex;
                condicion = true;
                Pet pett = new Pet(id, micro, species, sex, size, potentDangerous, neighborhood1);
                pets.add(pett);
            } else {
                condicion = false;
            }
        }

        System.out.println(condicion);
        if (top.toUpperCase().equals("TOP")) {
            for (int i = 0; i < n; i++) {
                species = pets.get(i).species;
                id = pets.get(i).id;
                micro = pets.get(i).microchip;
                size = pets.get(i).size;
                neighborhood1 = pets.get(i).neighborhood;
                potentDangerous = pets.get(i).potentDangerous;
                sex = pets.get(i).sex;
                Pet pett = new Pet(id, micro, species, sex, size, potentDangerous, neighborhood1);
                pets2.add(pett);
            }
        }


        if (top.toUpperCase().equals("LAST")) {
            Collections.reverse(listPet);
            for (int i = 0; i < n; i++) {
                species = pets.get(i).species;
                id = pets.get(i).id;
                micro = pets.get(i).microchip;
                size = pets.get(i).size;
                neighborhood1 = pets.get(i).neighborhood;
                potentDangerous = pets.get(i).potentDangerous;
                sex = pets.get(i).sex;
                Pet pett = new Pet(id, micro, species, sex, size, potentDangerous, neighborhood1);
                pets2.add(pett);
            }
        }


        return pets2;
    }

    /**se crea el metodo findByMultipleFields
     * <b>pre</b>Recibir los valores de tipo string y boolean para poder buscar el ID de la mascota segun unos parametros<br>
     * <b>post</b>Se muestra en pantalla el ID segun los parametros digitados por el usuario<br>
     * @param sex
     * @param species
     * @param size
     * @param potentDangerous
     */
    public void findByMultipleFields(String sex, String species, String size, boolean potentDangerous) {
        String id = "";
        String yellow = "\033[33m";
        String red = "\033[31m";
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).sex.equals(sex) && listPet.get(i).species.equals(species)
                    && listPet.get(i).size.equals(size) && listPet.get(i).potentDangerous == potentDangerous) {

                id = listPet.get(i).id;
                if (!id.equals("NO-ID")) {
                    System.out.println(yellow + id);
                } else {
                    System.out.println(red + "No se encontraron ID, verifique que anteriormente se hayan creado");
                    break;
                }

            }
        }
    }
}

