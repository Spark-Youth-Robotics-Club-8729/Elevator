
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ultrasonicGround extends SubsystemBase{
    Ultrasonic m_rangeFinder = new Ultrasonic(11, 10);
    double distanceMillimeters = m_rangeFinder.getRangeMM();
    private final double threashholdMillimeters = 2.0e1;
      
    public boolean onGround() {
        return (distanceMillimeters < threashholdMillimeters);
    }
}
