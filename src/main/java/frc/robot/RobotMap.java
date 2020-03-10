// /*----------------------------------------------------------------------------*/                                                             
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */                                                               
// /* Open Source Software - may be modified and shared by FRC teams. The code   */                                                               
// /* must be accompanied by the FIRST BSD license file in the root directory of */                                                              
// /* the project.                                                               */                                                            
// /*----------------------------------------------------------------------------*/                                                              

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
  public static int JoystickPort = 0;
  public static int XboxControllerPort = 1;

  // Motor Port Identifers
  public static int leftMasterPort = 0;
  public static int leftSlavePort = 1;
  public static int rightMasterPort = 2;
  public static int righSlavePort = 3;
  public static int intakePort = 4;
  public static int magazinePort = 5;
  public static int loaderPort = 6;
  public static int shooterRightPort = 7;
  public static int shooterLeftPort = 8;
  public static int controlPanelPort = 9;
  public static int climberPort1 = 10;
  public static int climberPort2 = 11;

  //Solenoid Port Identifers
  public static int GBSlowSolenoidPort = 7;
  public static int GBFastSolenoidPort = 2;
  public static int intakeRetractSolenoidPort = 0;
  public static int intakeDeploySolenoidPort = 1;
  public static int controlPanelDeploySolenoidPort = 5;
  public static int controlPanelRetractSolenoidPort = 4;

  // Limit Switch
  public static int limitSwitchPort = 0;


  //public static int button_dPad_left = 16;
}






//nice