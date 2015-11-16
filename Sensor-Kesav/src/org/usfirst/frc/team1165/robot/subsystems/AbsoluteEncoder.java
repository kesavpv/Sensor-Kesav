package org.usfirst.frc.team1165.robot.subsystems;

//import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AbsoluteEncoder extends Subsystem {

	AnalogInput ai = new AnalogInput(0);
	AnalogPotentiometer a = new AnalogPotentiometer(ai, 360, 0);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public void report()
	{
		SmartDashboard.putNumber("Voltage", ai.getVoltage());
		SmartDashboard.putNumber("ADC Value", ai.getValue());
		SmartDashboard.putNumber("Degree", a.get());
	}
}

