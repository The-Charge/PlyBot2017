package org.usfirst.frc2619.PlyBot2017.subsystems.drivetrain.motionrecord;

import org.usfirst.frc2619.PlyBot2017.Robot;
import org.usfirst.frc2619.PlyBot2017.RobotMap;
import org.usfirst.frc2619.motionrecording.MotionPIDSet;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class DriveTrainRightPIDSet extends DriveTrainPIDSet{

	public PIDSource getPidSource() {
		return RobotMap.driveTrainRightFrontMotor;
	}
	
	public PIDOutput getPidOutput() {
		return RobotMap.driveTrainRightFrontMotor;
	}
}
