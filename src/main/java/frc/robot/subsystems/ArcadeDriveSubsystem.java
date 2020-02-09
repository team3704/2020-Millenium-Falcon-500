/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualArcadeDriveCommand;

/**
 * Add your docs here.
 */
public class ArcadeDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Instantiate new motor controller objects
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave1 = new WPI_TalonSRX(RobotMap.leftSlave1Port);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave1 = new WPI_TalonSRX(RobotMap.righSlave1Port);

  // public Spark leftMaster = new Spark(RobotMap.leftMasterPort);
  // public Spark leftSlave1 = new Spark(RobotMap.leftSlave1Port);
  // public Spark rightMaster = new Spark(RobotMap.rightMasterPort);
  // public Spark rightSlave1 = new Spark(RobotMap.righSlave1Port);

  // Technique to combine motors into differential drive
  // SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster,
  // leftSlave1, leftSlave2);
  // SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster,
  // rightSlave1,rightSlave2);

  // Instantiate a new DifferentialDrive objects
  // Assign motor controllers to differential drive
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  // Create constructor Function
  public ArcadeDriveSubsystem() {
      // Point slaves to masters
      leftSlave1.follow(leftMaster);
      rightSlave1.follow(rightMaster);

  }

  // Add manualArcadeDrive() method
  public void manualArcadeDrive(double move, double turn) {

    // Max speed for testing mode
    if(move > 0.5) move = .5;

    // Creates deadband for small joystick movements
    if (Math.abs(move) < 0.10) {
      move = 0;
    }
    if (Math.abs(turn) < 0.10) {
      turn = 0;
    }

    drive.arcadeDrive(move, turn);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualArcadeDriveCommand());
  }
}
