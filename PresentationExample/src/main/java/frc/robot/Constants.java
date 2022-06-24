// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.math.util.Units;

public final class Constants {

  public static final class DriveConstants {
    public static final int leftMotorID = 1;
    public static final int rightMotorID = 2;

    public static final InvertType leftMotorInvert = InvertType.None;
    public static final InvertType rightMotorInvert = InvertType.InvertMotorOutput;

    //PID for drivetrain motors
    public static final double kP = 0.1;
    public static final double kI = 0;
    public static final double kD = 0;

    public static final double gearRatio = 1;
    public static final double wheelDiameter = Units.inchesToMeters(5);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double targetDeadband = Units.inchesToMeters(5);
  }

  public static final class ShooterConstants {
    public static final int masterID = 3;
    public static final int followerID = 4;

    public static final InvertType masterInvert = InvertType.None;
    public static final InvertType followerInvert = InvertType.OpposeMaster;

  }

}
