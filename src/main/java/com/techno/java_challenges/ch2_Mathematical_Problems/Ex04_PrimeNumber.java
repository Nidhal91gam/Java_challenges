package com.techno.java_challenges.ch2_Mathematical_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex04_PrimeNumber {
    //Prime numbers are numbers that have only 2 factors: 1 and themselves.
    // For example,the first 5 prime numbers are 2, 3, 5, 7, and 11. By contrast,
    // numbers with more than 2 factors are call composite numbers.

    private Ex04_PrimeNumber()
    {
    }

    static boolean isPrimeNumber (final int number){

        for( int i=2 ; i <= number /2 ; i++ ){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> calcPrimesUpTo(final int maxValue)
    {
        // initially mark all values as potential prime number
        final boolean[] isPotentiallyPrime = new boolean[maxValue + 1];
        Arrays.fill(isPotentiallyPrime, true);

        isPotentiallyPrime[0] = false;  // 0 n'est pas un nombre premier
        isPotentiallyPrime[1] = false;  // 1 n'est pas un nombre premier

        // run through all numbers starting at 2, optimization only up to half
        for (int i = 2; i <= maxValue / 2; i++)
        {
            if (isPotentiallyPrime[i])
            {
                // "erase" all multiples (always increase by the current number)
                eraseMultiplesOfCurrent(isPotentiallyPrime, i);
            }
        }

        // Get result ==> could be done directly in the loop above, but would be less
        // readable
        return buildPrimesList(isPotentiallyPrime);
    }

    static List<Integer> buildPrimesList(final boolean[] isPotentiallyPrime)
    {
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPotentiallyPrime.length; i++)
        {
            if (isPotentiallyPrime[i])
                primes.add(i);
        }
        return primes;
    }

    private static void eraseMultiplesOfCurrent(final boolean[] isPotentiallyPrime, final int i)
    {
        for (int n = i + i; n < isPotentiallyPrime.length; n = n + i)
        {
            isPotentiallyPrime[n] = false;
            // System.out.println("Eliminating " + n);
        }
    }

    public static void main(String[] args) {

        System.out.println( isPrimeNumber(11) );

        System.out.println(calcPrimesUpTo(20));
    }
}
