package model;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.webkit.Utilities;

import model.employees.Bartender;
import model.employees.Chef;
import model.employees.Employee;
import model.employees.GenderType;
import model.employees.HR;
import model.employees.Manager;
import model.employees.Waiter;
import model.exception.EmployeeNotFoundException;

public class EmployeeManagement {

    private static ArrayList<Employee> employeeDB = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void loadDB(){
        employeeDB.add(new Waiter("Rikard", "1990-09-25", GenderType.MALE));
        employeeDB.add(new Waiter("Johannes", "1930-09-25", GenderType.MALE));
        employeeDB.add(new Waiter("Mattias", "1200-09-25", GenderType.MALE));
    }

    public static void addEmployee(){

        System.out.println("Enter employee name");
        String name = sc.nextLine();

        //TODO
        System.out.println("Enter DOB (yyyy-mm-dd)");
        String dob = sc.nextLine();

        int gender;
        while (true) {
            System.out.println("Enter employee gender");
            System.out.println("1. Female");
            System.out.println("2. Male");
            System.out.println("3. Other");
            try {
                gender = Integer.parseInt(sc.nextLine());
                if (gender >= 1 && gender <= 3) {
                    break;
                } else {
                    System.out.println("Enter a number from 1 to 3 only!");
                }
            } catch (NumberFormatException ignored) {}
        }

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

        int role;
        while (true){
            System.out.println("Enter employee role");
            System.out.println("1. Manager");
            System.out.println("2. HR");
            System.out.println("3. Chef");
            System.out.println("4. Bartender");
            System.out.println("5. Waiter");
            try {
                 role = Integer.parseInt(sc.nextLine());
                if (role >= 1 && role <= 5) {
                    break;
                } else {
                    System.out.println("Enter a number from 1 to 5 only!");
                }
            } catch (NumberFormatException ignored) { }
        }
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
        
        try {
			Employee foundEmployee = getEmployeeByID(id);
			System.out.println("Enter new name: ");
			String name = sc.nextLine();
			foundEmployee.setName(name);
		} catch (EmployeeNotFoundException e) {
			System.out.println("Couldn't find the employee with ID: " + id);
		}
        
    }

    public static void updateDobByID() {
    	System.out.println("What is the ID of the employee?");
    	int id = Integer.parseInt(sc.nextLine());
    	
        try {
			Employee foundEmployee = getEmployeeByID(id);
			System.out.println("Enter new Date of birth: (yyyy-mm-dd): ");
			String dob = sc.nextLine();
			foundEmployee.setDob(dob);
		} catch (EmployeeNotFoundException e) {
			System.out.println("Couldn't find the employee with ID: " + id);
		}
        
    }

    public static void updateSalaryByID() {
    	System.out.println("What is the ID of the employee?");
    	int id = Integer.parseInt(sc.nextLine());
    	
        try {
			Employee foundEmployee = getEmployeeByID(id);
			System.out.println("Enter new salary: ");
			double salary = Double.parseDouble(sc.nextLine());
			foundEmployee.setSalary(salary);
		} catch (EmployeeNotFoundException e) {
			System.out.println("Couldn't find the employee with ID: " + id);
		}
        
        
        
    }

    public static void searchByName() {
    }

    public static void searchByID() {
        System.out.println("What is the ID of the employee?");
        int id = Integer.parseInt(sc.nextLine());
        
        try {
			Employee foundEmployee = getEmployeeByID(id);
		} catch (EmployeeNotFoundException e) {
			System.out.println("Couldn't find the employee with ID: " + id);
		}
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
    
    
    private static Employee getEmployeeByID(int id) throws EmployeeNotFoundException {
    	
    	for(Employee emp: employeeDB) {
    		if(emp.getID() == id)
    			return emp;
    	}
    	throw new EmployeeNotFoundException();
    }
}
