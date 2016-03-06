package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1165.robot.subsystems.AbsoluteEncoder;
import org.usfirst.frc.team1165.robot.subsystems.Accelerometer;
import org.usfirst.frc.team1165.robot.subsystems.ImuDigitalComboBoard;
import org.usfirst.frc.team1165.robot.subsystems.MaxBotixProximitySensor;
import org.usfirst.frc.team1165.robot.subsystems.MaxBotixProximitySensor.Model;
import org.usfirst.frc.team1165.robot.subsystems.PIDDemo;
import org.usfirst.frc.team1165.robot.subsystems.VexRangeFinder;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	public static OI oi;
	
	public static final AbsoluteEncoder absoluteEncoder = new AbsoluteEncoder();
	public static final Accelerometer accelerometer = new Accelerometer(); 
	public static final ImuDigitalComboBoard imu = new ImuDigitalComboBoard(Port.kOnboard, new DigitalInput(RobotMap.GYRO_INTERRUPT_CHANNEL));
	public static final MaxBotixProximitySensor mb1013 = new MaxBotixProximitySensor(Model.MB1013, new SerialPort(9600, SerialPort.Port.kOnboard), new AnalogInput(3));
//	public static final MaxBotixProximitySensorK mb1200 = new MaxBotixProximitySensorK(Model.MB1200, new SerialPort(9600, SerialPort.Port.kOnboard), new AnalogInput(3));
	public static final PIDDemo pidDemo = new PIDDemo();
	public static final VexRangeFinder vexRangeFinderK = new VexRangeFinder(1, 1);

	int session;
	Image frame;

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
		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
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

	public void operatorControl()
	{
		NIVision.IMAQdxStartAcquisition(session);

		/*
		 * grab an image, draw the circle, and provide it for the camera server
		 * which will in turn send it to the dashboard.
		 */
		NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

		while (isOperatorControl() && isEnabled())
		{

			NIVision.IMAQdxGrab(session, frame, 1);
			NIVision.imaqDrawShapeOnImage(frame, frame, rect,
					DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

			CameraServer.getInstance().setImage(frame);

//			robot code here!
			Timer.delay(0.005);		// wait for a motor update time
		}

		NIVision.IMAQdxStopAcquisition(session);
	}

	public void test() {
		//
	}
}