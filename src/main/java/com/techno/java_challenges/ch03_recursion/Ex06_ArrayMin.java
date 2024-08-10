package com.techno.java_challenges.ch03_recursion;

public class Ex06_ArrayMin {
    private Ex06_ArrayMin()
    {
    }

    static int min(final int[] values)
    {
        return min(values, 0, Integer.MAX_VALUE);
    }

    static int min(final int[] values, final int pos, int currentMin)
    {
        if (pos >= values.length)
            return currentMin;

        final int current = values[pos];
        if (current < currentMin)
            currentMin = current;

        return min(values, pos + 1, currentMin);
    }
}
