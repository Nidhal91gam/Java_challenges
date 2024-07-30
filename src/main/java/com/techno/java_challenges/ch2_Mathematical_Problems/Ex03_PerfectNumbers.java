package com.techno.java_challenges.ch2_Mathematical_Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex03_PerfectNumbers {

    //perfect number, a positive integer that is equal to the sum of its proper divisors.
    // The smallest perfect number is 6, which is the sum of 1, 2, and 3. Other perfect numbers are 28, 496, and 8,128

    private Ex03_PerfectNumbers()
    {
    }

    static List<Integer> calcPerfectNumbers(final int maxExclusive)
    {
        final List<Integer> results = new ArrayList<>();

        for (int i = 2; i < maxExclusive; i++)
        {
            if (isPerfectNumberSimple(i))
                results.add(i);
        }

        return results;
    }
    static List<Integer> calcPerfectNumbersStreamBased(final int maxExclusive)
    {
        return IntStream.range(2, maxExclusive).
                filter(i -> isPerfectNumberSimple(i)).mapToObj(i -> i).toList();
    }

    static boolean isPerfectNumberSimple(final int number)
    {
        // always divisible by 1
        int sumOfMultipliers = 1;

        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                sumOfMultipliers += i;
            }
        }

        return sumOfMultipliers == number;
    }

    static boolean isPerfectNumberBasedOnProperDivisors(final int number)
    {
        final List<Integer> divisors = findProperDivisors(number);

        return divisors.stream().mapToInt(n -> n).sum() == number;
    }
    static List<Integer> findProperDivisors(final int value)
    {
        final List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= value / 2; i++)
        {
            if (value % i == 0)
            {
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static void main(String[] args) {

        System.out.println(isPerfectNumberSimple(6));

        System.out.println(isPerfectNumberSimple(28));

        System.out.println(calcPerfectNumbersStreamBased(29));
    }

}
