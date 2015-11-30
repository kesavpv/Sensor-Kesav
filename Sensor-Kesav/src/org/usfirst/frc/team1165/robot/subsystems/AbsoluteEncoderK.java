package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ReportAbsoluteEncoder;

//import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AbsoluteEncoderK extends Subsystem implements PIDSource {

	AnalogInput ai = new AnalogInput(RobotMap.absoluteEncoderPort);
	AnalogPotentiometer pot = new AnalogPotentiometer(ai, 360.0, 0.0);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ReportAbsoluteEncoder());
	}
	public void report()
	{
		SmartDashboard.putNumber("Voltage", ai.getVoltage());
		SmartDashboard.putNumber("ADC Value", ai.getValue());
		SmartDashboard.putNumber("Degree", pot.get());
	}
	@Override
	public double pidGet() {
		return pot.get();
	}
}