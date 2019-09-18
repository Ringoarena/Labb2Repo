package model.employees;

public class Manager extends Employee {
	
	private int noOfPeopleFired;
    public Manager(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(18000);
    }

    @Override
    public double bonus() {
    	double bonus = 2500;
    	if(noOfPeopleFired<5) {
    		System.out.println("Well done you didn't fire too many people this year! Here is your bonus");
    		return bonus;
    	}
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }

    private void fire() {
    	System.out.println("YOU'RE FIRED GET OUT OF HERE!");
    	noOfPeopleFired++;
    }
	@Override
	public void performDuties() {
		fire();
	}
}
