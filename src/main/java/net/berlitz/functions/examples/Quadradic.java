package net.berlitz.functions.examples;


public class Quadradic implements function {
    Integer parameterA;
    Integer parameterB;
    Integer parameterC;
    public Quadradic(int a, int b, int c) {
        parameterA = a;
        parameterB = b;
        parameterC = c;
    }

    @Override
    public Object call(Object... args) {
        return (parameterA * ((Integer) args[0]))^2 + (parameterB * ((int) args[0]))+ parameterC;
    }

    @Override
    public String getName() {
        return parameterA.toString() + "x^2" + '+' + parameterB.toString() + "x" + '+' + parameterC.toString();
    }
}
