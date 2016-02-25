package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.Reporter;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.ITG3200;
import edu.wpi.first.wpilibj.ITG3200.GyroAxis;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class ImuDigitalComboBoard extends ReportableSubsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private ADXL345_I2C acc;
	private ITG3200 gyro;
	
	private GyroAxis xGyro, yGyro, zGyro;
	
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
	
	public void report()
	{
		// Report Accelerometer
		SmartDashboard.putNumber("Acc X", acc.getX());
		SmartDashboard.putNumber("Acc Y", acc.getY());
		SmartDashboard.putNumber("Acc Z", acc.getZ());
		
		// Report Gyro Rate
		SmartDashboard.putNumber("Gyroscope Rate X", xGyro.getAngle());
		SmartDashboard.putNumber("Gyroscope Rate Y", yGyro.getAngle());
		SmartDashboard.putNumber("Gyroscope Rate Z", zGyro.getAngle());
		
		// Report Gyro Angle
		SmartDashboard.putNumber("Gyroscope Angle X",xGyro.getRate());
		SmartDashboard.putNumber("Gyroscope Angle Y", yGyro.getRate());
		SmartDashboard.putNumber("Gyroscope Angle Z", zGyro.getRate());
	}
	
	public void calibrateGyro() {
		gyro.calibrate(5.0);
	}
	
	public void resetGyro() {
		gyro.reset();
	}
}