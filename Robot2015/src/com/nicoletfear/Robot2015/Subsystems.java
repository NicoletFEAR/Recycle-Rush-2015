package com.nicoletfear.Robot2015;

import com.nicoletfear.Robot2015.subsystems.ControllerChecker;
import com.nicoletfear.Robot2015.subsystems.DriveTrain;

public class Subsystems {
	public static final RioCheck rioCheck = new RoboRioCheck();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final ControllerChecker controllerChecker = new ControllerChecker();
}
