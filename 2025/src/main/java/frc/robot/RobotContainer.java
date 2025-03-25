// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;
import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.Command.Climber.ClimberActive;
import frc.robot.Command.Climber.ClimberInactive;
import frc.robot.Command.Climber.ClimberRelease;
import frc.robot.Command.Elevator.ElevatorDown;
import frc.robot.Command.Elevator.ElevatorUp;
import frc.robot.Command.Intake.Lifter.LiftDown;
import frc.robot.Command.Intake.Lifter.LiftUp;
import frc.robot.Command.Intake.Sucker.IntakeKeep;
import frc.robot.Command.Intake.Sucker.IntakeSpit;
import frc.robot.Command.Intake.Sucker.IntakeSuck;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Elevator.ElevatorSubSystem;
import frc.robot.subsystems.Intake.IntakeSubSystem;
import frc.robot.subsystems.Climber.ClimberSystem;

public class RobotContainer {
    
    private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

    /* Setting up bindings for necessary control of the swerve drive platform */
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();

    private final Telemetry logger = new Telemetry(MaxSpeed);

    private final CommandXboxController joystick = new CommandXboxController(0);
    private final CommandXboxController CoDrivejoystick = new CommandXboxController(1);

    public final ElevatorSubSystem elevator = new ElevatorSubSystem();
    public final ClimberSystem climber = new ClimberSystem();
    public final IntakeSubSystem intake = new IntakeSubSystem();

    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();

    public void AllianceInverted(){

    }

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            // Drivetrain will execute this command periodically
            drivetrain.applyRequest(() ->
                drive.withVelocityX(-joystick.getLeftY() * MaxSpeed*0.7) // Drive forward with negative Y (forward)
                    .withVelocityY(-joystick.getLeftX() * MaxSpeed*0.7) // Drive left with negative X (left)
                    .withRotationalRate(-joystick.getRightX() * MaxAngularRate*0.7) // Drive counterclockwise with negative X (left)
            )
        );

        joystick.a().whileTrue(drivetrain.applyRequest(() -> brake));
        joystick.b().whileTrue(drivetrain.applyRequest(() ->
            point.withModuleDirection(new Rotation2d(-joystick.getLeftY(), -joystick.getLeftX()))
        ));

        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
        joystick.back().and(joystick.y()).whileTrue(drivetrain.sysIdDynamic(Direction.kForward));
        joystick.back().and(joystick.x()).whileTrue(drivetrain.sysIdDynamic(Direction.kReverse));
        joystick.start().and(joystick.y()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kForward));
        joystick.start().and(joystick.x()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kReverse));

        // reset the field-centric heading on left bumper press
        // joystick.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldCentric()));

        // Elevator control
        joystick.rightTrigger().whileTrue(new ElevatorUp(elevator));
        joystick.leftTrigger().whileTrue(new ElevatorDown(elevator));


        //Climber  control
        CoDrivejoystick.leftStick().whileTrue(new ClimberRelease(climber));
        CoDrivejoystick.rightStick().whileTrue(new ClimberActive(climber));

        CoDrivejoystick.x().whileTrue(new ClimberInactive(climber));

        //intake Control
        CoDrivejoystick.leftTrigger().whileTrue(new IntakeSpit(intake));
        CoDrivejoystick.rightTrigger().whileTrue(new IntakeSuck(intake));
        CoDrivejoystick.a().whileTrue(new IntakeKeep(intake));
        // CoDrivejoystick.a().whileTrue(new LiftUp(intake));
        // CoDrivejoystick.b().whileTrue(new LiftDown(intake));
        drivetrain.registerTelemetry(logger::telemeterize);
    }

    public Command getAutonomousCommand() {
        return drivetrain.applyRequest(() ->
        drive.withVelocityX(-1) // Drive forward with negative Y (forward)
            .withVelocityY(0) // Drive left with negative X (left)
            .withRotationalRate(0) // Drive counterclockwise with negative X (left)
    );
    }
}
