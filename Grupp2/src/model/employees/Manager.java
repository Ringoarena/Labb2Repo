package model.employees;

import java.time.LocalDate;

import ui.Utilities;

public class Manager extends Employee {
	
	private int noOfPeopleFired;
    public Manager(String name, LocalDate dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(18000);
    }
    
    private int test;
    @Override
    public double bonus() {
    	double bonus = 2500;
    	if(noOfPeopleFired<5) {
    		return bonus+=2500;
    	}
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() +  Utilities.fixLength("People fired "+noOfPeopleFired, 15) ;
    }
    
	@Override
	public void performDuties() {
		System.out.println("YOU'RE FIRED GET OUT OF HERE!");
    	noOfPeopleFired++;
	}
}
