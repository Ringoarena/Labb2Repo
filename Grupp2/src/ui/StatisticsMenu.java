package ui;

import model.EmployeeManagement;

class StatisticsMenu {
    private static boolean previous;

    static void runSubMenu() {
        previous = false;
        printHeader();

        while (!previous) {
            printMenu();
            performAction(Utilities.getMenuInput(0, 7));
        }
    }

    private static void printHeader() {
        System.out.println("\n+-----------------+");
        System.out.println("|Statistics Header|");
        System.out.println("+-----------------+");
    }

    private static void printMenu() {
        System.out.println("\nStatistics menu");
        System.out.println("1. Average wage");
        System.out.println("2. Maximum wage");
        System.out.println("3. Minimum wage");
        System.out.println("4. Total bonus");
        System.out.println("5. Percentage women");
        System.out.println("6. Percentage men per role");
        System.out.println("7. Average age");
        System.out.println("0. Return to previous menu");
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nReturning to previous menu...");
                previous = true;
                break;
            case 1:
                EmployeeManagement.displayAverageWage();
                break;
            case 2:
                EmployeeManagement.displayMaximumWage();
                break;
            case 3:
                EmployeeManagement.displayMinimumWage();
                break;
            case 4:
                EmployeeManagement.displayTotalBonus();
                break;
            case 5:
                EmployeeManagement.displayPercentageWomen();
                break;
            case 6:
                EmployeeManagement.displayPercentageMenPerRole();
                break;
            case 7:
                EmployeeManagement.displayAverageAge();
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
