package com.epam.lab7.p1;
/*Concrete Creators implement or override the base factory method, by creating and returning one of the AutoFactory*/

public class FordFactory extends AutoFactory {
    @Override
    public Auto createTheAuto() {
        return new Ford();
    }
}
