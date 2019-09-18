package model.employees;

public class Bartender extends Employee {

    public Bartender(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(13000);

    }

    @Override
    public double bonus() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }

	@Override
	public void performDuties() {
		// TODO Auto-generated method stub
		
	}
}
