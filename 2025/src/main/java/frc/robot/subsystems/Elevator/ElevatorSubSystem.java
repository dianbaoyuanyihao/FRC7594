// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubSystem extends SubsystemBase {
  /** Creates a new ElevatorSubSystem. */
  TalonFX mElevatorMotor;

  public ElevatorSubSystem() {
    mElevatorMotor = new TalonFX(50);
  }
  
  
  public void moveElevator(double speed) {
    mElevatorMotor.set(speed);
  }
  public void stopElevator() {
    mElevatorMotor.set(0.04);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
