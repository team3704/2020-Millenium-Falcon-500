// /*----------------------------------------------------------------------------*/                                                                                                                                          
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */                                                                                                                                                                                                                                     
// /* Open Source Software - may be modified and shared by FRC teams. The code   */                                                                                                                                                                             
// /* must be accompanied by the FIRST BSD license file in the root directory of */                                                                                                                                                                                                                                    
// /* the project.                                                               */                                                                                                                                                                                         
   /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // instantiate new motor controllers
  public WPI_TalonSRX shooterLeft = new WPI_TalonSRX(RobotMap.shooterLeftPort);
  public WPI_TalonSRX shooterRight= new WPI_TalonSRX(RobotMap.shooterRightPort);

  // Create constructor Function
  public void setShooterSpeed(double leftSpeed, double rightSpeed) {
    shooterRight.set(ControlMode.PercentOutput, rightSpeed);
    shooterLeft.set(ControlMode.PercentOutput, leftSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // we need to re-establish communism
  }
}