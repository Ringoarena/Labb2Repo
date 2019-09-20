package model.employees;

import java.time.LocalDate;
import java.util.Random;

public class HR extends Employee {

	private int noOfPeopleRecruited;
	
    public HR(String name, LocalDate dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(16000);
    }

    @Override
    public double bonus() {
        if(noOfPeopleRecruited>10) {
        	System.out.println("Congratulations on fixing the new recuits!");
        	return 2000;
        }
        else {
        	System.out.println("You have to work hard nextYear");
        	return 0;
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", People recruited: " + noOfPeopleRecruited;
    }
    

	@Override
	public void performDuties() {
	  	Random rnd = new Random();
    	Boolean succesfulInterview = rnd.nextBoolean();
    	if(succesfulInterview) {
    		System.out.println("The interview was succesful and the candidate is going to be hired");
    		noOfPeopleRecruited++;
    	}
    	else
    		System.out.println("The interviewee made an unfortunate impression and we're going to move on to newer candidates.");
	}
}
