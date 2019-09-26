package model.employees;

import java.time.LocalDate;
import java.util.Random;
import ui.Utilities;

public class Chef extends Employee{
    private int noOfDrinksDuringWork;

    public Chef(String name, LocalDate dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(15000);
    }

    @Override
    public double bonus() {
    	if(noOfDrinksDuringWork<10) {
    		return bonus+=2000;	
    	}
    	else {
    		return 0;
    	}
    }

    @Override
    public String toString(){
        return super.toString() + Utilities.fixLengthString("No of drinks "+noOfDrinksDuringWork, 15) ;
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
