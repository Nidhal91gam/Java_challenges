package com.techno.java_challenges.ch2_Mathematical_Problems;

import java.util.ArrayList;
import java.util.List;

public class Ex10_MaxChangeCalculator {
    private Ex10_MaxChangeCalculator()
    {
    }

    static int calcMaxPossibleChange(final List<Integer> values)
    {
        final List<Integer> sortedNumberx = new ArrayList<>(values);
        sortedNumberx.sort(Integer::compareTo);

        int maxPossibleChange = 0;

        for (int currentValue : sortedNumberx)
        {
            if (currentValue > maxPossibleChange + 1)
                break;

            maxPossibleChange += currentValue;
        }

        return maxPossibleChange;
    }
}
