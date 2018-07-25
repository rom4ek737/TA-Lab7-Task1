package com.epam.lab7.presentation.factoryMethod;

public class TxtReader implements FileReader {
    private DecodedFile decodedFile;

    public TxtReader(String file) {
        this.decodedFile = new DecodedFile(file);
    }

    @Override
    public DecodedFile getDecodedFile() {
        return decodedFile;
    }
}
