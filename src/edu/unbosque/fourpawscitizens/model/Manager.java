package edu.unbosque.fourpawscitizens.model;

import com.opencsv.CSVReader;
import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.*;
import java.util.ArrayList;

public class Manager {

    public ArrayList<Pet> listPet;


    public Manager() {
        listPet = new ArrayList<Pet>();
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
//                System.out.println(Arrays.toString(nextLine));
                try{
                    boolean parametro;
                    parametro = nextLine[4].equals("SI");
                    Pet pet = new Pet("", Long.parseLong(nextLine[0]), nextLine[1], nextLine[2], nextLine[3], parametro, nextLine[5]);
                    listPet.add(pet);
                }catch (NumberFormatException e){
                    System.out.println(e);
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
    public String assignID(long microChip, String species, String sex, String size, boolean potentDangerous, String neighborhood) {
        String newMicroChip = microChip + "";
        String potentialDanger;
        int amount = 3;
        String newsMicroChip = newMicroChip.substring(newMicroChip.length() - amount);
        String newSpecies = species.substring(0, 1);
        String newSex = sex.substring(0, 1);
        String newSize = size.substring(0, 1);
        if (!potentDangerous) {
            potentialDanger = "F";
        } else {
            potentialDanger = "T";
        }
        String id = newsMicroChip + "-" + newSpecies + newSex + newSize + potentialDanger + "-" + neighborhood;
        return id.toUpperCase();
    }

//    public long findByMicrochip(String id){
//
//    }
//
//    public String countBySpecies(String species){
//
//    }
//
//    public List findBypotentDangerousInNeighborhood(String ){
//
//    }
//
//    public List findByMultipleFields(){
//
//    }

}

