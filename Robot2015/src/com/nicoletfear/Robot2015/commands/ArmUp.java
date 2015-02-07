package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nicoletfear.Robot2015.Robot;
import com.nicoletfear.Robot2015.RobotMap;

/**
 *
 */
public class ArmUp extends Command {

	private boolean finished = false;
	
    public ArmUp() {
    	requires(Robot.dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    	if(Robot.dog.upLimitPressed() == true){
    		finished = true;
    	}else{
    		Robot.dog.upMotorTest();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!finished){
    		if(Robot.dog.upLimitPressed() == false)
        	{
        		Robot.dog.upMotorTest();
        	}
        	else
        	{
        		Robot.dog.stopMotorTest();
        		finished = true;
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dog.stopMotorTest();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	finished = true;
    	end();
    }
}
