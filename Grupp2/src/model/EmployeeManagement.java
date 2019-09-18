package model;

import UI.Utilities;
import model.employees.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    private static ArrayList<Employee> employeeDB = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void loadDB() {
        employeeDB.add(new Waiter("Rikard", "1990-09-25", GenderType.MALE));
        employeeDB.add(new Waiter("Johannes", "1930-09-25", GenderType.MALE));
        employeeDB.add(new Waiter("Mattias", "1200-09-25", GenderType.MALE));
    }

    public static void addEmployee(){
        //test
        System.out.println("Enter employee name");
        String name = sc.nextLine();

        //TODO
        System.out.println("Enter DOB (yyyy-mm-dd)");
        String dob = sc.nextLine();

        System.out.println("Enter employee gender");
        System.out.println("1. Female");
        System.out.println("2. Male");
        System.out.println("3. Other");
        int gender = Utilities.getInput(1,3);

        GenderType newEmployeeGender = null;
        switch(gender) {
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

        System.out.println("Enter employee role");
        System.out.println("1. Manager");
        System.out.println("2. HR");
        System.out.println("3. Chef");
        System.out.println("4. Bartender");
        System.out.println("5. Waiter");
        int role = Utilities.getInput(1,5);

        switch(role){
            case 1:
                employeeDB.add(new Manager(name, dob, newEmployeeGender));
                break;
            case 2:
                employeeDB.add(new HR(name, dob, newEmployeeGender));
                break;
            case 3:
                employeeDB.add(new Chef(name, dob, newEmployeeGender));
                break;
            case 4:
                employeeDB.add(new Bartender(name, dob, newEmployeeGender));
                break;
            case 5:
                employeeDB.add(new Waiter(name, dob, newEmployeeGender));
                break;
            default:
                System.out.println("Unknown error!");
        }
    }

    public static int getSize() {
        return employeeDB.size();
    }

    public static void displayAllEmployees(){
        for (Employee emp: employeeDB)
            System.out.println(emp.toString());
    }

    public static void deleteEmployeeByID() {
        System.out.println("What is the ID of the employee you wish to remove?");
        int id = Integer.parseInt(sc.nextLine());
        Employee tmp = null;
        // trådsäker metod
        for (Employee emp: employeeDB) {
            if (emp.getID() == id) {
                tmp = emp;
                break;
            } else {
                System.out.println("ID not found.");
            }
        }
        employeeDB.remove(tmp);
    }

    public static void updateNameByID() {
        System.out.println("What is the ID of the employee?");
        int id = Integer.parseInt(sc.nextLine());

    }

    public static void updateDobByID() {
    }

    public static void updateSalaryByID() {
    }

    public static void searchByName() {
    }

    public static void searchByID() {
        System.out.println("What is the ID of the employee?");
        int id = Integer.parseInt(sc.nextLine());
    }

    public static void searchByRole() {
    }

//    public static void removeEmployeeByID() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("\nWhat is the ID of the employee?");
//        int id = Integer.parseInt(sc.nextLine());
//
//        for (int i = 0; i < counter; i++) {
//            if ((employeeDB[i]).getID() == id) {
//                if (i == (counter - 1)) {
//                    employeeDB[counter - 1] = null;
//                } else {
//                    employeeDB[i] = employeeDB[counter - 1];
//                }
//                employeeDB[counter - 1] = null;
//                counter--;
//            }
//        }
//    }
//
//    public static void findHighestSalary(){
//        int highest = 0;
//        for (int i = 1; i < db.length; i++) {
//            if (db[i].getSalary() > db[highest].getSalary()) {
//                highest = i;
//            }
//        }
//        System.out.println("Highest salary: " + db[highest]);
//    }
//
//    public static void findOldestPerson(){
//        int oldest = 0;
//        for (int i = 1; i < db.length; i++) {
//            if (db[i].calculateAge() > db[oldest].calculateAge()) {
//                oldest = i;
//            }
//        }
//        System.out.println("Oldest employee: " + db[oldest]);
//    }
}
