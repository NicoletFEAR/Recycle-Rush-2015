package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Subsystems;
import com.nicoletfear.Robot2015.commands.Backward;
import edu.wpi.first.wpilibj.command.Command;

public class ReverseForward extends Command 
{
	
	Command backward;
	
    public ReverseForward(double timeout) 
    {
    	super(timeout);
        requires(Subsystems.driveTrain);
    }

    protected void initialize()
    {
    }

    protected void execute() 
    {
    	Subsystems.driveTrain.autonomousDrive(0.3);
    }

    protected boolean isFinished() 
    {
    	return isTimedOut();
    }

    protected void end() 
    {

    	Subsystems.driveTrain.autonomousDrive(0);
    }

    protected void interrupted() 
    {
    	end();
    }
}
