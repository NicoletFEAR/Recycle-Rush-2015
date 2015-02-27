package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	double m_left, m_right;
	double newRight;
	double newLeft;
	
    public AutoDrive(double left, double right, double time) {
    	super(time);
    	m_left = left;
    	m_right = right;
        // Use requires() here to declare subsystem dependencies
    	requires(Subsystems.driveTrain); // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	m_left = turnRight(0);
    	m_right = turnLeft(0);
    	Subsystems.driveTrain.driveWheelsTank(m_left, m_right);
    }
    
    private double turnRight(double degrees)
    {
    	return newRight;
    }
    
    private double turnLeft(double degrees)
    {
    	return newLeft;
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Subsystems.driveTrain.driveWheelsTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
