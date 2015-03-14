package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStop extends Command {

    public AutoStop() {
    	requires(Subsystems.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.driveTrain.autonomousDrive(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.driveTrain.autonomousDrive(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Subsystems.driveTrain.autonomousDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
