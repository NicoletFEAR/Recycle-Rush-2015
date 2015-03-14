package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.nicoletfear.Robot2015.Robot;

public class ArmDown extends Command 
{
	
	private boolean finishedRight = false;
	private boolean finishedLeft = false;

    public ArmDown() 
    {
    	requires(Robot.Dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	finishedRight = false;
    	finishedLeft = false;
    	
    	if(!Robot.Dog.downLimitPressedLeft())
    	{
    		Robot.Dog.downMotorTestLeft();
    	}
    	
    	if(!Robot.Dog.downLimitPressedRight())
    	{
    		Robot.Dog.downMotorTestRight();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.Dog.downLimitPressedRight())
    	{
    		Robot.Dog.stopMotorTestRight();
    		finishedRight = true;
    	}
    	
    	if(Robot.Dog.downLimitPressedLeft())
    	{
    		Robot.Dog.stopMotorTestLeft();
    		finishedLeft = true;
    	}
    }

    // Will return true when this Command no longer needs to run execute()
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
