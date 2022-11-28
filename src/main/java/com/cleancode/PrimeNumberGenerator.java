package com.cleancode;

public class PrimeNumberGenerator {
    int primes[];
    int numberOfPrimes;
    private final int ORDMAX = 30;
    private int multiples[];

    private int ord;
    private int square;

    public PrimeNumberGenerator(int numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
        this.primes = new int[numberOfPrimes + 1];
        primes[1] = 2;
    }

    public int[] findPrimeNumbers() {
        multiples = new int[ORDMAX + 1];
        ord = 2;
        square = 9;

        int candidate = 1;
        for (int primeIndex=2; primeIndex <= numberOfPrimes;primeIndex++) {
            candidate = getNextPrimeNumber(candidate);
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    private int getNextPrimeNumber(int candidate) {
        boolean possiblyPrime = false;
        while (!possiblyPrime) {
            candidate = getCandidate(candidate);
            possiblyPrime = isPrimeNumber(candidate);
        }
        ;
        return candidate;
    }

    private int getCandidate(int candidate) {
        candidate += 2;
        if (candidate == square) {
            ord++;
            square = primes[ord] * primes[ord];
            multiples[ord - 1] = candidate;
        }
        return candidate;
    }

    private boolean isPrimeNumber(int candidate) {
        boolean possiblyPrime;
        int n = 2;
        possiblyPrime = true;
        while (n < ord && possiblyPrime) {
            while (multiples[n] < candidate)
                multiples[n] += primes[n] + primes[n];
            if (multiples[n] == candidate)
                possiblyPrime = false;
            n++;
        }
        return possiblyPrime;
    }

}