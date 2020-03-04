/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Instantiate new motor controller objects
  public VictorSPX intakemotor = new VictorSPX(RobotMap.intakePort);

  // Instantiate new Solenoid for pneumatic cylinder
  public DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.intakeDeploySolenoidPort,RobotMap.intakeRetractSolenoidPort);

  public void deployPiston() {
      intakeSolenoid.set(Value.kForward);
  }

  public void retractPiston() {
      intakeSolenoid.set(Value.kReverse);
  }

  public void setIntakeSpeed(double speed){
      intakemotor.set(ControlMode.PercentOutput, speed);
  }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}