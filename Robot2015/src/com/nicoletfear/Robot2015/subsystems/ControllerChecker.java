package com.nicoletfear.Robot2015.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ControllerChecker extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void showWarning() {
    	SmartDashboard.putString("controllerScreen", "Press Start On Drive Controller");
    }
    public void clearWarning() {
    	SmartDashboard.putString("controllerScreen", "");
    }
}

