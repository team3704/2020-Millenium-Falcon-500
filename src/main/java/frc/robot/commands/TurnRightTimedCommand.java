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
public class TurnRightTimedCommand extends TimedCommand {
  /**
   * Add your docs here.
   */
  public TurnRightTimedCommand(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arcadeDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.arcadeDriveSubsystem.manualArcadeDrive(0, 0.25);
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.arcadeDriveSubsystem.manualArcadeDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
