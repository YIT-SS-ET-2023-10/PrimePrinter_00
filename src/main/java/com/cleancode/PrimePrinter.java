package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numberOfPrimes = 1000;

        PrimeNumberGenerator primeGenerator = new PrimeNumberGenerator(numberOfPrimes);
        int[] primes = primeGenerator.generatePrimes();

        PrimeNumbersPrinter primeNumbersPrinter = new PrimeNumbersPrinter(primes);
        primeNumbersPrinter.printPrimeNumbers();
    }

}