package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheckControllers extends Command {

    public CheckControllers() {
        // Use requires() here to declare subsystem dependencies
        requires(Subsystems.controllerChecker);
        setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.controllerChecker.showWarning();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Subsystems.controllerChecker.clearWarning();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}