package org.usfirst.frc.team1165.robot.subsystems;

import com.ni.vision.NIVision.Image;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
	Add a Camera subsystem to your Eclipse project
	Using Intermediate Vision example:
		Add NIVision code to configure and start camera acquisition
		Add NIVision code to grab a frame from the camera and give it to the CameraServer
	Add code to display images using a default command
	Add code necessary to instantiate your subsystem
	Make sure your code builds successfully
	Using Git, get your code to the laptop
	Test your code on the roboRIO
		Be sure to add the necessary camera viewer to the SmartDashboard
 */

public class Camera extends Subsystem
{
	int session;
	Image frame;

	// Put methods for controlling this subsystem here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
	}

	public Camera()
	{
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

		// the camera name (ex "cam0") can be found through the roborio web interface
		session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);

		NIVision.IMAQdxConfigureGrab(session);

		NIVision.IMAQdxStartAcquisition(session);
	}

	public void reportCamera()
	{
		/**
		 * grab an image, draw the circle, and provide it for the camera server
		 * which will in turn send it to the dashboard.
		 */
		NIVision.IMAQdxGrab(session, frame, 1);

		CameraServer.getInstance().setImage(frame);
	}
}