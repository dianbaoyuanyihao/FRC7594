// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSystem extends SubsystemBase {
  /** Creates a new Climber. */
  VictorSPX mClimberLiftMotor;
  TalonFX mClimberMotor;

  public ClimberSystem() {
    mClimberLiftMotor = new VictorSPX(17);
    mClimberMotor = new TalonFX (19);
  }
  
  public void ClimberLift(double speed) {
    mClimberLiftMotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void Climberactive(double speed) {
    mClimberMotor.set(speed);
  }

  public void ClimberInactive(double speed){
    mClimberMotor.set(speed);
  }

  public void stopClimberLift() {
    mClimberLiftMotor.set(ControlMode.PercentOutput, 0);
  }

  public void stopClimberactive() {
    mClimberMotor.set(0);
  }

  public void stopClimberInactive(){
    mClimberMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
