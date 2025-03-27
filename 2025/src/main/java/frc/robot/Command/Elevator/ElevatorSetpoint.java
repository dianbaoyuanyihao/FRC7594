package frc.robot.Command.Elevator;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Elevator.ElevatorSubSystem;


public class ElevatorSetpoint extends SequentialCommandGroup {
    public ElevatorSetpoint (ElevatorSubSystem elevator, double setpoint){
        addCommands(
           elevator.setSetpointCommand(setpoint),
            Commands.waitUntil(() -> elevator.isAtSetPoint())
            );
    }
    
}
