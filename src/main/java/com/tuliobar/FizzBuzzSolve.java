package com.tuliobar;

import com.tuliobar.processor.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzzSolve {

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzSolve.class);
    private int initialNumber;
    private int finalNumber;
    private Chain chain;

    /**
     * Cria uma instancia de <code>FizzBuzzSolve</code> a qual irá utilziar <code>chain</code> para processar
     * os valores.
     * <code>FizzBuzzSolve</code> possui a instanciação de todos Processors {@link Chain} que serão utilizados.
     * @param initialNumber é o valor inicial da iteração
     * @param finalNumber é o valor final da iteração
     */
    public FizzBuzzSolve(int initialNumber, int finalNumber) {
        if(initialNumber < 0 || finalNumber < 0) {
            throw new IllegalArgumentException("Não é permitido número negativo.");
        }
        if(finalNumber < initialNumber) {
            throw new IllegalArgumentException("O valor final deve ser superior ao inicial.");
        }
        if(initialNumber == finalNumber) {
            throw new IllegalArgumentException("Não é permitido que os valores sejam iguais.");
        }
        this.initialNumber = initialNumber;
        this.finalNumber = finalNumber;
        chain = new FizzBuzzProcessor();
        FizzProcessor chain2 = new FizzProcessor();
        BuzzProcessor chain3 = new BuzzProcessor();
        DefaultProcessor chain4 = new DefaultProcessor();
        chain.setNext(chain2);
        chain2.setNext(chain3);
        chain3.setNext(chain4);
    }

    public void solve() {
        for(int count = initialNumber; count <= finalNumber; count++) {
            String processed = chain.process(count);
            LOGGER.info("{}", processed);
        }
    }
}
