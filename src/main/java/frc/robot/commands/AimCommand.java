// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
   /*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.Math;
import frc.robot.Robot;

public class AimCommand extends Command {
  public AimCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arcadeDriveSubsystem);
   // requires(Robot.limelightSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);

    double KpAim = 0.05;
    double KpDistance = 0.05;
    double min_aim_command = 0.15;

    //double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    //double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

    double heading_error = tx;
    double distance_error = ty;
    double steering_adjust = 0.0;
    double max_drive = 0.05;
    double max_turn = 0.15;

    //seeking target
    //if (tv == 0.0) {
    //  steering_adjust = 0.1;
    //}

    //Aim
    steering_adjust = KpAim*heading_error + min_aim_command;
    

    //Range
    double distance_adjust = KpDistance * distance_error;
    

    Robot.arcadeDriveSubsystem.manualArcadeDrive(distance_adjust, steering_adjust, true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    

    if (Math.abs(tx) < 0.5) {
      return true;
    } 
    else {
      return false;
    }
  
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}