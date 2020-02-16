/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class MagazineSubsystem extends Subsystem {

public WPI_TalonSRX magazineMotor1 = new WPI_TalonSRX(RobotMap.firstMagazinePort);
public WPI_TalonSRX magazineMotor2 = new WPI_TalonSRX(RobotMap.secondMagazinePort);

public MagazineSubsystem() {
  // Point slaves to masters
   magazineMotor2.follow(magazineMotor1);
}

public void setMagazineSpeed(double speed){
  magazineMotor1.set(speed);
  //motor goes at half speed in magazineCommand
}

  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
