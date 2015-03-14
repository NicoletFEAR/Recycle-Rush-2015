package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseForward extends Command 
{
	
    public ReverseForward(double timeout) 
    {
    	super(timeout);
        requires(Subsystems.driveTrain);
    }

    protected void initialize()
    {
    	Subsystems.driveTrain.autonomousDrive(0.3);
    }

    protected void execute() 
    {
    }

    protected boolean isFinished() 
    {
    	return isTimedOut();
    }

    protected void end() 
    {
    }

    protected void interrupted() 
    {
    	end();
    }
}
