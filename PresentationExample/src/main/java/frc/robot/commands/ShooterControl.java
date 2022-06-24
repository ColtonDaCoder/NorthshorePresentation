// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ShooterControl extends CommandBase {

  private final Shooter s_Shooter;

  private double power;

  public ShooterControl(Shooter s_Shooter, double power) {
    this.s_Shooter = s_Shooter;
    this.power = power;
  }

  @Override
  public void initialize() {
    addRequirements(s_Shooter);
  }

  @Override
  public void execute() {
    s_Shooter.setPower(power);
  }

  @Override 
  public void end(boolean interrupted){
    s_Shooter.setPower(0);
  }

}
