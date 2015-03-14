package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.nicoletfear.Robot2015.Robot;

public class ArmUp extends Command 
{
	
	private boolean finishedRight = false;
	private boolean finishedLeft = false;

    public ArmUp() 
    {
    	requires(Robot.Dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	finishedRight = false;
    	finishedLeft = false;
    	
    	if(!Robot.Dog.upLimitPressedLeft())
    	{
    		Robot.Dog.upMotorTestLeft();
    	}
    	
    	if(!Robot.Dog.upLimitPressedRight())
    	{
    		Robot.Dog.upMotorTestRight();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.Dog.upLimitPressedRight())
    	{
    		Robot.Dog.stopMotorTestRight();
    		finishedRight = true;
    	}
    	
    	if(Robot.Dog.upLimitPressedLeft())
    	{
    		Robot.Dog.stopMotorTestLeft();
    		finishedLeft = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if(timeSinceInitialized() > 5)
    	{
    		finishedRight = true;
    		finishedLeft = true;
    	}
    	return finishedLeft && finishedRight;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.Dog.stopMotorTestRight();
    	Robot.Dog.stopMotorTestLeft();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	finishedRight = true;
    	finishedLeft = true;
    	end();
    }
}
