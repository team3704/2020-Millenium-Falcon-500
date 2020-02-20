/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeRetractCommand;
import frc.robot.commands.MagazineCommand;
import frc.robot.commands.cpDeployCommand;
import frc.robot.commands.cpRetractCommand;
import frc.robot.commands.Arcade_ShiftCommand;
import frc.robot.commands.IntakeDeployCommand;
import frc.robot.commands.IntakeMotorCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  // Controllers
  public Joystick xbox;
  public Joystick joystick;

  //Xbox Controller Buttons
  public JoystickButton leftBumper;       //port 5
  public JoystickButton rightBumper;      //port 6
  public JoystickButton buttonA;          //port 1
  public JoystickButton buttonB;          //port 2
  public JoystickButton buttonX;          //port 3
  public JoystickButton buttonY;          //port 4
  public JoystickButton buttonStickLeft;  //port 9
  public JoystickButton buttonStickRight; //port 10
  public JoystickButton buttonBack;       //port7
  public JoystickButton buttonStart;      //port 8

    //Joystick Controller Buttons
    public JoystickButton button1;
    public JoystickButton button2;
    public JoystickButton button3;
    public JoystickButton button4;
    public JoystickButton button5;
    public JoystickButton button6;
    public JoystickButton button7;
    public JoystickButton button8;
    public JoystickButton button9;
    public JoystickButton button10;

// new comment

  public OI()  {
  
      xbox = new Joystick(RobotMap.XboxControllerPort);
      joystick = new Joystick(RobotMap.JoystickPort);

      button1 = new JoystickButton(joystick, 1);
      button1.whenPressed(new Arcade_ShiftCommand(Value.kReverse));
      button1.whenReleased(new Arcade_ShiftCommand(Value.kForward));

      rightBumper = new JoystickButton(xbox, 6);
      rightBumper.whileHeld(new IntakeMotorCommand());
      rightBumper.whileHeld(new MagazineCommand());

      
      buttonA = new JoystickButton(xbox, 1);
      buttonA.whenPressed(new IntakeDeployCommand());

      buttonB = new JoystickButton(xbox, 2);
      buttonB.whenPressed(new IntakeRetractCommand());

      buttonX = new JoystickButton(xbox, 3);
      buttonX.whenPressed(new cpDeployCommand());

      buttonY = new JoystickButton(xbox, 4);;
      buttonY.whenPressed(new cpRetractCommand());
    
  }

}