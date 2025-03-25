package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.path.PathConstraints;

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
        
    }

    public static final class ClimberConstants {

        public static final double ClimberLReleaseSpeed = 0;
        public static final double ClimberLAbsorbSpeed = 0;
        public static final double ClimberLActiveSpeed = 0;
        public static final double ClimberLInactiveSpeed = 0;      

    }

}