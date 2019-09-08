package com.zonedigital.toyrobotsimulator.repl;

import java.util.Scanner;

import com.zonedigital.toyrobotsimulator.exception.PlayAreaException;
import com.zonedigital.toyrobotsimulator.simulator.InstructionProcessor;

public class ToyRobotSimulator {
	private static Scanner scanner;
	
	private static String showHelp() {
		StringBuilder helpScreen = new StringBuilder();
		
		helpScreen.append("Commands List\n");
		helpScreen.append("=============\n\n");
		helpScreen.append("PLACE X,Y, ORIENTATION - (X = int, Y = int, ORIENTATION = NORTH, EAST, SOUTH, WEST)\n");
		helpScreen.append("MOVE - Moves the toy robot one unit forward in the direction it is currently facing.\n");
		helpScreen.append("LEFT - Will rotate the robot 90° anticlockwise without changing the position of the robot.\n");
		helpScreen.append("RIGHT - Rotate the robot 90° clockwise without changing the position of the robot.\n");
		helpScreen.append("REPORT - Outputs the X,Y coordinates and orientation of the robot.\n");
		
		return helpScreen.toString();
	}

	public static void main(String[] args) throws Exception{

		scanner = new Scanner(System.in);
		String command = "";

		System.out.println("...Toy Robot Simulator...");
		System.out.println("Your play area is a 5x5 grid, your robot is placed at [0,0] facing north. 0,0 is the most SOUTH WEST corner");
		System.out.println("Enter commands to play. use --help for instructions.");

		InstructionProcessor.initialisePlayArea();
		InstructionProcessor.processInstruction("PLACE 0,0,NORTH", false);
		
		while(command != null && !command.equalsIgnoreCase("exit")) {
			//  prompt for the next instruction
			System.out.print("$> ");

			// get their input as a String
			command = scanner.nextLine();

			if(command.equalsIgnoreCase("--help")) {
				System.out.println(showHelp());
			} else if(command.equalsIgnoreCase("exit")) {
				System.out.println("Thank You, Exiting");
			} else {
				try {
					if(!CommandValidator.validInstruction(command)) {
						System.out.println("Invalid command " + command);
					} else {
						//process the instruction
						InstructionProcessor.processInstruction(command, false);
					}
				} catch (PlayAreaException paEx){
					System.out.println(paEx.getMessage());
				} catch (Exception ex) {
					System.out.println("Invalid command " + command);
				}
			}
		}
	}
}
