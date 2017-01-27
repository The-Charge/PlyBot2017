package org.usfirst.frc2619.motionrecording;

import java.io.BufferedWriter;
import java.io.FileWriter;

import edu.wpi.first.wpilibj.command.Command;

public class MotionRecordCommand extends Command {
	private MotionRecordConfiguration config;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	
	private boolean hadError;
	private long startTime;
	private long lastWriteTime;

	public MotionRecordCommand(MotionRecordConfiguration config){
		this.config = config;
		hadError = false;
	}

    protected void initialize() {
    	MotionRecordLogger.logMessage("Initializing MotionRecordCommand");
    	// An error hasn't occurred until it occurs...
    	hadError = false;
    	// Set our lastWriteTime to -1 (force a write immediately)
    	lastWriteTime = -1;
    	startTime = System.currentTimeMillis();
    	try {
	    	// Create our recorder file if it doesn't exist:
	    	if(!config.getRecordingFile().exists()){
	    		config.getRecordingFile().createNewFile();
	    	}
	    	// Open up the file for writing:
	    	fileWriter = new FileWriter(config.getRecordingFile());
	    	bufferedWriter = new BufferedWriter(fileWriter);
	    	
    	}catch(Exception ex){
    		hadError = true;
    		MotionRecordLogger.logMessage("An error occurred while initializing MotionRecordCommand!");
    		ex.printStackTrace();
    	}
    	MotionRecordLogger.logMessage("MotionRecordCommand Initialized!");
    }

    protected void execute() {
    	// Is it time to write yet?
    	long currentTime = System.currentTimeMillis();
    	long delta = currentTime - lastWriteTime;
    	if(delta > config.getMillisecondsPerSetpoint()){
    		//Time to write!
    		writeSetpoints(currentTime);
    		lastWriteTime = currentTime;
    	}
    }
    
    private void writeSetpoints(long currentTime) {
    	int size = config.getMotionPIDSets().size();
    	long deltaTime = currentTime - startTime;
    	// Build our line:
    	String line = "";
    	line += deltaTime;
    	for(int i=0; i<size; i++){
    		line += ",";
    		line += config.getMotionPIDSets().get(i).getPidSource().pidGet();
    	}
    	line += "\n";
    	try{
    		bufferedWriter.write(line);
    	}catch(Exception ex){
    		hadError = true;
    		MotionRecordLogger.logMessage("An error occurred while writing in MotionRecordCommand!");
    		ex.printStackTrace();
    	}
    }
	
	
	@Override
	protected boolean isFinished() {
		// Only finish if interrupted, or we have a fatal error...
		return hadError;
	}

	
    protected void end() {
    	// Cleanup:
    	MotionRecordLogger.logMessage("Cleaning up MotionRecordCommand");
    	try{
	    	if(bufferedWriter != null){
	    		bufferedWriter.close();
	    	}
	    	if(fileWriter != null){
	    		fileWriter.close();
	    	}
    	}catch(Exception ex){
       		hadError = true;
    		MotionRecordLogger.logMessage("An error occurred while cleaning up MotionRecordCommand!");
    		ex.printStackTrace();
    	}
    	
    }

    protected void interrupted() {
    	end();
    }
}
