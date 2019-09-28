package model.employees;

import java.time.LocalDate;
import ui.Utilities;
import static java.time.temporal.ChronoUnit.*;

public abstract class Employee implements Comparable<Employee>{

    private String name;
    private LocalDate dob;
    private Integer ID;
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

    @Override
    public int compareTo(Employee employee) {
        return this.getID().compareTo(employee.getID());
    }

    public abstract double bonus();

    public abstract void performDuties();

    public String getName() {
        return name;
    }

    public void setName(String input) {
        input = input.trim();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        for (int i = 0; i < input.length(); i++) {
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

    public Integer getID() {
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
                "  " + Utilities.fixLengthString(dob,13) +
                "  " + Utilities.fixLengthString(calculateAge(),3) +
                "  " + Utilities.fixLengthString((int)salary,7) +
                "  " + Utilities.fixLengthString(gender, 7) + "  ";
//        return Utilities.fixLength(""+ID, 3) + Utilities.fixLength(name, 10) + Utilities.fixLength(""+dob, 15)
//         + Utilities.fixLength(""+salary, 10) + Utilities.fixLength(""+gender, 7);
    }

    public long calculateAge(){
        LocalDate now = LocalDate.now();
        return YEARS.between(dob, now);
    }
}
