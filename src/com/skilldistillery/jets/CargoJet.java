package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier{

	public CargoJet(String model, double speed, int range, long price, String pilot) {
		super(model, speed, range, price, pilot);
	}

	@Override
	public void fly() {
		double flightPath = this.getRange() / this.getSpeed();
		System.out.println(this.toString() + " can travel for " + flightPath + " hours");	
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + ": Shipment loaded, prepare for takeoff");
	}

}
