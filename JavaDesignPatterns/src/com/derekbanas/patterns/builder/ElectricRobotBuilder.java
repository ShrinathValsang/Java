package com.derekbanas.patterns.builder;

public class ElectricRobotBuilder implements RobotBuilder {
	
	private Robot robot;
	
	public ElectricRobotBuilder () {
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
