// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.ShooterControl;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //Controller
  private final Joystick controller = new Joystick(0);

  //Button
  private final JoystickButton shoot = new JoystickButton(controller, 0);

  //Subsystems
  private final Shooter s_Shooter = new Shooter();
  private final Drivetrain s_Drivetrain = new Drivetrain();

  private final AutoCommand m_autoCommand = new AutoCommand(s_Shooter, s_Drivetrain);


  public RobotContainer() {
    s_Drivetrain.setDefaultCommand(new TankDriveCommand(s_Drivetrain, controller));
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {

    shoot.whileHeld(new ShooterControl(s_Shooter, 1));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
