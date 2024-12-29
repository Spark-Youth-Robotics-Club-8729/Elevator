
package frc.robot.subsystems;

import frc.robot.Constants.MotorConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;
// import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix6.hardware.TalonFX;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;
// import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.revrobotics.RelativeEncoder;

public class KrakenMotorSubsystem extends SubsystemBase {
  // Motor controller for Kraken motor
  private final TalonFX krakenMotor = new TalonFX(MotorConstants.KRAKEN_MOTOR_CAN_ID);

  public KrakenMotorSubsystem () {
    
  }

  public double getRotationEncoder() {
    double currentValue = krakenMotor.getPosition().getValue();
    return currentValue;
}
  // Method to set motor speed
  public void setMotorSpeed(double speed) {
    // The speed can range from -1.0 to 1.0 (full reverse to full forward)
    krakenMotor.setRotate(speed);
  }

  // Method to stop the motor (set speed to 0)
  public void stopMotor() {
    krakenMotor.setRotate(0);
  }

  // Periodic method for subsystem updates
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Add any monitoring or logging logic here if necessary
    // for this version using the encoder won't be nesseary but as we add more to it we will need to use it have presets
    SmartDashboard.putNumber("Rotation Encoder", getRotationEncoder());
  }
}
