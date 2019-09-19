package model.employees;

public class Bartender extends Employee {

	
	private int cocktailServed;
    public Bartender(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(13000);

    }

    @Override
    public double bonus() {
    	if(cocktailServed>55) {
    		System.out.println("You did well this year, here's your bonus!");
    		return 3000;
    	}
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + ", Cocktails served: " + cocktailServed;
    }

	@Override
	public void performDuties() {
		System.out.println("Here you go! Enyor your drink!");
		cocktailServed++;
	}
}
