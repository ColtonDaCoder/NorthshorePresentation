// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  public TalonFX masterFx;
  public TalonFX followerFx;

  public Shooter() {
    masterFx = new TalonFX(Constants.ShooterConstants.masterID);
    masterFx.configFactoryDefault();
    masterFx.setInverted(Constants.ShooterConstants.masterInvert);

    followerFx = new TalonFX(Constants.ShooterConstants.followerID);
    followerFx.configFactoryDefault();
    followerFx.setInverted(Constants.ShooterConstants.followerInvert);
    followerFx.follow(masterFx);
  }

  public void setPower(double power){
    masterFx.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
      SmartDashboard.putNumber("Velocity: ", masterFx.getSelectedSensorVelocity());
  }


}
