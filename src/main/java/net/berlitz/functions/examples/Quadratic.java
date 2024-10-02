package net.berlitz.functions.examples;

public class Quadratic {
    private static Integer parameterA;
    private static Integer parameterB;
    private static Integer parameterC;

    // Constructor to initialize parameters
    public Quadratic(int a, int b, int c) {
        parameterA = a;
        parameterB = b;
        parameterC = c;
    }

    // Call method to evaluate the quadratic function
    public static long call(double x) {
        return (long) ((parameterA * x * x) + (parameterB * x) + parameterC);
    }

    public String getName() {
        return parameterA + "x^2 + " + parameterB + "x + " + parameterC;
    }

    // Fitness functions
    public static long fitnessMaximize(double x) {
        return call(x); // Return the value of the quadratic function directly
    }

    public static long fitnessMinimize(double x) {
        return -call(x); // Return the negative for minimization
    }
}
