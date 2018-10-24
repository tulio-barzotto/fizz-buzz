package com.tuliobar;


import com.tuliobar.processor.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

    private Chain chain;

    private final String BUZZ = "Buzz";

    private final String FIZZBUZZ = "FizzBuzz";

    private final String FIZZ = "Fizz";

    @Before
    public void setUp() {
        chain = new FizzBuzzProcessor();
        FizzProcessor chain2 = new FizzProcessor();
        BuzzProcessor chain3 = new BuzzProcessor();
        DefaultProcessor chain4 = new DefaultProcessor();
        chain.setNext(chain2);
        chain2.setNext(chain3);
        chain3.setNext(chain4);
    }

    /**
     * Testando {@link BuzzProcessor} para que gere "Buzz" caso seja divisível
     * por 5 ou contenha 5 no número
     */
    @Test
    public void testBuzzProcess() {
        String processed;
        processed = chain.process(5);
        Assert.assertEquals(BUZZ, processed);
        processed = chain.process(50);
        Assert.assertEquals(BUZZ, processed);
        processed = chain.process(100);
        Assert.assertEquals(BUZZ, processed);
        processed = chain.process(52);
        Assert.assertEquals(BUZZ, processed);
        processed = chain.process(56);
        Assert.assertEquals(BUZZ, processed);
    }

    /**
     * Testando {@link DefaultProcessor} para que gere o próprio número caso não
     * seja divisível por 3 nem por 5.
     */
    @Test
    public void testDefaultProcess() {
        String processed;
        processed = chain.process(1);
        Assert.assertEquals("1", processed);
        processed = chain.process(47);
        Assert.assertEquals("47", processed);
        processed = chain.process(98);
        Assert.assertEquals("98", processed);
    }

    /**
     * Testando {@link FizzProcessor} para que gere "Fizz" caso seja divisível
     * por 3 ou contenha 3 no número
     */
    @Test
    public void testFizzProcess() {
        String processed;
        processed = chain.process(3);
        Assert.assertEquals(FIZZ, processed);
        processed = chain.process(54);
        Assert.assertEquals(FIZZ, processed);
        processed = chain.process(99);
        Assert.assertEquals(FIZZ, processed);
        processed = chain.process(13);
        Assert.assertEquals(FIZZ, processed);
        processed = chain.process(73);
        Assert.assertEquals(FIZZ, processed);
    }

    /**
     * Testando {@link FizzBuzzProcessor} para que gere "FizzBuzz" caso seja divisível
     * por 3 e por 5
     */
    @Test
    public void testFizzBuzzProcess() {
        String processed;
        processed = chain.process(15);
        Assert.assertEquals(FIZZBUZZ, processed);
        processed = chain.process(45);
        Assert.assertEquals(FIZZBUZZ, processed);
        processed = chain.process(90);
        Assert.assertEquals(FIZZBUZZ, processed);
    }

}