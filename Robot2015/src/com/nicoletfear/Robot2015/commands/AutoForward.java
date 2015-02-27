package com.nicoletfear.Robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoForward extends CommandGroup {
	
    public  AutoForward() {
    	//addSequential(new Forward(5.5));
    	addSequential(new Forward(6));
    	//addSequential(new Backward(2));
    	addSequential(new AutoStop());
        
        //backward = new Backward(2);
        //addSequential(new Forward(2));
    	//if (backward != null) backward.start();
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
