package ui;

import java.util.Scanner;

public class Utilities {

    public static Scanner sc = new Scanner(System.in);

    public static int getMenuInput(int lowEnd, int highEnd) {
        int decision = -1;
        while (!(lowEnd <= decision && decision <= highEnd)) {
            System.out.print("Enter decision: ");
            try {
                decision = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ignored) {
            }
            if (!(lowEnd <= decision && decision <= highEnd)) {
                System.out.println("Illegal input, numbers from " + lowEnd + " to " + highEnd + " only!");
            }
        }
        return decision;
    }

    public static int getIntegerInput() throws NumberFormatException {
        while (true) {
            try {
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ilegal input");
            }
        }
    }

    public static String fixLength(String s, int l) {
        if (s.length() < l) {
            for (int i = s.length(); i < l + 1; i++) {
                s = s + " ";
            }
        } else if (s.length() > l) {
            return s.substring(0, l + 1);
        }
        return s;
    }
}
