package com.techno.java_challenges.ch2_Mathematical_Problems;

import java.util.Map;

public class Ex01_Basiscs {
    private Ex01_Basiscs()
    {
    }

    static int calc(final int n, final int m)
    {
        return n * m / 2 % 7;
    }

    static void calcSumAndCountAllNumbersDivBy_2_Or_7_Simple(final int max)
    {
        int count = 0;
        int sum = 0;

        for (int i = 1; i < max; i++)
        {
            final boolean divisibleBy2or7 = i % 2 == 0 || i % 7 == 0;
            if (divisibleBy2or7)
            {
                count++;
                sum += i;
            }
        }

        System.out.println("count: " + count);
        System.out.println("sum: " + sum);
    }

    enum ReturnCode {
        SUM, COUNT
    }

    public static Map<ReturnCode, Integer> calcSumAndCountAllNumbersDivBy_2_Or_7(final int max)
    {
        int count = 0;
        int sum = 0;

        for (int i = 1; i < max; i++)
        {
            final boolean divisibleBy2or7 = i % 2 == 0 || i % 7 == 0;
            if (divisibleBy2or7)
            {
                System.out.println(i);
                count++;
                sum += i;
            }
        }

        return Map.of(ReturnCode.SUM, sum, ReturnCode.COUNT, count);
    }

    static boolean isEven(final int n)
    {
        return n % 2 == 0;
    }

    static boolean isOdd(final int n)
    {
        return n % 2 != 0;
    }

    public static void main(String[] args) {

        calcSumAndCountAllNumbersDivBy_2_Or_7_Simple(5);

        System.out.println( calcSumAndCountAllNumbersDivBy_2_Or_7(5));

        System.out.println(isEven(5));

        System.out.println(isOdd(5));
    }
}
