package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveToDistance extends CommandBase{
    
    private Drivetrain s_Drivetrain;
    private double distance;

    public DriveToDistance(Drivetrain s_Drivetrain, double distance){
        this.s_Drivetrain = s_Drivetrain;
        this.distance = distance;
    }

    @Override
    public void execute() {
      s_Drivetrain.setDistance(distance);
    }


    @Override
    public void end(boolean interrupted) {
        s_Drivetrain.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(s_Drivetrain.getLeftDistance() - distance) < s_Drivetrain.metersToFalcon(Constants.DriveConstants.targetDeadband);
    }

  
}
