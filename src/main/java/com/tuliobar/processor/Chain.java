package com.tuliobar.processor;

/**
 *
 * A interface contendo os métodos necessários para o design pattern Chain of Responsibility
 *
 */
public interface Chain {

    void setNext(Chain nextChain);
    String process(int number);
}
