package com.epam.lab7.presentation.factoryMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFactoryMethod {
    private static final Logger logger = LogManager.getLogger(MyFactoryMethod.class);

    public static void main(String[] args) throws IOException {
        DecodedFile decodedFile;
        FileReader reader = null;
        logger.info("Please, input the file's name");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file = bufferedReader.readLine();
        String format = file.substring(file.indexOf('.') + 1, (file.length()));
        if (format.equals("pdf")) {
            reader = new PdfReader(file);
        }
        if (format.equals("txt")) {
            reader = new TxtReader(file);
        }
        if (format.equals("docx")) {
            reader = new DocxReader(file);
        }
        assert reader != null;
        decodedFile = reader.getDecodedFile();
        logger.info(decodedFile);
    }
}
