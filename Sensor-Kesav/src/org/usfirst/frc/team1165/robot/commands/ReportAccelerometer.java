package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.Accelerometer;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ReportAccelerometer extends Command
{

	BuiltInAccelerometer a = new BuiltInAccelerometer();
    
	public ReportAccelerometer()
    {
        requires(new Accelerometer());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	SmartDashboard.putDouble("Accelerometer X", a.getX());
    	SmartDashboard.putDouble("Accelerometer Y", a.getY());
    	SmartDashboard.putDouble("Accelerometer Z", a.getZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}