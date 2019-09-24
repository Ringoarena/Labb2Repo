package ui;

import model.EmployeeManagement;

public class Menu {
    private static boolean exit;

    public static void main(String[] args) {
        while (!exit) {
            System.out.println("\nMain menu");
            System.out.println("1. Management");
            System.out.println("2. Statistics");
            System.out.println("0. Exit");
            switch (Utilities.getMenuInput(0, 2)) {
                case 0:
                    System.out.println("\nTerminating process...");
                    exit = true;
                    break;
                case 1:
                    runManagementMenu();
                    break;
                case 2:
                    runStatisticsMenu();
                    break;
                default:
                    System.out.println("\nUnknown error...");
            }
        }
    }

    private static void runManagementMenu() {
        boolean previous = false;
        while (!previous) {
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
            System.out.println("10. Put employees to work");
            System.out.println("11. Load database");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 11)) {
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
                case 10:
                    EmployeeManagement.putToWork();
                    break;
                case 11:
                    EmployeeManagement.loadDB();
                    break;
                default:
                    System.out.println("\nUnknown error...");
            }
        }
    }

    private static void runStatisticsMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nStatistics menu");
            System.out.println("1. Average wage");
            System.out.println("2. Maximum wage");
            System.out.println("3. Minimum wage");
            System.out.println("4. Total bonus");
            System.out.println("5. Percentage women");
            System.out.println("6. Percentage men per role");
            System.out.println("7. Average age");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 7)) {
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
}