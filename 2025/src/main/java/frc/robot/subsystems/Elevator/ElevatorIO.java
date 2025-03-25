package frc.robot.subsystems.Elevator;

import org.littletonrobotics.junction.AutoLog;

public interface ElevatorIO {
  void updateInputs(ElevatorIOInputs inputs);
  void setElevatorVoltage(double voltage);
  void setElevatorTarget(double meter);
  void resetElevatorPosition();
  double getElevatorVelocity();
  double getElevatorHeight();
  boolean isNearExtension(double expected);
  boolean isNearZeroExtension();

  @AutoLog
  class ElevatorIOInputs{
    
    public double positionMeters = 0;
    public double velocityMetersPerSec = 0;
    public double setpointMeters = 0;
    public double appliedVolts = 0;
    public double statorCurrentAmps = 0;
    public double SupplyCurrentAmps = 0;
    public double tempCelsius = 0;

  }
}
