package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        long microChip= 123456789;
        String species="FELINO";
        String sex ="MACHO";
        String size ="GRANDE";
        boolean potentDangerous = true;
        String neighborhood= "USAQUEN";
        String newMicroChip = microChip + "";
        String newsMicroChip = newMicroChip.substring(1, 5);
        String newSpecies = species.substring(0, 1);
        String newSex = sex.substring(0, 1);
        String newSize = size.substring(0, 1);
        String newPotentDangerous = potentDangerous + "";
        String newsPotentDangerous = newPotentDangerous.substring(0, 1);

        String id = newsMicroChip+"-" + newSpecies + newSex +newSize+ newsPotentDangerous.toUpperCase() + "-" + neighborhood;
        System.out.println(id);
    }
}
