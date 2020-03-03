// /*----------------------------------------------------------------------------*/                                                           |_|_|_|_|_|
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */                                                           |_|_|_|_|_|
// /* Open Source Software - may be modified and shared by FRC teams. The code   */                                                           |_|_|_|_|_|
// /* must be accompanied by the FIRST BSD license file in the root directory of */                                                           |_|_|_|_|_|
// /* the project.                                                               */                                                           |_|_|_|_|_|
// /*----------------------------------------------------------------------------*/                      

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all.
 * Unless you know what you are doing, do not modify this file except to
 * change the parameter class to the startRobot call.
 */
public final class Main {
  private Main() {
  }

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
