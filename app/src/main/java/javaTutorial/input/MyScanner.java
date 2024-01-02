package javaTutorial.input;

import java.util.Scanner;

public class MyScanner {

    public static void main(String[] args) {
        int i = readInt("%s%n> ", "Enter a positive number");
        System.out.printf("You entered: %d", i);
        int j = readInt("%s: ", "Enter another number");
        System.out.printf("You entered: %d", j);
    }

    private static int readInt(String format, Object...args) {
        int number;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.printf(format, args);
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid Input, try again.");
                    System.out.printf(format, args);
                    sc.next();
                }
                number = sc.nextInt();
            } while (number < 0);
        }
        return number;
    }
}
