package org.usfirst.frc2619.motionrecording;

import java.io.File;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Subsystem;

public class MotionRecordConfiguration {
	/**
	 * The file to record the motion to
	 */
	private File motionRecordingFile;
	
	/**
	 * Subsystems that the playback command needs to control
	 * This is to prevent something like TankDrive interfering
	 */
	private ArrayList<Subsystem> requiredSubsystems;
	/**
	 * Timespan between recorded setpoints
	 * This is to prevent ridiculously huge files.
	 * default is 100 millisecond
	 */
	private long millisecondsPerSetpoint;
	/**
	 * The PID sets which determine what to read/write
	 */
	private ArrayList<MotionPIDSet> motionPIDSets;
	
	public MotionRecordConfiguration(){
		requiredSubsystems = new ArrayList<Subsystem>();
		motionPIDSets = new ArrayList<MotionPIDSet>();
		millisecondsPerSetpoint = 100;
	}
	
	protected void addRequiredSubsystem(Subsystem s){
		requiredSubsystems.add(s);
	}
	
	public ArrayList<Subsystem> getRequiredSubsystems() {
		return requiredSubsystems;
	}
	
	protected void setRecordingFile(File f){
		motionRecordingFile = f;
	}
	
	public File getRecordingFile(){
		return motionRecordingFile;
	}

	public long getMillisecondsPerSetpoint() {
		return millisecondsPerSetpoint;
	}

	protected void setMillisecondsPerSetpoint(long millisecondsPerSetpoint) {
		this.millisecondsPerSetpoint = millisecondsPerSetpoint;
	}

	public ArrayList<MotionPIDSet> getMotionPIDSets() {
		return motionPIDSets;
	}

	protected void addMotionPIDSet(MotionPIDSet motionPIDSet) {
		this.motionPIDSets.add(motionPIDSet);
	}
}
