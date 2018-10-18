package com.tuliobar;


import org.junit.Test;

public class FizzBuzzSolveTest {

    private FizzBuzzSolve fizzBuzzSolve;

    /**
     * Testando {@link FizzBuzzSolve} para que lançe exceção caso pelo menos um dos
     * parâmetros seja negativo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSolveWithParamNegative(){
        fizzBuzzSolve = new FizzBuzzSolve(-1, 10);
        fizzBuzzSolve = new FizzBuzzSolve(-10, -5);
    }

    /**
     * Testando {@link FizzBuzzSolve} para que lançe exceção caso parâemtro inicial
     * seja maior do que o final.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSolveWithParamInitialGreaterThanFinal(){
        fizzBuzzSolve = new FizzBuzzSolve(100, 1);
    }

    /**
     * Testando {@link FizzBuzzSolve} para que lançe exceção caso os parâmetros
     * sejam iguais.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSolveWithParamEquals(){
        fizzBuzzSolve = new FizzBuzzSolve(100, 100);
        fizzBuzzSolve = new FizzBuzzSolve(1, 1);
        fizzBuzzSolve = new FizzBuzzSolve(0, 0);
    }

}