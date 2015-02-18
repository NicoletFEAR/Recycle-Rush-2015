package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmStop extends Command
{
	boolean finished = false;
	
	public ArmStop()
	{
		requires(Robot.Dog);
	}

	@Override
	protected void initialize()
	{
		Robot.Dog.stopMotorTestRight();
		Robot.Dog.stopMotorTestLeft();
		finished = true;
	}
	
	@Override
	protected void execute() 
	{
		Robot.Dog.stopMotorTestRight();
		Robot.Dog.stopMotorTestLeft();
		finished = true;
	}

	@Override
	protected boolean isFinished() 
	{
		return finished;
	}
	
	@Override
	protected void end() 
	{
		Robot.Dog.stopMotorTestRight();
		Robot.Dog.stopMotorTestLeft();
	}

	@Override
	protected void interrupted() 
	{
		finished = true;
		end();
	}
}
