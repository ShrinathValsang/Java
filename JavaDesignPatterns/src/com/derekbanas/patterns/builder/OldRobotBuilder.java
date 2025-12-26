package com.derekbanas.patterns.builder;

// Set fields for Robot built using these specifications
public class OldRobotBuilder implements RobotBuilder {
	
	private Robot robot;
	
	public OldRobotBuilder () {
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		robot.setRobotoHead("Tin robot head");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotoTorso("Tin robot torso");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobotoArms("Blowtorch arms");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotoLegs("Roller skates");
	}

	@Override
	public Robot getRobot() {
		return this.robot;
	}

}
