package com.techno.java_challenges.ch2_Mathematical_Problems;

public class Ex08_QuadraticSolver2_Improved_On2 {
    private Ex08_QuadraticSolver2_Improved_On2()
    {
    }

    public static void main(final String[] args) {
        // nested loops
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                final int c = (int) Math.sqrt(a * a + b * b);
                if (c < 100 && a * a + b * b == c * c) {
                    System.out.println("a = " + a + " / b = " + b + " / c = " + c);
                }
            }
        }
    }
}
