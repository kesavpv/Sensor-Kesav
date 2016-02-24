package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VexRangeFinderK extends ReportableSubsystem
{
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Ultrasonic ultra = new Ultrasonic(1,1);
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new Reporter(this));
	}

	public void report()
	{
		// creates the ultra object andassigns ultra to be an ultrasonic sensor which uses DigitalOutput 1 for the echo pulse and DigitalInput 1 for the trigger pulse
		
		ultra.setAutomaticMode(true); // turns on automatic mode
		
		SmartDashboard.putNumber("Range(in.)", ultra.getRangeInches());
		SmartDashboard.putNumber("Range(mm.)", ultra.getRangeMM());
	}
}