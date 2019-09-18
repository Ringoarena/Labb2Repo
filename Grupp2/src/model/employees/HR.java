package model.employees;

import java.util.Random;

public class HR extends Employee {

	private int noOfPeopleRecruited;
	
    public HR(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(16000);
    }

    @Override
    public double bonus() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }
    
    public void interview() {
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
