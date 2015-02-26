
package com.nicoletfear.Robot2015;

import com.nicoletfear.Robot2015.RobotMap;
import com.nicoletfear.Robot2015.commands.Forward;
import com.nicoletfear.Robot2015.subsystems.Dog;
import com.nicoletfear.Robot2015.commands.Drive;



import com.nicoletfear.Robot2015.commands.ReverseBackward;
import com.nicoletfear.Robot2015.commands.ReverseForward;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	

	Compressor compressor;
	Solenoid solenoid1, solenoid2;

	public static OI oi;
	
	
	Command forward;
	Command backward;
	Command reversebackward;
	Command reverseforward;
	
    Command autonomousCommand;
    
    public static Dog Dog;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	 RobotMap.init();
    	 
        Dog = new Dog();
    	
		oi = new OI();
		solenoid1 = new Solenoid(0, 1);
		solenoid2 = new Solenoid(2, 3);
		compressor = new Compressor();
        compressor.start();

        forward = new Forward(6);
        //reversebackward = new ReverseBackward(6);
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run	();
	}

	public void autonomousInit() 
	{
        if (forward != null) forward.start();
        
       // if (reversebackward != null) reversebackward.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    	Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
    	//putNumber instead of putDouble should work, test later.
    	SmartDashboard.putNumber("LeftDrive Setpoint", Drive.getNewLeft());
		SmartDashboard.putNumber("LeftDrive Joystick Position", Drive.getLeftStick());
		SmartDashboard.putNumber("LeftDrive Encoder Position", Subsystems.driveTrain.getEncPositionLeft());
		SmartDashboard.putNumber("LeftDrive Speed", Drive.getLastLeft());
		
		SmartDashboard.putNumber("RightDrive Setpoint", Drive.getNewRight());
		SmartDashboard.putNumber("RightDrive Joystick Position", Drive.getRightStick());
		SmartDashboard.putNumber("RightDrive Encoder Position", Subsystems.driveTrain.getEncPositionRight());
		SmartDashboard.putNumber("RightDrive Speed", Drive.getLastRight());
		
		SmartDashboard.putNumber("LeftArm Position", Dog.getLeftPosition());
		SmartDashboard.putNumber("LeftArm Speed", Dog.getLeftVelocity());
		
		SmartDashboard.putNumber("RightArm Position", Dog.getRightPosition());
		SmartDashboard.putNumber("RightArm Speed", Dog.getRightVelocity());
				
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
