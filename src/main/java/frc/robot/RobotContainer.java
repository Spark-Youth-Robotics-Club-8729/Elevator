package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.ElevatorDown;
import frc.robot.subsystems.KrakenMotorSubsystem;

public class RobotContainer {
    private final KrakenMotorSubsystem elevator = new KrakenMotorSubsystem(0);
    private final Joystick joystick = new Joystick(frc.robot.Constants.JoystickConstants.JOYSTICK_PORT);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(joystick, frc.robot.Constants.JoystickConstants.UP_BUTTON)
            .whileTrue(new ElevatorUp(elevator));

        new JoystickButton(joystick, frc.robot.Constants.JoystickConstants.DOWN_BUTTON)
            .whileTrue(new ElevatorDown(elevator));
    }
}
