package com.techno.java_challenges.ch2_Mathematical_Problems;

import java.util.ArrayList;
import java.util.List;

public class Ex12_PrimeFactors {
    private Ex12_PrimeFactors()
    {
    }

    static List<Integer> calcPrimeFactors(final int n)
    {
        final List<Integer> primeFactors = new ArrayList<>();

        final List<Integer> allPrimes = calcPrimesUpTo(n);

        int remainingValue = n;

        // as long as even, divide by 2 again and again
        while (remainingValue % 2 == 0 && remainingValue >= 2)
        {
            remainingValue = remainingValue / 2;
            primeFactors.add(2);
        }

        if (isPrime(allPrimes, remainingValue))
        {
            primeFactors.add(remainingValue);
        }
        else
        {
            // remainder is not a prime number, further check
            while (remainingValue > 1)
            {
                for (final Integer currentPrime : allPrimes)
                {
                    if (remainingValue % currentPrime == 0)
                    {
                        remainingValue = remainingValue / currentPrime;
                        primeFactors.add(currentPrime);
                        // start again from the beginning, because every divisor
                        // may occur more than once
                        break;
                    }
                }
            }
        }

        return primeFactors;
    }

    static List<Integer> calcPrimeFactorsOptimized(final int n)
    {
        final List<Integer> allPrimes = calcPrimesUpTo(n);

        final List<Integer> primeFactors = new ArrayList<>();

        int remainingValue = n;
        while (remainingValue > 1)
        {
            for (final Integer currentPrime : allPrimes)
            {
                while (remainingValue % currentPrime == 0)
                {
                    remainingValue = remainingValue / currentPrime;
                    primeFactors.add(currentPrime);
                }
            }
        }
        return primeFactors;
    }

    private static boolean isPrime(final List<Integer> allPrimes, final int n)
    {
        return allPrimes.contains(n);
    }

    private static List<Integer> calcPrimesUpTo(final int n)
    {
        return Ex04_PrimeNumber.calcPrimesUpTo(n);
    }
}
