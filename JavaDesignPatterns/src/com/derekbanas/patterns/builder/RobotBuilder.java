package com.derekbanas.patterns.builder;


// Defines what every Robot has
public interface RobotBuilder {
	
	public void buildRobotHead();
	public void buildRobotTorso();
	public void buildRobotArms();
	public void buildRobotLegs();
	public Robot getRobot();
}
