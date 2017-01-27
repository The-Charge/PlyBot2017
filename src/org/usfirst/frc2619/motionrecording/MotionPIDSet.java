package org.usfirst.frc2619.motionrecording;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public abstract class MotionPIDSet {
	private PIDSource pidSource;
	private PIDOutput pidOutput;
	
	public PIDSource getPidSource() {
		return pidSource;
	}
	public void setPidSource(PIDSource pidSource) {
		this.pidSource = pidSource;
	}
	public PIDOutput getPidOutput() {
		return pidOutput;
	}
	public void setPidOutput(PIDOutput pidOutput) {
		this.pidOutput = pidOutput;
	}
	
	public abstract void startPID();
	public abstract void stopPID();
	public abstract void setPIDTarget(double target);
}