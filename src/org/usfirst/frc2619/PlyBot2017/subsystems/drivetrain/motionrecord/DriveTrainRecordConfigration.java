package org.usfirst.frc2619.PlyBot2017.subsystems.drivetrain.motionrecord;

import java.io.File;
import java.util.ArrayList;

import org.usfirst.frc2619.PlyBot2017.Robot;
import org.usfirst.frc2619.motionrecording.MotionPIDSet;
import org.usfirst.frc2619.motionrecording.MotionRecordConfiguration;

public class DriveTrainRecordConfigration extends MotionRecordConfiguration {

	public DriveTrainRecordConfigration(){
		super();
		addRequiredSubsystem(Robot.driveTrain);
		addMotionPIDSet(new DriveTrainLeftPIDSet());
		addMotionPIDSet(new DriveTrainRightPIDSet());
		setRecordingFile(new File("/driveTrainMotion.txt"));
	}
	
}
