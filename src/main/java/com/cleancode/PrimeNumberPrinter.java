package com.cleancode;

public class PrimeNumberPrinter {
    final int linesPerPage = 50;
    final int columns = 4;
    int pagenumber;
    int pageoffset;
    int numberOfPrimes;
    int[] primes;

    public PrimeNumberPrinter(int[] primes) {
        this.primes = primes;
        numberOfPrimes = primes.length-1;
    }

    public void printPrimeNumbers() {
        pagenumber = 1;
        pageoffset = 1;

        while (pageoffset <= numberOfPrimes) {
            printPageHead(numberOfPrimes, pagenumber);

            for (int rowoffset=pageoffset; rowoffset <= pageoffset+linesPerPage-1; rowoffset++) {
                printRow(rowoffset);
            }
            System.out.println("\f");

            pagenumber++;
            pageoffset += linesPerPage*columns;

        }
    }

    private void printRow(int rowoffset) {
        for (int column = 0; column <= columns - 1; column++)
            if (rowoffset + column * linesPerPage <= numberOfPrimes)
                System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
        System.out.println();
    }

    public static void printPageHead(int numberOfPrimes, int pagenumber) {
        System.out.print("The First ");
        System.out.print(numberOfPrimes);
        System.out.print(" Prime Numbers === Page ");
        System.out.print(pagenumber);
        System.out.println("\n");
    }
}