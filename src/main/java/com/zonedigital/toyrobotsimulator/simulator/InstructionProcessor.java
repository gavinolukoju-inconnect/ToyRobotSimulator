package com.zonedigital.toyrobotsimulator.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

import com.zonedigital.toyrobotsimulator.exception.PlayAreaException;
import com.zonedigital.toyrobotsimulator.model.PlayArea;
import com.zonedigital.toyrobotsimulator.model.ToyRobot;
import com.zonedigital.toyrobotsimulator.model.ToyRobot.Orientation;

public class InstructionProcessor {

	//interpret instruction
	public static void processInstruction(final String instruction, boolean echo) throws PlayAreaException {

		String normalisedInstruction = instruction.trim().toUpperCase();

		if(normalisedInstruction.startsWith("PLACE")) {

			String parameters = normalisedInstruction.substring("PLACE".length());

			StringTokenizer stringTokenizer = new StringTokenizer(parameters.trim(), ",");

			while (stringTokenizer.hasMoreElements()) {

				int x = Integer.parseInt(stringTokenizer.nextElement().toString());
				int y = Integer.parseInt(stringTokenizer.nextElement().toString());
				String orientation = stringTokenizer.nextElement().toString().trim();
				
				switch(orientation) 
				{

				case "NORTH" :
					PlayArea.getInstance().placeRobot(x, y, Orientation.NORTH);
					break;
				case "SOUTH" :
					PlayArea.getInstance().placeRobot(x, y, Orientation.SOUTH);
					break;
				case "EAST" :
					PlayArea.getInstance().placeRobot(x, y, Orientation.EAST);
					break;
				case "WEST" :
					PlayArea.getInstance().placeRobot(x, y, Orientation.WEST);
					break;
				default: 
					//do nothing
					break;

				}
				if(echo) {
					System.out.println("PLACE " + x +"," + y +"," + orientation);
				}
			}
		} else if (normalisedInstruction.startsWith("MOVE")) {		
			PlayArea.getInstance().move();
			if(echo) {
				System.out.println("MOVE");
			}
		} else if (normalisedInstruction.startsWith("LEFT")) {		
			PlayArea.getInstance().turnLeft();
			if(echo) {
				System.out.println("LEFT");
			}
		} else if (normalisedInstruction.startsWith("RIGHT")) {
			PlayArea.getInstance().turnRight();
			if(echo) {
				System.out.println("RIGHT");
			}
		} else if (normalisedInstruction.startsWith("REPORT")) {
			if(echo) {
				System.out.println("REPORT");
			}
			System.out.println(ToyRobot.getInstance().report());
		}
	}
	
	 //load file
	public static void loadFile(final String fileName) throws IOException {

		try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			for(String line; (line = br.readLine()) != null; ) {
				// process the line.
				processInstruction(line, true);
			}
		} catch (PlayAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialisePlayArea() {
		PlayArea.initialise(5,5);
	}
	
	//echo and iterate over instructions

	public static void main(String [] args) {
		try {
			PlayArea.initialise(5,5);
			loadFile(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
