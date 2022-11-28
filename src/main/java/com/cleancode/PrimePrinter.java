package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numberOfPrimes = 1000;
        int primes[];

        primes = findPrimeNumbers(numberOfPrimes);

        printPrimeNumbers(numberOfPrimes, primes);
    }

    private static int[] findPrimeNumbers(int numberOfPrimes) {
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

    private static void printPrimeNumbers(int numberOfPrimes, int[] primes) {
        final int linesPerPage = 50;
        final int columns = 4;

        int pagenumber;
        int pageoffset;
        pagenumber = 1;
        pageoffset = 1;

        while (pageoffset <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(numberOfPrimes);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");

            for (int rowoffset=pageoffset; rowoffset <= pageoffset+linesPerPage-1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfPrimes)
                        System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage*columns;

        }
    }
}