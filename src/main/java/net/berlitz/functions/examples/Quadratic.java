package net.berlitz.functions.examples;


public class Quadratic {
    static Integer parameterA;
    static Integer parameterB;
    static Integer parameterC;
    public Quadratic(int a, int b, int c) {
        parameterA = a;
        parameterB = b;
        parameterC = c;
    }

    public static Object call(Object... args) {
        return (parameterA * ((Integer) args[0]))^2 + (parameterB * ((int) args[0]))+ parameterC;
    }

    public String getName() {
        return parameterA.toString() + "x^2" + '+' + parameterB.toString() + "x" + '+' + parameterC.toString();
    }

    public static int fitnessMaximize(int Chromosome) {
        return ((Integer) call(Chromosome));
    }

    public static int fitnessMinimize(int Chromosome) {
        return -((Integer) call(Chromosome));
    }
}
