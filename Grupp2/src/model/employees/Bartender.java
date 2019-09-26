package model.employees;

import java.time.LocalDate;
import ui.Utilities;

public class Bartender extends Employee {
	private int cocktailServed;

    public Bartender(String name, LocalDate dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(13000);
    }

    @Override
    public double bonus() {
    	if(cocktailServed>55) {
    		return bonus+=3000;
    	}
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + Utilities.fixLengthString("Drinks served "+cocktailServed, 15) ;
    }

	@Override
	public void performDuties() {
		System.out.println("Here you go! Enjoy your drink!");
		cocktailServed++;
	}
}
