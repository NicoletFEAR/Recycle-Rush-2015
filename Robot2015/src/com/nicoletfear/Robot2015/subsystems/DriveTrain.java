package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.Subsystems;
import com.nicoletfear.Robot2015.commands.Drive;
import com.nicoletfear.Robot2015.Robot;


import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    SpeedController frontRight = new CANTalon(Subsystems.rioCheck.getPortNumber(2));
    SpeedController frontLeft = new CANTalon(Subsystems.rioCheck.getPortNumber(3));
    SpeedController backRight = new CANTalon(Subsystems.rioCheck.getPortNumber(1));
    SpeedController backLeft = new CANTalon(Subsystems.rioCheck.getPortNumber(0));
    
    RobotDrive drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	public DriveTrain() {
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);		//Inverts the right wheels of the right motors
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);		//Inverts the left wheels of the left motors
		
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
		frontRight.set(-x);
		frontLeft.set(x);
		backRight.set(-x);
		backLeft.set(x);
	}
}
		

