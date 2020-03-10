/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * Add your docs here.
 */
public class ClimberSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // Instantiate new motor controller objects
  public VictorSPX wandMotor = new VictorSPX(RobotMap.climberPort1);
  public VictorSPX winchMotor = new VictorSPX(RobotMap.climberPort2);

  // Instantiate new limit switch and counter
  DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);

  public void setWandSpeed(double speed) {
    wandMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setWinchSpeed(double speed) {
    winchMotor.set(ControlMode.PercentOutput, speed);
  }

  public boolean isSwitchSet() {
    return limitSwitch.get();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
