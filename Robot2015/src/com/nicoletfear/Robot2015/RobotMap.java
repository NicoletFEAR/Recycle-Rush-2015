package com.nicoletfear.Robot2015;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	public static int TalonPortDogRight = 2;
	public static int TalonIDDogRight = 2;
	public static int TalonPortDogLeft = 13;
	public static int TalonIDDogLeft = 13;
    
	public static DigitalInput dogLimitSwitchTopRight;
	public static DigitalInput dogLimitSwitchBottomRight;
	public static DigitalInput dogLimitSwitchTopLeft;
	public static DigitalInput dogLimitSwitchBottomLeft;
    
    public static void init() 
    {
    	dogLimitSwitchTopRight = new DigitalInput(5);
    	LiveWindow.addSensor("dog", "LimitSwitchTopRight", dogLimitSwitchTopRight);
    	dogLimitSwitchBottomRight = new DigitalInput(4);
    	LiveWindow.addSensor("dog", "LimitSwitchBottomRight", dogLimitSwitchBottomRight);
    	
    	dogLimitSwitchTopLeft = new DigitalInput(6);
    	LiveWindow.addSensor("dog", "LimitSwitchTopLeft", dogLimitSwitchTopLeft);
    	dogLimitSwitchBottomLeft = new DigitalInput(7);
    	LiveWindow.addSensor("dog", "LimitSwitchBottomLeft", dogLimitSwitchBottomLeft);       
    }

	public static final int pressureSwitchChannel = 1;
    public static final int compressorRelayChannel = 8;
}
