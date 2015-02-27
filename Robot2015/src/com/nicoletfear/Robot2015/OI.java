package com.nicoletfear.Robot2015;

import com.nicoletfear.Robot2015.commands.ArmStop;
import com.nicoletfear.Robot2015.commands.ArmUp;
//import com.nicoletfear.Robot2015.commands.AutonomousCommand;

import  com.nicoletfear.Robot2015.commands.ArmDown;
import com.nicoletfear.Robot2015.commands.Exhaust;
import com.nicoletfear.Robot2015.commands.Intake;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nicoletfear.Robot2015.xbox.Buttons;

import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI 
{
	public static final Joystick driveStick = new Joystick(0); 
    public static final Joystick driveStickTwo = new Joystick(1); 
	
	public static final Joystick gameMech = new Joystick(2);
	
	public static final Button startButtonOnDrive = new JoystickButton(driveStick , Buttons.Start);
	public static final Button aButtonOnDrive = new JoystickButton(driveStickTwo, Buttons.Trigger);
	public static final Button bButtonOnDrive = new JoystickButton(driveStick, Buttons.B);
	
	
	public static Button yButton = new JoystickButton(gameMech , Buttons.Y);
	public static Button aButton = new JoystickButton(gameMech , Buttons.A);
	public static Button bButton = new JoystickButton(gameMech , Buttons.B);
	public static Button rbButton = new JoystickButton(gameMech , Buttons.RightBump);
	public static Button lbButton = new JoystickButton(gameMech , Buttons.LeftBump);
	
	
	
	static
	{
		SmartDashboard.putData(Subsystems.driveTrain);
		
	}
	public OI() 
	{
		
		yButton.whenPressed(new ArmUp());
		aButton.whenPressed(new ArmDown());
		bButton.whenPressed(new ArmStop());
		rbButton.whileHeld(new Intake());
		lbButton.whileHeld(new Exhaust());
        	
        SmartDashboard.putData("ArmUp", new ArmUp());
       
    }
}

