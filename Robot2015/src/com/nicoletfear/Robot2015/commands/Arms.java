package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.OI;
import com.nicoletfear.Robot2015.Robot;
import com.nicoletfear.Robot2015.xbox.Axes;
import com.nicoletfear.Robot2015.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class Arms extends Command
{
	
	private static double rightstick;
	

    public Arms() 
    {
    	requires(Robot.Dog);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
	{
    	
    	rightstick = OI.gameMech.getRawAxis(Axes.rightControlStickY);
    	
    	if(Math.abs(rightstick) < 0.05){
    		/*double left = Robot.Dog.getLeftPosition();
    		double right = Robot.Dog.getRightPosition();
    		if ( left <  Robot.Dog.getLeftPosition()|| right >  Robot.Dog.getRightPosition()){
    			new ArmUp();
    		}
    		else
    		{*/
    			Robot.Dog.stopMotorTestLeft();
    			Robot.Dog.stopMotorTestRight();
    		//}
    	}else{
    		Robot.Dog.MotorTestLeftSpeed(rightstick);
        	Robot.Dog.MotorTestRightSpeed(rightstick);
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
    	Robot.Dog.stopMotorTestLeft();
    	Robot.Dog.stopMotorTestRight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
    
   
}
