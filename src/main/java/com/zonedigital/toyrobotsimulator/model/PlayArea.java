package com.zonedigital.toyrobotsimulator.model;

import com.zonedigital.toyrobotsimulator.exception.PlayAreaException;
import com.zonedigital.toyrobotsimulator.model.ToyRobot.Orientation;

public class PlayArea {

	private int maxX;
	private int maxY;
	private boolean placedRobot = false;
	
	private static PlayArea _instance = null;
	
	private PlayArea() {
		super();
	}

	public static void initialise(final int maxX, final int maxY) {
		getInstance().maxX = maxX;
		getInstance().maxY = maxY;
	}
	
	public static PlayArea getInstance() {
		if(_instance == null) {
			 _instance = new PlayArea();
		} 
		
		return _instance;
	}

	
	private void incX() throws PlayAreaException {
		if(ToyRobot.getInstance().getRobotPosition()[0] + 1 > getInstance().maxX) {
			throw new PlayAreaException("Unable to comply, Robot would leave the play area");
		} else {
			ToyRobot.getInstance().getRobotPosition()[0]++;
		}
	}

	private void decX() throws PlayAreaException {
		if(ToyRobot.getInstance().getRobotPosition()[0] - 1 < 0) {
			throw new PlayAreaException("Unable to comply, Robot would leave the play area");
		} else {
			ToyRobot.getInstance().getRobotPosition()[0]--;
		}
	}

	private void incY() throws PlayAreaException {
		if(ToyRobot.getInstance().getRobotPosition()[1] + 1 > getInstance().maxY) {
			throw new PlayAreaException("Unable to comply, Robot would leave the play area");
		} else {
			ToyRobot.getInstance().getRobotPosition()[1]++;
		}
	}

	private void decY() throws PlayAreaException {
		if(ToyRobot.getInstance().getRobotPosition()[1] - 1 < 0) {
			throw new PlayAreaException("Unable to comply, Robot would leave the play area");
		} else {
			ToyRobot.getInstance().getRobotPosition()[1]--;
		}
	}


	/**
	 * Move the robot forward based on the orientation of the robot
	 * @throws PlayAreaException
	 */
	public void move() throws PlayAreaException {
		if(getInstance().placedRobot) {
			switch(ToyRobot.getInstance().getFacing()) {

			case NORTH :
				this.incY();
				break;
			case SOUTH :
				this.decY();
				break;
			case EAST :
				this.incX();
				break;
			case WEST :
				this.decX();
				break;
			default: 
				//do nothing
				break;

			}
		} else {
			throw new PlayAreaException("Robot not in the play area");
		}
	}
	
	public void placeRobot(final int x, final int y, Orientation orientation) throws PlayAreaException {
		
		if((x > getInstance().maxX) || (y > getInstance().maxY)) {
			getInstance().placedRobot = false;
			throw new PlayAreaException("Robot must be placed within the play space, co-ordinates [" + x + ", "+ y + "] are out of bounds");
		} else {
			ToyRobot.getInstance().setRobotPosition(new int[]{x,y});
			ToyRobot.getInstance().setFacing(orientation);
			getInstance().placedRobot = true;
		}
	}

	/**
	 * Method to turn the orientation of the robot to the left on the spot
	 * @throws PlayAreaException 
	 */
	public void turnLeft() throws PlayAreaException {
		if(getInstance().placedRobot) {
			switch(ToyRobot.getInstance().getFacing()) {

			case NORTH :
				ToyRobot.getInstance().setFacing(Orientation.WEST);
				break;
			case SOUTH :
				ToyRobot.getInstance().setFacing(Orientation.EAST);
				break;
			case EAST :
				ToyRobot.getInstance().setFacing(Orientation.NORTH);
				break;
			case WEST :
				ToyRobot.getInstance().setFacing(Orientation.SOUTH);
				break;
			default: 
				//do nothing
				break;

			}
		} else {
			throw new PlayAreaException("Robot not in the play area");
		}
	}

	/**
	 * Method to turn the orientation of the robot to the right on the spot
	 * @throws PlayAreaException 
	 */
	public void turnRight() throws PlayAreaException {
		if(getInstance().placedRobot) {
			switch(ToyRobot.getInstance().getFacing()) {

			case NORTH :
				ToyRobot.getInstance().setFacing(Orientation.EAST);
				break;
			case SOUTH :
				ToyRobot.getInstance().setFacing(Orientation.WEST);
				break;
			case EAST :
				ToyRobot.getInstance().setFacing(Orientation.SOUTH);
				break;
			case WEST :
				ToyRobot.getInstance().setFacing(Orientation.NORTH);
				break;
			default: 
				//do nothing
				break;

			}
		}else {
			throw new PlayAreaException("Robot not in the play area");
		}
	}
}

