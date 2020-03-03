/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class cpMotorTimedCommand extends TimedCommand {
  public cpMotorTimedCommand(double timeout) {
  super(timeout);
  requires(Robot.controlPanelTurnSubsystem);
  }
@Override
public synchronized void requires(Subsystem subsystem) {
}    // eg. requires(chassis);
  
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.controlPanelTurnSubsystem.setCPMSpeed(0.25);
  }

  // Make this return true when this Command no longer needs to run execute()

  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
