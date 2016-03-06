package org.usfirst.frc.team1165.robot;

public class RobotMap
{
	/**
	 * Name of camera:
	 */
	public final static String CAMERA_NAME = "cam11";

	public static final double GYRO_CALIBRATION_TIME 	= 3.0;

	/**
	 * Digital input channel for receiving inputs from gyro
	 */
	public static final int GYRO_INTERRUPT_CHANNEL 	= 9;

	/**
	 * For accessing the VEX ultrasonic range finder
	 */
	public static final int VEX_PING_CHANNEL = 0;
	public static final int VEX_ECHO_CHANNEL = 1;

	/**
	 * For accessing the absolute encoder:
	 */
	public static final int ABSOLUTE_ENCODER_PORT 	= 2;

	/**
	 * Analog output channels for LEDs:
	 */
	public static final int RED_LED_CHANNEL 		= 3;
	public static final int GREEN_LED_CHANNEL 		= 4;

	public static final String PID_DEMO_SETPOINT_KEY = "PID Demo Setpoint";

	/**
	 * MaxBotix sensor analog input
	 */
	public static final int ANALOG_INPUT_PORT 		= 5;
}