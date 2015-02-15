package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.Subsystems;
import com.nicoletfear.Robot2015.commands.Drive;
import com.nicoletfear.Robot2015.Robot;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
    CANTalon backright = new CANTalon(1); //backright
	CANTalon frontright = new CANTalon(2); //frontright
	CANTalon frontleft = new CANTalon(3); //frontleft
	CANTalon backleft = new CANTalon(0); //backleft
	
	/*
	CANTalon backright = new CANTalon(0); //backright
	CANTalon frontright = new CANTalon(1); //frontright
	CANTalon frontleft = new CANTalon(14); //frontleft
	CANTalon backleft = new CANTalon(15); //backleft
	*/
    
    RobotDrive drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	public DriveTrain() {
		//drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		drive = new RobotDrive(frontleft, frontright);
		
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);		//Inverts the right wheels of the right motors
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);		//Inverts the left wheels of the left motors
	 
		frontright.reverseSensor(true);
		frontright.reverseOutput(true);
		frontleft.reverseSensor(true);
		frontleft.reverseOutput(true);
		
	    backright.changeControlMode(CANTalon.ControlMode.Follower);
	    backright.set(frontright.getDeviceID());
	    backleft.changeControlMode(CANTalon.ControlMode.Follower);
	    backleft.set(frontleft.getDeviceID());
	   
	    frontright.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	   // frontleft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	    
	    
	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }

	public void driveWheelsMecanum(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}	
	
	public void driveWheelsTank(double leftValue, double rightValue){
		
		drive.tankDrive(leftValue, rightValue, true);
	}
	
	public void autonomousDrive(double x){
		frontright.set(-x);
		frontleft.set(x);
		
	}
}

		

