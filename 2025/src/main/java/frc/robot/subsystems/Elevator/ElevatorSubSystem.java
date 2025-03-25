// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.lib.TunableControllers.TunableElevatorFeedforward;
import frc.lib.TunableControllers.TunablePID;

public class ElevatorSubSystem extends SubsystemBase {
  /** Creates a new ElevatorSubSystem. */
  TalonFX mElevatorMotor;
  private TunablePID elevatorPID = new TunablePID("elevatorPID", 2, 0, 0);
  private TunableElevatorFeedforward elevatorFeedforward = new TunableElevatorFeedforward("elevatorFeedforward", 0, 0.02, 0.8);
  private TrapezoidProfile profile = new TrapezoidProfile(ElevatorConstants.CONSTRAINTS);
  private TrapezoidProfile.State startingState;
  private TrapezoidProfile.State goalState;
  private double setpoint;
  private Timer timer = new Timer();

  public ElevatorSubSystem() {
    mElevatorMotor = new TalonFX(50);
  }
  
  
  public void moveElevator(double speed) {
    mElevatorMotor.set(speed);
  }
  public void stopElevator() {
    mElevatorMotor.set(0.04);
  }
  private void movetowardsSetpoints(){
  TrapezoidProfile.State desiredState = profile.calculate(timer.get(), startingState, goalState);
    double output = elevatorFeedforward.calculate(desiredState.velocity) + elevatorPID.calculate(encoder.getPosition(), desiredState.position); //how fast motor go
    mElevatorMotor.set(output);
    SmartDashboard.putNumber("elevatorSetPoints", setpoint);
    SmartDashboard.putNumber("desiredVelocity", desiredState.velocity);
    SmartDashboard.putNumber("desiredPosition", desiredState.position);
    SmartDashboard.putNumber("actualVelocity", encoder.getVelocity());
    SmartDashboard.putNumber("actualPosition", encoder.getPosition());
    SmartDashboard.putNumber("motorOutput", output);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
