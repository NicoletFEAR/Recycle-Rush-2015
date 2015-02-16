package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nicoletfear.Robot2015.Robot;
import com.nicoletfear.Robot2015.RobotMap;

/**
 *
 */
public class ArmUp extends Command {
	
	private boolean finishedRight = false;
	private boolean finishedLeft = false;

    public ArmUp() {
    	requires(Robot.dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	finishedLeft = false;
    	finishedRight = false;
    	
    	if(!Robot.dog.upLimitPressedLeft()){
    		Robot.dog.upMotorTestLeft();
    	}
    	
    	if(!Robot.dog.upLimitPressedRight()){
    		Robot.dog.upMotorTestRight();
    	}
    	/*
    	finishedRight = false;
    	finishedLeft = false;
    	
    	if(Robot.dog.upLimitPressedRight() == true){
    		finishedRight = true;
    	}
    	
    	if(Robot.dog.upLimitPressedLeft() == true){
    		finishedLeft = true;
    	}
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.dog.upLimitPressedRight()){
    		Robot.dog.stopMotorTestRight();
    	}
    	
    	if(Robot.dog.upLimitPressedLeft()){
    		Robot.dog.stopMotorTestLeft();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.dog.upLimitPressedRight() == true){
    		finishedRight = true;
    	}
    	
    	if(Robot.dog.upLimitPressedLeft() == true){
    		finishedLeft = true;
    	}
    	
    	if(timeSinceInitialized() > 10){
    		finishedRight = true;
    		finishedLeft = true;
    	}
    	return finishedLeft && finishedRight;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dog.stopMotorTestRight();
    	Robot.dog.stopMotorTestLeft();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	finishedRight = true;
    	finishedLeft = true;
    	end();
    }
}
