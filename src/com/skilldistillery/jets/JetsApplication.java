package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private Airfield airfield = new Airfield();
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.start();
	}

	private void start() {
		airfield.initAirfield();
		
		boolean keepGoing = true;
		while(keepGoing) {
			printMenu();
			System.out.print("Select an option: ");
			int input = scan.nextInt();
			scan.nextLine();
			
			switch(input) {
			case 1:
				airfield.listFleet();
				break;
			case 2:
				airfield.allFly();
				break;
			case 3:
				System.out.println("Fastest jet: " + airfield.getFastestJet());
				break;
			case 4:
				System.out.println("Jet with the furthest range: " + airfield.getJetWithMostRange());
				break;
			case 5:
				airfield.loadAllCargo();
				break;
			case 6:
				airfield.dogfight();
				break;
			case 7:
				userAddJet();
				break;
			case 8:
				System.out.println("Which jet would you like to remove?");
				System.out.println();
				airfield.listFleet();
				System.out.println();
				System.out.println("Enter numbered position in the airfield beginning with 0");
				int index = scan.nextInt();
				if (airfield.removeJet(index)) {
					System.out.println("Jet succesfully removed");
				}
				break;
			case 9:
				System.out.println("<< Simulation finished >>");
				keepGoing = false;
				break;
			}
			if(keepGoing) {
				System.out.println("Continue? Y/N");
				String choice = scan.next();
				if (choice.equalsIgnoreCase("Y")) {
					keepGoing = true;
				} else {
					keepGoing = false;
				}
			}
		}
	}
	
	private void printMenu() {
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("+ AIRCRAFT SIMULATOR          +");
		System.out.println("+ Option 1:                   +");
		System.out.println("+ Display current fleet       +");
		System.out.println("+ Option 2:                   +");
		System.out.println("+ Fly all jets                +");
		System.out.println("+ Option 3:                   +");
		System.out.println("+ View fastest jet            +");
		System.out.println("+ Option 4:                   +");
		System.out.println("+ View jet with longest range +");
		System.out.println("+ Option 5:                   +");
		System.out.println("+ Load all cargo jets         +");
		System.out.println("+ Option 6:                   +");
		System.out.println("+ Dogfight!                   +");
		System.out.println("+ Option 7:                   +");
		System.out.println("+ Add a new jet to the fleet  +");
		System.out.println("+ Option 8:                   +");
		System.out.println("+ Remove a jet from the fleet +");
		System.out.println("+ Option 9:                   +");
		System.out.println("+ Quit                        +");
		System.out.println("+++++++++++++++++++++++++++++++");
	}

	private void userAddJet() {
		System.out.println("Select a jet to add: ");
		airfield.printSimpleJets();
		String jetType = scan.nextLine().toLowerCase();
		System.out.print("Input the model: ");
		String model = scan.nextLine();
		System.out.print("Enter a max speed in MPH: ");
		double speed = scan.nextDouble();
		System.out.print("Enter the max range of distance traveled: ");
		int range = scan.nextInt();
		System.out.print("Set the price of the aircraft: ");
		long price = scan.nextLong();
		scan.nextLine();
		System.out.print("Assign a pilot: ");
		String pilot = scan.nextLine();
		System.out.println();
		switch (jetType) {
		case "passenger jet":
			PassengerJet userPassenger = new PassengerJet(model, speed, range, price, pilot);
			airfield.addJet(userPassenger);
			break;
		case "cargo jet":
			CargoJet userCargo = new CargoJet(model, speed, range, price, pilot);
			airfield.addJet(userCargo);
			break;
		case "fighter jet":
			FighterJet userFighter = new FighterJet(model, speed, range, price, pilot);
			airfield.addJet(userFighter);
			break;
		default:
			System.out.println("Error: could not meet specification requirements");
			break;
		}
		System.out.println(jetType + " added to the fleet");
	}

}
