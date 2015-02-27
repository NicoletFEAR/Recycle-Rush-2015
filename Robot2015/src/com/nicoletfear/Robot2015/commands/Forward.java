package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

//Autonomous forward speed is about 2.33 feet per second
public class Forward extends Command 
{
	
    public Forward(double timeout) 
    {
    	super(timeout);
        requires(Subsystems.driveTrain);
    }

    protected void initialize()
    {
    	Subsystems.driveTrain.autonomousDrive(0.35);
    }

    protected void execute() 
    {
    	Subsystems.driveTrain.autonomousDrive(0.35);
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
