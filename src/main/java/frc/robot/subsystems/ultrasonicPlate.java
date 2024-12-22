package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ultrasonicPlate extends SubsystemBase{
    Ultrasonic m_rangeFinder = new Ultrasonic(7, 6);
    double distanceMillimeters = m_rangeFinder.getRangeMM();
    private final double threashholdMillimeters = 5.0e1;
      
    public boolean onPlate() {
        return (distanceMillimeters < threashholdMillimeters);
    }
}
