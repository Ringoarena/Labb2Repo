package model.employees;

import java.util.Random;

public class Waiter extends Employee {

    private int tip;

    public Waiter(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(10000);
    }

    @Override
    public double bonus() {
        return 0;
    }

    public void serve(String dish){
        System.out.println("One " + dish + " coming up!");
        tipGenerator();
    }

    private void tipGenerator(){
        this.tip = 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }
}
