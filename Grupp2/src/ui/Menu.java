package ui;

import model.EmployeeManagement;
import model.employees.Employee;
import java.util.Comparator;

public class Menu {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain menu");
            System.out.println("1. Management");
            System.out.println("2. Statistics");
            System.out.println("3. Load database");
            System.out.println("0. Exit");
            switch (Utilities.getMenuInput(0, 3)) {
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
                case 3:
                    EmployeeManagement.loadDB();
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
            System.out.println("3. Update employee");
            System.out.println("4. Search menu");
            System.out.println("5. Display employees");
            System.out.println("6. Put employees to work");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 6)) {
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
                    runUpdateMenu();
                    break;
                case 4:
                    runSearchMenu();
                    break;
                case 5:
                    runSortMenu();
                    break;
                case 6:
                    EmployeeManagement.putToWork();
                    break;
                default:
                    System.out.println("\nUnknown error...");
            }
        }
    }

    private static void runSortMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nSort employees by:");
            System.out.println("1. Alphabetical order");
            System.out.println("2. Salary, ascending");
            System.out.println("3. Salary, descending");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 3)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    Comparator<Employee> alphabetical = (e1, e2) -> e1.getName().compareTo(e2.getName());
                    EmployeeManagement.getEmployeeDB().sort(alphabetical);
                    EmployeeManagement.displayAllEmployees();
                    break;
                case 2:
                    Comparator<Employee> ascending = (e1, e2) -> (int) (e1.getSalary()-e2.getSalary());
                    EmployeeManagement.getEmployeeDB().sort(ascending);
                    EmployeeManagement.displayAllEmployees();
                    break;
                case 3:
                    Comparator<Employee> descending = (e1, e2) -> (int) (e2.getSalary()-e1.getSalary());
                    EmployeeManagement.getEmployeeDB().sort(descending);
                    EmployeeManagement.displayAllEmployees();
                    break;
                default:
                    System.out.println("Unknown error...");
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

    public static void runUpdateMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nUpdate...");
            System.out.println("1. name of employee");
            System.out.println("2. DOB of employee");
            System.out.println("3. salary of employee");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 3)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    EmployeeManagement.updateNameByID();
                    break;
                case 2:
                    EmployeeManagement.updateDobByID();
                    break;
                case 3:
                    EmployeeManagement.updateSalaryByID();
                    break;
                default:
                    System.out.println("\nUnknown error...");
            }
        }
    }

    private static void runSearchMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nSearch menu");
            System.out.println("1. Search employee by name");
            System.out.println("2. Search employee by ID");
            System.out.println("3. Search employee by role");
            System.out.println("0. Return to previous menu");
            switch (Utilities.getMenuInput(0, 3)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    EmployeeManagement.searchByName();
                    break;
                case 2:
                    EmployeeManagement.searchByID();
                    break;
                case 3:
                    EmployeeManagement.searchByRole();
                    break;
                default:
            }
        }
    }
}