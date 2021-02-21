package edu.unbosque.fourpawscitizens.model;

import com.opencsv.CSVReader;
import edu.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {

    public ArrayList<Pet> listPet;
    public Pet pet;

    public Manager() {

        listPet = new ArrayList<Pet>();
        pet = new Pet();
    }

    /**
     *
     */
    public void uploadData(String file) throws IOException {
        char SEPARATOR = ';';
        final char QUOTE = '"';
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(file), SEPARATOR, QUOTE);
            String[] nextLine = null;

            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
    }

    /**
     *
     * @param microChip
     * @param species
     * @param sex
     * @param size
     * @param potentDangerous
     * @param neighborhood
     * @return
     */
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

    public long findByMicrochip(String id){

    }

    public String countBySpecies(String species){

    }

    public List findBypotentDangerousInNeighborhood(String ){

    }

    public List findByMultipleFields(){

    }

}

