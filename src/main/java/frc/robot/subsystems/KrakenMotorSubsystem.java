package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix6.hardware.TalonFX;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;
// import com.ctre.phoenix6.configs.TalonFXConfigurator;

public class KrakenMotorSubsystem extends SubsystemBase {

  // Motor controller for Kraken motor
  private final TalonFX krakenMotor;

  // Constructor: Initialize the Kraken motor with TalonFX
  public KrakenMotorSubsystem(int motorPort) {
    // Initialize the TalonFX motor controller with the given motor port
    this.krakenMotor = new TalonFX(motorPort); // Use TalonFX to control the Kraken X60 motor
  }

  // Method to set motor speed
  public void setMotorSpeed(double speed) {
    // The speed can range from -1.0 to 1.0 (full reverse to full forward)
    krakenMotor.set(speed);
  }

  // Method to stop the motor (set speed to 0)
  public void stopMotor() {
    krakenMotor.set(0);
  }

  // Periodic method for subsystem updates
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Add any monitoring or logging logic here if necessary
  }
}