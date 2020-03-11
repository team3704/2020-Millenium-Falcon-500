/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class DriveBackTimedCommand extends TimedCommand {
  /**
   * Add your docs here.
   */
  public DriveBackTimedCommand(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arcadeDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Entered auton drive " + System.currentTimeMillis());
    Robot.arcadeDriveSubsystem.autonArcadeDrive(-0.30, 0, false);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after timeout
  @Override
  protected void end() {
    System.out.println("Exited auton drive " + System.currentTimeMillis());
    Robot.arcadeDriveSubsystem.manualArcadeDrive(0, 0, true);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
