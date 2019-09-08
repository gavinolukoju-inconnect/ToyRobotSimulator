package com.zonedigital.toyrobotsimulator.test;

import org.junit.Test;

import com.zonedigital.toyrobotsimulator.exception.PlayAreaException;
import com.zonedigital.toyrobotsimulator.model.PlayArea;
import com.zonedigital.toyrobotsimulator.model.ToyRobot;
import com.zonedigital.toyrobotsimulator.model.ToyRobot.Orientation;

import static org.junit.Assert.*;

public class PlayAreaTest {
	
	@Test
	public void testPlaceRobot() {
		try {
			PlayArea.initialise(5,5);
		
			PlayArea.getInstance().placeRobot(0, 0, Orientation.NORTH);

			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.NORTH); 
		} catch (PlayAreaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMove() {
		try {
			PlayArea.initialise(5,5);
			PlayArea.getInstance().placeRobot(0, 0, Orientation.NORTH);

			PlayArea.getInstance().move();

			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 1);

		} catch (PlayAreaException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void testTurnLeft() {
		try {
			PlayArea.initialise(5,5);
			PlayArea.getInstance().placeRobot(0, 0, Orientation.NORTH);

			PlayArea.getInstance().turnLeft();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.WEST); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnLeft();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.SOUTH); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnLeft();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.EAST); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnLeft();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.NORTH); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			

		} catch (PlayAreaException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void testTurnRight() {
		try {
			PlayArea.initialise(5,5);
			PlayArea.getInstance().placeRobot(0, 0, Orientation.NORTH);

			PlayArea.getInstance().turnRight();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.EAST); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnRight();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.SOUTH); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnRight();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.WEST); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			
			PlayArea.getInstance().turnRight();

			assertEquals(ToyRobot.getInstance().getFacing(), Orientation.NORTH); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[0], 0); 
			assertEquals(ToyRobot.getInstance().getRobotPosition()[1], 0);
			

		} catch (PlayAreaException e) {

			e.printStackTrace();
		}
	}
	
	//test report


}
