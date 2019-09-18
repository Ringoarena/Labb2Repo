package UI;

import model.EmployeeManagement;

public class MainMenu {
    private static boolean exit;

    public static void main(String[] args) {
        printHeader();
        EmployeeManagement.loadDB();
        while (!exit) {
            printMenu();
            performAction(Utilities.getInput(0, 2));
        }
    }

    private static void printHeader() {
        System.out.println("+---------------+");
        System.out.println("|  Main Header  |");
        System.out.println("+---------------+");
    }

    private static void printMenu() {
        System.out.println("\nMain menu");
        System.out.println("1. Management");
        System.out.println("2. Statistics");
        System.out.println("0. Exit");
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nTerminating process...");
                exit = true;
                break;
            case 1:
                ManagementMenu.runSubMenu();
                break;
            case 2:
                StatisticsMenu.runSubMenu();
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
