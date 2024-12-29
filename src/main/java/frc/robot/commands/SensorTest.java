package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.UltrasonicSensorSubsystem;

public class PrintSensorDistanceCommand extends CommandBase {
    private final UltrasonicSensorSubsystem sensorSubsystem;

    public PrintSensorDistanceCommand(UltrasonicSensorSubsystem sensorSubsystem) {
        this.sensorSubsystem = sensorSubsystem;
        addRequirements(sensorSubsystem); // Declare subsystem dependency
    }

    @Override
    public void execute() {
        double distance = sensorSubsystem.getDistance();
        System.out.println("Ultrasonic Sensor Distance: " + distance + " cm");
    }

    @Override
    public boolean isFinished() {
        return false; // Run continuously
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Stopped distance measurement.");
    }
}
