package UI;

import model.EmployeeManagement;

import java.util.Scanner;

public class ManagementMenu {
    private static boolean previous;
    private static Scanner sc = new Scanner(System.in);

    public static void runSubMenu() {
        previous = false;
        printHeader();

        while (!previous) {
            printMenu();
            performAction(Utilities.getInput(0, 9));
        }
    }

    private static void printHeader() {
        System.out.println("\n+-----------------+");
        System.out.println("|Management Header|");
        System.out.println("+-----------------+");
    }

    private static void printMenu() {
        System.out.println("\nManagement Menu");
        System.out.println("1. Register employee");
        System.out.println("2. Delete employee by ID");
        System.out.println("3. Update name of employee");
        System.out.println("4. Update DOB of employee");
        System.out.println("5. Update salary of employee");
        System.out.println("6. Search employee by name");
        System.out.println("7. Search employee by ID");
        System.out.println("8. Search employee by role");
        System.out.println("9. Display all employees");
        System.out.println("0. Return to previous menu");
    }

//    private static int getInput() {
//        int nDecision = 9;
//        int decision = -1;
//        while (!(0 <= decision && decision <= nDecision)) {
//            System.out.print("Enter decision: ");
//            try {
//                decision = Integer.parseInt(sc.nextLine());
//            } catch (NumberFormatException ignored) {}
//            if (!(0 <= decision && decision <= nDecision)) {
//                System.out.println("Illegal input, numbers from 0 to " + nDecision + " only!");
//            }
//        }
//        return decision;
//    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nReturning to previous menu...");
                previous = true;
                break;
            case 1:
                EmployeeManagement.addEmployee();
                break;
            case 2:
                EmployeeManagement.deleteEmployeeByID();
                break;
            case 3:
                EmployeeManagement.updateNameByID();
                break;
            case 4:
                EmployeeManagement.updateDobByID();
                break;
            case 5:
                EmployeeManagement.updateSalaryByID();
                break;
            case 6:
                EmployeeManagement.searchByName();
                break;
            case 7:
                EmployeeManagement.searchByID();
                break;
            case 8:
                EmployeeManagement.searchByRole();
                break;
            case 9:
                EmployeeManagement.displayAllEmployees();
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
