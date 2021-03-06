// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.PlyBot2017.subsystems;

import org.usfirst.frc2619.PlyBot2017.RobotMap;
import org.usfirst.frc2619.PlyBot2017.TheChargeDashboard;
import org.usfirst.frc2619.PlyBot2017.commands.*;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ShooterMotors extends Subsystem {
	private final static double SPEED_P_CONSTANT = 0.3;
	private final static double SPEED_I_CONSTANT = 0.001;
	private final static double SPEED_D_CONSTANT = 0;
	private final static double SPEED_F_CONSTANT = 0.12;
	
	double SpeedP = SPEED_P_CONSTANT;
	double SpeedI = SPEED_I_CONSTANT;
	double SpeedD = SPEED_D_CONSTANT;
	double SpeedF = SPEED_F_CONSTANT;
	
	private final static int MAX_TICKS_PER_SECOND = 8691;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftFrontMotor = RobotMap.shooterMotorsLeftFrontMotor;
    private final CANTalon rightFrontMotor = RobotMap.shooterMotorsRightFrontMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void writeDefaultDashboardValues() {
    	TheChargeDashboard.putNumber("ShooterSpeedP", SPEED_P_CONSTANT);
    	TheChargeDashboard.putNumber("ShooterSpeedI", SPEED_I_CONSTANT);
		TheChargeDashboard.putNumber("ShooterSpeedD", SPEED_D_CONSTANT);
		TheChargeDashboard.putNumber("ShooterSpeedF", SPEED_F_CONSTANT);
	}

	public void readDashboardControlValues() {
		SpeedP = SmartDashboard.getNumber("ShooterSpeedP", SPEED_P_CONSTANT);
		SpeedI = SmartDashboard.getNumber("ShooterSpeedI", SPEED_I_CONSTANT);
		SpeedD = SmartDashboard.getNumber("ShooterSpeedD", SPEED_D_CONSTANT);
		SpeedF = SmartDashboard.getNumber("ShooterSpeedF", SPEED_F_CONSTANT);
		
		// set CANTalon PIDs
		leftFrontMotor.setPID(SpeedP, SpeedI, SpeedD, SpeedF, 0, 0, 0);
		rightFrontMotor.setPID(SpeedP, SpeedI, SpeedD, SpeedF, 0, 0, 0);
	}
	
	public void initSpeedPercentageMode() {
		leftFrontMotor.changeControlMode(TalonControlMode.Speed);
		rightFrontMotor.changeControlMode(TalonControlMode.Speed);
		
		leftFrontMotor.setProfile(0);
		rightFrontMotor.setProfile(0);

		leftFrontMotor.configMaxOutputVoltage(12);
		rightFrontMotor.configMaxOutputVoltage(12);
	}
	
	public void set(double percentSpeed) {
		// Sets what speed the motors will run at.
		leftFrontMotor.setSetpoint(MAX_TICKS_PER_SECOND * percentSpeed);
		rightFrontMotor.setSetpoint(MAX_TICKS_PER_SECOND * percentSpeed);
	}
}

