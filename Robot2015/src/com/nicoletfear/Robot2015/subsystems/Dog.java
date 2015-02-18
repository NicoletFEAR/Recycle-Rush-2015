// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Dog extends Subsystem 
{
    DigitalInput limitSwitchTopRight = RobotMap.dogLimitSwitchTopRight;
    DigitalInput limitSwitchBottomRight = RobotMap.dogLimitSwitchBottomRight;
    DigitalInput limitSwitchTopLeft = RobotMap.dogLimitSwitchTopLeft;
    DigitalInput limitSwitchBottomLeft = RobotMap.dogLimitSwitchBottomLeft;
    
    CANTalon dogMotorRight = new CANTalon(RobotMap.TalonIDDogRight);
    CANTalon dogMotorLeft = new CANTalon(RobotMap.TalonIDDogLeft);
    public final double MAXGAMEMECH = 1.0;
    
    public void initDefaultCommand() 
    {
    }
    
    public void stopMotorTestRight()
    {
    	dogMotorRight.set(0);
    }
    
    public void stopMotorTestLeft()
    {
    	dogMotorLeft.set(0);
    }
    
    public void upMotorTestRight()
    {
    	dogMotorRight.set(MAXGAMEMECH);
    }
    
    public void downMotorTestRight()
    {
    	dogMotorRight.set(-MAXGAMEMECH);
    }
    
    public void upMotorTestLeft()
    {
    	dogMotorLeft.set(-MAXGAMEMECH);
    }
    
    public void downMotorTestLeft()
    {
    	dogMotorLeft.set(MAXGAMEMECH);
    }
    
    public double getRightVelocity()
    {
    	return dogMotorRight.getEncVelocity();
    }
    
    public double getRightPosition()
    {
    	return dogMotorRight.getEncPosition();
    }
    
    public double getLeftVelocity()
    {
    	return dogMotorLeft.getEncVelocity();
    }
    
    public double getLeftPosition()
    {
    	return dogMotorLeft.getEncPosition();
    }
    
    public boolean upLimitPressedRight()
    {
    	if(RobotMap.dogLimitSwitchTopRight.get())
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public boolean downLimitPressedRight()
    {
    	return !RobotMap.dogLimitSwitchBottomRight.get();
    }
    
    public boolean upLimitPressedLeft()
    {
    	if(RobotMap.dogLimitSwitchTopLeft.get())
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public boolean downLimitPressedLeft()
    {
    	return !RobotMap.dogLimitSwitchBottomLeft.get();
    }
}

