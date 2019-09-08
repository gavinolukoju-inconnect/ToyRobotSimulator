package com.zonedigital.toyrobotsimulator.model;

public class ToyRobot {

	public enum Orientation {
		NORTH, SOUTH, EAST, WEST;
	}

	//2d array representing the robots position in space X=0, Y=1
	private int[] robotPosition = new int[2];

	//robots orientation in space North, South, East, West only
	private Orientation facing;

	private static ToyRobot _instance;

	private ToyRobot() {
		resetRobot();
	}

	public static ToyRobot getInstance() {
		if(_instance == null) {
			_instance = new ToyRobot();
		}

		return _instance;

	}
	
	public void resetRobot() {
		this.robotPosition[0] = 0;
		this.robotPosition[1] = 1;
		this.facing = Orientation.NORTH;
	}

	public String report() {
		return ("Output: " + this.robotPosition[0]  + "," + this.robotPosition[1] + "," + this.getFacing());
	}

	/*******************************************************************/
	/****************** UNCHANGED ACCESSOR METHODS FOLLOW **************/
	/*******************************************************************/

	public int[] getRobotPosition() {
		return robotPosition;
	}

	public void setRobotPosition(int[] robotPosition) {
		this.robotPosition = robotPosition;
	}

	public Orientation getFacing() {
		return facing;
	}

	public void setFacing(Orientation facing) {
		this.facing = facing;
	}


}
