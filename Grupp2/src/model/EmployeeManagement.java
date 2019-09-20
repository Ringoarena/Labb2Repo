package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.employees.*;
import model.exception.EmployeeNotFoundException;
import ui.Utilities;

public class EmployeeManagement {

	private static ArrayList<Employee> employeeDB = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void loadDB() {
		employeeDB.add(new Waiter("Rikard", "1990-09-25", GenderType.MALE));
		employeeDB.add(new Chef("Johannes", "1930-09-25", GenderType.MALE));
		employeeDB.add(new Bartender("Mattias", "1200-09-25", GenderType.MALE));
		putToWork();
	}

	public static void addEmployee() {

		System.out.println("Enter employee name");
		String name = sc.nextLine();

		// TODO
		System.out.println("Enter DOB (yyyy-mm-dd)");
		String dob = sc.nextLine();

		System.out.println("Enter employee gender");
		System.out.println("1. Female");
		System.out.println("2. Male");
		System.out.println("3. Other");
		int gender = Utilities.getInput(1, 3);

		GenderType newEmployeeGender = null;
		switch (gender) {
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
		int role = Utilities.getInput(1, 5);

		switch (role) {
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

	public static void displayAllEmployees() {
		for (Employee emp : employeeDB)
			System.out.println(emp.toString());
	}

	public static void deleteEmployeeByID() {
		System.out.println("What is the ID of the employee you wish to remove?");
		int id = Integer.parseInt(sc.nextLine());
		Employee tmp = null;
		// trådsäker metod
		for (Employee emp : employeeDB) {
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
		System.out.println("What is the name of the employee?");
		String inputName = sc.nextLine();
		boolean foundName = false;

		for (Employee employee : employeeDB) {
			if (inputName.equals(employee.getName())) {
				System.out.println(employee.toString());
				foundName = true;
			}
		}
		if (!foundName) {
			System.out.println("There are no employees with that name.");
		}
	}

	public static void searchByID() {
		System.out.println("What is the ID of the employee?");
		int id = Integer.parseInt(sc.nextLine());

		// Anropar korrekt toString enligt polymorfism
		try {
			Employee foundEmployee = getEmployeeByID(id);
			System.out.println(foundEmployee.toString());
		} catch (EmployeeNotFoundException e) {
			System.out.println("Couldn't find the employee with ID: " + id);
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
		for (Employee emp : employeeDB) {
			if (emp.getID() == id)
				return emp;
		}
		throw new EmployeeNotFoundException();
	}

	public static void searchByRole() {

		System.out.println("Which role do you want to find?");
		System.out.println("1. Bartender");
		System.out.println("2. Chef");
		System.out.println("3. HR rep");
		System.out.println("4. Manager");
		System.out.println("5. Waiter");

		int choice = Utilities.getInput(1, 5);

		switch (choice) {
		case 1:
			for (Employee employee : employeeDB) {
				if (employee instanceof Bartender) {
					System.out.println(employee);
				}
			}
			break;
		case 2:
			for (Employee employee : employeeDB) {
				if (employee instanceof Chef) {
					System.out.println(employee);
				}
			}
			break;
		case 3:
			for (Employee employee : employeeDB) {
				if (employee instanceof HR) {
					System.out.println(employee);
				}
			}
			break;
		case 4:
			for (Employee employee : employeeDB) {
				if (employee instanceof Manager) {
					System.out.println(employee);
				}
			}
			break;
		case 5:
			for (Employee employee : employeeDB) {
				if (employee instanceof Waiter) {
					System.out.println(employee);
				}
			}
			break;
		default:
			System.out.println("Unkown error");

		}

	}

	public static void displayAverageWage() {
		double totalWage = 0;
		for (Employee employee : employeeDB) {
			totalWage += employee.getSalary();
		}

		System.out.println("The average wage is: " + totalWage / employeeDB.size() + ".");
	}

	public static void displayMaximumWage() {
		Employee emp = employeeDB.get(0);
		for (Employee employee : employeeDB) {
			if (employee.getSalary() > emp.getSalary()) {
				emp = employee;
			}
		}

		System.out.println("The maximum wage is: " + emp.getSalary() + " and belongs to " + emp.getName() + ".");
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
			System.out.println(
					"Percentage of male bartenders: " + (int) (nrOfBartenderMen / bartenderList.size() * 100) + "%.");
		}
		if (!chefList.isEmpty()) {
			System.out.println("Percentage of male chefs: " + (int) (nrOfChefMen / chefList.size() * 100) + "%.");
		}
		if (!hrList.isEmpty()) {
			System.out.println("Percentage of men in HR: " + (int) (nrOfHRMen / hrList.size() * 100) + "%.");
		}
		if (!managerList.isEmpty()) {
			System.out.println(
					"Percentage of male managers: " + (int) (nrOfManagerMen / managerList.size() * 100) + "%.");
		}
		if (!waiterList.isEmpty()) {
			System.out.println("Percentage of male waiters: " + (int) (nrOfWaiterMen / waiterList.size() * 100) + "%.");
		}

	}
        
        public static void displayAverageAge(){
            double totalAge = 0;
            for (Employee employee : employeeDB) {
                totalAge += employee.calculateAge();
            }
            
            System.out.println("The average age is: " + (int)(totalAge/employeeDB.size()));
        }

}
