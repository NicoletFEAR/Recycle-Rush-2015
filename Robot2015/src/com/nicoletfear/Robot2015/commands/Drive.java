package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.OI;
import com.nicoletfear.Robot2015.xbox.Axes;
import com.nicoletfear.Robot2015.Subsystems;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
    	requires(Subsystems.driveTrain);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = OI.driveStick.getRawAxis(Axes.leftControlStickX);
    	double y = OI.driveStick.getRawAxis(Axes.leftControlStickY);
    	double rotation = OI.driveStick.getRawAxis(Axes.rightControlStickX);
    	Subsystems.driveTrain.driveWheelsTank(x, y);
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
