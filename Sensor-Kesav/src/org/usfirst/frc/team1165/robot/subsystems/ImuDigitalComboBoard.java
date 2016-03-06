package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.ITG3200;
import edu.wpi.first.wpilibj.ITG3200.GyroAxis;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * A subsystem that provides acces to the accelerometer and gyroscope on
 * the 6 DoF IMU Digital Combo Board.
 */
public class ImuDigitalComboBoard extends ReportableSubsystem
{
	private ADXL345_I2C acc;
	private ITG3200 gyro;

	private GyroAxis xGyro;
	private GyroAxis yGyro;
	private GyroAxis zGyro;
	
	public ImuDigitalComboBoard(Port port, DigitalInput interrupt)
	{
		acc = new ADXL345_I2C(port, Accelerometer.Range.k16G);
		gyro = new ITG3200(port, interrupt, false);

		xGyro = gyro.getXGyro();
		yGyro = gyro.getYGyro();
		zGyro = gyro.getZGyro();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Reporter(this));
	}

	/**
	 * Method to check if a device on a board exists.
	 * If so, report Accelerometer, Gyro Rate, Gyro Angle and Sample Rate
	 */
	@Override
	public void report()
	{
		if (acc != null)
		{
			SmartDashboard.putNumber("IMU Acc X", acc.getX());
			SmartDashboard.putNumber("IMU Acc Y", acc.getY());
			SmartDashboard.putNumber("IMU Acc Z", acc.getZ());
		}
		if (gyro != null)
		{
			SmartDashboard.putNumber("IMU Gyro Rate X", xGyro.getAngle());
			SmartDashboard.putNumber("IMU Gyro Rate Y", yGyro.getAngle());
			SmartDashboard.putNumber("IMU Gyro Rate Z", zGyro.getAngle());
	
			SmartDashboard.putNumber("IMU Gyro Angle X", xGyro.getRate());
			SmartDashboard.putNumber("IMU Gyro Angle Y", yGyro.getRate());
			SmartDashboard.putNumber("IMU Gyro Angle Z", zGyro.getRate());
			
			SmartDashboard.putNumber("IMU Gyro Sample Rate", gyro.getMeasuredSampleRate());
		}
	}
	
	/**
	 * Re-calibrates the gyroscope.
	 */
	public void calibrateGyro() {
		gyro.calibrate(RobotMap.GYRO_CALIBRATION_TIME);
	}

	/**
	 * Resets all gyro axes angles to 0.
	 */
	public void resetGyro() {
		gyro.reset();
	}
}