package model.employees;

import java.time.LocalDate;
import java.util.Random;

import ui.Utilities;

public class Waiter extends Employee {

	private double tip;

	public Waiter(String name, LocalDate dob, GenderType gender) {
		super(name, dob, gender);
		setSalary(10000);
	}

	@Override
	public double bonus() {
		if (0.1 <= tip / getSalary()) {
			return bonus+=1000;
		} else {
			return bonus+=0;
		}
	}

	private void tipGenerator() {
		Random rnd = new Random();
		int tip = rnd.nextInt(11) + 10;
		System.out.println("You got " + tip + "$ in tip");
		this.tip += tip;
	}

	@Override
	public String toString() {
		return super.toString() + Utilities.fixLengthString("Tip: "+tip, 15) ;
	}

	@Override
	public void performDuties() {
		System.out.println("One dish coming up!");
		tipGenerator();
	}
}
