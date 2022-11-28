package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numberOfPrimes = 1000;

        PrimeNumberGenerator primeGenerator = new PrimeNumberGenerator(numberOfPrimes);
        int[] primes = primeGenerator.findPrimeNumbers();

        PrimeNumberPrinter primeNumberPrinter = new PrimeNumberPrinter(primes);
        primeNumberPrinter.printPrimeNumbers();
    }

}