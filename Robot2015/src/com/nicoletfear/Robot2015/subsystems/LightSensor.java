package com.nicoletfear.Robot2015.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LightSensor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DigitalInput lightSensor;
	DigitalOutput LEDOut;

	public LightSensor(){
		lightSensor = new DigitalInput(0);
		LEDOut = new DigitalOutput(1);
		LEDOut.set(false);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

