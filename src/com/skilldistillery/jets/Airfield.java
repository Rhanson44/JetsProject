package com.skilldistillery.jets;

import java.util.ArrayList;

public class Airfield {

	// NO ADDITIONAL FIELDS
	private ArrayList<Jet> jets;

	public Airfield() {
		jets = new ArrayList<>();
	}

	public void initAirfield() {
		PassengerJet passengerJet = new PassengerJet("Model", 900.0, 100, 100);
		CargoJet cargoJet = new CargoJet("Model", 100.0, 100, 100);
		CargoJet cargoJet2 = new CargoJet("Model", 100.0, 500, 100);
		FighterJet fighterJet = new FighterJet("Model", 100.0, 100, 100);
		FighterJet fighterJet2 = new FighterJet("Model", 100.0, 100, 100);

		jets.add(passengerJet);
		jets.add(cargoJet);
		jets.add(cargoJet2);
		jets.add(fighterJet);
		jets.add(fighterJet2);
	}

	public void listFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}
	
	public void allFly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public Jet getFastestJet() {
		Jet fastestJet = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			Jet currentJet = jets.get(i);
			if (currentJet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = currentJet;
			}
		}
		return fastestJet;
	}

	public Jet getJetWithMostRange() {
		Jet furthestRange = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			Jet currentJet = jets.get(i);
			if (currentJet.getRange() > furthestRange.getRange()) {
				furthestRange = currentJet;
			}
		}
		return furthestRange;
	}

	public void loadAllCargo() {
		for (Jet jet : jets) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			}
		}
	}
	
	public void dogfight() {
		for (Jet jet : jets) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			} else if (jet instanceof FighterJet) {
				((FighterJet) jet).engageAttack();
			}
		}
	}

	public void addJet(Jet jet) {
		jets.add(jet);
	}

	public boolean removeJet(int index) {
		try {
			jets.remove(index);
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Exceeded available positions in airfield");
			return false;
		}
	}

	public void printSimpleJets() {
		System.out.println("Enter jet name separated by a space - 'fighter jet'");
		System.out.println(jets.get(0).getClass().getSimpleName());
		System.out.println(jets.get(1).getClass().getSimpleName());
		System.out.println(jets.get(3).getClass().getSimpleName());
	}

	// NO getJets();
}
