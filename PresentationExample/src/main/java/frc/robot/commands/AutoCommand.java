// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutoCommand extends SequentialCommandGroup {

    public AutoCommand(Shooter s_Shooter, Drivetrain s_Drivetrain) {

        addCommands(
                new InstantCommand(() -> s_Shooter.setPower(1)),
                new WaitCommand(5),
                new InstantCommand(() -> s_Shooter.setPower(0)),
                new DriveToDistance(s_Drivetrain, 15)     
        );
    }

}
