package com.epam.lab7.hw3.task3;

import java.util.ArrayList;
import java.util.List;

public class LoggerError {

    List<String> list = new ArrayList<>();

    public boolean isEvenNumber(int number) {
        boolean result = false;
        if (number % 2 == 0) {
            result = true;
        }
        return result;
    }

    public void myContains() {
        list.add("My");
        list.add("name");
        list.add("is");
        list.add("Roman");
    }

    public boolean difference(int a, int b) {
        if (a > b)
            return true;
        else
            return false;
    }
}