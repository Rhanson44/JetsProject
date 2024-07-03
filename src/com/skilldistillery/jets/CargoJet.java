package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier{

	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("I'm soaring!");
	}

	@Override
	public String toString() {
		return "CargoJet= [" + super.toString() + "]";
	}

	@Override
	public void loadCargo() {
		System.out.println("Shipment loaded, prepare for takeoff");
	}

}
