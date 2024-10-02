package net.berlitz.util;

public class BinaryConverter {
    public static double binToDec(String binaryString) {
        int intVal = Integer.parseInt(binaryString, 2);
        return -10 + (20.0 * intVal) / 31; // Use 20.0 to ensure floating-point division
    }
}