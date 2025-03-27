package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

public class Constants {

    public static final class AlgaeIntakeSuckerConstants {

        public static final double AlgaeSuckSpeed = 0.8;
        public static final double AlgaeSpitSpeed = -0.8;
        public static final double AlgaeHoldSpeed = 0.04;
        public static final double AlgaeKeepSpeed = 0;
        
    }

    public static final class AlgaeIntakeLifterConstants{

        public static final double LiftUpSpeed = -0.8;
        public static final double LiftDownSpeed = 0.3;
        public static final double LiftHoldSpeed = 0;
 
    }

    public static final class ElevatorConstants {

        public static final double ElevatorLUpSpeed = 0;
        public static final double ElevatorLDownSpeed = 0;
        public static final double ElevatorLHoldSpeed = 0;
        public static final double maxVelocity = 0.5;
        public static final double maxAcceleration = 1;
        public static final double closeEnough = 0.01;
        public static final TrapezoidProfile.Constraints CONSTRAINTS = new Constraints(maxVelocity, maxAcceleration);

        public static final double gearRatio = 12; //to get
        public static final double pitchDiameter = 0.0447; //to get
        public static final double circumference = pitchDiameter * Math.PI; 
        public static final double positionConversionFactor = circumference/gearRatio;
        public static final double velocityConversionFactor = circumference/gearRatio/60;
        
    }

    public static final class ClimberConstants {

        public static final double ClimberLReleaseSpeed = 0;
        public static final double ClimberLAbsorbSpeed = 0;
        public static final double ClimberLActiveSpeed = 0;
        public static final double ClimberLInactiveSpeed = 0;      

    }

    public final class ScoreAngle{
        //to test and change
        public static final Double L1 = 0.2;
        public static final Double L2 = .59;
        public static final Double L3 = .87;
        public static final Double L4=  .9;
        public static final Double DEFAULT = 0.0;
      
      }
      

}