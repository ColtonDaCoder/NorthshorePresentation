package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{

    private TalonFX leftMotor;
    private TalonFX rightMotor;
    
    public Drivetrain(){
        leftMotor = new TalonFX(Constants.DriveConstants.leftMotorID);
        leftMotor.configFactoryDefault();
        leftMotor.setInverted(Constants.DriveConstants.leftMotorInvert);
        leftMotor.config_kP(0, Constants.DriveConstants.kP);
        leftMotor.config_kI(0, Constants.DriveConstants.kI);
        leftMotor.config_kD(0, Constants.DriveConstants.kD);

        rightMotor = new TalonFX(Constants.DriveConstants.rightMotorID);
        rightMotor.configFactoryDefault();
        rightMotor.setInverted(Constants.DriveConstants.rightMotorInvert);
        rightMotor.config_kP(0, Constants.DriveConstants.kP);
        rightMotor.config_kI(0, Constants.DriveConstants.kI);
        rightMotor.config_kD(0, Constants.DriveConstants.kD);
    }

    public void tankDrive(double left, double right){
        leftMotor.set(ControlMode.PercentOutput, left);
        rightMotor.set(ControlMode.PercentOutput, right);
    }

    //Sets distance to left and right drivetrain motors separately
    public void setDistance(double distance){
        leftMotor.setSelectedSensorPosition(0);
        rightMotor.setSelectedSensorPosition(0);
        leftMotor.set(ControlMode.Position, metersToFalcon(distance));
        rightMotor.set(ControlMode.Position, metersToFalcon(distance));
    }


    public double getLeftDistance(){
        return leftMotor.getSelectedSensorPosition();
    }

    public double metersToFalcon(double distance){
        return distance * (1 / (Constants.DriveConstants.gearRatio * Constants.DriveConstants.wheelCircumference));
    }

}
