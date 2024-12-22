package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.KrakenMotorSubsystem;

public class ElevatorUp extends CommandBase {
    private final KrakenMotorSubsystem elevator;

    public ElevatorUp(KrakenMotorSubsystem elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
        elevator.move(frc.robot.Constants.ElevatorConstants.ELEVATOR_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.stop();
    }

    @Override
    public boolean isFinished() {
        return false; // Runs until interrupted
    }
}
