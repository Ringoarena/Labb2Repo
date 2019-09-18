package model.employees;

public class Manager extends Employee {
    public Manager(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(18000);
    }

    @Override
    public double bonus() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }
}
