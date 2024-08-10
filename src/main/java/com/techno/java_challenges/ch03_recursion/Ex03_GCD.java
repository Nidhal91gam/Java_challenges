package com.techno.java_challenges.ch03_recursion;

public class Ex03_GCD {
    private Ex03_GCD()
    {
    }

    static int gcd(final int a, final int b)
    {
        if (b == 0)
            return a;

        final int remainder = a % b;

        return gcd(b, remainder);
    }

    static int gcdIterative(int a, int b)
    {
        while (b != 0)
        {
            final int remainder = a % b;
            a = b;
            b = remainder;
        }

        // b == 0
        return a;
    }

    static int lcm(final int a, final int b)
    {
        return a * b / gcd(a, b);
    }
}
