package com.cleancode;

public class PrimeNumbersPrinter {
    final int linesPerPage = 50;
    final int columns = 4;
    int pagenumber;
    int pageoffset;
    int numberOfPrimes;
    int[] primes;

    public PrimeNumbersPrinter(int[] primes) {
        this.primes = primes;
        numberOfPrimes = primes.length-1;
    }

    public void printPrimeNumbers() {
        pagenumber = 1;
        pageoffset = 1;

        while (existPrimes()) {
            printPage();
        }
    }

    private boolean existPrimes() {
        return pageoffset <= numberOfPrimes;
    }

    private void printPage() {
        printPageHead(numberOfPrimes, pagenumber);
        printPageBody();

        prepareNextPage();
    }

    private void printPageHead(int numberOfPrimes, int pagenumber) {
        System.out.print("The First ");
        System.out.print(numberOfPrimes);
        System.out.print(" Prime Numbers === Page ");
        System.out.print(pagenumber);
        System.out.println("\n");
    }

    private void printPageBody() {
        for (int rowoffset=pageoffset; rowoffset <= pageoffset+linesPerPage-1; rowoffset++) {
            printRow(rowoffset);
        }
        System.out.println("\f");
    }

    private void prepareNextPage() {
        pagenumber++;
        pageoffset += linesPerPage*columns;
    }

    private void printRow(int rowoffset) {
        for (int column = 0; column <= columns - 1; column++)
            if (rowoffset + column * linesPerPage <= numberOfPrimes)
                System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
        System.out.println();
    }

}