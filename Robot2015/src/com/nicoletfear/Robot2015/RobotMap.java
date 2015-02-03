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
	public static int TalonPortDog = 12;
	public static int TalonIDDog = 12;
    //public static SpeedController dogMotor;
    
	public static DigitalInput dogLimitSwitchTop;
	
    
    public static void init() {
    	dogLimitSwitchTop = new DigitalInput(5);
    	LiveWindow.addSensor("dog", "LimitSwitchTop", dogLimitSwitchTop);
               
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
