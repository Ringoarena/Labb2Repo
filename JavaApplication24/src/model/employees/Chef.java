package model.employees;

import java.util.Random;

public class Chef extends Employee{
    int noOfDrinksDuringWork;
    public Chef(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(15000);
    }

    @Override
    public double bonus() {
    	if(noOfDrinksDuringWork<10)
    		return 2000;
    	else
    		return 0;
    	
    }

    @Override
    public String toString(){
        return super.toString() + ", Drinks during work: " + noOfDrinksDuringWork;
    }

	@Override
	public void performDuties() {
		boolean exausted = new Random().nextBoolean();
		System.out.println("Food is ready to be served!!");
		if(exausted) {
			System.out.println("Jeez this is very taxing, I think I need a drink");
			noOfDrinksDuringWork++;
		}
		
		
		}
}
