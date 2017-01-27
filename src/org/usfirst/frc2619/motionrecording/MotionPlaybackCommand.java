package org.usfirst.frc2619.motionrecording;

import java.util.Scanner;

import edu.wpi.first.wpilibj.command.Command;

public class MotionPlaybackCommand extends Command{
	
	private MotionRecordConfiguration config;
	private boolean hadError;
	private boolean fileDone;
	
	private long startTime;
	
	private Scanner scanner;
	
	private String[] lineTokens;
	
	public MotionPlaybackCommand(MotionRecordConfiguration config){
		this.config = config;
		// Need to require the subsystems:
		for(int i=0; i<config.getRequiredSubsystems().size(); i++){
			requires(config.getRequiredSubsystems().get(i));
		}
	}
	
	
	@Override
	protected void initialize() {
    	MotionRecordLogger.logMessage("Initializing MotionPlaybackCommand");
    	// An error hasn't occurred until it occurs...
    	hadError = false;
    	// We're not done with the file until it's empty:
    	fileDone = false;
    	// Set up our start time
    	startTime = System.currentTimeMillis();
    	lineTokens = null;
    	try{
    		scanner = new Scanner(config.getRecordingFile());
    	}catch(Exception ex){
    		hadError = true;
    		MotionRecordLogger.logMessage("An error occurred while initializing MotionPlaybackCommand!");
    		ex.printStackTrace();
    	}
    	// Start all our controllers:
    	int size = config.getMotionPIDSets().size();
    	for(int i=0; i<size; i++){
			config.getMotionPIDSets().get(i).startPID();
    	}
    	MotionRecordLogger.logMessage("MotionPlaybackCommand Initialized!");
	}
	
	@Override
	protected void execute() {
		// If the line can go to the drive, feed it in:
		if(timeToRunLine()){
			feedLine();
			lineTokens = null;
			// Keep feeding:
			while(lineTokens == null && scanner.hasNext()){
				lineTokens = scanner.nextLine().split(",");
				if(timeToRunLine()){
					feedLine();
					lineTokens = null;
				}
			}
		}
		
		// If we don't have a line, get one:
		if(lineTokens == null && scanner.hasNext()){
			lineTokens = scanner.nextLine().split(",");
		}
	}
	
	private boolean timeToRunLine() {
		if(lineTokens == null){
			return false;
		}
		long neededDelta = Long.parseLong(lineTokens[0]);
		long currentDelta = System.currentTimeMillis() - startTime;
		return currentDelta >= neededDelta;
	}
	
	private void feedLine() {
    	int size = config.getMotionPIDSets().size();
    	for(int i=0; i<size; i++){
    		if(lineTokens.length > i+1){
    			//Get the setpoint:
    			double setPoint = Double.parseDouble(lineTokens[i+1]);
    			//Feed it in:
    			config.getMotionPIDSets().get(i).setPIDTarget(setPoint);
    		}
    	}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return hadError || (scanner != null && !scanner.hasNext());
	}

    protected void end() {
    	// Cleanup:
    	MotionRecordLogger.logMessage("Cleaning up MotionPlaybackCommand");
    	try{
	    	if(scanner != null){
	    		scanner.close();
	    	}
    	}catch(Exception ex){
       		hadError = true;
    		MotionRecordLogger.logMessage("An error occurred while cleaning up MotionPlaybackCommand!");
    		ex.printStackTrace();
    	}

    	int size = config.getMotionPIDSets().size();
    	for(int i=0; i<size; i++){
			config.getMotionPIDSets().get(i).stopPID();
    	}
    	
    }

    protected void interrupted() {
    	end();
    }
}
