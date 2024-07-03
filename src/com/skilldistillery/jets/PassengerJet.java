package com.skilldistillery.jets;

public class PassengerJet extends Jet{
	
	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		this.toString();
	}

	@Override
	public String toString() {
		return "PassengerJet =[" + super.toString() + "]";
	}

}
