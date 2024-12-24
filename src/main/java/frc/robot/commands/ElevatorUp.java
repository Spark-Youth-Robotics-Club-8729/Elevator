package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.KrakenMotorSubsystem;

public class ElevatorUp extends Command {
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
        elevator.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return false; // Runs until interrupted
    }
}
