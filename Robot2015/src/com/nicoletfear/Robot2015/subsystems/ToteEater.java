package com.nicoletfear.Robot2015.subsystems;

import com.nicoletfear.Robot2015.commands.Exhaust;
import com.nicoletfear.Robot2015.commands.Intake;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteEater extends Subsystem {
    
    Victor toteEaterControllerRight = new Victor(0);
    Victor toteEaterControllerLeft = new Victor(1);
   
    public final double MAX_TOTEEATER = 1;

    public void initDefaultCommand() {
    	setDefaultCommand(new Exhaust());
    	setDefaultCommand(new Intake());
    }
    
    public void intake(){
    	toteEaterControllerRight.set(MAX_TOTEEATER);
    	toteEaterControllerLeft.set(-MAX_TOTEEATER);
    }
    
    public void exhaust(){
    	toteEaterControllerRight.set(-MAX_TOTEEATER);
    	toteEaterControllerLeft.set(MAX_TOTEEATER);
    }
    
    public void stopEater(){
    	toteEaterControllerRight.set(0);
    	toteEaterControllerLeft.set(0);
    }
}

