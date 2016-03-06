package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class SetPIDDemoSetPoint extends Command
{
	private double setpoint;
	private String setpointKey;
	
    public SetPIDDemoSetPoint() {
    	requires(Robot.pidDemo);
    }
    
    public SetPIDDemoSetPoint(double setpoint) {
    	this();
    	this.setpoint = setpoint;
    }

    protected SetPIDDemoSetPoint(String setpointKey) {
    	this.setpointKey = setpointKey;
    }
    
    @Override
	protected void initialize()
    {
    	if(setpointKey != null)
    		setpoint = SmartDashboard.getNumber(setpointKey);
    	
    	Robot.pidDemo.setSetpoint(setpoint);
    	Robot.pidDemo.enable();
	}

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
    	return Robot.pidDemo.onTarget();
    }

    @Override
    protected void end() {
    	Robot.pidDemo.disable();
    }

    @Override
    protected void interrupted() {
    	end();
    }	
}
