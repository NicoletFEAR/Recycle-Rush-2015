
package com.nicoletfear.Robot2015.diagnostics;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {

    public Robot() {
      
    }

    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
        
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
    	SpeedController frontRight = new Talon(0);
        SpeedController frontLeft = new Talon(1);
        SpeedController backRight = new Talon(2);
        SpeedController backLeft = new Talon(3);
        while (isOperatorControl() && isEnabled()) {
            frontRight.set(0);
            frontLeft.set(0);
            backRight.set(0);
            backLeft.set(0);
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
