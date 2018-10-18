package com.tuliobar.processor;

/**
 *
 * Subclasse concreta para criar novo processor.
 *
 */
public class FizzProcessor implements Chain {

    private Chain nextChain;

    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    public String process(int number) {
        if(number % 3 == 0 || String.valueOf(number).contains("3")) {
            return "Fizz";
        } else {
            return this.nextChain.process(number);
        }
    }
}
