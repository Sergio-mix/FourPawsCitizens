package edu.unbosque.fourpawscitizens.model;

import com.opencsv.CSVReader;
import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {

    public ArrayList<Pet> listPet;


    public Manager() {

    }

    /**
     *
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
                    Pet pet = new Pet("NO-ID", Long.parseLong(nextLine[0]), nextLine[1], nextLine[2], nextLine[3], parametro, nextLine[5]);
                    listPet.add(pet);
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


    /**
     * @param microChip
     * @param species
     * @param sex
     * @param size
     * @param potentDangerous
     * @param neighborhood
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

        mensaje = "ID: " + id +
                "\nSpecies: " + species +
                "\nGender: " + sex +
                "\nSize: " + size +
                "\nPotentially Dangerous: " + potentDangerous +
                "\nNeighborhood: " + neighborhood;
        return mensaje;
    }


    public int countBySpecies(String species){

        int cont=0;

        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).species.equals(species)) {
                species = listPet.get(i).species;
                cont++;


            }
        }


        return cont;


    }

    //
//    public List findBypotentDangerousInNeighborhood(String ){
//
//    }
//
    public void findByMultipleFields(String sex, String species, String size, boolean potentDangerous) {
        String mensaje;
        String id = "";
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).sex.equals(sex) && listPet.get(i).species.equals(species)
                    && listPet.get(i).size.equals(size) && listPet.get(i).potentDangerous == potentDangerous) {
                id = listPet.get(i).id;
                System.out.println(id);

            }
        }



    }

    public ArrayList<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(ArrayList<Pet> listPet) {
        this.listPet = listPet;
    }
}

