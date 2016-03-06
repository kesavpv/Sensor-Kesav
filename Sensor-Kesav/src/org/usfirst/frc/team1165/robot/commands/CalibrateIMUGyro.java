package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Calibrates the gyroscope on an IMU Digital Combo Board.
 */
public class CalibrateIMUGyro extends Command {

    public CalibrateIMUGyro() {
        requires(Robot.imu);
    }

    protected void initialize() {
    	Robot.imu.calibrateGyro();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
