/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Arcade_ShiftCommand extends Command {

  public Value value;

  public Arcade_ShiftCommand(Value value) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arcadeDriveSubsystem);
    this.value = value;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.arcadeDriveSubsystem.shift(value);

    double move = -1* Robot.oi.joystick.getY();
    double turn = Robot.oi.joystick.getX();
    Robot.arcadeDriveSubsystem.manualArcadeDrive(move, turn);

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
   }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
