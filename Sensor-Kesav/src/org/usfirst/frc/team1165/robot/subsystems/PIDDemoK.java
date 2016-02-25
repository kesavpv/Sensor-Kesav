package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.util.Led;
import org.usfirst.frc.team1165.util.PidLeds;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * A PID subsystem demonstrator that controls two LEDs to
 * instruct the user how to turn the absolute encoder shaft
 * to reach the set point.
 * 
 * Flashing green LED indicates turn the shaft clockwise.
 * Flashing red LED indicates turn the shaft counterclockwise.
 * Both LEDs on solid indicates set point reached.
 */
public class PIDDemoK extends PIDSubsystem
{
	private final static double
		kP = 0.05,
		kI = 0.0,
		kD = 0,
		minPosition = 0.0,
		maxPosition = 360.0,
		minFrequency = -0.8,
		maxFrequency = 0.8,
		tolerance = 3;
	
	private PidLeds leds = new PidLeds(RobotMap.RED_LED_CHANNEL, RobotMap.GREEN_LED_CHANNEL);
	
	public PIDDemoK()
	{
		super(kP, kI, kD);
		
        setAbsoluteTolerance(tolerance);
        setInputRange(minPosition, maxPosition);
        setOutputRange(minFrequency, maxFrequency);
        
        getPIDController().setContinuous();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	@Override
	protected double returnPIDInput() {
		return Robot.absoluteEncoder.pidGet();
	}
	
	@Override
	protected void usePIDOutput(double output) {
		leds.pidWrite(output);
	}
}
