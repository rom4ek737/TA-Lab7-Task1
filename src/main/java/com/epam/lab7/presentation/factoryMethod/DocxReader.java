package com.epam.lab7.presentation.factoryMethod;

public class DocxReader implements FileReader {
    private DecodedFile decodedFile;

    public DocxReader(String file) {
        this.decodedFile = new DecodedFile(file);
    }

    @Override
    public DecodedFile getDecodedFile() {
        return decodedFile;
    }
}

