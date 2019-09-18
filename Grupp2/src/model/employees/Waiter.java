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
		if (0.1 > tip / getSalary()) {
			System.out.println("Du har fått in 10% av din lön i dricks och förtjänar en bonus!");
			return 1000;
		} else {
			System.out.println("Du förtjänar tyvärr inte bonus detta år pga av din låga drickskvot!");
			return 0;
		}
	}


	private void tipGenerator() {
		Random rnd = new Random(System.currentTimeMillis());
		this.tip = rnd.nextInt(11) + 10;
	}

	@Override
	public String toString() {
		return super.toString() + " TIP placeholder";
	}

	@Override
	public void performDuties() {
		System.out.println("One dish coming up!");
		tipGenerator();
	}
}
