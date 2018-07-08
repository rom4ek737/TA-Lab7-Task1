package com.epam.lab7.hw3.task4;

import java.util.ArrayList;
import java.util.List;

public class PrivateMethods {

    List<String> list = new ArrayList<>();

    private boolean isEvenNumber(int number) {
        boolean result = false;
        if (number % 2 == 0) {
            result = true;
        }
        return result;
    }

    private String myContains(String s) {
        return s + "My";
    }

    private boolean difference(int a, int b) {
        if (a > b)
            return true;
        else
            return false;
    }
}