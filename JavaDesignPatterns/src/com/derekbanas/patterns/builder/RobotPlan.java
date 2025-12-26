package com.derekbanas.patterns.builder;

// Defines all the methods a Robot must have
public interface RobotPlan {
	
	public void setRobotoHead(String head);
	public void setRobotoTorso(String torso);
	public void setRobotoArms(String arms);
	public void setRobotoLegs(String legs);

}
