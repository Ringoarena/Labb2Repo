package model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;

import model.employees.Bartender;
import model.employees.Chef;
import model.employees.Employee;
import model.employees.GenderType;
import model.employees.HR;
import model.employees.Manager;
import model.employees.Waiter;
import model.exception.EmployeeNotFoundException;
import ui.Utilities;

public class EmployeeManagement {

    private static ArrayList<Employee> employeeDB = new ArrayList<>();

    public static ArrayList<Employee> getEmployeeDB() {
        return employeeDB;
    }

    public static void loadDB() {
        employeeDB.add(new Waiter("Rikard", LocalDate.of(1990, 9, 25), GenderType.MALE));
        employeeDB.add(new Waiter("Pelle", LocalDate.of(1992, 2, 12), GenderType.MALE));
        employeeDB.add(new Waiter("Maja", LocalDate.of(1989, 9, 25), GenderType.FEMALE));
        employeeDB.add(new Waiter("Anna", LocalDate.of(1993, 9, 25), GenderType.FEMALE));
        employeeDB.add(new Waiter("Sara", LocalDate.of(1987, 9, 25), GenderType.FEMALE));
        employeeDB.add(new Waiter("Emma", LocalDate.of(1986, 9, 25), GenderType.FEMALE));

        employeeDB.add(new Chef("Johannes", LocalDate.of(1991, 9, 25), GenderType.MALE));
        employeeDB.add(new Chef("Peter", LocalDate.of(1989, 9, 25), GenderType.MALE));
        employeeDB.add(new Chef("Tina", LocalDate.of(1991, 9, 25), GenderType.FEMALE));

        employeeDB.add(new Bartender("Mattias", LocalDate.of(1985, 9, 25), GenderType.MALE));
        employeeDB.add(new Bartender("Sam", LocalDate.of(1987, 3, 25), GenderType.MALE));
        employeeDB.add(new Bartender("Lina", LocalDate.of(1991, 5, 25), GenderType.FEMALE));

        employeeDB.add(new Manager("Göran", LocalDate.of(1964, 9, 25), GenderType.MALE));
        employeeDB.add(new Manager("Simon", LocalDate.of(1975, 9, 25), GenderType.MALE));

        employeeDB.add(new HR("Gunnel", LocalDate.of(1962, 9, 25), GenderType.FEMALE));
        employeeDB.add(new HR("Berit", LocalDate.of(1965, 9, 25), GenderType.FEMALE));
        employeeDB.add(new HR("Sören", LocalDate.of(1968, 9, 25), GenderType.MALE));
        System.out.println("\nLoading database...");
    }

    public static void addEmployee() {
        String name;
        LocalDate dob;
        GenderType newEmployeeGender = null;
        Employee newEmployee = null;

        System.out.print("\nEnter employee name ");
        name = Utilities.sc.nextLine();
        while (true) {
            try {
                System.out.print("Enter DOB (yyyy-mm-dd) ");
                String s = Utilities.sc.nextLine();
                dob = LocalDate.parse(s);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Illegal input!");
            }
        }
        System.out.println("\nEnter employee gender");
        System.out.println("1. Female");
        System.out.println("2. Male");
        System.out.println("3. Other");
        switch (Utilities.getMenuInput(1, 3)) {
            case 1:
                newEmployeeGender = GenderType.FEMALE;
                break;
            case 2:
                newEmployeeGender = GenderType.MALE;
                break;
            case 3:
                newEmployeeGender = GenderType.OTHER;
                break;
            default:
                System.out.println("Unknown error");
                break;
        }
        System.out.println("\nEnter employee role");
        System.out.println("1. Manager");
        System.out.println("2. HR");
        System.out.println("3. Chef");
        System.out.println("4. Bartender");
        System.out.println("5. Waiter");
        switch (Utilities.getMenuInput(1, 5)) {
            case 1:
                newEmployee = new Manager(name, dob, newEmployeeGender);
                break;
            case 2:
                newEmployee = new HR(name, dob, newEmployeeGender);
                break;
            case 3:
                newEmployee = new Chef(name, dob, newEmployeeGender);
                break;
            case 4:
                newEmployee = new Bartender(name, dob, newEmployeeGender);
                break;
            case 5:
                newEmployee = new Waiter(name, dob, newEmployeeGender);
                break;
            default:
                System.out.println("Unknown error!");
        }
        employeeDB.add(newEmployee);
        System.out.println("\nEmployee added: " + newEmployee.getName());
    }

    public static void displayAllEmployees() {
        printHeader();
        for (Employee emp : employeeDB) {
            System.out.println(emp.toString());
        }
    }

    public static void deleteEmployeeByID() {
        Employee temp;

        System.out.print("\nEnter the ID of the employee: ");
        int id = Utilities.getIntegerInput();
        try {
            temp = getEmployeeByID(id);
            employeeDB.remove(temp);
            System.out.println("\nEmployee removed: "+temp.getName());
        } catch (EmployeeNotFoundException e) {
            System.out.println("ID " + id + " not found");
        }
    }

    public static void updateNameByID() {
        System.out.print("\nEnter the ID of the employee: ");
        int id = Utilities.getIntegerInput();
        try {
            Employee foundEmployee = getEmployeeByID(id);
            String oldName = foundEmployee.getName();
            System.out.print("Enter new name: ");
            String name = Utilities.sc.nextLine();
            foundEmployee.setName(name);
            System.out.println(oldName + " changed name to " + foundEmployee.getName());
        } catch (EmployeeNotFoundException e) {
            System.out.println("ID " + id + " not found");
        }
    }

    public static void updateDobByID() {
        System.out.print("\nEnter the ID of the employee: ");
        int id = Utilities.getIntegerInput();
        while (true) {
            try {
                Employee foundEmployee = getEmployeeByID(id);
                LocalDate oldDob = foundEmployee.getDob();
                System.out.print("Enter new Date of birth (yyyy-mm-dd): ");
                String dob = Utilities.sc.nextLine();
                foundEmployee.setDob(LocalDate.parse(dob));
                System.out.println(foundEmployee.getName() + " changed DOB from " + oldDob + " to " + foundEmployee.getDob());
                break;
            } catch (EmployeeNotFoundException e) {
                System.out.println("ID " + id + " not found");
            } catch (DateTimeParseException e) {
                System.out.println("Illegal dateformat!");
            }
        }
    }

    public static void updateSalaryByID() {
        System.out.print("\nEnter the ID of the employee: ");
        int id = Utilities.getIntegerInput();
        try {
            Employee foundEmployee = getEmployeeByID(id);
            double oldSalary = foundEmployee.getSalary();
            System.out.print("Enter new salary: ");
            double salary = Double.parseDouble(Utilities.sc.nextLine());
            foundEmployee.setSalary(salary);
            System.out.println(foundEmployee.getName() + " changed salary from " + (int)oldSalary + " to " + (int)foundEmployee.getSalary());
        } catch (EmployeeNotFoundException e) {
            System.out.println("ID " + id + " not found");
        }
    }

    public static void searchByName() {
        System.out.print("\nEnter name: ");
        String inputName = Utilities.sc.nextLine();
        boolean foundName = false;
        for (Employee employee : employeeDB) {
            if (inputName.equalsIgnoreCase(employee.getName())) {
                printHeader();
                System.out.println(employee.toString());
                foundName = true;
            }
        }
        if (!foundName) {
            System.out.println("Employee not found.");
        }
    }

    private static void printHeader() {
        System.out.println();
        System.out.println(Utilities.fixLengthString("ID", 5) +
                "  " + Utilities.fixLengthString("Name", 20) +
                "  " + Utilities.fixLengthString("Date of birth", 15) +
                "  " + Utilities.fixLengthString("Salary", 7) +
                "  " + Utilities.fixLengthString("Gender", 7) +
                "  " + Utilities.fixLengthString("Unique variable", 15));
    }

    public static void searchByID() {
        System.out.print("\nEnter the ID of the employee: ");
        int id = Utilities.getIntegerInput();
        try {
            Employee foundEmployee = getEmployeeByID(id);
            printHeader();
            System.out.println(foundEmployee.toString());
        } catch (EmployeeNotFoundException e) {
            System.out.println("ID " + id + " not found");
        }
    }

    public static void putToWork() {
        Random rnd = new Random(System.currentTimeMillis());
        int nTimes;
        for (Employee employee : employeeDB) {
            nTimes = rnd.nextInt(10) + 1;
            for (int i = 0; i < nTimes; i++) {
                employee.performDuties();
            }
        }
    }

    private static Employee getEmployeeByID(int id) throws EmployeeNotFoundException {
        for (Employee employee : employeeDB) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public static void searchByRole() {
        ArrayList<Employee> localDB = new ArrayList<>();
        System.out.println("\nWhich role do you want to find?");
        System.out.println("1. Bartender");
        System.out.println("2. Chef");
        System.out.println("3. HR rep");
        System.out.println("4. Manager");
        System.out.println("5. Waiter");
        switch (Utilities.getMenuInput(1, 5)) {
            case 1:
                for (Employee employee : employeeDB) {
                    if (employee instanceof Bartender) {
                        localDB.add(employee);
                    }
                }
                break;
            case 2:
                for (Employee employee : employeeDB) {
                    if (employee instanceof Chef) {
                        localDB.add(employee);
                    }
                }
                break;
            case 3:
                for (Employee employee : employeeDB) {
                    if (employee instanceof HR) {
                        localDB.add(employee);
                    }
                }
                break;
            case 4:
                for (Employee employee : employeeDB) {
                    if (employee instanceof Manager) {
                        localDB.add(employee);
                    }
                }
                break;
            case 5:
                for (Employee employee : employeeDB) {
                    if (employee instanceof Waiter) {
                        localDB.add(employee);
                    }
                }
                break;
            default:
                System.out.println("Unkown error");
        }
        if (!(localDB.isEmpty())) {
            printHeader();
            for (Employee employee : localDB) {
                System.out.println(employee);
            }
        } else {
            System.out.println("\nNo such employees on staff.");
        }
    }

    public static void displayAverageWage() {
        double totalWage = 0;
        for (Employee employee : employeeDB) {
            totalWage += employee.getSalary();
        }
        System.out.println("The average wage is: " + (int) (totalWage / employeeDB.size()) + ".");
    }

    public static void displayMaximumWage() {
        Employee temp = employeeDB.get(0);
        for (Employee employee : employeeDB) {
            if (employee.getSalary() > temp.getSalary()) {
                temp = employee;
            }
        }
        System.out.println("The maximum wage is: " + temp.getSalary() + " and belongs to " + temp.getName() + ".");
    }

    public static void displayMinimumWage() {
        Employee emp = employeeDB.get(0);
        for (Employee employee : employeeDB) {
            if (employee.getSalary() < emp.getSalary()) {
                emp = employee;
            }
        }
        System.out.println("The minimum wage is: " + emp.getSalary() + " and belongs to " + emp.getName() + ".");
    }

    public static void displayTotalBonus() {
        double totalBonus = 0;
        for (Employee employee : employeeDB) {
            totalBonus += employee.bonus();
        }
        System.out.println("The total bonus is: " + totalBonus);
    }

    public static void displayPercentageWomen() {
        double nrOfWomen = 0;
        for (Employee employee : employeeDB) {
            if (employee.getGender() == GenderType.FEMALE) {
                nrOfWomen++;
            }
        }
        System.out.println(
                "The percentage of female employees is: " + (int) (nrOfWomen / employeeDB.size() * 100) + "%.");
    }

    public static void displayPercentageMenPerRole() {
        ArrayList<Bartender> bartenderList = new ArrayList<>();
        ArrayList<Chef> chefList = new ArrayList<>();
        ArrayList<HR> hrList = new ArrayList<>();
        ArrayList<Manager> managerList = new ArrayList<>();
        ArrayList<Waiter> waiterList = new ArrayList<>();
        double nrOfBartenderMen = 0;
        double nrOfChefMen = 0;
        double nrOfHRMen = 0;
        double nrOfManagerMen = 0;
        double nrOfWaiterMen = 0;

        for (Employee employee : employeeDB) {
            if (employee instanceof Bartender) {
                bartenderList.add((Bartender) employee);
                if (employee.getGender() == GenderType.MALE) {
                    nrOfBartenderMen++;
                }
            }
            if (employee instanceof Chef) {
                chefList.add((Chef) employee);
                if (employee.getGender() == GenderType.MALE) {
                    nrOfChefMen++;
                }
            }
            if (employee instanceof HR) {
                hrList.add((HR) employee);
                if (employee.getGender() == GenderType.MALE) {
                    nrOfHRMen++;
                }
            }
            if (employee instanceof Manager) {
                managerList.add((Manager) employee);
                if (employee.getGender() == GenderType.MALE) {
                    nrOfManagerMen++;
                }
            }
            if (employee instanceof Waiter) {
                waiterList.add((Waiter) employee);
                if (employee.getGender() == GenderType.MALE) {
                    nrOfWaiterMen++;
                }
            }
        }

        if (!bartenderList.isEmpty()) {
            System.out.println("Percentage of male bartenders: " + (int) (nrOfBartenderMen / bartenderList.size() * 100) + "%.");
        }
        if (!chefList.isEmpty()) {
            System.out.println("Percentage of male chefs: " + (int) (nrOfChefMen / chefList.size() * 100) + "%.");
        }
        if (!hrList.isEmpty()) {
            System.out.println("Percentage of men in HR: " + (int) (nrOfHRMen / hrList.size() * 100) + "%.");
        }
        if (!managerList.isEmpty()) {
            System.out.println("Percentage of male managers: " + (int) (nrOfManagerMen / managerList.size() * 100) + "%.");
        }
        if (!waiterList.isEmpty()) {
            System.out.println("Percentage of male waiters: " + (int) (nrOfWaiterMen / waiterList.size() * 100) + "%.");
        }
    }

    public static void displayAverageAge() {
        double totalAge = 0;
        for (Employee employee : employeeDB) {
            totalAge += employee.calculateAge();
        }
        System.out.println("The average age is: " + (int) (totalAge / employeeDB.size()));
    }

}
