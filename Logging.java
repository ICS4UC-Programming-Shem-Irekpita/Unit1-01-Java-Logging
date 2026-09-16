package com.example; // Replace or remove package line if not using packages

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program calculates the maximum number of maple wood logs a logging
 * truck can carry based on a user-specified log length. Maple wood weighs
 * 20 kg/m, and the truck has a strict weight capacity limit of 1,100 kg.
 *
 * @author Shem Irekpita
 * @version 1.0
 * @since 2026-09-15
 */
public final class Logging {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private Logging() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Main entry point of the program.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final double maxCapacity = 1100.0;
        final double weightPerMeter = 20.0;

        System.out.print("Please enter the length of the maple log ");
        System.out.print("in meters. Note that the length can ");
        System.out.println("only be 0.25, 0.5, or 1 meter. Only: ");

        try {
            final double length = sc.nextDouble();

            if (length < 0) {
                System.out.println("Error: Length cannot be negative.");
            } else if (length == 0) {
                System.out.println("The logs length cannot be 0.");
            } else if (length == 0.25 || length == 0.5 || length == 1.0) {
                final double weightPerLog = weightPerMeter * length;
                final double maxLogs = maxCapacity / weightPerLog;
                System.out.println("The maximum number of logs the truck "
                        + "can carry is: " + (int) maxLogs);
            } else {
                System.out.println("Error: Length must be either "
                        + "0.25, 0.5, or 1 meter.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid numeric "
                    + "value for the length.");
        } finally {
            sc.close();
        }
    }
}
