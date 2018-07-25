package com.epam.lab7.presentation.factoryMethod;

public class DecodedFile {
    private String file;

    public DecodedFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return file + ": is decoded";
    }
}
