package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numberOfPrimes = 1000;
        int primes[];

        primes = findPrimeNumbers(numberOfPrimes);

        PrimeNumberPrinter primeNumberPrinter = new PrimeNumberPrinter(primes);
        primeNumberPrinter.printPrimeNumbers();
    }

    public static int[] findPrimeNumbers(int numberOfPrimes) {
        int primes[] = new int[numberOfPrimes+1];
        primes[1] = 2;

        final int ORDMAX = 30;
        int multiples[] = new int[ORDMAX+1];


        int candidate;
        candidate=1;

        int primeIndex;
        primeIndex=1;

        int ord;
        ord = 2;

        int square;
        square = 9;


        while (primeIndex < numberOfPrimes) {
            boolean possiblyPrime;
            do {
                candidate += 2;
                if( candidate == square) {
                    ord++;
                    square=primes[ord]*primes[ord];
                    multiples[ord-1]=candidate;
                }

                int n=2;
                possiblyPrime=true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n]<candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime=false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex]=candidate;
        }
        return primes;
    }

}