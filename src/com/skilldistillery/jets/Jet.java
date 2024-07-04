package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private String pilot;
	
	public abstract void fly();
	
	public Jet(String model, double speed, int range, long price, String pilot) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = pilot;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "'" + getClass().getSimpleName() + ": Pilot - " + pilot + ", model - " + model + ", speed(MPH) - " + speed + ", range - " + range + ", price - " + price + "'";
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	
}
