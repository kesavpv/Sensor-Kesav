package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1165.robot.subsystems.ReportableSubsystem;

/**
 * A Command that reports information from a ReportableSubsystem.
 */
public class Reporter extends Command
{
	private ReportableSubsystem reportable;
	
	public Reporter(ReportableSubsystem reportable)
	{
		// Use requires() here to declare subsystem dependencies
		requires(reportable);
		this.reportable = reportable;
	}
	
	protected void execute() {
		reportable.report();
	}
	
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}