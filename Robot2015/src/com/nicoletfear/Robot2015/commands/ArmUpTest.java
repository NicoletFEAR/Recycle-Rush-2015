package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nicoletfear.Robot2015.Robot;
import com.nicoletfear.Robot2015.RobotMap;

/**
 *
 */
public class ArmUpTest extends Command {

    public ArmUpTest() {
    	requires(Robot.dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(RobotMap.dogLimitSwitchTop.get()){
    		RobotMap.dogMotor.set(0.25);
    	}else{
    		RobotMap.dogMotor.set(0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.dogLimitSwitchTop.get()){
    		RobotMap.dogMotor.set(0.25);
    	}else{
    		RobotMap.dogMotor.set(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
