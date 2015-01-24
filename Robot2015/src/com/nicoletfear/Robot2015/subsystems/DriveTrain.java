package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.Subsystems;
import com.nicoletfear.Robot2015.commands.Drive;
import com.nicoletfear.Robot2015.Robot;
import com.nicoletfear.Robot2015.xbox.Velocities;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    SpeedController frontRight = new TalonSRX(Subsystems.rioCheck.getPortNumber(2));
    SpeedController frontLeft = new TalonSRX(Subsystems.rioCheck.getPortNumber(3));
    SpeedController backRight = new Victor(Subsystems.rioCheck.getPortNumber(1));
    SpeedController backLeft = new Victor(Subsystems.rioCheck.getPortNumber(0));
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
	/*
    public void driveWheelsZeroTurn(double left, double right){
        Velocities newVelocities = calculateNewVelocityAndAccountForDeadzone(left, right);
        Velocities correctedTurn = correctForTurningZeroTurn(newVelocities); 
         outputToWheels(correctedTurn);
     }
     
     

     private void outputToWheels(Velocities correctedTurn) {
         rightWheel.set(-correctedTurn.getRightVelocity());
         leftWheel.set(correctedTurn.getLeftVelocity());
         System.out.println(correctedTurn.getLeftVelocity() + "," + correctedTurn.getRightVelocity());
     }

     private Velocities calculateNewVelocityAndAccountForDeadzone(double left, double right) {
         double lastRight = rightWheel.get();
         right = zeroWithinDeadzone(right);
         double newVeloRight = calculateNewVelocity(right, lastRight);
         double lastLeft = -leftWheel.get();//undo negatives from setting motors
         left = zeroWithinDeadzone(left);
         double newVeloLeft = calculateNewVelocity(left, lastLeft);
         Velocities newVelocities = new Velocities(-newVeloLeft, -newVeloRight);//wheels would run backwards without negative.
         return newVelocities;
     }
     
        
     /**
      * Returns 0 when value is within deadzone, otherwise returns the value.
      * @param value The value to check.
      * @return 0 when value is within deadzone, otherwise returns the value.
      *
     private double zeroWithinDeadzone(double value) {
         final double deadzone = .04;
         if(Math.abs(value) < deadzone) return 0;
         else return value;
     }

     /**
      * makes sure we don't go over a max accel so we dont rip up grass.
      * @param joyStick -the acceleration speed increase
      * @param last -the last recored speed increase
      * @return the new velocity
      *
     private double calculateNewVelocity(double joyStick, double last) {
         double maxAcc = SmartDashboard.getNumber("maxAcc");
         //double maxDecel = SmartDashboard.getNumber("maxDecel");
         double maxDecel = 0.1;
         double change = joyStick - last;
         double newVelo = 0.0;
         
         if (change <= 0 &&  joyStick > 0)
         {
             newVelo = last - maxDecel;//decel forward <- fast acel
         }
         else if (change <= 0 & joyStick < 0)
         {
             newVelo = last - maxAcc;//Accel back <- slow accel
         }
         else if (change >= 0 & joyStick > 0)
         {
             newVelo = last + maxAcc;//Accel foward <- slow accel
         }
         else if (change >= 0 & joyStick < 0)
         {
             newVelo = last + maxDecel;//decel back <- fast accel
         }
         else{
             newVelo = last + change;
         } return newVelo;
         
     }
    
     /**
      * The two velocities decides which direction the robot moves
      * @param leftVelocity
      * @param rightVelocity
      * @return returns the NewVelocities by keeping one the same and replacing the other with a min value.
      *
      *
     private Velocities correctForTurningZeroTurn(Velocities velocities) {
        double leftVelocity = velocities.getLeftVelocity();
        double rightVelocity = velocities.getRightVelocity();
        double min = SmartDashboard.getNumber("minVelocity");
        if (leftVelocity > 0 && rightVelocity <= 0) {
           return new Velocities (leftVelocity, /* rightVelocity * min);
        }
        else if (leftVelocity <= 0 && rightVelocity > 0) {
           return new Velocities (/* leftVelocity * min, rightVelocity); 
        }
        else if (leftVelocity == 0 && rightVelocity < 0) {
            return new Velocities(/* leftVelocity * -min, rightVelocity);
        }
        else if (leftVelocity < 0 && rightVelocity == 0) {
            return new Velocities(leftVelocity, /* rightVelocity * -min);
        }
        else {
            return new Velocities(leftVelocity, rightVelocity); 
        }
     }
     private Velocities correctForTurning (Velocities velocities) {
         double maxDiff = SmartDashboard.getNumber("SpeedControl");
        double leftVelocity = velocities.getLeftVelocity();
        double rightVelocity = velocities.getRightVelocity();
         if(leftVelocity > 0 || rightVelocity > 0) {
             if (maxDiff < leftVelocity - rightVelocity )
             {
             return new Velocities (leftVelocity, leftVelocity - maxDiff);

             }
             else if (maxDiff < rightVelocity - leftVelocity )
             {
                 return new Velocities (rightVelocity - maxDiff, rightVelocity);
             }
             else
             {
                 return new Velocities(leftVelocity, rightVelocity); 
             }
         }
         else {
             if (maxDiff < leftVelocity - rightVelocity )
             {
                 return new Velocities(rightVelocity + maxDiff, rightVelocity); 
             }
             else if (maxDiff < rightVelocity - leftVelocity )
             {
                 return new Velocities(leftVelocity, leftVelocity + maxDiff); 
             }
             else
             {
                 return new Velocities(leftVelocity, rightVelocity); 
             }
         }
     }*/
}
		

