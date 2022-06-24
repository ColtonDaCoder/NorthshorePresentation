package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDriveCommand extends CommandBase{
    
    private Drivetrain s_Drivetrain;
    private Joystick controller;

    public TankDriveCommand(Drivetrain s_Drivetrain, Joystick controller){
        this.s_Drivetrain = s_Drivetrain;
        this.controller = controller;
    }

    @Override
    public void execute() {
        double left = controller.getRawAxis(1);
        double right = controller.getRawAxis(3);
        s_Drivetrain.tankDrive(left, right);
    }

}
