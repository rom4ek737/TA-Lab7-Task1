package com.epam.lab7.presentation.templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPattern {
    public static void main(String[] args) throws IOException {
        SimpleText simpleText;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        if (name.equalsIgnoreCase("Roman")) {
            simpleText = new FirstUser();
        } else if (name.equalsIgnoreCase("Petro")) {
            simpleText = new SecondUser();
        } else throw new RuntimeException("User not found");
        simpleText.seeTheTrace(name);
    }
}