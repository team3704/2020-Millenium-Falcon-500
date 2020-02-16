/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // Physical parameters
  public static int wheelDiameter = 8;

  // Controller Port
  public static int XboxControllerPort = 0;
  
  // Motor Port Identifers
  public static int leftMasterPort = 0;
  public static int leftSlavePort = 1;
  public static int rightMasterPort = 2;
  public static int righSlavePort = 3;

  public static int intakePort = 4;

  public static int firstMagazinePort = 5;
  public static int secondMagazinePort = 6;

  public static int loaderPort = 7;

  public static int shooterMasterPort = 8;
  public static int shooterSlavePort = 9;

  public static int controlPanelPort = 10;

  public static int climberPort = 11;

  //Solenoid Port Identifers
  public static int intakeDeploySolenoidPort = 3;
  public static int intakeRetractSolenoidPort = 2;
  public static int GBSlowSolenoidPort = 0;
  public static int GBFastSolenoidPort = 1;
  public static int controlPanelDeploySolenoidPort = 6;
  public static int controlPanelRetractSolenoidPort = 7;
  public static int climbSolenoidPort = 8;
}
