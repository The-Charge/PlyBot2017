package org.usfirst.frc2619.PlyBot2017.subsystems.drivetrain.motionrecord;

import org.usfirst.frc2619.motionrecording.MotionPIDSet;

import edu.wpi.first.wpilibj.PIDController;

public class DriveTrainPIDSet extends MotionPIDSet{
	PIDController pidcontroller;

	public DriveTrainPIDSet(){
		pidcontroller = new PIDController(1,0.1, 0, getPidSource(), getPidOutput());
	}
	
	public void startPID(){
		pidcontroller.enable();
	}
	public void stopPID(){
		pidcontroller.disable();
	}
	public void setPIDTarget(double target){
		pidcontroller.setSetpoint(target);
	}
}
