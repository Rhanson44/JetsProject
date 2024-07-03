package com.skilldistillery.jets;

import java.util.ArrayList;

public class Airfield {
	
	//NO ADDITIONAL FIELDS
	private ArrayList<Jet> jets;
	
	public Airfield() {
		jets = new ArrayList<>();
	}
	
	public void initAirfield() {
		PassengerJet passengerJet = new PassengerJet("Model", 100.0, 100, 100);
		jets.add(passengerJet);
	}
	
	public void addJet(Jet jet) {
		
	}
	
	//NO getJets();
}
