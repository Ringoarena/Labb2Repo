package model.employees;

import java.time.LocalDate;
import java.util.Random;

public class Chef extends Employee{
    int noOfDrinksDuringWork;
    public Chef(String name, LocalDate dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(15000);
    }

    @Override
    public double bonus() {
    	if(noOfDrinksDuringWork<10) {
    		System.out.println("Well done, you managed to stay away from the bottle!");
    		return 2000;	
    	}
    	else {
    		System.out.println("This is an intervention, we just want you healthy.");
    		return 0;
    	}
    	
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
