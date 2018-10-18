package com.tuliobar;

public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        FizzBuzzSolve fizzBuzzSolve = new FizzBuzzSolve(1, 100);
        fizzBuzzSolve.solve();
    }
}
