package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numberOfPrimes = 1000;
        final int linesPerPage = 50;
        final int columns = 4;
        final int ORDMAX = 30;
        int primes[] = new int[numberOfPrimes+1];
        int pagenumber;
        int pageoffset;
        int rowoffset;
        int column;
        int candidate;
        int primeIndex;
        boolean possiblyPrime;
        int ord;
        int square;
        int n=0;
        int multiples[] = new int[ORDMAX+1];

        candidate=1;
        primeIndex=1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if( candidate == square) {
                    ord++;
                    square=primes[ord]*primes[ord];
                    multiples[ord-1]=candidate;
                }
                n=2;
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
        pagenumber = 1;
        pageoffset = 1;
        while (pageoffset <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(numberOfPrimes);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");
            for (rowoffset=pageoffset; rowoffset <= pageoffset+linesPerPage-1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
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