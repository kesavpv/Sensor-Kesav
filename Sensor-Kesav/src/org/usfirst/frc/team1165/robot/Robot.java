package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.subsystems.AbsoluteEncoder;
import org.usfirst.frc.team1165.robot.subsystems.Accelerometer;
import org.usfirst.frc.team1165.robot.subsystems.Camera;
import org.usfirst.frc.team1165.robot.subsystems.Camera.CameraMode;
import org.usfirst.frc.team1165.robot.subsystems.ImuDigitalComboBoard;
import org.usfirst.frc.team1165.robot.subsystems.MaxBotixProximitySensor;
import org.usfirst.frc.team1165.robot.subsystems.MaxBotixProximitySensor.Model;
import org.usfirst.frc.team1165.robot.subsystems.PIDDemo;
import org.usfirst.frc.team1165.robot.subsystems.UserButton;
import org.usfirst.frc.team1165.robot.subsystems.VexRangeFinder;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	/**
	 * Subsystems
	 */
	public static final UserButton userButton = new UserButton();
	public static final Accelerometer roboRIOAccelerometer = new Accelerometer();
//	public static final Camera camera = new Camera(RobotMap.CAMERA_NAME, CameraMode.SUBSYSTEM);
	public static final AbsoluteEncoder absoluteEncoder = new AbsoluteEncoder();
	public static final VexRangeFinder vexRangeFinder = new VexRangeFinder(RobotMap.VEX_PING_CHANNEL, RobotMap.VEX_ECHO_CHANNEL);

//	public static final MaxBotixProximitySensor mb1013 = new MaxBotixProximitySensor(Model.MB1013, new SerialPort(9600, SerialPort.Port.kOnboard), new AnalogInput(RobotMap.ANALOG_INPUT_PORT));
//	public static final MaxBotixProximitySensor mb1200 = new MaxBotixProximitySensor(Model.MB1200, new SerialPort(9600, SerialPort.Port.kOnboard), new AnalogInput(RobotMap.ANALOG_INPUT_PORT));

//	public static final ImuDigitalComboBoard imu = new ImuDigitalComboBoard(I2C.Port.kOnboard, new DigitalInput(RobotMap.GYRO_INTERRUPT_CHANNEL));

	public static final PIDDemo pidDemo = new PIDDemo();
	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit() {
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