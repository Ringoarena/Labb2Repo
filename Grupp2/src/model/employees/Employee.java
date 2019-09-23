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
    protected double bonus;
    

    private static int IDGenerator;

    public Employee(String name, LocalDate dob, GenderType gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.ID = ++IDGenerator;
    }
    
    public double getBonus() {
    	return bonus;
    }

    public abstract double bonus();

    public abstract void performDuties();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Utilities.fixLength(""+ID, 3) + Utilities.fixLength(name, 10) + Utilities.fixLength(""+dob, 15)
         + Utilities.fixLength(""+salary, 10) + Utilities.fixLength(""+gender, 7);
    }

    public long calculateAge(){
        LocalDate now = LocalDate.now();
        return YEARS.between(dob, now);
    }
}
