package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Manager manager =new Manager();

            manager.uploadData("src\\data\\pets-citizens.csv");

    }
}
