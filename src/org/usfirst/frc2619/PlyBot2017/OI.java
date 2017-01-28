// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.PlyBot2017;

import org.usfirst.frc2619.PlyBot2017.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton invertDriveButton;
    public JoystickButton drive2SecondsButton;
    public Joystick leftJoystick;
    public Joystick rightJoystick;
    public JoystickButton tankDriveButton;
    public JoystickButton arcadeDriveButton;
    public JoystickButton claytonDriveButton;
    public JoystickButton haloDriveButton;
    public JoystickButton xboxDriveButoon;
    public Joystick buttonBox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonBox = new Joystick(2);
        
        xboxDriveButoon = new JoystickButton(buttonBox, 5);
        xboxDriveButoon.whenPressed(new XboxDrive());
        haloDriveButton = new JoystickButton(buttonBox, 4);
        haloDriveButton.whenPressed(new HaloDrive());
        claytonDriveButton = new JoystickButton(buttonBox, 3);
        claytonDriveButton.whenPressed(new ClaytonDrive());
        arcadeDriveButton = new JoystickButton(buttonBox, 2);
        arcadeDriveButton.whenPressed(new ArcadeDrive());
        tankDriveButton = new JoystickButton(buttonBox, 1);
        tankDriveButton.whenPressed(new TankDrive());
        rightJoystick = new Joystick(1);
        
        leftJoystick = new Joystick(0);
        
        drive2SecondsButton = new JoystickButton(leftJoystick, 3);
        drive2SecondsButton.whenPressed(new DriveXSeconds(2));
        invertDriveButton = new JoystickButton(leftJoystick, 4);
        invertDriveButton.whileHeld(new InvertDrive());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("TankDrive", new TankDrive());
        SmartDashboard.putData("DriveXSeconds", new DriveXSeconds());
        SmartDashboard.putData("DriveXFeet: FiveFeet", new DriveXFeet(5));
        SmartDashboard.putData("DriveXFeet: TenFeet", new DriveXFeet(10));
        SmartDashboard.putData("DriveXFeet: FifteenFeet", new DriveXFeet(15));
        SmartDashboard.putData("DriveXFeet: TwentyFeet", new DriveXFeet(20));
        SmartDashboard.putData("DriveXFeet: NegFiveFeet", new DriveXFeet(-5));
        SmartDashboard.putData("DriveXFeet: NegTenFeet", new DriveXFeet(-10));
        SmartDashboard.putData("DriveXFeet: NegFifteenFeet", new DriveXFeet(-15));
        SmartDashboard.putData("DriveXFeet: NegTwentyFeet", new DriveXFeet(-20));
        SmartDashboard.putData("ArcadeDrive", new ArcadeDrive());
        SmartDashboard.putData("ClaytonDrive", new ClaytonDrive());
        SmartDashboard.putData("HaloDrive", new HaloDrive());
        SmartDashboard.putData("XboxDrive", new XboxDrive());
        SmartDashboard.putData("TurnNDegreesRelative: 90Degrees", new TurnNDegreesRelative(90));
        SmartDashboard.putData("TurnNDegreesRelative: 180Degrees", new TurnNDegreesRelative(180));
        SmartDashboard.putData("TurnNDegreesRelative: 45Degrees", new TurnNDegreesRelative(45));
        SmartDashboard.putData("TurnNDegreesRelative: -90Degrees", new TurnNDegreesRelative(-90));
        SmartDashboard.putData("TurnNDegreesRelative: -45Degrees", new TurnNDegreesRelative(-45));
        SmartDashboard.putData("DriveForwardBack5", new DriveForwardBack5());
        SmartDashboard.putData("DriveBackForward5", new DriveBackForward5());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getButtonBox() {
        return buttonBox;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

