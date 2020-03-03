/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Make the xbox triggers buttons
 */
public class XboxTrigger extends Trigger {
  XboxController xbox;
  Hand hand;
  public XboxTrigger(XboxController xbox, Hand hand) {
    this.xbox = xbox;
    this.hand = hand;
  }

  @Override
  public boolean get() {
    return this.xbox.getTriggerAxis(this.hand) >= 0.25;
  }
}
