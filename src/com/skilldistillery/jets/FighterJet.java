package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void engageAttack() {
		System.out.println("DUCK DIVE DIP AND DODGE");
	}

	@Override
	public void fly() {
		double flightPath = this.getSpeed() / this.getRange();
		System.out.println(this.toString() + " can travel " + flightPath + " miles");
	}

}
