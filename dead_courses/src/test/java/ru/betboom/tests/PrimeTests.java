package ru.betboom.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.betboom.Primes;

public class PrimeTests {

    @Test
    public void testPrimees() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrimees() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
