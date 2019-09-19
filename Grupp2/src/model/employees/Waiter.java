package model.employees;

import java.util.Random;

public class Waiter extends Employee {

	private double tip;

	public Waiter(String name, String dob, GenderType gender) {
		super(name, dob, gender);
		setSalary(10000);
	}

	@Override
	public double bonus() {
		if (0.1 <= tip / getSalary()) {
			System.out.println("You have earned at least 10% of your salary in tip, you deserve a bonus!");
			return 1000;
		} else {
			System.out.println("You do not deserve a bonus this year, better luck next time!");
			return 0;
		}
	}


	private void tipGenerator() {
		Random rnd = new Random(System.currentTimeMillis());
		int tip = rnd.nextInt(11) + 10;
		System.out.println("You got " + tip + "$ in tip");
		this.tip += tip;
		
	}

	@Override
	public String toString() {
		return super.toString() + ", Tip: " + tip;
	}

	@Override
	public void performDuties() {
		System.out.println("One dish coming up!");
		tipGenerator();
	}
}
