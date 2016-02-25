package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VexRangeFinderK extends ReportableSubsystem
{
	Ultrasonic ultra;
	
	public VexRangeFinderK(int pingChannel, int echoChannel)
	{
		ultra = new Ultrasonic(pingChannel, echoChannel);
		ultra.setAutomaticMode(true);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}

	public void report() {
		SmartDashboard.putNumber("Range(in.)", ultra.getRangeInches());
		SmartDashboard.putNumber("Range(mm.)", ultra.getRangeMM());
	}
}