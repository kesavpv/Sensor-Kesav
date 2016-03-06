package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Provides access to the User button on the roboRIO.
 */
public class UserButton extends ReportableSubsystem
{
	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}
	
	/**
	 * Returns true if the User button on the roboRIO is pushed.
	 */
	public boolean isPushed() {
		return Utility.getUserButton();
	}
	
	/**
	 * Reports the button status to the Smart Dashboard.
	 */
	public void report() {
		SmartDashboard.putBoolean("User button", isPushed());
	}
}