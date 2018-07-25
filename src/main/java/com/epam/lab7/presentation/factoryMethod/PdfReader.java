package com.epam.lab7.presentation.factoryMethod;

public class PdfReader implements FileReader {
    private DecodedFile decodedFile;

    public PdfReader(String file) {
        this.decodedFile = new DecodedFile(file);
    }

    @Override
    public DecodedFile getDecodedFile() {
        return decodedFile;
    }
}
