package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.OI;
import com.nicoletfear.Robot2015.xbox.Axes;
import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command
{
	
	private static double lastLeft = 0, lastRight = 0;
	private static double newLeft, newRight;
	private static double leftStick, rightstick;
	private double ACCEL_WEIGHT = 0.09;

    public Drive() 
    {
    	requires(Subsystems.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
	{
    	leftStick = OI.driveStick.getRawAxis(Axes.leftControlStickY);
    	rightstick = OI.driveStickTwo.getRawAxis(Axes.leftControlStickY);
    	    	
    	newLeft = calculateNewVelocity(leftStick, lastLeft);
    	newRight = calculateNewVelocity(rightstick, lastRight);
    	
    	Subsystems.driveTrain.driveWheelsTank(newLeft * 1.07, newRight); //left speed controllers are more powerful than the right
    	
    	lastLeft = newLeft;
    	lastRight = newRight;
    }
    
    
    private double calculateNewVelocity(double current, double last)
    {
    	if(OI.aButtonOnDrive.get()){
    		return -0.5;
    	}else if(OI.bButtonOnDrive.get()){
    		return last * 0.01;
    	}else{
    		return last * (1 - ACCEL_WEIGHT) + current * ACCEL_WEIGHT;	
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
    
    public static double getLeftStick()
    {
    	return leftStick;
    }
    
    public static double getRightStick()
    {
    	return rightstick;
    }
    
    public static double getNewLeft()
    {
    	return newLeft;
    }
    
    public static double getNewRight()
    {
    	return newRight;
    }
    
    public static double getLastLeft()
    {
    	return lastLeft;
    }
    
    public static double getLastRight()
    {
    	return lastRight;
    }
}
