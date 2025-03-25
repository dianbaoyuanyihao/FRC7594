// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command.Elevator;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorSubSystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ElevatorUp extends Command {
  /** Creates a new ElevatorUp. */
  private final ElevatorSubSystem elevatorsSubSystem;
  public ElevatorUp(ElevatorSubSystem elevatorsSubSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevatorsSubSystem);
    this.elevatorsSubSystem = elevatorsSubSystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevatorsSubSystem.moveElevator(0.45);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevatorsSubSystem.stopElevator();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
