package com.skilldistillery.jets;


public class JetsApplication {
	private Airfield airfield = new Airfield();

	public static void main(String[] args) {
		
		JetsApplication app = new JetsApplication();
		app.start();
	}

	private void start() {
		airfield.initAirfield();
	}

}
