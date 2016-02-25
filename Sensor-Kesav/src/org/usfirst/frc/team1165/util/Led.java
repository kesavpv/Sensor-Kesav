package org.usfirst.frc.team1165.util;

import edu.wpi.first.wpilibj.AnalogOutput;

/**
 * A class for controlling an LED connected to an analog output port.
 * 
 * @author jkoehring
 *
 */
public class Led implements Pulsee
{
	private final double
		voltageOff = 0.0,
		voltageOn = 3.0,
		voltageIdle = voltageOn;
	
	private AnalogOutput analogOutput;
	
	/**
	 * Construct from a channel number.
	 */
	public Led(int channel) {
		analogOutput = new AnalogOutput(channel);
	}
	
	/**
	 * Construct from an analog output.
	 */
	public Led(AnalogOutput analogOutput) {
		this.analogOutput = analogOutput;
	}

	@Override
	public void idle() {
		analogOutput.setVoltage(voltageIdle);
	}

	@Override
	public void off() {
		analogOutput.setVoltage(voltageOff);
	}

	@Override
	public void on() {
		analogOutput.setVoltage(voltageOn);		
	}
	
}
