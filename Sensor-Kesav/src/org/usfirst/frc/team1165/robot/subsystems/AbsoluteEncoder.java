package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Class that provides access to the MA3-A10-250-N Absolute Encoder.
 */
public class AbsoluteEncoder extends ReportableSubsystem implements PIDSource
{
	private AnalogInput ai = new AnalogInput(RobotMap.ABSOLUTE_ENCODER_PORT);
	private AnalogPotentiometer pot = new AnalogPotentiometer(ai, 360.0, 0.0);

	/**
	 * Returns the value of the encoder in degrees from 0 to 360.
	 */
	public double get() {
		return pot.get();
	}
	
	/**
	 * Returns the underlying analog potentiometer.
	 */
	public AnalogPotentiometer getPot() {
		return pot;
	}
	
	/**
	 * Set default command to report status on SmartDashboard
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}
	
	/**
	 * Report meaningful information to the SmartDashboard.
	 */
	public void report()
	{
		SmartDashboard.putNumber("Voltage", ai.getVoltage());
		SmartDashboard.putNumber("ADC Value", ai.getValue());
		SmartDashboard.putNumber("Degree", pot.get());
	}

	/**
	 * Provides input for a PID controller.
	 */
	@Override
	public double pidGet() {
		return pot.get();
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return null;
	}
}