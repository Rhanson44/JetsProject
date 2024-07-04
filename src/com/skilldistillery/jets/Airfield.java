package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airfield {

	// NO ADDITIONAL FIELDS
	private ArrayList<Jet> jets;

	public Airfield() {
		jets = new ArrayList<>();
	}

	public void initAirfield() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetsArr = line.split(",");
				String type = jetsArr[0];
				String model = jetsArr[1];
				double speed = Double.parseDouble(jetsArr[2]);
				int range = Integer.parseInt(jetsArr[3]);
				long price = Long.parseLong(jetsArr[4]);
				switch(type) {
				case "PassengerJet":
					PassengerJet passengerJet = new PassengerJet(model, speed, range, price);
					jets.add(passengerJet);
					break;
				case "CargoJet":
					CargoJet cargoJet = new CargoJet(model, speed, range, price);
					jets.add(cargoJet);
					break;
				case "FighterJet":
					FighterJet fighterJet = new FighterJet(model, speed, range, price);
					jets.add(fighterJet);
					break;
				default:
					type = null;
					break;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
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
