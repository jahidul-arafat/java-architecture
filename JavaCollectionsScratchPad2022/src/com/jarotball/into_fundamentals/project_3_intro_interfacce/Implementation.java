package com.jarotball.into_fundamentals.project_3_intro_interfacce;

public class Implementation implements Contract{

    @Override
    public void term1() {
        System.out.println("Into term1");
    }

    @Override
    public void term2() {
        System.out.println("Into term2");

    }

    @Override
    public void extendedTerm() {
        System.out.println("Into extendedTerm");
    }
}
