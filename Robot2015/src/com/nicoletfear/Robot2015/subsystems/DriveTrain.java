package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.commands.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem 
{	
	
	// Test robot ID's
	/*
    CANTalon backright = new CANTalon(1); //backright
	CANTalon frontright = new CANTalon(2); //frontright
	CANTalon frontleft = new CANTalon(3); //frontleft
	CANTalon backleft = new CANTalon(0); //backleft
	*/
	
	CANTalon backright = new CANTalon(0); //backright
	CANTalon frontright = new CANTalon(1); //frontright
	CANTalon frontleft = new CANTalon(14); //frontleft
	CANTalon backleft = new CANTalon(15); //backleft
    
    RobotDrive drive;
    
	public DriveTrain() 
	{
		//drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		drive = new RobotDrive(backleft, backright);
		
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);		//Inverts the right wheels of the right motors
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);		//Inverts the left wheels of the left motors
	 
		/*
		backright.reverseSensor(true); // <- this might be messing it up
		backright.reverseOutput(true);
		backleft.reverseSensor(true);
		backleft.reverseOutput(true);
		*/
		
	    frontright.changeControlMode(CANTalon.ControlMode.Follower);
	    frontright.set(backright.getDeviceID());
	    frontleft.changeControlMode(CANTalon.ControlMode.Follower);
	    frontleft.set(backleft.getDeviceID());
	   
	    backright.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	    backleft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	    
	    SmartDashboard.putNumber("frontRightP", frontright.getP());//putNumber instead of putDouble
		SmartDashboard.putNumber("backRightP", backright.getP());
		SmartDashboard.putNumber("frontLeftP", frontleft.getP());
		SmartDashboard.putNumber("backLeftP", backleft.getP());
		
		SmartDashboard.putNumber("frontRightI", frontright.getI());
		SmartDashboard.putNumber("backRightI", backright.getI());
		SmartDashboard.putNumber("frontLeftI", frontleft.getI());
		SmartDashboard.putNumber("backLeftI", backleft.getI());
		
		SmartDashboard.putNumber("frontRightD", frontright.getD());
		SmartDashboard.putNumber("backRightD", backright.getD());
		SmartDashboard.putNumber("frontLeftD", frontleft.getD());
		SmartDashboard.putNumber("backLeftD", backleft.getD());
	
	}
	
    public void initDefaultCommand() 
    {
        setDefaultCommand(new Drive());
    }

	public void driveWheelsMecanum(double x, double y, double rotation) 
	{
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}	
	
	public void driveWheelsTank(double leftValue, double rightValue)
	{
		
		drive.tankDrive(leftValue, rightValue, true);
	}
	
	public void autonomousDrive(double x)
	{
		backright.set(-x);
		backleft.set(x);
		
	}
	
	public double getEncPositionLeft()
	{
	    return backleft.getEncPosition();
	}
	
	public double getEncPositionRight()
	{
		return backright.getEncPosition();
	}
}

		

