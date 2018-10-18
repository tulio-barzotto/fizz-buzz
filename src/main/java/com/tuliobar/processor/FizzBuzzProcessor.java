package com.tuliobar.processor;

/**
 *
 * Subclasse concreta para criar novo processor.
 *
 */
public class FizzBuzzProcessor implements Chain {

    private Chain nextChain;

    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    public String process(int number) {
        if(number % 15 == 0) {
            return "FizzBuzz";
        } else {
            return this.nextChain.process(number);
        }
    }
}
