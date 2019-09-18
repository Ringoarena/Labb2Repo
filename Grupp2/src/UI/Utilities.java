package UI;

import java.util.Scanner;

public class Utilities {

    public static int getInput(int lowEnd, int highEnd) {
        Scanner sc = new Scanner(System.in);
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
}
