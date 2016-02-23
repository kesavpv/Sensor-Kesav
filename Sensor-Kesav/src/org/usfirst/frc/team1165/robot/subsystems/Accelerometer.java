package org.usfirst.frc.team1165.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Provides access to the roboRIO built-in accelerometer.
 */
public class Accelerometer
{
	private BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
	// Set the default command to report values on the SmartDashboard.
	public void initDefaultCommand() {
		setDefaultCommand(new ReportAccelerometer());
	}
	
	// Reports the values of this subsystem on the SmartDashBoard.
	public void report()
	{
		SmartDashboard.putNumber("roboRIO X Accel", accelerometer.getX());
		SmartDashboard.putNumber("roboRIO Y Accel", accelerometer.getY());
		SmartDashboard.putNumber("roboRIO Z Accel", accelerometer.getZ());
	}
}
