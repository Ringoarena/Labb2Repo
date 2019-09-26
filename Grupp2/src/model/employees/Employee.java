package model.employees;

import java.time.LocalDate;
import ui.Utilities;
import static java.time.temporal.ChronoUnit.*;

public abstract class Employee {

    private String name;
    private LocalDate dob;
    private int ID;
    private double salary;
    private GenderType gender;
    double bonus;

    private static int IDGenerator;

    Employee(String name, LocalDate dob, GenderType gender) {
        this.setName(name);
        this.dob = dob;
        this.gender = gender;
        this.ID = ++IDGenerator;
    }

    public abstract double bonus();

    public abstract void performDuties();

    public String getName() {
        return name;
    }

    public void setName(String input) {
        input = input.trim();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == ' ') {
                input = input.substring(0, i + 1) + input.substring(i + 1, i + 2).toUpperCase() + input.substring(i + 2);
            }
        }
        this.name = input;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getID() {
        return ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public GenderType getGender(){
        return this.gender;
    }       

    @Override
    public String toString() {
        return Utilities.fixLengthString(ID,5) +
                "  " + Utilities.fixLengthString(name,20) +
                "  " + Utilities.fixLengthString(dob,15) +
                "  " + Utilities.fixLengthString(salary,7) +
                "  " + Utilities.fixLengthString(gender, 7) + "  ";
//        return Utilities.fixLength(""+ID, 3) + Utilities.fixLength(name, 10) + Utilities.fixLength(""+dob, 15)
//         + Utilities.fixLength(""+salary, 10) + Utilities.fixLength(""+gender, 7);
    }

//            System.out.println(Utilities.fixLengthString("ID", 5) +
//                    "  " + Utilities.fixLengthString("Name", 20) +
//                    "  " + Utilities.fixLengthString("Date of birth", 15) +
//                    "  " + Utilities.fixLengthString("Salary", 7) +
//                    "  " + Utilities.fixLengthString("Gender", 7) +
//                    "  " + Utilities.fixLengthString("Unique variable", 15));

    public long calculateAge(){
        LocalDate now = LocalDate.now();
        return YEARS.between(dob, now);
    }
}
