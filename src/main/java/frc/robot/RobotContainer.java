// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.ElevatorDown;
import frc.robot.subsystems.KrakenMotorSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.UltrasonicSensorSubsystem;
import frc.robot.commands.PrintSensorDistanceCommand;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final KrakenMotorSubsystem elevatorSubsystem = new KrakenMotorSubsystem();
    private final CommandXboxController operatorJoystick = new CommandXboxController(JoystickConstants.JOYSTICK_PORT);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureBindings();
    }

    /* Triggering commands with these buttons being pressed */
    private void configureBindings() {
        operatorJoystick.b().whileTrue(new ElevatorUp(elevatorSubsystem, Constants.MotorConstants.ELE_SPEED));
        operatorJoystick.a().whileTrue(new ElevatorDown(elevatorSubsystem, Constants.MotorConstants.ELE_SPEED));
        
    }
    
    private final UltrasonicSensorSubsystem ultrasonicSensorSubsystem =
            new UltrasonicSensorSubsystem(0, 1); // Adjust channels as needed
    private final PrintSensorDistanceCommand printSensorDistanceCommand =
            new PrintSensorDistanceCommand(ultrasonicSensorSubsystem);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // runs automatically
        ultrasonicSensorSubsystem.setDefaultCommand(printSensorDistanceCommand);
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
