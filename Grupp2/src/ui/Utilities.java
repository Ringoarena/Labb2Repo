package ui;

import model.employees.GenderType;

import java.time.LocalDate;
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
                System.out.print("Ilegal input, enter an ID: ");
            }
        }
    }

    public static String fixLengthString(String string, int length) {
        if (string.length() >= length) {
            return string.substring(0, length);
        } else {
            while (string.length() < length) {
                string += " ";
            }
            return string;
        }
    }

    public static String fixLengthString(int integer, int length) {
        String string = String.valueOf(integer);
        return fixLengthString(string, length);
    }

    public static String fixLengthString(double d, int length) {
        String string = String.valueOf(d);
        return fixLengthString(string, length);
    }

    public static String fixLengthString(LocalDate localDate, int length) {
        String string = String.valueOf(localDate);
        return fixLengthString(string, length);
    }

    public static String fixLengthString(GenderType genderType, int length) {
        String string = String.valueOf(genderType);
        return fixLengthString(string, length);
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
