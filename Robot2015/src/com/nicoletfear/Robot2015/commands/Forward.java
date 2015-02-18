package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;
import com.nicoletfear.Robot2015.commands.Backward;
import edu.wpi.first.wpilibj.command.Command;

public class Forward extends Command 
{
	
	Command backward;
	
    public Forward(double timeout) 
    {
    	super(timeout);
        requires(Subsystems.driveTrain);
    }

    protected void initialize()
    {
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
    	backward = new Backward(2);
    	if (backward != null) backward.start();
    }

    protected void interrupted() 
    {
    	end();
    }
}
