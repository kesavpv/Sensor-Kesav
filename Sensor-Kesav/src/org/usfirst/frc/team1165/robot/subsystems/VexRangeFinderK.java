package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Provides access to the VEX Ultrasonic Range Finder
 */
public class VexRangeFinderK extends ReportableSubsystem
{
	private Ultrasonic rangeFinder;
	
	/**
	 * Construct given the ping (output) and echo (input) channels.
	 */
	public VexRangeFinderK(int pingChannel, int echoChannel)
	{
		rangeFinder = new Ultrasonic(pingChannel, echoChannel);
		rangeFinder.setAutomaticMode(true);
	}
	
	/**
	 * Returns the current range in inches.
	 */
	public double getRangeInches() {
		return rangeFinder.getRangeInches();
	}
	
	/**
	 * Returns the current range in millimeters.
	 */
	public double getRangeMillimeters() {
		return rangeFinder.getRangeMM();
	}
	/**
	 * Set default command to report status on SmartDashboard
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}

	/**
	 * Report meaningful information to the SmartDashboard
	 */
	@Override
	public void report()
	{
		SmartDashboard.putNumber("Range(in.)", rangeFinder.getRangeInches());
		SmartDashboard.putNumber("Range(mm.)", rangeFinder.getRangeMM());
	}
}