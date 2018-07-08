package com.epam.lab7.hw3.task5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class VoidMethods {
    ArrayList<String> list = new ArrayList<>();
    Boolean wasCreated = false;

    public void createFile() throws IOException {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("CreatedFile.txt");
            wasCreated = true;
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        file.close();
    }

    public void listElements() {
        list.add("Hello");
        list.add("Everybody");
        list.add("OK");
    }
}
