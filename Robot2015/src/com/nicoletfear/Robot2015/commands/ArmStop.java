package com.nicoletfear.Robot2015.commands;

import com.nicoletfear.Robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmStop extends Command{
	boolean finished = false;
	
	public ArmStop(){
		requires(Robot.dog);
	}

	@Override
	protected void initialize() {
		Robot.dog.stopMotorTestRight();
		Robot.dog.stopMotorTestLeft();
		finished = true;
	}
	
	@Override
	protected void execute() {
		Robot.dog.stopMotorTestRight();
		Robot.dog.stopMotorTestLeft();
		finished = true;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}
	
	@Override
	protected void end() {
		Robot.dog.stopMotorTestRight();
		Robot.dog.stopMotorTestLeft();
	}

	@Override
	protected void interrupted() {
		finished = true;
		end();
	}
}
