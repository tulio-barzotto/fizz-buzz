package com.tuliobar.processor;

/**
 *
 * Subclasse concreta para criar novo processor.
 *
 */
public class DefaultProcessor implements Chain {

    private Chain nextChain;

    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    public String process(int number) {
        return String.valueOf(number);
    }
}
