package com.tuliobar.processor;

/**
 *
 * Subclasse concreta para criar novo processor.
 *
 */
public class BuzzProcessor implements Chain {

    private Chain nextChain;

    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    public String process(int number) {
        if(number % 5 == 0) {
            return "Buzz";
        } else {
            return this.nextChain.process(number);
        }
    }
}
