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
     * por 5.
     */
    @Test
    public void testBuzzProcess() {
        String processed;
        processed = chain.process(5);
        Assert.assertEquals(processed, BUZZ);
        processed = chain.process(50);
        Assert.assertEquals(processed, BUZZ);
        processed = chain.process(100);
        Assert.assertEquals(processed, BUZZ);
    }

    /**
     * Testando {@link DefaultProcessor} para que gere o próprio número caso não
     * seja divisível por 3 nem por 5.
     */
    @Test
    public void testDefaultProcess() {
        String processed;
        processed = chain.process(1);
        Assert.assertEquals(processed, "1");
        processed = chain.process(47);
        Assert.assertEquals(processed, "47");
        processed = chain.process(98);
        Assert.assertEquals(processed, "98");
    }

    /**
     * Testando {@link FizzProcessor} para que gere "Fizz" caso seja divisível
     * por 3
     */
    @Test
    public void testFizzProcess() {
        String processed;
        processed = chain.process(3);
        Assert.assertEquals(processed, FIZZ);
        processed = chain.process(54);
        Assert.assertEquals(processed, FIZZ);
        processed = chain.process(99);
        Assert.assertEquals(processed, FIZZ);
    }

    /**
     * Testando {@link FizzBuzzProcessor} para que gere "FizzBuzz" caso seja divisível
     * por 3 e por 5
     */
    @Test
    public void testFizzBuzzProcess() {
        String processed;
        processed = chain.process(15);
        Assert.assertEquals(processed, FIZZBUZZ);
        processed = chain.process(45);
        Assert.assertEquals(processed, FIZZBUZZ);
        processed = chain.process(90);
        Assert.assertEquals(processed, FIZZBUZZ);
    }

}