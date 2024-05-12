package primeGenerator.API.src.primegenerator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PrimeGeneratorTest {

	
	@Test
    public void testPrimeNumbersBetween1And10() {
        PrimeGenerator primeGenerator = new PrimeGenerator(1, 10);
        List<Integer> primes = primeGenerator.generate("brute");
        assertEquals(List.of(2, 3, 5, 7), primes);
    }

    @Test
    public void testPrimeNumbersBetween10And20() {
        PrimeGenerator primeGenerator = new PrimeGenerator(10, 20);
        List<Integer> primes = primeGenerator.generate("sieve");
        assertEquals(List.of(11, 13, 17, 19), primes);
    }

    @Test
    public void testPrimeNumbersBetween20And30() {
        PrimeGenerator primeGenerator = new PrimeGenerator(20, 30);
        List<Integer> primes = primeGenerator.generate("trial");
        assertEquals(List.of(23, 29), primes);
    }

    @Test
    public void testPrimeNumbersBetweenNegativeRange() {
        PrimeGenerator primeGenerator = new PrimeGenerator(-10, -1);
        List<Integer> primes = primeGenerator.generate("brute");
        assertTrue(primes.isEmpty());
    }

    @Test
    public void testPrimeNumbersBetweenZeroAndTen() {
        PrimeGenerator primeGenerator = new PrimeGenerator(0, 10);
        List<Integer> primes = primeGenerator.generate("sieve");
        assertEquals(List.of(2, 3, 5, 7), primes);
    }

    @Test
    public void testPrimeNumbersBetweenLargeRange() {
        PrimeGenerator primeGenerator = new PrimeGenerator(1000, 1100);
        List<Integer> primes = primeGenerator.generate("brute");
        assertEquals(List.of(1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093,1097), primes);
    }

    

}
