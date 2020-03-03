/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimberSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // Instantiate new motor controller objects
  public WPI_TalonSRX climbMotor1 = new WPI_TalonSRX(RobotMap.climberPort1);
  public WPI_TalonSRX climbMotor2 = new WPI_TalonSRX(RobotMap.climberPort2);

  // Instantiate new limit switch and counter
  DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);
  Counter counter = new Counter(limitSwitch);

  public void setClimbSpeed(double speed) {
    climbMotor1.set(speed);
  }

  public void setClimbRetractSpeed(double speed) {
    climbMotor1.set(speed);
    climbMotor2.set(speed);
  }

  public boolean isSwitchSet() {
    return counter.get() > 0;
  }
  
  public void initializeCounter() {
    counter.reset();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
