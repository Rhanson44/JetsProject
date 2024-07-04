package com.skilldistillery.jets;

public class PassengerJet extends Jet{
	
	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		double flightPath = this.getSpeed() * this.getRange();
		System.out.println(this.toString() + " can travel " + flightPath + " miles");
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
