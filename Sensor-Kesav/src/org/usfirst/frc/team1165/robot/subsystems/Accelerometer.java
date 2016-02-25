package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Provides access to the roboRIO built-in accelerometer.
 */
public class Accelerometer extends ReportableSubsystem
{
	private BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}
	
	public void report()
	{
		SmartDashboard.putNumber("roboRIO X Accel", accelerometer.getX());
		SmartDashboard.putNumber("roboRIO Y Accel", accelerometer.getY());
		SmartDashboard.putNumber("roboRIO Z Accel", accelerometer.getZ());
	}
}