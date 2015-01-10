package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    SpeedController frontRight = new Talon(1);
    SpeedController frontLeft = new Talon(2);
    SpeedController backRight = new Talon(3);
    SpeedController backLeft = new Talon(4);
    RobotDrive drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	public DriveTrain() {
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);		//Inverts the right wheels of the right motors
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }

	public void driveWheels(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}
}

