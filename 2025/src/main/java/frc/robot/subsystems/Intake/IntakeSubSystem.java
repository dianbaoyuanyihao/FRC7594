// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubSystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  TalonSRX mIntakeMotor;
  TalonFX mIntakeLiftMotor;
  public IntakeSubSystem() {

    mIntakeMotor = new TalonSRX(15);
    mIntakeLiftMotor = new TalonFX(16);
  }
  
  public void IntakeLift(double liftspeed) {

    mIntakeLiftMotor.set(liftspeed);
  
 }


  public void IntakeSuck(double speed) {

    mIntakeMotor.set(ControlMode.PercentOutput,speed);

  }

  public void IntakeKeep(double speed){

    mIntakeMotor.set(ControlMode.PercentOutput, speed);

  }

  public void stopIntakeSuck() {

    mIntakeMotor.set(ControlMode.PercentOutput,0);

  }

  public void stopIntakeLift() {
    mIntakeLiftMotor.set(0.02);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
