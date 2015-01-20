
package com.nicoletfear.Robot2015;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

<<<<<<< HEAD
=======
import com.nicoletfear.Robot2015.commands.CheckControllers;
>>>>>>> 19de7475401b7ba815ce9e6edbca6b0ec291d641
import com.nicoletfear.Robot2015.commands.ExampleCommand;
import com.nicoletfear.Robot2015.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
<<<<<<< HEAD
	Compressor compressor;
	Solenoid solenoid1, solenoid2;

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

=======
>>>>>>> 19de7475401b7ba815ce9e6edbca6b0ec291d641
    Command autonomousCommand;
    public static CheckControllers checkControllers;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
<<<<<<< HEAD
		oi = new OI();
		solenoid1 = new Solenoid(0, 1);
		solenoid2 = new Solenoid(2, 3);
		solenoid1.set(true);
		solenoid2.set(true);
		compressor = new Compressor();
        compressor.start();
=======
>>>>>>> 19de7475401b7ba815ce9e6edbca6b0ec291d641
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        checkControllers = new CheckControllers();
        checkControllers.start();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
