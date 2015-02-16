package com.nicoletfear.Robot2015;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CANTalon;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
// Test comment - remove later
	
	//public static int TalonPortDog = 12;
	//public static int TalonIDDog = 12;
	//remove above
	public static int TalonPortDogRight = 2;
	public static int TalonIDDogRight = 2;
	public static int TalonPortDogLeft = 13;
	public static int TalonIDDogLeft = 13;
	
    //public static SpeedController dogMotor;
    
	public static DigitalInput dogLimitSwitchTopRight;
	public static DigitalInput dogLimitSwitchBottomRight;
	public static DigitalInput dogLimitSwitchTopLeft;
	public static DigitalInput dogLimitSwitchBottomLeft;
    
    public static void init() {
    	dogLimitSwitchTopRight = new DigitalInput(5);
    	LiveWindow.addSensor("dog", "LimitSwitchTopRight", dogLimitSwitchTopRight);
    	dogLimitSwitchBottomRight = new DigitalInput(4);
    	LiveWindow.addSensor("dog", "LimitSwitchBottomRight", dogLimitSwitchBottomRight);
    	
    	dogLimitSwitchTopLeft = new DigitalInput(6);
    	LiveWindow.addSensor("dog", "LimitSwitchTopLeft", dogLimitSwitchTopLeft);
    	dogLimitSwitchBottomLeft = new DigitalInput(7);
    	LiveWindow.addSensor("dog", "LimitSwitchBottomLeft", dogLimitSwitchBottomLeft);       
    }
       
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static final int pressureSwitchChannel = 1;
    public static final int compressorRelayChannel = 8;
}
