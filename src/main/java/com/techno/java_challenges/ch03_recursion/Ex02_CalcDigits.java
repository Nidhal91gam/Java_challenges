package com.techno.java_challenges.ch03_recursion;

public class Ex02_CalcDigits {
    private Ex02_CalcDigits()
    {
    }

    static int countDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("i must be >= 0");

        if (value < 10)
            return 1;

        final int remainder = value / 10;

        return countDigits(remainder) + 1;
    }

    static int calcSumOfDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("i must be >= 0");

        if (value < 10)
            return value;

        final int remainder = value / 10;
        final int lastDigit = value % 10;

        return calcSumOfDigits(remainder) + lastDigit;
    }
}
