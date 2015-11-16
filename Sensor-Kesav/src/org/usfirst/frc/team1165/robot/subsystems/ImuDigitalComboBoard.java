package org.usfirst.frc.team1165.robot.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.ITG3200;
import edu.wpi.first.wpilibj.ITG3200.GyroAxis;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class ImuDigitalComboBoard extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	ADXL345_I2C acc;
	ITG3200 gyro;
	
	public ImuDigitalComboBoard(Port port, DigitalInput interrupt)
	{
		acc = new ADXL345_I2C(port, Accelerometer.Range.k16G);
		gyro = new ITG3200(port, interrupt, false);
	}
	
	private GyroAxis xGyro;
	private GyroAxis yGyro;
	private GyroAxis zGyro;

    
	public void initDefaultCommand() 
	{
       xGyro = gyro.getXGyro();
       yGyro = gyro.getYGyro();
       zGyro = gyro.getZGyro();
    }
	public void reportAccelerometer()
	{
		SmartDashboard.putNumber("Acc X", acc.getX());
		SmartDashboard.putNumber("Acc Y", acc.getY());
		SmartDashboard.putNumber("Acc Z", acc.getZ());
	}
	public void reportGyroRate()
	{
		SmartDashboard.putNumber("Gyroscope Rate X", xGyro.getAngle());
		SmartDashboard.putNumber("Gyroscope Rate Y", yGyro.getAngle());
		SmartDashboard.putNumber("Gyroscope Rate Z", zGyro.getAngle());
	}
	public void reportGyroAngle()
	{
		SmartDashboard.putNumber("Gyroscope Angle X",xGyro.getRate());
		SmartDashboard.putNumber("Gyroscope Angle Y", yGyro.getRate());
		SmartDashboard.putNumber("Gyroscope Angle Z", zGyro.getRate());
	}
	public void calibrateGyro()
	{
		gyro.calibrate(5.0);
	}
}