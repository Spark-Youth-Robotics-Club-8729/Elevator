package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UltrasonicSensorSubsystem extends SubsystemBase {
    private final DigitalOutput trigPin;
    private final DigitalInput echoPin;

    public UltrasonicSensorSubsystem(int trigChannel, int echoChannel) {
        trigPin = new DigitalOutput(trigChannel);
        echoPin = new DigitalInput(echoChannel);
    }

    /**
     
Sends a pulse to the sensor to trigger a distance measurement.*/
  public double getDistance() {// Send a 10 µs HIGH pulse to Trig pin
      trigPin.set(true);
      Timer.delay(0.00001); // 10 µs pulse
      trigPin.set(false);

        // Wait for the Echo pin to go HIGH
        while (!echoPin.get()) {
            // Optionally implement a timeout
        }

        // Measure the duration of the HIGH pulse on the Echo pin
        Timer timer = new Timer();
        timer.start();
        while (echoPin.get()) {
            // Optionally implement a timeout
        }
        double duration = timer.get() * 1_000_000; // Convert seconds to microseconds
        timer.stop();

        // Calculate distance in cm
        return duration / 58.0;
    }
}
